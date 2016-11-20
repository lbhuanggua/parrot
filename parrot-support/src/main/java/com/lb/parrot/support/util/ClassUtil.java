package com.lb.parrot.support.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassUtil {

	public static List<Field> getFields(Class<?> cls) {
		List<Field> fields = new ArrayList<Field>();
		List<Field> fieldPub = Arrays.asList(cls.getFields());
		List<Field> fieldPri = Arrays.asList(cls.getDeclaredFields());
		fields.addAll(fieldPub);
		fields.addAll(fieldPri);
		return fields;
	}
	
}
