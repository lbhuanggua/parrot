package com.lb.parrot.message.convert.xml;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.lb.parrot.message.event.ScanPushEvent;
import com.lb.parrot.support.common.WeChatEventMode;
import com.lb.parrot.support.convert.Convert;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.convert.xml.AbstractXmlConvert;
import com.lb.parrot.support.util.ParserUtil;


@Service
public class ScanPushEventConvert extends AbstractXmlConvert {

	public ScanPushEventConvert() {
		super(ScanPushEvent.class);
	}

	public ConvertMode getConvertMode() {
		return ConvertMode.RECEIVE;
	}

	protected boolean checkMatch(String input) {
		return WeChatEventMode.SCANCODE_PUSH.getEvent().equals(getEvent(input));
	}

	@PostConstruct
	protected void init() {
		ParserUtil.addXmlConvert((Convert) this);
	}
	
}
