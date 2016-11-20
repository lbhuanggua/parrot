package com.lb.parrot.customer.result;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;

public class KfaccountOnlineListResult implements ToServerResult {
	private static final long serialVersionUID = 1L;
	@JSONField(name = "kf_online_list")
	private List<KfaccountOnline> onlineList;

	public List<KfaccountOnline> getOnlineList() {
		return onlineList;
	}

	public void setOnlineList(List<KfaccountOnline> onlineList) {
		this.onlineList = onlineList;
	}

	@Override
	public String toString() {
		return "KfOnlineListResult [onlineList=" + onlineList + "]";
	}
	
	

}
