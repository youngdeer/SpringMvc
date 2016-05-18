package springTest.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;

import deerSYS.common.ApplicationContextUtil;
import deerSYS.system.dao.SystemDao;

public class SqlTest {
	static ApplicationContext context = ApplicationContextUtil.getContext();
	static SystemDao systemDao = (SystemDao) context.getBean("systemDao");

	public static void main(String args[]){
		List<HashMap> list = getRoleList("");
		System.out.println(list);
	}
	
	public static List<HashMap> getRoleList(String parentId){
		HashMap searchMap = new HashMap();
		searchMap.put("parentId", parentId);
		List<HashMap> list = systemDao.roleList(searchMap);
		
		if(list.size() > 0 && list != null){
			for(int i = 0; i < list.size(); i++){
				HashMap map = list.get(i);
				String roleId = (String) map.get("roleId");
				List<HashMap> children = getRoleList(roleId);
				map.put("children", children);
			}
		}
		return list;
	}
}
