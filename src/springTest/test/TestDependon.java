package springTest.test;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import springTest.beans.DependentBean;

public class TestDependon {

	public static void main(String[] args) throws IOException{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		context.registerShutdownHook();
		DependentBean obj = (DependentBean) context.getBean("dependentBean");
		obj.write("deer!!!");
	}
}
