package com.lb.parrot.support.convert.text;

import com.lb.parrot.support.convert.AbstractConvert;
import com.lb.parrot.support.convert.Convert;
import com.lb.parrot.support.exception.WeChatSupportException;
import com.lb.parrot.support.util.ParserUtil;

/**
 * 
* <p>Title: 文本类对象转换器(排除json、xml)</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public abstract class AbstractTextConvert extends AbstractConvert{

	public AbstractTextConvert(Class<?> clazz) {
		super(clazz);
	}

	/**
     * 初始化方法
     */
    protected void init(){
    	ParserUtil.addTextConvert((Convert)this);
    }

	public <INPUT> boolean isMatch(INPUT input) {
		if (input instanceof String) {
			return checkMatch((String) input);
		}
		return false;
	}
    
    /**
	 * 根据报文内容进行判断
	 * @param input
	 * @return
	 */
	protected abstract boolean checkMatch(String input);
	
	public <OUTPUT, INPUT> OUTPUT convert(INPUT input) throws WeChatSupportException{
		try{
			return convertString((String)input);
		}catch(Exception e){
			throw new WeChatSupportException(String.format("%s convert to class:%s is failed!",input,clazz.getName()),e);
		}
	}
	
	/**
	 * 转换String报文
	 * @param <OUTPUT>
	 * @param input
	 * @return
	 */
	protected abstract <OUTPUT> OUTPUT convertString(String input);
}
