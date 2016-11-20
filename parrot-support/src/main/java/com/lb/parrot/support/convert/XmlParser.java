package com.lb.parrot.support.convert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lb.parrot.support.exception.WeChatSupportException;

/**
 * 
* <p>Title: XML报文转换器</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public class XmlParser extends AbstractParser{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(XmlParser.class);
	
	@SuppressWarnings("unchecked")
	public <T> T parse(String message, ConvertMode mode) throws WeChatSupportException{
		for (Convert convert : convertList) {
			LOGGER.debug("convert priority : {} , mode : {}, class name : {}", convert.getPriority(), convert.getConvertMode(), convert.getClass().getName());
			if (checkConvertMode(convert, mode) && convert.isMatch(message)) {
				LOGGER.debug("class {} converting ...", convert.getClass().getName());
				return (T) convert.convert(message);
			}
		}
		return null;
	}
	
}
