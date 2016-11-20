package com.lb.parrot.menu.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;

//TODO 自定义菜单配置接口返回结果封装待写
public class CurrentSelfmenuInfoResult implements ToServerResult {
	private static final long serialVersionUID = 1L;
	@JSONField(name = "is_menu_open")
	private String isMenuOpen;

}
