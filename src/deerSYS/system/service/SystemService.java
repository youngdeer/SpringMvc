package deerSYS.system.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import deerSYS.system.dao.SystemDao;

@Controller
@RequestMapping("/deerSYS")
@SuppressWarnings("unchecked")
public class SystemService {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	SystemDao systemDao = (SystemDao) context.getBean("systemDao");
	
	/**
	 * index页面
	 * deer
	 */
	@RequestMapping("/toIndex")
	public ModelAndView toIndex(){
		ModelAndView mav = new ModelAndView("deerSYS/page/index/index");  
        return mav;  
	}
	
	/**
	 * regist页面
	 * deer
	 */
	@RequestMapping("/toRegist")
	public ModelAndView toRegist(){
		ModelAndView mav = new ModelAndView("deerSYS/page/regist/regist");  
        return mav;  
	}
	
	/**
	 * 提交注册
	 * deer
	 */
	@RequestMapping("/submitRegist")
	@ResponseBody
	public HashMap submitRegist(@RequestParam("username") String username,@RequestParam("password") String password){
		HashMap outputData = new HashMap();
		if(!isExistUsername(username)){
			HashMap map = new HashMap();
			map.put("username", username);
			map.put("password", password);
			int result = systemDao.insertUserAccount(map);
			outputData.put("result", result);
		}else{
			outputData.put("result", 2);
		}
		
        return outputData;  
	}
	
	/**
	 * 验证用户名是否存在
	 * deer
	 */
	public boolean isExistUsername(String username){
		boolean falg = true;
		HashMap searchMap = new HashMap();
		searchMap.put("username", username);
		List<HashMap> list = systemDao.userAccountList(searchMap);
		if(list == null || list.size() == 0){
			falg = false;
		}
		return falg;
	}
}
