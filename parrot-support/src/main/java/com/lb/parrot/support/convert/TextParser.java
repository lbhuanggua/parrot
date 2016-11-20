package com.lb.parrot.support.convert;

import com.lb.parrot.support.exception.WeChatSupportException;

/**
 * 
* <p>Title: 普通文本报文转换器</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public class TextParser extends AbstractParser {

	@SuppressWarnings("unchecked")
	public <T> T parse(String message, ConvertMode mode) throws WeChatSupportException{
		for (Convert convert : convertList) {
			if (checkConvertMode(convert, mode) && convert.isMatch(message)) {
				return (T) convert.convert(message);
			}
		}
		return null;
	}

}
