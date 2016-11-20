package com.lb.parrot.menu.convert.json;

import com.alibaba.fastjson.JSONObject;
import com.lb.parrot.menu.result.MenuResult;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.convert.json.AbstractJSONObjectConvert;

public class MenuResultConvert extends AbstractJSONObjectConvert {

	public MenuResultConvert() {
		super(MenuResult.class);
		setPriority(100);
	}

	public ConvertMode getConvertMode() {
		return ConvertMode.SEND;
	}

	protected boolean checkMatch(JSONObject input) {
		return input.containsKey("menu");
	}

}
