package com.lb.parrot.support.context;

import java.io.Serializable;
import java.util.Map;

/**
 * 
* <p>Title: 普通的环境，不支持多层嵌套</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public interface BaseContext extends Serializable{
	/**
	 * 添加到环境
	 * 
	 * @param name
	 * @param object
	 */
	<T> T put(String name, T object);

	/**
	 * 把环境中某键值的名字换成另外的名字
	 * @param key
	 * @param newKey
	 * @return
	 */
	boolean renameKey(String key, String newKey);

	/**
	 * 遍历所有删除及子环境并删除找到的第一个
	 * 
	 * @param name
	 * @return
	 */
	<T> T remove(String name);

	/**
	 * 获取对象，如果当前环境中没有，则到子环境当中寻找
	 * 
	 * @param name
	 * @return
	 */
	<T> T get(String name);

    void putAll(Map<String,Object>map);

	/**
	 * 
	 * @param name
	 * @param defaultValue
	 *            默认值
	 * @return
	 */
	<T> T get(String name, T defaultValue);

	int size();

	/**
	 * 检测变量是否存在
	 * 
	 * @param name
	 * @return 返回是否存在
	 */
	boolean exist(String name);

	BaseContext contain(String name);
	/**
	 * 删除环境中的所有内容
	 */
	void clear();

	/**
	 * 返回环境中所有内容
	 * 
	 * @return
	 */
	Map<String, Object> getItemMap();

}