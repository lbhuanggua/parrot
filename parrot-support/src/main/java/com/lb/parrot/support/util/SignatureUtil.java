package com.lb.parrot.support.util;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.WeChatClient;
import com.lb.parrot.support.aes.AesException;
import com.lb.parrot.support.aes.WXBizMsgCrypt;
import com.lb.parrot.support.exception.WeChatSupportException;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 微信签名辅助工具
 * 
 */
public class SignatureUtil {

	static Charset CHARSET = Charset.forName("utf-8");
	static int BLOCK_SIZE = 32;
	static final String XML_FORMAT = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";

	/**
	 * 验证服务器地址的有效性算法：<br>
	 * 1. 将token、timestamp、nonce三个参数进行字典序排序<br>
	 * 2. 将三个参数字符串拼接成一个字符串进行sha1加密<br>
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static String createSignature(String token, String timestamp,
			String nonce) throws WeChatSupportException{
		if (StringUtil.isEmpty(token) || StringUtil.isEmpty(timestamp) || StringUtil.isEmpty(nonce)) {
			return null;
		}
		return createSha1Algorithm(token, timestamp, nonce);
	}

	/**
	 * JS-SDK使用权限签名算法:<br>
	 * 1. 对所有待签名参数按照字段名的ASCII
	 * 码从小到大排序（字典序）后，使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1<br>
	 * 2. 对string1进行sha1签名，得到signature
	 * 
	 * @return
	 */
	public static String createJsApiSignature(String noncestr, String ticket,
			String timestamp, String url) throws WeChatSupportException{
		if (StringUtil.isEmpty(noncestr) || StringUtil.isEmpty(timestamp)
				|| StringUtil.isEmpty(url) || StringUtil.isEmpty(ticket)) {
			return null;
		}
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("noncestr", noncestr);
		maps.put("jsapi_ticket", ticket);
		maps.put("timestamp", timestamp);
		maps.put("url", url);

		List<String> keyList = new ArrayList<String>(maps.keySet());
		Collections.sort(keyList);

		StringBuffer sb = new StringBuffer();
		for (String key : keyList) {
			sb.append(key).append("=").append(maps.get(key)).append("&");
		}
		sb.delete(sb.length() - 1, sb.length());

		try {
			return doMessageDigestFormat(sb.toString(), "SHA-1");
		} catch (NoSuchAlgorithmException e) {
			throw new WeChatSupportException(e.getMessage(),e);
		} catch (UnsupportedEncodingException e) {
			throw new WeChatSupportException(e.getMessage(),e);
		}
	}

	/**
	 * 微信商户平台签名通用算法:<br>
	 * 1.设所有发送或者接收到的数据为集合M，将集合M内非空参数值的参数按照参数名ASCII码从小到大排序（字典序），使用URL键值对的格式（即key1
	 * =value1&key2=value2…）拼接成字符串stringA<br>
	 * 2.在stringA最后拼接上key得到stringSignTemp字符串，并对stringSignTemp进行MD5运算，
	 * 再将得到的字符串所有字符转换为大写，得到sign值signValue<br>
	 * 算法来源请参考:https://pay.weixin.qq.com/wiki/doc/api/app.php?chapter=4_3
	 * 
	 * @param o
	 * @param key
	 * @return
	 */
	public static String createPaySignature(Object o, String key) throws WeChatSupportException{
		if (o == null || key == null) {
			return null;
		}
		try {
			ArrayList<String> list = new ArrayList<String>();
			Class<?> cls = o.getClass();
			List<Field> fields = ClassUtil.getFields(cls);
			// 拼接字段
			for (Field f : fields) {
				f.setAccessible(true);
				Object value = f.get(o);
				if (value != null && !value.equals("") 
						&& !f.getName().equals("serialVersionUID") 
						&& !f.getName().equals("signature")) {
					XStreamAlias alias = f.getAnnotation(XStreamAlias.class);
					if (alias != null) {
						list.add(alias.value() + "=" + value + "&");
					} else {
						list.add(f.getName() + "=" + value + "&");
					}
					
				}
			}
			int size = list.size();
			String[] arrayToSort = list.toArray(new String[size]);
			// 排序
			Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < size; i++) {
				sb.append(arrayToSort[i]);
			}
			// 增加key值
			sb.append("key=").append(key);
			// MD5运算
			String result = doMessageDigestFormat(sb.toString(), "MD5");
			return result.toUpperCase();
		} catch (Exception e) {
			throw new WeChatSupportException(e.getMessage(),e);
		}

	}
	
	public static String createPaySignatureJSON(Object o, String key) throws WeChatSupportException{
		if (o == null || key == null) {
			return null;
		}
		try {
			ArrayList<String> list = new ArrayList<String>();
			Class<?> cls = o.getClass();
			Field[] fields = cls.getDeclaredFields();
			// 拼接字段
			for (Field f : fields) {
				f.setAccessible(true);
				Object value = f.get(o);
				if (value != null && value != "" 
						&& !f.getName().equals("serialVersionUID") 
						&& !f.getName().equals("signature")) {
					JSONField jsonField = f.getAnnotation(JSONField.class);
					if (jsonField != null) {
						list.add(jsonField.name() + "=" + value + "&");
					} else {
						list.add(f.getName() + "=" + value + "&");
					}
				}
			}
			int size = list.size();
			String[] arrayToSort = list.toArray(new String[size]);
			// 排序
			Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < size; i++) {
				sb.append(arrayToSort[i]);
			}
			// 增加key值
			sb.append("key=").append(key);

			// MD5运算
			String result = doMessageDigestFormat(sb.toString(), "MD5");
			return result.toUpperCase();
		} catch (Exception e) {
			throw new WeChatSupportException(e.getMessage(),e);
		}

	}

	/**
	 * 简化SHA-1算法
	 * 
	 * @param str
	 * @return
	 */
	protected static String createSha1Algorithm(String... str) throws WeChatSupportException{
		// 按字典序排序
		Arrays.sort(str);
		// 连接字符串
		StringBuffer sb = new StringBuffer();
		for (String s : str) {
			sb.append(s);
		}
		// 执行sha1加密
		try {
			return doMessageDigest(sb.toString(), "SHA-1");
		} catch (NoSuchAlgorithmException e) {
			throw new WeChatSupportException(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			throw new WeChatSupportException(e.getMessage(), e);
		}
	}

	/**
	 * 执行签名算法
	 * 
	 * @param message
	 * @param algorithm
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	private static String doMessageDigestFormat(String message, String algorithm)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance(algorithm);
		md.reset();
		md.update(message.getBytes("UTF-8"));
		return byteToHex(md.digest());
	}

	/**
	 * 执行签名算法
	 * 
	 * @param message
	 * @param algorithm
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	private static String doMessageDigest(String message, String algorithm)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance(algorithm);
		md.reset();
		md.update(message.getBytes("UTF-8"));
		return new BigInteger(1, md.digest()).toString(16);
	}

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	/**
	 * 获得对明文进行补位填充的字节.
	 * 
	 * @param count
	 *            需要进行填充补位操作的明文字节个数
	 * @return 补齐用的字节数组
	 */
	static byte[] encode(int count) {
		// 计算需要填充的位数
		int amountToPad = BLOCK_SIZE - (count % BLOCK_SIZE);
		if (amountToPad == 0) {
			amountToPad = BLOCK_SIZE;
		}
		// 获得补位所用的字符
		char padChr = chr(amountToPad);
		String tmp = new String();
		for (int index = 0; index < amountToPad; index++) {
			tmp += padChr;
		}
		return tmp.getBytes(CHARSET);
	}

	/**
	 * 删除解密后明文的补位字符
	 * 
	 * @param decrypted
	 *            解密后的明文
	 * @return 删除补位字符后的明文
	 */
	static byte[] decode(byte[] decrypted) {
		int pad = (int) decrypted[decrypted.length - 1];
		if (pad < 1 || pad > 32) {
			pad = 0;
		}
		return Arrays.copyOfRange(decrypted, 0, decrypted.length - pad);
	}

	/**
	 * 将数字转化成ASCII码对应的字符，用于对明文进行补码
	 * 
	 * @param a
	 *            需要转化的数字
	 * @return 转化得到的字符
	 */
	static char chr(int a) {
		byte target = (byte) (a & 0xFF);
		return (char) target;
	}
	
	/**
	 * 加密微信消息(需要配置微信通讯模式为加密模式)<br>
	 * @param xml
	 * @param timestamp
	 * @param nonce
	 * @param client
	 * @return
	 * @throws AesException 
	 */
	public static String encryptMessage(String xml, String timestamp, String nonce, WeChatClient client) throws AesException {
		return new WXBizMsgCrypt(client.getToken(), client.getEncodeAseKey(), client.getAppid()).encryptMsg(xml, timestamp, nonce);
	}

	/**
	 * 解密微信消息(需要配置微信通讯模式为加密模式)<br>
	 * @param xml
	 * @param client
	 * @return
	 */
	public static String decryptMessage(String xml, String timestamp, String nonce, String msgSignature, WeChatClient client) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		StringReader sr = new StringReader(xml);
		InputSource is = new InputSource(sr);
		Document document = db.parse(is);

		Element root = document.getDocumentElement();
		NodeList nodelist1 = root.getElementsByTagName("Encrypt");

		String encrypt = nodelist1.item(0).getTextContent();

		String fromXML = String.format(XML_FORMAT, encrypt);
		// 公众平台发送消息给第三方，第三方处理, 第三方收到公众号平台发送的消息
		return new WXBizMsgCrypt(client.getToken(), client.getEncodeAseKey(),
				client.getAppid()).decryptMsg(msgSignature, timestamp, nonce, fromXML);
	}
	
	public static String getRandomStr() {
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 16; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
}
