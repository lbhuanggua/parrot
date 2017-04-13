package com.lb.parrot.support;

/**
 * 
 * <p>
 * Title: 微信客户号设置
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author lbhuanggua
 * @date 2016年05月19日
 */
public class WeChatClient {

	/**
	 * 微信的appid
	 */
	private String appid;
	/**
	 * 微信的app秘钥
	 */
	private String secret;
	/**
	 * 认证的token字符串
	 */
	private String token;
	/**
	 * 微信消息加密密钥
	 */
	private String encodeAseKey;
	/**
	 * 商户号
	 */
	private String mchId;
	/**
	 * 商户平台的key字符串
	 */
	private String payToken;
	/**
	 * HTTP是否强制检查签名
	 */
	private String checkSignature;
	/**
	 * 是否检查微信服务器ip
	 */
	private String checkIp;
	/**
	 * 证书路径
	 */
	private String certPath;
	/**
	 * 验证密码
	 */
	private String password;
	/**
	 * 证书类型
	 */
	private String certType;

	public WeChatClient() {
		super();
	}

	public WeChatClient(String appid, String secret) {
		super();
		this.appid = appid;
		this.secret = secret;
	}

	public WeChatClient(String appid, String secret, String token,
			String encodeAseKey, String mchId, String payToken,
			String checkSignature, String checkIp, String certPath,
			String password, String certType) {
		super();
		this.appid = appid;
		this.secret = secret;
		this.token = token;
		this.encodeAseKey = encodeAseKey;
		this.mchId = mchId;
		this.payToken = payToken;
		this.checkSignature = checkSignature;
		this.checkIp = checkIp;
		this.certPath = certPath;
		this.password = password;
		this.certType = certType;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAppid() {
		return appid;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getPayToken() {
		return payToken;
	}

	public void setPayToken(String payToken) {
		this.payToken = payToken;
	}

	public String getEncodeAseKey() {
		return encodeAseKey;
	}

	public void setEncodeAseKey(String encodeAseKey) {
		this.encodeAseKey = encodeAseKey;
	}

	public boolean isCheckSignature() {
		return Boolean.valueOf(checkSignature);
	}

	public void setCheckSignature(String checkSignature) {
		this.checkSignature = checkSignature;
	}

	public boolean isCheckIp() {
		return Boolean.valueOf(checkIp);
	}

	public void setCheckIp(String checkIp) {
		this.checkIp = checkIp;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getCertPath() {
		return certPath;
	}

	public void setCertPath(String certPath) {
		this.certPath = certPath;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

}
