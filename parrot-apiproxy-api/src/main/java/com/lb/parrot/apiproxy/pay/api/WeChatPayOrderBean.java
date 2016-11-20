package com.lb.parrot.apiproxy.pay.api;

import com.lb.parrot.apiproxy.pay.model.WeChatCreateOrderModel;
import com.lb.parrot.apiproxy.pay.model.WeChatDownBillModel;
import com.lb.parrot.apiproxy.pay.model.WeChatOrderConditionModel;
import com.lb.parrot.pay.exception.WeChatPayException;
import com.lb.parrot.pay.response.H5PayResponse;
import com.lb.parrot.pay.result.DownloadBillResult;
import com.lb.parrot.pay.result.OrderQueryResult;

public interface WeChatPayOrderBean {
	
	/**
	 * H5支付统一下单
	 * @param model
	 * @return
	 * @throws WeChatPayException
	 */
	H5PayResponse unified(WeChatCreateOrderModel model) throws WeChatPayException;

	/**
	 * 查询订单
	 * @param model
	 * @return
	 * @throws WeChatPayException
	 */
	OrderQueryResult query(WeChatOrderConditionModel model) throws WeChatPayException;
	
	/**
	 * 关闭订单
	 * @param model
	 * @return
	 * @throws WeChatPayException
	 */
	void close(WeChatOrderConditionModel model) throws WeChatPayException;
	
	/**
	 * 下载对账单
	 * @param model
	 * @return
	 * @throws WeChatPayException
	 */
	DownloadBillResult down(WeChatDownBillModel model) throws WeChatPayException;
	
}
