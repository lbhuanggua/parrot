package com.lb.parrot.support.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lb.parrot.support.common.ToServerResult;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QrcodeResult extends AbstractToServerResult implements
		ToServerResult {
	private static final long serialVersionUID = 1L;
	/**
	 * 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
	 */
	@JSONField(name = "ticket")
	String ticket;

	/**
	 * 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。
	 */
	@JSONField(name = "expire_seconds")
	long expireSeconds;

	/**
	 * 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
	 */
	@JSONField(name = "url")
	String url;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public long getExpireSeconds() {
		return expireSeconds;
	}

	public void setExpireSeconds(long expireSeconds) {
		this.expireSeconds = expireSeconds;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "QrcodeResult [ticket=" + ticket + ", expireSeconds="
				+ expireSeconds + ", url=" + url + "]";
	}

}
