package com.lb.parrot.pay.result.red;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class RedPackHBList {

	@XStreamImplicit
	private List<RedPackHB> redPackHB;

	public List<RedPackHB> getRedPackHB() {
		return redPackHB;
	}

	public void setRedPackHB(List<RedPackHB> redPackHB) {
		this.redPackHB = redPackHB;
	}

}
