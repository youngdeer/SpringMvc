package org.swinglife.reflect.demo_04;

import java.lang.reflect.Constructor;

public class Test {
	public static void main(String[] args){
		Class<?> demo = null;
		try {
			demo = Class.forName("org.swinglife.reflect.demo_04.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Person per1 = null;
		Person per2 = null;
		Person per3 = null;
		Person per4 = null;
		Constructor<?> con[] = demo.getConstructors();
		try {
			per1 = (Person) con[3].newInstance();
			per2 = (Person) con[0].newInstance("luyang");
			per3 = (Person) con[1].newInstance(20);
			per4 = (Person) con[2].newInstance("luyang",20);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(per1.getName()+":"+per1.getAge());
		System.out.println(per2.getName()+":"+per2.getAge());
		System.out.println(per3.getName()+":"+per3.getAge());
		System.out.println(per4.getName()+":"+per4.getAge());
	}
}
