package com.lb.parrot.customer.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;

/**
 * 0	成功
 * 65400	API不可用，即没有开通/升级到新版客服功能
 * 65401	无效客服帐号
 * 65403	客服昵称不合法
 * 65404	客服帐号不合法
 * 65405	帐号数目已达到上限，不能继续添加
 * 65406	已经存在的客服帐号
 * 65407    邀请对象已经是该公众号客服
 * 65408    本公众号已经有一个邀请给该微信
 * 65409    无效的微信号
 * 65410    邀请对象绑定公众号客服数达到上限（目前每个微信号可以绑定5个公众号客服帐号）
 * 65411    该帐号已经有一个等待确认的邀请，不能重复邀请
 * 65412    该帐号已经绑定微信号，不能进行邀请
 * 65413	不存在对应用户的会话信息
 * 65414	客户正在被其他客服接待
 * 40005    不支持的媒体类型
 * 40009    媒体文件长度不合法
 * 40003	非法的openid
 *
 */
public class KfaccountResult implements ToServerResult {
	private static final long serialVersionUID = 1L;
	@JSONField(name = "errcode")
	private String errCode;

	@JSONField(name = "errmsg")
	private String errMsg;

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	@Override
	public String toString() {
		return "KfaccountResult [errCode=" + errCode + ", errMsg=" + errMsg
				+ "]";
	}

}
