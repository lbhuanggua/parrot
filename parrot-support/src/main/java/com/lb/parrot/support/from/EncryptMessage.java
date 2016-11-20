package com.lb.parrot.support.from;

import com.lb.parrot.support.common.FromServerMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
* <p>Title: 加密消息</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
@XStreamAlias("xml")
public class EncryptMessage implements FromServerMessage{

	private static final long serialVersionUID = 1L;

	@XStreamAlias("Encrypt")
	private String encrypt;
	
	@XStreamAlias("ToUserName")
	private String toUserName;

	public String getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	@Override
	public String toString() {
		return "EncryptMessage [encrypt=" + getEncrypt() + ", toUserName="
				+ getToUserName() + "]";
	}
	
}
