package com.lb.parrot.apiproxy.pay.api;

import com.lb.parrot.apiproxy.pay.model.WeChatRefundModel;
import com.lb.parrot.apiproxy.pay.model.WeChatRefundQueryModel;
import com.lb.parrot.pay.exception.WeChatPayException;
import com.lb.parrot.pay.result.RefundQueryResult;
import com.lb.parrot.pay.result.RefundResult;

public interface WeChatPayRefundBean {
	
	/**
	 * 申请退款
	 * @param model
	 * @return
	 * @throws WeChatPayException
	 */
	RefundResult refund(WeChatRefundModel model) throws WeChatPayException;
	
	/**
	 * 查询退款
	 * @param model
	 * @return
	 * @throws WeChatPayException
	 */
	RefundQueryResult query(WeChatRefundQueryModel model) throws WeChatPayException;
	
}