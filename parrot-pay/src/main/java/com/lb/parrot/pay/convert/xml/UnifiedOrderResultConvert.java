package com.lb.parrot.pay.convert.xml;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.lb.parrot.pay.result.UnifiedOrderResult;
import com.lb.parrot.support.convert.Convert;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.convert.xml.AbstractXmlConvert;
import com.lb.parrot.support.util.ParserUtil;

/**
 * 
* <p>Title: 统一下单对象转换器</p>
* <p>Description: return_code 和result_code都为SUCCESS的对象转换器</p>
* @author lbhuanggua
* @date 2016年05月19日
 */
@Component
public class UnifiedOrderResultConvert extends AbstractXmlConvert{

	public UnifiedOrderResultConvert() {
		super(UnifiedOrderResult.class);
		this.setPriority(1);
	}

	public ConvertMode getConvertMode() {
		return ConvertMode.SEND;
	}

	protected boolean checkMatch(String input) {
		return "SUCCESS".equals(get(input, "return_code"))
				&& "SUCCESS".equals(get(input, "result_code"))
				&& contains(input, "prepay_id")
				&& contains(input, "trade_type");
	}
	
	@PostConstruct
	protected void init() {
		ParserUtil.addXmlConvert((Convert) this);
	}
	
}
