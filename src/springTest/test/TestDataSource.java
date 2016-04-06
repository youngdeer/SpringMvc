package springTest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springTest.dao.ITestDao;

public class TestDataSource {

	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ITestDao testDao = (ITestDao) context.getBean("testDao");
//		testDao.save();
		System.out.println(testDao.count());
	}
}
