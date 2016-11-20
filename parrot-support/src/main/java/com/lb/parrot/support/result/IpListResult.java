package com.lb.parrot.support.result;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;

public class IpListResult extends AbstractToServerResult implements ToServerResult {

	private static final long serialVersionUID = 1L;
	
	@JSONField(name = "ip_list")
	private List<String> ipsList;

	public List<String> getIpsList() {
		return ipsList;
	}

	public void setIpsList(List<String> ipsList) {
		this.ipsList = ipsList;
	}

}
