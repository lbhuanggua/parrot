package com.lb.parrot.support.convert.json;

import com.alibaba.fastjson.JSONObject;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.result.AccessToken;

public class AccessTokenConvert extends AbstractJSONObjectConvert{

	public AccessTokenConvert() {
		super(AccessToken.class);
		setPriority(100);
	}

	public ConvertMode getConvertMode() {
		return ConvertMode.SEND;
	}

	protected boolean checkMatch(JSONObject input) {
		return input.containsKey("access_token");
	}
	
}
