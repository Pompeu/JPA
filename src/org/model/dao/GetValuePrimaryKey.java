package org.model.dao;

import java.lang.reflect.Field;

public class GetValuePrimaryKey {
	private GetValuePrimaryKey() {
	}

	public static Integer getID(Object object) {
		Field field = object.getClass().getDeclaredFields()[1];
		field.setAccessible(true);
		Integer id = null;
		try {
			id = (Integer) field.get(object);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return id;
	}
}
