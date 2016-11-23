package com.lb.parrot.message.convert.xml;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.lb.parrot.message.from.MessageMode;
import com.lb.parrot.message.from.TextMessage;
import com.lb.parrot.support.convert.Convert;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.convert.xml.AbstractXmlConvert;
import com.lb.parrot.support.util.ParserUtil;

/**
 * 
* <p>Title: 文本转换器</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
@Component
public class TextMessageConvert extends AbstractXmlConvert {

	public TextMessageConvert(){
		super(TextMessage.class);
	}

	public ConvertMode getConvertMode() {
		return ConvertMode.RECEIVE;
	}

	protected boolean checkMatch(String input) {
		return MessageMode.TEXT.getType().equals(getMsgType(input));
	}
	
	@PostConstruct
	protected void init() {
		ParserUtil.addXmlConvert((Convert) this);
	}
}
