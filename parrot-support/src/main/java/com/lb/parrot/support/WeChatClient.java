package com.lb.parrot.support;

import org.springframework.stereotype.Service;

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
@Service
public class WeChatClient {

	/**
	 * 微信的appid
	 */
	String appid;

	/**
	 * 微信的app秘钥
	 */
	String secret;

	/**
	 * 认证的token字符串
	 */
	String token;

	/**
	 * 微信消息加密密钥
	 */
	String encodeAseKey;

	/**
	 * 商户号
	 */
	String mchId;

	/**
	 * 商户平台的key字符串
	 */
	String payToken;

	/**
	 * HTTP是否强制检查签名
	 */
	boolean checkSignature;

	/**
	 * 是否检查微信服务器ip
	 */
	boolean checkIp;

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
		return checkSignature;
	}

	public void setCheckSignature(String checkSignature) {
		this.checkSignature = Boolean.getBoolean(checkSignature);
	}

	public boolean isCheckIp() {
		return checkIp;
	}

	public void setCheckIp(String checkIp) {
		this.checkIp = Boolean.getBoolean(checkIp);
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

	public void setCheckSignature(boolean checkSignature) {
		this.checkSignature = checkSignature;
	}

	public void setCheckIp(boolean checkIp) {
		this.checkIp = checkIp;
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
