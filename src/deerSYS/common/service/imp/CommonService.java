package deerSYS.common.service.imp;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import deerSYS.common.CommonDao;
import deerSYS.common.service.ICommonService;

@SuppressWarnings("unchecked")
public class CommonService implements ICommonService{
	
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	CommonDao commonDao = (CommonDao) context.getBean("commonDao");
	
	public void save(String tableName,HashMap tableContent){
		commonDao.save(tableName, tableContent);
//		int j = 1/0;
	}
}
