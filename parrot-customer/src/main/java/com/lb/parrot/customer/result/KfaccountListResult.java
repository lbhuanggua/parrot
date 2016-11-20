package com.lb.parrot.customer.result;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;

/**
 * 获得全部客服的列表结果
 *
 */
public class KfaccountListResult implements ToServerResult {
	private static final long serialVersionUID = 1L;
	@JSONField(name = "kf_list")
	private List<Kfaccount> kfAccountList;

	public List<Kfaccount> getKfAccountList() {
		return kfAccountList;
	}

	public void setKfAccountList(List<Kfaccount> kfAccountList) {
		this.kfAccountList = kfAccountList;
	}

}
