package com.lb.parrot.message.from;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 客服
 *
 */
@XStreamAlias("xml")
public class KfAccount {

	@XStreamAlias("KfAccount")
	private String kfAccount;

	public String getKfAccount() {
		return kfAccount;
	}

	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}

}
