package springTest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springTest.dao.imp.TestDaoMybatis;

public class mybatisTest {

	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		TestDaoMybatis obj = (TestDaoMybatis) context.getBean("testDaoMybatis");
		System.out.println(obj.list());
	}
}
