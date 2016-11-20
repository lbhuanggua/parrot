package com.lb.parrot.template.message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerMessage;

/**
 * 设置所属行业
 *
 */
public class ApiSetIndustryMessage implements ToServerMessage {
	private static final long serialVersionUID = 1L;
	/**
	 * 公众号模板消息所属行业编号
	 */
	@JSONField(name = "industry_id1")
	private String industryId1;

	/**
	 * 公众号模板消息所属行业编号
	 */
	@JSONField(name = "industry_id2")
	private String industryId2;

	public String getIndustryId1() {
		return industryId1;
	}

	public void setIndustryId1(String industryId1) {
		this.industryId1 = industryId1;
	}

	public String getIndustryId2() {
		return industryId2;
	}

	public void setIndustryId2(String industryId2) {
		this.industryId2 = industryId2;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
