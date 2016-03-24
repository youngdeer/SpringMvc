package org.swinglife.reflect.demo_06;

import org.swinglife.reflect.Demo;

public class Test {
	public static void main(String[] args){
		Demo demo = new Demo();
		System.out.println("类加载器： "+demo.getClass().getClassLoader().getClass().getName());
	}
}
