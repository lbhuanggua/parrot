package com.lb.parrot.menu.message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerMessage;

/**
 * 删除个性化菜单
 *
 */
public class DelconditionalMenu implements ToServerMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JSONField(name = "menuid")
	private String menuid;

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
