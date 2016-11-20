package com.lb.parrot.pay.result.pojo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
* <p>Title: </p>
* <p>Description: 支付通讯结果公共模型</p>
* @author lbhuanggua
* @date 2016年05月17日
 */
public class PayReturnResult implements ToServerPayResult{

	private static final long serialVersionUID = 1L;

	/**
	 * 返回状态码
	 */
	@XStreamAlias("return_code")
	private String returnCode;
	
	/**
	 * 返回消息
	 */
	@XStreamAlias("return_msg")
	private String returnMsg;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	
	@Override
	public String toString() {
		XStream xstream = new XStream(new XppDriver(new NoNameCoder()));
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.processAnnotations(getClass());
		return xstream.toXML(this);
	}
	
}
