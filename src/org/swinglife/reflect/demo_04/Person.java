package org.swinglife.reflect.demo_04;

public class Person {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(){
		
	}
	
	public Person(String name){
		this.name = name;
	}
	
	public Person(int age){
		this.age = age;
	}
	
	public Person(String name,int age){
		this.age = age;
		this.name = name;
	}
}
