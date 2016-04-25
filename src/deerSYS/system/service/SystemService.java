package deerSYS.system.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import deerSYS.common.CommonService;
import deerSYS.system.dao.SystemDao;

@Controller
@RequestMapping("/deerSYS")
@SuppressWarnings("unchecked")
public class SystemService {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	SystemDao systemDao = (SystemDao) context.getBean("systemDao");
	
	CommonService commonService = new CommonService();
	
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
	 * login页面
	 * deer
	 */
	@RequestMapping("/toLogin")
	public ModelAndView toLogin(){
		ModelAndView mav = new ModelAndView("deerSYS/page/login/login");  
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
	
	/**
	 * 验证用户名密码是否匹配
	 * deer
	 */
	public boolean isMatch(String username,String password){
		boolean falg = true;
		HashMap map = new HashMap();
		map.put("username", username);
		map.put("password", password);
		List<HashMap> list = systemDao.userAccountList(map);
		if(list == null || list.size() == 0){
			falg = false;
		}
		return falg;
	}
	
	/**
	 * 用户登陆
	 * deer
	 */
	@RequestMapping("/userLogin")
	@ResponseBody
	public HashMap userLogin(@RequestParam("username") String username,@RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response){
		HashMap outputData = new HashMap();
		if(isMatch(username,password)){
			commonService.addSession(request, "username", username);
//			System.out.println(request.getSession().getAttribute("username"));
			outputData.put("result", 1);
		}else{
			outputData.put("result", 2);
		}
		return outputData;
	}
	
	/**
	 * 用户登出
	 * deer
	 */
	@RequestMapping("/userLogout")
	public ModelAndView userLogout(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("deerSYS/page/index/index");  
		commonService.removeSession(request, "username");
        return mav; 
	}
}