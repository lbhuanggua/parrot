package com.lb.parrot.support.result;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;

/**
 * 用户信息列表
 *
 */
public class UserInfoListResult implements ToServerResult {
	private static final long serialVersionUID = 1L;
	@JSONField(name = "user_info_list")
	private List<UserInfoResult> userInfoList;

	public List<UserInfoResult> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfoResult> userInfoList) {
		this.userInfoList = userInfoList;
	}

	@Override
	public String toString() {
		return "UserInfoListResult [userInfoList=" + userInfoList + "]";
	}

}
