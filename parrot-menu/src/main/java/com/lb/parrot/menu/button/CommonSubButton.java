package com.lb.parrot.menu.button;

/**
 * 二级菜单按钮
 *
 */
public class CommonSubButton {
   
	public CommonSubButton(){
		
	}
	
	public CommonSubButton(String name,String type){
		this.name = name;
		this.type = type;
	}
	
    private String type;
	
	private String name;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
