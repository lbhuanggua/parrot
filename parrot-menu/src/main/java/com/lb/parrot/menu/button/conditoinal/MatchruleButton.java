package com.lb.parrot.menu.button.conditoinal;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 个性化菜单匹配规则
 *
 */
public class MatchruleButton {
	
	public MatchruleButton(){
	}
	

	public MatchruleButton(String tagId, String sex, String country,
			String province, String city, String clientPlatformType,
			String language) {
		super();
		this.tagId = tagId;
		this.sex = sex;
		this.country = country;
		this.province = province;
		this.city = city;
		this.clientPlatformType = clientPlatformType;
		this.language = language;
	}


	@JSONField(name = "tag_id")
	private String tagId;

	@JSONField(name = "sex")
	private String sex;

	@JSONField(name = "country")
	private String country;

	@JSONField(name = "province")
	private String province;

	@JSONField(name = "city")
	private String city;

	@JSONField(name = "client_platform_type")
	private String clientPlatformType;

	@JSONField(name = "language")
	private String language;

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getClientPlatformType() {
		return clientPlatformType;
	}

	public void setClientPlatformType(String clientPlatformType) {
		this.clientPlatformType = clientPlatformType;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
