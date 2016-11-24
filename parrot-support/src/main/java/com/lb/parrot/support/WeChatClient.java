package com.lb.parrot.support;

import org.springframework.beans.factory.annotation.Value;
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
	@Value("${parrot.wechat.appid}")
	private String appid;
	/**
	 * 微信的app秘钥
	 */
	@Value("${parrot.wechat.secret}")
	private String secret;
	/**
	 * 认证的token字符串
	 */
	@Value("${parrot.wechat.token}")
	private String token;
	/**
	 * 微信消息加密密钥
	 */
	@Value("${parrot.wechat.encodeAseKey}")
	private String encodeAseKey;
	/**
	 * 商户号
	 */
	@Value("${parrot.wechat.mchId}")
	private String mchId;
	/**
	 * 商户平台的key字符串
	 */
	@Value("${parrot.wechat.payToken}")
	private String payToken;
	/**
	 * HTTP是否强制检查签名
	 */
	@Value("${parrot.wechat.checkSignature}")
	private String checkSignature;
	/**
	 * 是否检查微信服务器ip
	 */
	@Value("${parrot.wechat.checkIp}")
	private String checkIp;
	/**
	 * 证书路径
	 */
	@Value("${parrot.wechat.certPath}")
	private String certPath;
	/**
	 * 验证密码
	 */
	@Value("${parrot.wechat.password}")
	private String password;
	/**
	 * 证书类型
	 */
	@Value("${parrot.wechat.certType}")
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
