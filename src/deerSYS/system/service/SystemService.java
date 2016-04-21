package deerSYS.system.service;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/deerSYS")
@SuppressWarnings("unchecked")
public class SystemService {
	
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
	public Object submitRegist(HashMap inputData){
		HashMap outputData = new HashMap();
		outputData.put("result", "xxxx");
        return outputData;  
	}
}
