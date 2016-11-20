package com.lb.parrot.support.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;

/**
 * 用户信息
 *
 */
public class UserInfoResult extends AbstractToServerResult implements ToServerResult {
	private static final long serialVersionUID = 1L;
	/**
	 * 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	 */
	@JSONField(name = "subscribe")
	private long subscribe;
	/**
	 * 用户的标识，对当前公众号唯一
	 */
	@JSONField(name = "openid")
	private String openid;
	/**
	 * 用户的昵称
	 */
	@JSONField(name = "nickname")
	private String nickname;
	/**
	 * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	 */
	@JSONField(name = "sex")
	private int sex;
	/**
	 * 用户的语言，简体中文为zh_CN
	 */
	@JSONField(name = "language")
	private String language;
	/**
	 * 用户所在城市
	 */
	@JSONField(name = "city")
	private String city;
	/**
	 * 用户所在省份
	 */
	@JSONField(name = "province")
	private String province;
	/**
	 * 用户所在国家
	 */
	@JSONField(name = "country")
	private String country;
	/**
	 * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。
	 * 若用户更换头像，原有头像URL将失效。
	 */
	@JSONField(name = "headimgurl")
	private String headimgurl;
	/**
	 * 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
	 */
	@JSONField(name = "subscribe_time")
	private long subscribeTime;
	/**
	 * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
	 */
	@JSONField(name = "unionid")
	private String unionid;
	/**
	 * 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
	 */
	@JSONField(name = "remark")
	private String remark;
	/**
	 * 用户所在的分组ID（兼容旧的用户分组接口）
	 */
	@JSONField(name = "groupid")
	private long groupid;
	/**
	 * 用户被打上的标签ID列表
	 */
	@JSONField(name = "tagid_list")
	private String tagidList;
	/**
	 * 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
	 */
	@JSONField(name = "privilege")
	private String privilege;
	
	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public long getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(long subscribe) {
		this.subscribe = subscribe;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public long getSubscribeTime() {
		return subscribeTime;
	}

	public void setSubscribeTime(long subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getGroupid() {
		return groupid;
	}

	public void setGroupid(long groupid) {
		this.groupid = groupid;
	}

	public String getTagidList() {
		return tagidList;
	}

	public void setTagidList(String tagidList) {
		this.tagidList = tagidList;
	}

	@Override
	public String toString() {
		return "UserInfoResult [subscribe=" + subscribe + ", openid=" + openid
				+ ", nickname=" + nickname + ", sex=" + sex + ", language="
				+ language + ", city=" + city + ", province=" + province
				+ ", country=" + country + ", headimgurl=" + headimgurl
				+ ", subscribeTime=" + subscribeTime + ", unionid=" + unionid
				+ ", remark=" + remark + ", groupid=" + groupid
				+ ", tagidList=" + tagidList + ", privilege=" + privilege + "]";
	}


}
