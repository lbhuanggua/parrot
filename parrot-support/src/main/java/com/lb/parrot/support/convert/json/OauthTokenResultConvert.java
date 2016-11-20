package com.lb.parrot.support.convert.json;

import com.alibaba.fastjson.JSONObject;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.result.Oauth2Token;

public class OauthTokenResultConvert extends AbstractJSONObjectConvert{

	public OauthTokenResultConvert() {
		super(Oauth2Token.class);
	}

	public ConvertMode getConvertMode() {
		return ConvertMode.SEND;
	}

	protected boolean checkMatch(JSONObject input) {
		return input.containsKey("openid") && input.containsKey("access_token");
	}

}
