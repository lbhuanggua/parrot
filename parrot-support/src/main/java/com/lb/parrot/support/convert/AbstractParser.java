package com.lb.parrot.support.convert;

import java.util.ArrayList;
import java.util.List;

import com.lb.parrot.support.exception.WeChatSupportException;

/**
 * 
* <p>Title: 抽象的解析集合类</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public abstract class AbstractParser {
	
	/**
	 * 类型转换器集合
	 */
	protected List<Convert> convertList = new ArrayList<Convert>();
	
	public void addWeChatConvert(Convert convert){
		if(!convertList.contains(convert)){
			convertList.add(convert);
			java.util.Collections.sort(convertList);
		}
	}
	
	public void removeWeChatConvert(Convert convert){
		if(convertList.contains(convert)){
		   convertList.remove(convert);
		   java.util.Collections.sort(convertList);
		}
	}
	
	/**
	 * 判断转换器的类型是否匹配
	 * @param convert
	 * @param mode
	 * @return
	 */
	public boolean checkConvertMode(Convert convert, ConvertMode mode){
		if (mode == null || mode == ConvertMode.ALL || convert.getConvertMode() == ConvertMode.ALL) {
			return true;
		}
		return convert.getConvertMode() == mode;
	}
	
	public abstract <T> T parse(String message, ConvertMode mode) throws WeChatSupportException;
}
