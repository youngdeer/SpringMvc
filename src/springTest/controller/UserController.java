package springTest.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import springTest.service.UserService;

@Controller(value="UserController")  
@Scope(value="prototype")  
public class UserController {
	
	@Resource
	private UserService userService;

	public UserService getUserService(){
		return userService;
	}
	
}
