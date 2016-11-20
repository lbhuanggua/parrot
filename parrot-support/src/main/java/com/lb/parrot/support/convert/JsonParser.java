package com.lb.parrot.support.convert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lb.parrot.support.exception.WeChatSupportException;

/**
 * 
* <p>Title: json报文转换器</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public class JsonParser extends AbstractParser {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonParser.class);
	
	public <T> T parse(String message, ConvertMode mode) throws WeChatSupportException{
		return parse(JSON.parseObject(message), mode);
	}

	@SuppressWarnings("unchecked")
	private <T> T parse(JSONObject message, ConvertMode mode) throws WeChatSupportException{
		for (Convert convert : convertList) {
			LOGGER.debug("convert={}", convert.getClass());
			if (checkConvertMode(convert, mode) && convert.isMatch(message)) {
				return (T) convert.convert(message);
			}
		}
		return null;
	}

}
