package com.lb.parrot.pay.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BillField implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> maps = new HashMap<String, Object>();

	public Object getValue(String name) {
		return maps.get(name);
	}

	public void setValue(String name, Object value) {
		maps.put(name, value);
	}
	
}
