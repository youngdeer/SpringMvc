package org.swinglife.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import wechat.util.WeixinUtil;

@Controller   
public class HomeController {  
      
    /*** 
     * ��ҳ ������/page/home.jspҳ�� 
     * @return 
     */  
    @RequestMapping("index")  
    public ModelAndView index(HttpServletRequest req){  
        //����ģ�͸���ͼ��������Ⱦҳ�档����ָ��Ҫ���ص�ҳ��Ϊhomeҳ��  
    	String code = req.getParameter("code");
    	String openId = WeixinUtil.getOpenIdByCode(code);
    	//����openid����ȥ��userid����ȡҳ������
        ModelAndView mav = new ModelAndView("home");  
        return mav;  
    }  
    
    /**
     * errorҳ�� /page/error.jsp
     */
    @RequestMapping("error")  
    public ModelAndView error(){  
        //����ģ�͸���ͼ��������Ⱦҳ�档����ָ��Ҫ���ص�ҳ��Ϊerrorҳ��  
        ModelAndView mav = new ModelAndView("error");  
        return mav;  
    }  
} 
