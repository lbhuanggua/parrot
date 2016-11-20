package com.lb.parrot.support.convert.json;

import com.alibaba.fastjson.JSONObject;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.result.ErrorResult;

public class ErrorResultConvert extends AbstractJSONObjectConvert {

	public ErrorResultConvert() {
		super(ErrorResult.class);
		setPriority(Integer.MIN_VALUE);
	}

	public ConvertMode getConvertMode() {
		return ConvertMode.ALL;
	}

	protected boolean checkMatch(JSONObject input) {
		return input.containsKey("errcode") && input.containsKey("errmsg") && !input.containsKey("msgid");
	}
	
}
