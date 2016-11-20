package com.lb.parrot.support.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lb.parrot.support.common.ToServerUrl;

/**
 * 
* <p>Title: 微信请求链接渲染器</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public class RendUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RendUtil.class);
	
	public static String rendUrl(ToServerUrl message) {
		String key = message.getKey();
		String url = message.getUrl();
		LOGGER.debug("请求渲染前:{} ", url);
		Class<?> clazz = message.getClass();
		List<Field> fields = ClassUtil.getFields(clazz);
		for (Field f : fields) {
			PropertyDescriptor pd;
			try {
				pd = new PropertyDescriptor(f.getName(), clazz);
				Method method = pd.getReadMethod();
				String result = (String) method.invoke(message);
				String reff = new StringBuffer("#").append(key).append(".").append(f.getName()).append("#").toString();
				url = url.replaceAll(reff, result);
			} catch (IntrospectionException e) {
				LOGGER.error(e.getMessage(), e);
			} catch (IllegalAccessException e) {
				LOGGER.error(e.getMessage(), e);
			} catch (IllegalArgumentException e) {
				LOGGER.error(e.getMessage(), e);
			} catch (InvocationTargetException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
		LOGGER.debug("请求渲染后:{} ", url);
		return url;
	}
	

}
