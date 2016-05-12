package springTest.test;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springTest.dao.imp.TestDaoMybatis;

@SuppressWarnings("unchecked")
public class mybatisTest {

	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		TestDaoMybatis obj = (TestDaoMybatis) context.getBean("testDaoMybatis");
		System.out.println(obj.list());
		HashMap map = new HashMap();
//		map.put("id", 5);
//		map.put("msg", "eee");
//		obj.insert(map);
		obj.deleteById("4");
	}
}
