package org.swinglife.reflect.demo_02;

import org.swinglife.reflect.Demo;

public class Test {
	public static void main(String[] args){
		Class<?> demo1 = null;
		Class<?> demo2 = null;
		Class<?> demo3 = null;
		try{
			demo1 = Class.forName("org.swinglife.reflect.Demo");
		}catch(Exception e){
			e.printStackTrace();
		}
		demo2 = new Demo().getClass();
		demo3 = Demo.class;
		System.out.println("className:"+demo1.getName());
		System.out.println("className:"+demo2.getName());
		System.out.println("className:"+demo3.getName());
	}
}
