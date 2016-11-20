package com.lb.parrot.customer.result;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 用户信息
 *
 */
public class SessionUser {

	@JSONField(name = "createtime")
	private long createTime;
	/**
	 * 粉丝的openid
	 */
	@JSONField(name = "openid")
	private String openid;
	/**
	 * 粉丝的最后一条消息的时间
	 */
	@JSONField(name = "latest_time")
	private long latestTime;

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public long getLatestTime() {
		return latestTime;
	}

	public void setLatestTime(long latestTime) {
		this.latestTime = latestTime;
	}

	@Override
	public String toString() {
		return "SessionUser [createTime=" + createTime + ", openid=" + openid
				+ ", latestTime=" + latestTime + "]";
	}

}
