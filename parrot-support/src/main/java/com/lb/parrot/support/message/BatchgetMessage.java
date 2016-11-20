package com.lb.parrot.support.message;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerMessage;

/**
 * 批量获取用户信息POST消息体
 *
 */
public class BatchgetMessage implements ToServerMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JSONField(name = "user_list")
	private List<UserOpenId> userList;

	public List<UserOpenId> getUserList() {
		return userList;
	}

	public void setUserList(List<UserOpenId> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
