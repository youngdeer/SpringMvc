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
		ModelAndView mav = new ModelAndView("deerSYS/page/userInfo/userInfoList");
		HashMap searchMap = new HashMap();
		int pageSize = 3;
		if(searchData != null && searchData != ""){
			JSONObject messageData = JSONObject.fromObject(searchData);
			Iterator<String> keys = messageData.keys();
			while(keys.hasNext()){
				String key  = keys.next();
				searchMap.put(key, messageData.get(key));
			}
			int pageNo = Integer.parseInt(searchMap.get("pageNo").toString());
			pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
			int pageStart = (pageNo-1)*pageSize;
			searchMap.put("pageStart",pageStart);
			searchMap.put("pageSize",pageSize);
			mav.addObject("currentPageNo", pageNo);
		}else{
			searchMap.put("pageStart",0);
			searchMap.put("pageSize",pageSize);
			mav.addObject("currentPageNo", 1);
		}
		List userInfoList = userInfoDao.userInfoList(searchMap);
		HashMap TotalMap = userInfoDao.countUserInfoList(searchMap);
		int totalPageNo = Integer.parseInt(TotalMap.get("total").toString())/pageSize + 1;
		mav.addObject("totalPageNo", totalPageNo);
		mav.addObject("userInfoList", userInfoList);
        return mav;  
	}
}
