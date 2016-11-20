package com.lb.parrot.support.convert.json;

import com.alibaba.fastjson.JSONObject;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.result.UserInfoResult;

public class UserInfoConvert extends AbstractJSONObjectConvert {

	public UserInfoConvert() {
		super(UserInfoResult.class);
		setPriority(100);
	}

	public ConvertMode getConvertMode() {
		return ConvertMode.SEND;
	}

	protected boolean checkMatch(JSONObject input) {
		return input.containsKey("openid") && input.containsKey("unionid") && !input.containsKey("user_info_list");
	}
}
