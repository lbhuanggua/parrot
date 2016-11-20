package com.lb.parrot.support.common;

/**
 * 
* <p>Title: 微信事件枚举</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public enum WeChatEventMode {

	/**
	 * 用户订阅事件1
	 */
	SUBSCRIBE("subscribe"),
	/**
	 * 退订事件2
	 */
	UNSUBSCRIBE("unsubscribe"),
	/**
	 * 扫描事件3
	 */
	SCAN("SCAN"),
	/**
	 * 自动上传位置4
	 */
	LOCATION("LOCATION"),
	/**
	 * 点击事件5
	 */
	CLICK("CLICK"),
	/**
	 * 跳转事件6
	 */
	VIEW("VIEW"),
	/**
	 * 模板消息推送事件7
	 */
	TEMPLATE_SEND_JOB_FINISH("TEMPLATESENDJOBFINISH"),
	/**
	 * 群发消息推送事件8
	 */
	MASS_SEND_JOB_FINISH("MASSSENDJOBFINISH"),
	/**
	 * 扫码推事件9
	 */
	SCANCODE_PUSH("scancode_push"),
	/**
	 * 扫码推事件且弹出“消息接收中”提示框10
	 */
	SCANCODE_WAITMSG("scancode_waitmsg"),
	/**
	 * 弹出系统拍照发图11
	 */
	PIC_SYSPHOTO("pic_sysphoto"),
	/**
	 * 弹出拍照或者相册发图12
	 */
	PIC_PHOTO_OR_ALBUM("pic_photo_or_album"),
	/**
	 * 弹出微信相册发图器13
	 */
	PIC_WEIXIN("pic_weixin"),
	/**
	 * 弹出地理位置选择器14
	 */
	LOCATION_SELECT("location_select"), 
	/**
	 * 下发消息15
	 */
	MEDIA_ID("media_id"), 
	/**
	 * 跳转图文消息URL用户点击view_limited类型按钮后，微信客户端将打开开发者在按钮中填写的永久素材id对应的图文消息URL，永久素材类型只支持图文消息。请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id
	 */
	VIEW_LIMITED("view_limited");

	private final String event;

	private WeChatEventMode(String event) {
		this.event = event;
	}

	public String getEvent() {
		return event;
	}

}
