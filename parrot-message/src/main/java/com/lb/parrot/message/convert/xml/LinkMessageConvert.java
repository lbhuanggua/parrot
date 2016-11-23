package com.lb.parrot.message.convert.xml;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.lb.parrot.message.from.LinkMessage;
import com.lb.parrot.message.from.MessageMode;
import com.lb.parrot.support.convert.Convert;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.convert.xml.AbstractXmlConvert;
import com.lb.parrot.support.util.ParserUtil;


@Service
public class LinkMessageConvert extends AbstractXmlConvert {

	public LinkMessageConvert() {
		super(LinkMessage.class);
	}

	public ConvertMode getConvertMode() {
		return ConvertMode.RECEIVE;
	}

	protected boolean checkMatch(String input) {
		return MessageMode.LINK.getType().equals(getMsgType(input));
	}
	
	@PostConstruct
	protected void init() {
		ParserUtil.addXmlConvert((Convert) this);
	}

}
