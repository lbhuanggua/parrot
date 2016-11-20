package com.lb.parrot.support.convert;

import com.alibaba.fastjson.JSON;

public class JsonToObject<T> implements Converter<String, T> {
	private Class<T> rootClass;

	public JsonToObject(Class<T> rootClass) {
		super();
		this.rootClass = rootClass;
	}

	public T convert(String inputData) {
		return JSON.parseObject(inputData, rootClass);
	}

}
