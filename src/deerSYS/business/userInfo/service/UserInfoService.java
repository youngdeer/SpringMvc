package deerSYS.business.userInfo.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/deerSYS")
@SuppressWarnings("unchecked")
public class UserInfoService {

	/**
	 * userinfo编辑页面
	 * deer
	 */
	@RequestMapping("/toUserInfoEdit")
	public ModelAndView toUserInfoEdit(){
		ModelAndView mav = new ModelAndView("deerSYS/page/userInfo/userInfoEdit");  
        return mav;  
	}
}
