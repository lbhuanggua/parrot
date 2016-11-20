package com.lb.parrot.pay.result;

import com.lb.parrot.pay.result.pojo.PayBusinessResult;
import com.lb.parrot.pay.result.pojo.ToServerPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
* <p>Title: 关闭订单结果模型</p>
* <p>Description: return_code 为SUCCESS的时候有返回</p>
* @author lbhuanggua
* @date 2016年05月20日
 */
@XStreamAlias("xml")
public class CloseOrderResult extends PayBusinessResult implements ToServerPayResult{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 业务结果描述
	 */
	@XStreamAlias("result_msg")
	private String resultMsg;

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	
}
