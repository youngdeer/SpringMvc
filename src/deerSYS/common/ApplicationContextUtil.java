package deerSYS.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtil {

	private static ApplicationContext context = null;

	public static ApplicationContext getContext() {
		if(context == null){
			System.out.println("--------------------create beans---------------------------");
			context = new ClassPathXmlApplicationContext("beans.xml");
		}
		return context;
	}

}
