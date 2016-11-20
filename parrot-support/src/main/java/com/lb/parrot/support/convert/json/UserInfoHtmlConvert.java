package com.lb.parrot.support.convert.json;

import com.alibaba.fastjson.JSONObject;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.result.UserInfoResult;

public class UserInfoHtmlConvert extends AbstractJSONObjectConvert {

	public UserInfoHtmlConvert() {
		super(UserInfoResult.class);
		setPriority(100);
	}

	public ConvertMode getConvertMode() {
		return ConvertMode.SEND;
	}

	protected boolean checkMatch(JSONObject input) {
		return !input.containsKey("subscribe") && input.containsKey("openid") && input.containsKey("unionid");
	}
}
