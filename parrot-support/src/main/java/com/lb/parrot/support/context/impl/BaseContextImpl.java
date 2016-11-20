package com.lb.parrot.support.context.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.lb.parrot.support.context.BaseContext;

@SuppressWarnings("serial")
public class BaseContextImpl implements BaseContext, Serializable {
	private Map<String, Object> itemMap = new HashMap<String, Object>();

	public void setItemMap(Map<String, Object> itemMap) {
		this.itemMap = itemMap;
	}

	@SuppressWarnings("unchecked")
	public <T> T put(final String name, final T object) {
		return (T) itemMap.put(name, object);
	}

	@SuppressWarnings("unchecked")
	public <T> T remove(final String name) {
		return (T) itemMap.remove(name);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(final String name) {
		return (T) itemMap.get(name);
	}

	public void putAll(Map<String, Object> map) {
		this.itemMap.putAll(map);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(final String name, final T defaultValue) {
		T result = (T) itemMap.get(name);
		if (result == null) {
			result = defaultValue;
		}
		return result;
	}

	public boolean exist(String name) {
		return itemMap.containsKey(name);
	}

	public BaseContext contain(String name) {
		if (itemMap.containsKey(name)) {
			return this;
		}
		return null;
	}

	public void clear() {
		itemMap.clear();
	}

	public Map<String, Object> getItemMap() {
		return itemMap;
	}

	public int size() {
		return itemMap.size();
	}

	public boolean renameKey(String key, String newKey) {
		if (itemMap.containsKey(key)) {
			itemMap.put(newKey, itemMap.get(key));
			itemMap.remove(key);
			return true;
		}
		return false;
	}
}
