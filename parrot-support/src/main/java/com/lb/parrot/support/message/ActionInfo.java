package com.lb.parrot.support.message;

import com.alibaba.fastjson.annotation.JSONField;


public class ActionInfo {

	@JSONField(name = "scene")
	private Scene scene;

	
	public ActionInfo(Scene scene) {
		super();
		this.scene = scene;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

}
