package springTest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springTest.aop.service.IHelloWorldService;

public class AopTest {

	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		
		IHelloWorldService helloWorldService = (IHelloWorldService) context.getBean("helloWorldService");
		
		helloWorldService.sayHello("param");
		
		helloWorldService.sayAfterReturning();
		
		System.out.println("----------------------------");
		helloWorldService.sayAround("lalalala");
		System.out.println("----------------------------");
		
		helloWorldService.sayAfterThrowing();
	}
	
}
