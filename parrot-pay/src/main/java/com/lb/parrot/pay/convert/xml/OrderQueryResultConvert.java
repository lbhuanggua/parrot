package com.lb.parrot.pay.convert.xml;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.lb.parrot.pay.result.OrderQueryResult;
import com.lb.parrot.support.convert.Convert;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.convert.xml.AbstractXmlConvert;
import com.lb.parrot.support.util.ParserUtil;

/**
 * 
* <p>Title: 查询订单结果对象转换器</p>
* <p>Description: return_code 和result_code都为SUCCESS的对象转换器</p>
* @author lbhuanggua
* @date 2016年05月19日
 */
@Component
public class OrderQueryResultConvert extends AbstractXmlConvert{

	public OrderQueryResultConvert() {
		super(OrderQueryResult.class);
		this.setPriority(1);
	}

	public ConvertMode getConvertMode() {
		return ConvertMode.SEND;
	}
	
	protected boolean checkMatch(String input) {
		return "SUCCESS".equals(get(input, "return_code"))
				&& "SUCCESS".equals(get(input, "result_code"))
				&& contains(input, "appid")
				&& contains(input, "mch_id")
				&& contains(input, "nonce_str") 
				&& contains(input, "sign")
				&& contains(input, "out_trade_no")
				&& contains(input, "trade_state")
				&& contains(input, "trade_state_desc");
	}
	
	@PostConstruct
	protected void init() {
		ParserUtil.addXmlConvert((Convert) this);
	}

}
