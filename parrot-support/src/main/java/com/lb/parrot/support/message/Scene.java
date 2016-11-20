package com.lb.parrot.support.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Scene {
	/**
	 * 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 */
	@JSONField(name = "scene_id")
	private Integer sceneId;
	/**
	 * 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，仅永久二维码支持此字段
	 */
	@JSONField(name = "scene_str")
	private String sceneStr;

	public Scene(Integer sceneId) {
		this.sceneId = sceneId;
	}
	
	public Scene(String sceneStr) {
		this.sceneStr = sceneStr;
	}

	public Integer getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}

	public String getSceneStr() {
		return sceneStr;
	}

	public void setSceneStr(String sceneStr) {
		this.sceneStr = sceneStr;
	}

}
