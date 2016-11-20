package com.lb.parrot.support.context;

import java.util.Map;

/**
 * 
* <p>Title: 多层环境</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public interface Context extends BaseContext {
	/**
	 * 创建子上下文
	 * 
	 * @param contextName
	 * @return
	 */
	Context createSubContext(String contextName);


	/**
	 * 从子环境删除
	 * @param contextName 子环境
	 * @param name 上下文变量名称
	 */
	<T> T remove(String contextName, String name);

	/**
	 * 从指定子环境获取变量
	 * 
	 * @param contextName 子环境
	 * @param name 上下文变量名称
	 * @return @
	 */
	<T> T getInSubContext(String contextName, String name);

	/**
	 * 添加到子环境
	 * 
	 * @param contextName 子环境
	 * @param name 上下文变量名称
	 * @param object 要放入的数据
	 *            
	 */
	<T> T put(String contextName, String name, T object);

	/**
	 * 返回父亲
	 * 
	 * @return
	 */
	Context getParent();

	/**
	 * 设置父亲
	 * 
	 * @param parent
	 */
	void setParent(Context parent);

	/**
	 * 添加子环境
	 * 
	 * @param contextName 子环境
	 * @param context
	 * @return
	 */
	Context putSubContext(String contextName, Context context);

	/**
	 * 删除子上下文
	 * 
	 * @param contextName 子环境
	 */
	Context removeSubContext(String contextName);

	/**
	 * 返回子环境
	 * 
	 * @param contextName 子环境
	 * @return 子环境
	 */
	Context getSubContext(String contextName);
	/**
	 * 删除所有子上下文
	 */
	void clearSubContext();

	/**
	 * 返回子环境MAP
	 * 
	 * @return 子环境MAP
	 */
	Map<String, Context> getSubContextMap();
	
	/**
	 * 返回当前环境(不包含子环境)中所有内容
	 * 
	 * @return
	 */
	Map<String, Object> getItemMap();
	
	/**
	 * 返回环境(包含子环境)中所有内容
	 * 
	 * @return
	 */
	Map<String, Object> getTotalItemMap();

}