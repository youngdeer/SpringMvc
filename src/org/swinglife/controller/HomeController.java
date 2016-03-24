package org.swinglife.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import wechat.util.WeixinUtil;

@Controller   
public class HomeController {  
      
    /*** 
     * 首页 返回至/page/home.jsp页面 
     * @return 
     */  
    @RequestMapping("index")  
    public ModelAndView index(HttpServletRequest req){  
        //创建模型跟视图，用于渲染页面。并且指定要返回的页面为home页面  
    	String code = req.getParameter("code");
    	String openId = WeixinUtil.getOpenIdByCode(code);
    	//根据openid反向去查userid来获取页面数据
        ModelAndView mav = new ModelAndView("home");  
        return mav;  
    }  
    
    /**
     * error页面 /page/error.jsp
     */
    @RequestMapping("error")  
    public ModelAndView error(){  
        //创建模型跟视图，用于渲染页面。并且指定要返回的页面为error页面  
        ModelAndView mav = new ModelAndView("error");  
        return mav;  
    }  
} 
