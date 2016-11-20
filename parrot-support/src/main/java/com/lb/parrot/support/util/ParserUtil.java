package com.lb.parrot.support.util;

import com.lb.parrot.support.convert.Convert;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.convert.JsonParser;
import com.lb.parrot.support.convert.TextParser;
import com.lb.parrot.support.convert.XmlParser;
import com.lb.parrot.support.convert.json.AccessTokenConvert;
import com.lb.parrot.support.convert.json.ErrorResultConvert;
import com.lb.parrot.support.convert.json.JsApiTicketConvert;
import com.lb.parrot.support.convert.json.OauthTokenResultConvert;
import com.lb.parrot.support.convert.json.UserInfoConvert;
import com.lb.parrot.support.exception.WeChatSupportException;

/**
 * 
* <p>Title: 微信信息解析工具</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public class ParserUtil {
	
	public final static JsonParser jsonParser = new JsonParser();
	public final static XmlParser xmlParser = new XmlParser();
	public final static TextParser textParser = new TextParser();
	
	static{
		jsonParser.addWeChatConvert(new OauthTokenResultConvert());
		jsonParser.addWeChatConvert(new AccessTokenConvert());
		jsonParser.addWeChatConvert(new JsApiTicketConvert());
		jsonParser.addWeChatConvert(new ErrorResultConvert());
		jsonParser.addWeChatConvert(new UserInfoConvert());
	}
	
	public static void addXmlConvert(Convert convert){
		xmlParser.addWeChatConvert(convert);
	}
	
    public static void removeXmlConvert(Convert convert){
    	xmlParser.removeWeChatConvert(convert);
	}
    
    public static void addJsonConvert(Convert convert){
    	jsonParser.addWeChatConvert(convert);
	}
	
    public static void removeJsonConvert(Convert convert){
    	jsonParser.removeWeChatConvert(convert);
	}
    
    public static void addTextConvert(Convert convert){
    	textParser.addWeChatConvert(convert);
	}
	
    public static void removeTextConvert(Convert convert){
    	textParser.removeWeChatConvert(convert);
	}
    
	/**
	 * 解析信息
	 * @param <T>
	 * @param content
	 * @return
	 */
	public static <T> T parse(String content, ConvertMode mode) throws WeChatSupportException{
		if(checkJson(content)){
			return jsonParser.parse(content,  mode);
		}else if(checkXml(content)){
			return xmlParser.parse(content,  mode);
		}else{
			return textParser.parse(content,  mode);
		}
		
	}
	
	/**
	 * 简单验证json
	 * @param s
	 * @return
	 */
	private static boolean checkJson(String s){
		if(StringUtil.isNotEmpty(s)){
		   s = s.trim();
		   return s.startsWith("{") && s.endsWith("}");
		}
		return false;
	}
	
	/**
	 * 简单验证xml
	 * @param s
	 * @return
	 */
	private static boolean checkXml(String s){
		if(StringUtil.isNotEmpty(s)){
		   s = s.trim();
		   return s.startsWith("<xml>") && s.endsWith("</xml>");
		}
	    return false;
	}
}
