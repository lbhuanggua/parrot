package com.lb.parrot.pay.common;

import com.lb.parrot.support.exception.WeChatSupportException;
import com.lb.parrot.support.util.SignatureUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * 抽象的签名创建者
 */
public abstract class AbstactPaySignature implements PaySignature {

	public String createSignature(String key) {
		try {
			return SignatureUtil.createPaySignature(this, key);
		} catch (WeChatSupportException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@Override
	public String toString() {
		XStream xstream = new XStream(new XppDriver(new NoNameCoder()));
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.processAnnotations(getClass());
		return xstream.toXML(this);
	}

}
