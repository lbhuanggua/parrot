package com.lb.parrot.support.convert.json;

import com.alibaba.fastjson.JSONObject;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.result.JsApiTicket;

public class JsApiTicketConvert extends AbstractJSONObjectConvert{

	public JsApiTicketConvert() {
		super(JsApiTicket.class);
	}

	public ConvertMode getConvertMode() {
		return ConvertMode.SEND;
	}

	protected boolean checkMatch(JSONObject input) {
		return input.containsKey("ticket") && input.containsKey("expires_in");
	}

}
