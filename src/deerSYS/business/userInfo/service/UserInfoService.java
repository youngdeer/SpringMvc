package deerSYS.business.userInfo.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import deerSYS.business.userInfo.dao.UserInfoDao;

@Controller
@RequestMapping("/deerSYS")
@SuppressWarnings("unchecked")
public class UserInfoService {
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	UserInfoDao userInfoDao = (UserInfoDao) context.getBean("userInfoDao");

	/**
	 * userinfo编辑页面
	 * deer
	 */
	@RequestMapping("/toUserInfoEdit")
	public ModelAndView toUserInfoEdit(){
		ModelAndView mav = new ModelAndView("deerSYS/page/userInfo/userInfoEdit");  
        return mav;  
	}
	
	/**
	 * userinfo列表页面
	 * deer
	 */
	@RequestMapping("/toUserInfoList")
	public ModelAndView toUserInfoList(String searchData){
		HashMap searchMap = new HashMap();
		if(searchData != null && searchData != ""){
			JSONObject messageData = JSONObject.fromObject(searchData);
			Iterator<String> keys = messageData.keys();
			while(keys.hasNext()){
				String key  = keys.next();
				searchMap.put(key, messageData.get(key));
			}
		}
		ModelAndView mav = new ModelAndView("deerSYS/page/userInfo/userInfoList");
		List userInfoList = userInfoDao.userInfoList(searchMap);
		mav.addObject("userInfoList", userInfoList);
        return mav;  
	}
}
