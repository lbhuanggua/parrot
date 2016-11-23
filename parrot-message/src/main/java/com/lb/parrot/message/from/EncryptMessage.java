package com.lb.parrot.message.from;

import com.lb.parrot.support.common.FromServerMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 加密消息
 *
 */
@XStreamAlias("xml")
public class EncryptMessage implements FromServerMessage{

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
