package com.lb.parrot.support.common;


public enum SceneMode {

	QR_SCENE("QR_SCENE"),

	QR_LIMIT_STR_SCENE("QR_LIMIT_STR_SCENE");

	private final String scene;

	private SceneMode(String scene) {
		this.scene = scene;
	}

	public String getScene() {
		return scene;
	}

}
