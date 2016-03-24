package org.swinglife.controller;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.swinglife.form.UnifiedOrder;

public class UnifiedOrderController {

	/*** 
     * 统一下单
     * @return 
     */  
    @RequestMapping(value="unifiedorder",method=RequestMethod.POST)  
    public String unifiedorder(UnifiedOrder orderInfo){  
    	String prepay_id = "";
    	
    	
        return prepay_id;
    }  
}
