package com.lb.parrot.apiproxy.pay.api;

import com.lb.parrot.apiproxy.pay.model.WeChatTransferModel;
import com.lb.parrot.pay.exception.WeChatPayException;
import com.lb.parrot.pay.result.transfer.GetTransferInfoResult;
import com.lb.parrot.pay.result.transfer.TransferResult;


public interface WeChatTransferBean {
	
	/**
	 * 企业付款
	 * @param model
	 * @return
	 * @throws WeChatPayException
	 */
	TransferResult transfers(WeChatTransferModel model) throws WeChatPayException;
	
	/**
	 * 查询企业付款
	 * @param partnerTradeNo
	 * @return
	 * @throws WeChatPayException
	 */
	GetTransferInfoResult gettransferinfo(String partnerTradeNo) throws WeChatPayException;
	
}