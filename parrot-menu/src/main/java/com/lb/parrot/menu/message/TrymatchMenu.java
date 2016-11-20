package com.lb.parrot.menu.message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerMessage;

/**
 * 测试个性化菜单匹配
 *
 */
public class TrymatchMenu implements ToServerMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JSONField(name = "user_id")
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
