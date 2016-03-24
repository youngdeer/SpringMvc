package org.swinglife.reflect.demo_05;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Test_01 {
	public static void main(String[] args){
		Class<?> demo = null;
		try {
			demo = Class.forName("org.swinglife.reflect.demo_05.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Class<?> intes[] = demo.getInterfaces();
		for(int i = 0; i < intes.length; i++){
			System.out.println("interface: "+intes[i].getName());
		}
		
		Class<?> temp = demo.getSuperclass();
		System.out.println("super class: "+temp.getName());
		
		Constructor<?> con[] = demo.getConstructors();
		for(int i = 0; i < con.length; i++){
			System.out.println("构造方法： "+con[i]);
		}
		
		try {
			Method method = demo.getMethod("sayHello");
			method.invoke(demo.newInstance());
			
			method = demo.getMethod("sayDeer", String.class,int.class);
			method.invoke(demo.newInstance(),"luyang",25);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
