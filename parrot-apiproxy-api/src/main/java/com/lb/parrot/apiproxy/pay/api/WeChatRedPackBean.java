package com.lb.parrot.apiproxy.pay.api;

import com.lb.parrot.apiproxy.pay.model.WeChatGroupRedPackModel;
import com.lb.parrot.apiproxy.pay.model.WeChatRedPackModel;
import com.lb.parrot.pay.exception.WeChatPayException;
import com.lb.parrot.pay.result.red.RedPackInfoResult;
import com.lb.parrot.pay.result.red.RedPackResult;

public interface WeChatRedPackBean {
	
	/**
	 * 发放普通红包
	 * @param model
	 * @return
	 * @throws WeChatPayException
	 */
	RedPackResult sendRedPack(WeChatRedPackModel model) throws WeChatPayException;

	/**
	 * 发放裂变红包
	 * @param model
	 * @return
	 * @throws WeChatPayException
	 */
	RedPackResult sendGroupRedPack(WeChatGroupRedPackModel model) throws WeChatPayException;
	
	/**
	 * 查询红包记录
	 * @param mchBillno	商户订单号
	 * @return
	 * @throws WeChatPayException
	 */
	RedPackInfoResult gethbinfo(String mchBillno) throws WeChatPayException;
	
}
