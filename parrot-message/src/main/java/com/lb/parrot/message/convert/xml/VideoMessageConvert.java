package com.lb.parrot.message.convert.xml;

import javax.annotation.PostConstruct;

import com.lb.parrot.message.from.MessageMode;
import com.lb.parrot.message.from.VideoMessage;
import com.lb.parrot.support.convert.Convert;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.convert.xml.AbstractXmlConvert;
import com.lb.parrot.support.util.ParserUtil;


public class VideoMessageConvert extends AbstractXmlConvert{

	public VideoMessageConvert() {
		super(VideoMessage.class);
	}

	public ConvertMode getConvertMode() {
		return ConvertMode.RECEIVE;
	}

	protected boolean checkMatch(String input) {
		return MessageMode.VIDEO.getType().equals(getMsgType(input));
	}

	@PostConstruct
	protected void init() {
		ParserUtil.addXmlConvert((Convert) this);
	}
	
}
