package com.lb.parrot.support.convert.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.lb.parrot.support.convert.AbstractConvert;
import com.lb.parrot.support.exception.WeChatSupportException;
import com.lb.parrot.support.util.XmlUtil;
import com.thoughtworks.xstream.XStream;

/**
 * 
* <p>Title:微信XML转换基类 </p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public abstract class AbstractXmlConvert extends AbstractConvert{

	protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractXmlConvert.class);
	
	protected XStream xstream;
	
	public AbstractXmlConvert(Class<?> clazz) {
		super(clazz);
		xstream = new XStream();
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.processAnnotations(clazz);
	}
	

	public <INPUT> boolean isMatch(INPUT input) {
		if (input instanceof String) {
			return checkMatch((String) input);
		}
		return false;
	}
	
	public <OUTPUT, INPUT> OUTPUT convert(INPUT input) throws WeChatSupportException{
		return convertXmlString((String)input);
	}

	/**
	 * 根据报文内容进行判断
	 * @param input
	 * @return
	 */
	protected abstract boolean checkMatch(String input);
	
	/**
	 * 转换String为业务对象
	 * @param <OUTPUT>
	 * @param input
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <OUTPUT> OUTPUT convertXmlString(String input) throws WeChatSupportException{
		try{
			return (OUTPUT) xstream.fromXML(input.toString());
		}catch(Exception e){
			throw new WeChatSupportException(String.format("%s convert to class:%s is failed!",input.toString(),clazz.getName()),e);
		}
	}
	
	protected String getMsgType(String input){
		return get(input,"MsgType");
	}
	
	protected String getEncrypt(String input){
		return get(input,"Encrypt");
	}
	
	protected String getEvent(String input){
		return get(input,"Event");
	}
	
	protected String get(String input, String nodename){
		Element element = XmlUtil.parseElement(input);
		NodeList nodelist = element.getElementsByTagName(nodename);
		return (nodelist != null && nodelist.item(0) != null) ? nodelist.item(0).getTextContent() : "";
	}
	
    protected boolean contains(String input, String nodename){
		Element element = XmlUtil.parseElement(input);
		NodeList nodelist = element.getElementsByTagName(nodename);
		return (nodelist != null && nodelist.getLength() > 0) ? true : false;
    }
    
}