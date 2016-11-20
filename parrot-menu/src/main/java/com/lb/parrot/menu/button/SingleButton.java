package com.lb.parrot.menu.button;

/**
 * 没有二级菜单的一级菜单
 *
 */
public class SingleButton extends CommonButton {
	public SingleButton() {
		super();
	}

	public SingleButton(String name) {
		super(name);
	}

	public SingleButton(String name, String type, String key) {
		super(name);
		this.type = type;
		this.key = key;
	}

	public SingleButton(String name, String type, String key, String url) {
		super(name);
		this.type = type;
		this.key = key;
		this.url = url;
	}

	private String type;

	private String key;

	private String url;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "SingleButton [type=" + type + ", key=" + key + ", url=" + url
				+ "]";
	}

}
