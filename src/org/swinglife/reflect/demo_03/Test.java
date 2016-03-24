package org.swinglife.reflect.demo_03;

public class Test {
	public static void main(String[] args){
		Class<?> demo = null;
		try {
			demo = Class.forName("org.swinglife.reflect.demo_03.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Person per = null;
		try {
			per = (Person) demo.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		per.setName("luyang");
		per.setAge(25);
		System.out.println(per.getName()+":"+per.getAge());
	}
}
