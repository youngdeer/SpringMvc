package springTest.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCircle {
	public static void main(String[] args){
		new ClassPathXmlApplicationContext("circleBeans.xml");
	}
}
