package com.lb.parrot.pay.convert.xml;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.lb.parrot.pay.result.PayFailResult;
import com.lb.parrot.support.convert.Convert;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.convert.xml.AbstractXmlConvert;
import com.lb.parrot.support.util.ParserUtil;

/**
 * 
* <p>Title: 支付通信失败转换器</p>
* <p>Description: return_code为FAIL的对象转换器</p>
* @author lbhuanggua
* @date 2016年05月19日
 */
@Component
public class PayFailResultConvert extends AbstractXmlConvert{

	public PayFailResultConvert() {
		super(PayFailResult.class);
		this.setPriority(0);
	}

	public ConvertMode getConvertMode() {
		return ConvertMode.SEND;
	}

	
	protected boolean checkMatch(String input) {
		return "FAIL".equals(get(input, "return_code"));
	}
	
	@PostConstruct
	protected void init() {
		ParserUtil.addXmlConvert((Convert) this);
	}

}
