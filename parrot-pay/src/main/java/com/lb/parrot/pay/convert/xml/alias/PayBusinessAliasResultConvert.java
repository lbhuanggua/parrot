package com.lb.parrot.pay.convert.xml.alias;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.lb.parrot.pay.result.alias.PayBusinessAliasResult;
import com.lb.parrot.support.convert.Convert;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.convert.xml.AbstractXmlConvert;
import com.lb.parrot.support.util.ParserUtil;

/**
 * 
* <p>Title: 支付通知成功，业务失败对象转换器</p>
* <p>Description: return_code为SUCCESS的对象转换器</p>
* @author lbhuanggua
* @date 2016年05月19日
 */
@Component
public class PayBusinessAliasResultConvert extends AbstractXmlConvert{

	public PayBusinessAliasResultConvert() {
		super(PayBusinessAliasResult.class);
		this.setPriority(99);
	}

	public ConvertMode getConvertMode() {
		return ConvertMode.SEND;
	}
	
	protected boolean checkMatch(String input) {
		return "SUCCESS".equals(get(input, "return_code"))
				&& "FAIL".equals(get(input, "result_code"));
	}
	
	@PostConstruct
	protected void init() {
		ParserUtil.addXmlConvert((Convert) this);
	}

}
