package org.swinglife.reflect.demo_05;

public class Person implements Deer{

	@Override
	public void sayDeer(String name, int age) {
		System.out.println(name+" is "+age+" years old");
	}

	@Override
	public void sayHello() {
		System.out.println("hello!");
	}
	
	public Person(){
		
	}
	
	public Person(String sex){
		this.sex = sex;
	}
	
	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
