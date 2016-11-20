package com.lb.parrot.support.message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lb.parrot.support.common.SceneMode;
import com.lb.parrot.support.common.ToServerMessage;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QrcodeCreateMessage implements ToServerMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
	 */
	@JSONField(name = "expire_seconds")
	private Long expireSeconds;

	/**
	 * 二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久,QR_LIMIT_STR_SCENE为永久的字符串参数值
	 */
	@JSONField(name = "action_name")
	private String actionName;
	/**
	 * 二维码详细信息
	 */
	@JSONField(name = "action_info")
	private ActionInfo actionInfo;
	
	public QrcodeCreateMessage() {
		this.actionName = SceneMode.QR_SCENE.getScene();
	}

	public QrcodeCreateMessage(String actionName) {
		this.actionName = actionName;
	}
	
	public QrcodeCreateMessage(String actionName,
			ActionInfo actionInfo) {
		this.actionName = actionName;
		this.actionInfo = actionInfo;
	}
	
	public QrcodeCreateMessage(Long expireSeconds, String actionName,
			ActionInfo actionInfo) {
		this.expireSeconds = expireSeconds;
		this.actionName = actionName;
		this.actionInfo = actionInfo;
	}

	public Long getExpireSeconds() {
		return expireSeconds;
	}

	public void setExpireSeconds(Long expireSeconds) {
		this.expireSeconds = expireSeconds;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public ActionInfo getActionInfo() {
		return actionInfo;
	}

	public void setActionInfo(ActionInfo actionInfo) {
		this.actionInfo = actionInfo;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
