package com.lb.parrot.message.convert.xml;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.lb.parrot.message.from.LocationMessage;
import com.lb.parrot.support.common.WeChatMessageMode;
import com.lb.parrot.support.convert.Convert;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.convert.xml.AbstractXmlConvert;
import com.lb.parrot.support.util.ParserUtil;

@Service
public class LocationMessageConvert extends AbstractXmlConvert {

	public LocationMessageConvert() {
		super(LocationMessage.class);
	}

	public ConvertMode getConvertMode() {
		return ConvertMode.RECEIVE;
	}

	protected boolean checkMatch(String input) {
		return WeChatMessageMode.LOCATION.getType().equals(getMsgType(input));
	}

	@PostConstruct
	protected void init() {
		ParserUtil.addXmlConvert((Convert) this);
	}
}
