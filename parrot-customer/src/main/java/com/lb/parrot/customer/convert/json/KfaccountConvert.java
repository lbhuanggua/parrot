package com.lb.parrot.customer.convert.json;

import com.alibaba.fastjson.JSONObject;
import com.lb.parrot.customer.result.KfaccountResult;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.convert.json.AbstractJSONObjectConvert;

public class KfaccountConvert extends AbstractJSONObjectConvert {

	public KfaccountConvert() {
		super(KfaccountResult.class);
		setPriority(100);
	}

	public ConvertMode getConvertMode() {
		return ConvertMode.ALL;
	}

	protected boolean checkMatch(JSONObject input) {
		return input.containsKey("errcode") && !input.containsKey("errmsg");
	}

}
