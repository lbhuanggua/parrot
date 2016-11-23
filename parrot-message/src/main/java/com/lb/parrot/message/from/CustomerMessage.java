package com.lb.parrot.message.from;

import com.lb.parrot.support.common.WeChatMessageMode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 客服消息
 *
 */
@XStreamAlias("xml")
public class CustomerMessage extends CommonMessage {

	public CustomerMessage() {
		setMsgType(WeChatMessageMode.TRANSFER_CUSTOMER_SERVICE.getType());
	}

	@XStreamAlias("TransInfo")
	private KfAccount transInfo;

	public KfAccount getTransInfo() {
		return transInfo;
	}

	public void setTransInfo(KfAccount transInfo) {
		this.transInfo = transInfo;
	}

}
