package com.lb.parrot.template.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;

public class IndustryResult implements ToServerResult{
	private static final long serialVersionUID = 1L;
	/**
	 * 帐号设置的主营行业
	 */
	@JSONField(name = "primary_industry")
	private IndustryClass primary_industry;

	/**
	 * 帐号设置的副营行业
	 */
	@JSONField(name = "secondary_industry")
	private IndustryClass secondary_industry;

	public IndustryClass getPrimary_industry() {
		return primary_industry;
	}

	public void setPrimary_industry(IndustryClass primary_industry) {
		this.primary_industry = primary_industry;
	}

	public IndustryClass getSecondary_industry() {
		return secondary_industry;
	}

	public void setSecondary_industry(IndustryClass secondary_industry) {
		this.secondary_industry = secondary_industry;
	}

}
