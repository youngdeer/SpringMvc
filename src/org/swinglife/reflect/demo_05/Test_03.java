package org.swinglife.reflect.demo_05;

import java.lang.reflect.Field;

public class Test_03 {
	public static void main(String[] args){
		Class<?> demo = null;
		Object obj = null;
		Field field = null;
		try {
			demo = Class.forName("org.swinglife.reflect.demo_05.Person");
			obj = demo.newInstance();
			field = demo.getDeclaredField("sex");
		} catch (Exception e) {
			e.printStackTrace();
		}
		field.setAccessible(true);
		try {
			field.set(obj, "female");
			System.out.println(field.get(obj));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}
