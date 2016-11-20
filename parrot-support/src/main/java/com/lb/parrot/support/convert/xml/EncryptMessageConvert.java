package com.lb.parrot.support.convert.xml;

import com.lb.parrot.support.convert.Convert;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.from.EncryptMessage;
import com.lb.parrot.support.util.ParserUtil;

//@Service
public class EncryptMessageConvert extends AbstractXmlConvert{

	public EncryptMessageConvert() {
		super(EncryptMessage.class);
	}

	public ConvertMode getConvertMode() {
		return ConvertMode.ALL;
	}

	protected boolean checkMatch(String input) {
		return contains(input, "Encrypt");
	}

	//@PostConstruct
	protected void init() {
		ParserUtil.addXmlConvert((Convert) this);
	}

	
}
