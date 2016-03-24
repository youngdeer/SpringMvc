package org.swinglife.reflect.demo_05;

import java.lang.reflect.Method;

public class Test_02 {
	public static void main(String[] args){
		Class<?> demo = null;
		Object obj = null;
		try {
			demo = Class.forName("org.swinglife.reflect.demo_05.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			obj = demo.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setter(obj,"Sex","male",String.class);
		getter(obj,"Sex");
	}
	
	public static void getter(Object obj,String att){
		try {
			Method method= obj.getClass().getMethod("get"+att);
			System.out.println(method.invoke(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setter(Object obj,String att,Object value,Class<?> type){
		try {
			Method method = obj.getClass().getMethod("set"+att, type);
			method.invoke(obj, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
