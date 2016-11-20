package com.lb.parrot.support.convert.json;

import com.alibaba.fastjson.JSONObject;
import com.lb.parrot.support.convert.AbstractConvert;
import com.lb.parrot.support.convert.Convert;
import com.lb.parrot.support.convert.JsonToObject;
import com.lb.parrot.support.exception.WeChatSupportException;
import com.lb.parrot.support.util.ParserUtil;

/**
 * 
* <p>Title: 微信json转换基类</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public abstract class AbstractJSONObjectConvert extends AbstractConvert {

	public AbstractJSONObjectConvert(Class<?> clazz) {
		super(clazz);
	}

	/**
	 * 初始化方法
	 */
	protected void init() {
		ParserUtil.addJsonConvert((Convert) this);
	}

	public <INPUT> boolean isMatch(INPUT input) {
		if (input instanceof JSONObject) {
			return checkMatch((JSONObject) input);
		}
		return false;
	}

	public <OUTPUT, INPUT> OUTPUT convert(INPUT input) throws WeChatSupportException{
		return convertJSON((JSONObject) input);
	}

	/**
	 * 根据报文内容进行判断
	 * 
	 * @param input
	 * @return
	 */
	protected abstract boolean checkMatch(JSONObject input);

	/**
	 * 转换JSONObject为业务对象
	 * 
	 * @param <OUTPUT>
	 * @param input
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <OUTPUT> OUTPUT convertJSON(JSONObject input) throws WeChatSupportException{
		try {
			JsonToObject jsonToken = new JsonToObject(clazz);
			return (OUTPUT) jsonToken.convert(input.toJSONString());
		} catch (Exception e) {
			throw new WeChatSupportException(String.format(
					"%s convert to class:%s is failed!", input.toJSONString(),
					clazz.getName()), e);
		}
	}
}
