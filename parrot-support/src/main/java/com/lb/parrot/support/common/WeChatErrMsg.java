package com.lb.parrot.support.common;

/**
 * 
* <p>Title: 接口返回码</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public enum WeChatErrMsg {
	
	ERROR01("系统繁忙，此时请开发者稍候再试", -1),
	OK("请求成功", 0),
	ERROR40001("获取access_token时AppSecret错误，或者access_token无效", 40001),
	ERROR40002("不合法的凭证类型", 40002),
	ERROR40003("不合法的OpenID", 40003),
	ERROR40004("不合法的媒体文件类型", 40004),
	ERROR40005("不合法的文件类型", 40005),
	ERROR40006("不合法的文件大小", 40006),
	ERROR40007("不合法的媒体文件id", 40007),
	ERROR40008("不合法的消息类型", 40008),
	ERROR40009("不合法的图片文件大小", 40009),
	ERROR40010("不合法的语音文件大小", 40010),
	ERROR40011("不合法的视频文件大小", 40011),
	ERROR40012("不合法的缩略图文件大小", 40012),
	ERROR40013("不合法的AppID", 40013),
	ERROR40014("不合法的access_token", 40014),
	ERROR40015("不合法的菜单类型", 40015),
	ERROR40016("不合法的按钮个数", 40016),
	ERROR40017("不合法的按钮个数", 40017),
	ERROR40018("不合法的按钮名字长度", 40018),
	ERROR40019("不合法的按钮KEY长度", 40019),
	ERROR40020("不合法的按钮URL长度", 40020),
	ERROR40021("不合法的菜单版本号", 40021),
	ERROR40022("不合法的子菜单级数", 40022),
	ERROR40023("不合法的子菜单按钮个数", 40023),
	ERROR40024("不合法的子菜单按钮类型", 40024),
	ERROR40025("不合法的子菜单按钮名字长度", 40025),
	ERROR40026("不合法的子菜单按钮KEY长度", 40026),
	ERROR40027("不合法的子菜单按钮URL长度", 40027),
	ERROR40028("不合法的自定义菜单使用用户", 40028),
	ERROR40029("不合法的oauth_code", 40029),
	ERROR40030("不合法的refresh_token", 40030),
	ERROR40031("不合法的openid列表", 40031),
	ERROR40032("不合法的openid列表长度", 40032),
	ERROR40033("不合法的请求字符，不能包含\\uxxxx格式的字符", 40033),
	ERROR40035("不合法的参数", 40035),
	ERROR40038("不合法的请求格式", 40038),
	ERROR40039("不合法的URL长度", 40039),
	ERROR40050("不合法的分组id", 40050),
	ERROR40051("分组名字不合法", 40051),
	ERROR40117("分组名字不合法", 40117),
	ERROR40118("media_id大小不合法", 40118),
	ERROR40119("button类型错误", 40119),
	ERROR40120("button类型错误", 40120),
	ERROR40121("不合法的media_id类型", 40121),
	ERROR40132("微信号不合法", 40132),
	ERROR40137("不支持的图片格式", 40137),
	ERROR41001("缺少access_token参数", 41001),
	ERROR41002("缺少appid参数", 41002),
	ERROR41003("缺少refresh_token参数", 41003),
	ERROR41004("缺少secret参数", 41004),
	ERROR41005("缺少多媒体文件数据", 41005),
	ERROR41006("缺少media_id参数", 41006),
	ERROR41007("缺少子菜单数据", 41007),
	ERROR41008("缺少oauth code", 41008),
	ERROR41009("缺少openid", 41009),
	ERROR42001("access_token超时，请检查access_token的有效期", 42001),
	ERROR42002("refresh_token超时", 42002),
	ERROR42003("oauth_code超时", 42003),
	ERROR42007("用户修改微信密码，accesstoken和refreshtoken失效，需要重新授权", 42007),
	ERROR43001("需要GET请求", 43001),
	ERROR43002("需要POST请求", 43002),
	ERROR43003("需要HTTPS请求", 43003),
	ERROR43004("需要接收者关注", 43004),
	ERROR43005("需要好友关系", 43005),
	ERROR44001("多媒体文件为空", 44001),
	ERROR44002("POST的数据包为空", 44002),
	ERROR44003("图文消息内容为空", 44003),
	ERROR44004("文本消息内容为空", 44004),
	ERROR45001("多媒体文件大小超过限制", 45001),
	ERROR45002("消息内容超过限制", 45002),
	ERROR45003("标题字段超过限制", 45003),
	ERROR45004("描述字段超过限制", 45004),
	ERROR45005("链接字段超过限制", 45005),
	ERROR45006("图片链接字段超过限制", 45006),
	ERROR45007("语音播放时间超过限制", 45007),
	ERROR45008("图文消息超过限制", 45008),
	ERROR45009("接口调用超过限制", 45009),
	ERROR45010("创建菜单个数超过限制", 45010),
	ERROR45011("API调用太频繁，请稍候再试", 45011),
	ERROR45015("回复时间超过限制", 45015),
	ERROR45016("系统分组，不允许修改", 45016),
	ERROR45017("分组名字过长", 45017),
	ERROR45018("分组数量超过上限", 45018),
	ERROR45047("客服接口下行条数超过上限", 45047),
	ERROR46001("不存在媒体数据", 46001),
	ERROR46002("不存在的菜单版本", 46002),
	ERROR46003("不存在的菜单数据", 46003),
	ERROR46004("不存在的用户", 46004),
	ERROR47001("解析JSON/XML内容错误", 47001),
	ERROR48001("api功能未授权，请确认公众号已获得该接口，可以在公众平台官网-开发者中心页中查看接口权限", 48001),
	ERROR48002("粉丝拒收消息（粉丝在公众号选项中，关闭了“接收消息”）", 48002),
	ERROR48004("api接口被封禁", 48004),
	ERROR48005("api禁止删除被自动回复和自定义菜单引用的素材", 48005),
	ERROR48006("api禁止清零调用次数，因为清零次数达到上限", 48006),
	ERROR50001("用户未授权该api", 50001),
	ERROR61451("参数错误(invalid parameter)", 61451),
	ERROR61452("无效客服账号(invalid kf_account)", 61452),
	ERROR61453("客服帐号已存在(kf_account exsited)", 61453),
	ERROR61454("客服帐号名长度超过限制(仅允许10个英文字符，不包括@及@后的公众号的微信号)(invalid   kf_acount length)", 61454),
	ERROR61455("客服帐号名包含非法字符(仅允许英文+数字)(illegal character in   kf_account)", 61455),
	ERROR61456("客服帐号个数超过限制(10个客服账号)(kf_account count exceeded)", 61456),
	ERROR61457("无效头像文件类型(invalid   file type)", 61457),
	ERROR61450("系统错误(system error)", 61450)	,
	ERROR61500("日期格式错误", 61500),
	ERROR65301("日期格式错误", 65301),
	ERROR65302("没有相应的用户", 65302),
	ERROR65303("没有默认菜单，不能创建个性化菜单", 65303),
	ERROR65304("MatchRule信息为空", 65304),
	ERROR65305("个性化菜单数量受限", 65305),
	ERROR65306("不支持个性化菜单的帐号", 65306),
	ERROR65307("个性化菜单信息为空", 65307),
	ERROR65308("包含没有响应类型的button", 65308),
	ERROR65309("个性化菜单开关处于关闭状态", 65309),
	ERROR65310("填写了省份或城市信息，国家信息不能为空", 65310),
	ERROR65311("填写了城市信息，省份信息不能为空", 65311),
	ERROR65312("不合法的国家信息", 65312),
	ERROR65313("不合法的省份信息", 65313),
	ERROR65314("不合法的城市信息", 65314),
	ERROR65316("该公众号的菜单设置了过多的域名外跳（最多跳转到3个域名的链接）", 65316),
	ERROR65317("不合法的URL", 65317),
	ERROR9001001("POST数据参数不合法", 9001001),
	ERROR9001002("远端服务不可用", 9001002),
	ERROR9001003("Ticket不合法", 9001003),
	ERROR9001004("获取摇周边用户信息失败", 9001004),
	ERROR9001005("获取商户信息失败", 9001005),
	ERROR9001006("获取OpenID失败", 9001006),
	ERROR9001007("上传文件缺失", 9001007),
	ERROR9001008("上传素材的文件类型不合法", 9001008),
	ERROR9001009("上传素材的文件尺寸不合法", 9001009),
	ERROR9001010("上传失败", 9001010),
	ERROR9001020("帐号不合法", 9001020),
	ERROR9001021("已有设备激活率低于50%，不能新增设备", 9001021),
	ERROR9001022("设备申请数不合法，必须为大于0的数字", 9001022),
	ERROR9001023("已存在审核中的设备ID申请", 9001023),
	ERROR9001024("一次查询设备ID数量不能超过50", 9001024),
	ERROR9001025("设备ID不合法", 9001025),
	ERROR9001026("页面ID不合法", 9001026),
	ERROR9001027("页面参数不合法", 9001027),
	ERROR9001028("一次删除页面ID数量不能超过10", 9001028),
	ERROR9001029("页面已应用在设备中，请先解除应用关系再删除", 9001029),
	ERROR9001030("帐号不合法一次查询页面ID数量不能超过50", 9001030),
	ERROR9001031("时间区间不合法", 9001031),
	ERROR9001032("保存设备与页面的绑定关系参数错误", 9001032),
	ERROR9001033("门店ID不合法", 9001033),
	ERROR9001034("设备备注信息过长", 9001034),
	ERROR9001035("设备申请参数不合法", 9001035),
	ERROR9001036("查询起始值begin不合法", 9001036)	;
	
	private int errcode;
	private String errmsg;

	private WeChatErrMsg(String errmsg, int errcode) {
		this.errmsg = errmsg;
		this.errcode = errcode;
	}

	public static String getErrmsgCN(int errcode) {
		for (WeChatErrMsg c : WeChatErrMsg.values()) {
			if (c.getErrcode() == errcode) {
				return c.getErrmsg();
			}
		}
		return "未定义的中文错误信息";
	}

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

}
