package org.swinglife.reflect.demo_05;

import java.lang.reflect.Array;

public class Test_04 {
	public static void main(String[] args){
		int[] temp = {1,2,3,4};
		Class<?> demo = temp.getClass().getComponentType();
		System.out.println("数组类型： "+demo.getName());
		System.out.println("数组长度： "+Array.getLength(temp));
		System.out.println("数组第一个元素： "+Array.get(temp, 0));
		Array.set(temp, 0, 100);
		System.out.println("数组第一个元素： "+Array.get(temp, 0));
	}
}
