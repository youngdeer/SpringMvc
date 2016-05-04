package springTest.test;

import org.apache.log4j.Logger;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springTest.beans.Hello;

public class TestHello {
	private static Logger logger = Logger.getLogger(TestHello.class);
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Hello obj = (Hello) context.getBean("hello");
		obj.sayHello();
		
		Hello obj1 = (Hello) context.getBean("hello1");
		obj1.sayHi();
		
		Hello obj2 = (Hello) context.getBean("hello2");
		obj2.sayHi();
		
		Hello obj3 = (Hello) context.getBean("hello3");
		obj3.sayHi();
		
		Hello obj4 = (Hello) context.getBean("hello4");
		obj4.sayHi();
		
		logger.info("logger info");
	}
}
