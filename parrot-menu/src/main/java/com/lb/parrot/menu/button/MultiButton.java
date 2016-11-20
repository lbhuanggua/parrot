package com.lb.parrot.menu.button;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 包含子菜单的一级菜单
 *
 */
public class MultiButton extends CommonButton{
    
	public MultiButton(){
		super();
	}
	
	public MultiButton(String name){
		super(name);
	}
	
	@JSONField(name="sub_button")
	private List<CommonSubButton> subButtons;

	public List<CommonSubButton> getSubButtons() {
		if(subButtons==null){
			subButtons = new ArrayList<CommonSubButton>();
		}
		return subButtons;
	}

	public void setSubButtons(List<CommonSubButton> subButtons) {
		this.subButtons = subButtons;
	}
	
	public void addSubButton(CommonSubButton subButton){
		getSubButtons().add(subButton);
	}
	
	public void removeSubButton(CommonSubButton subButton){
		getSubButtons().remove(subButton);
	}
}
