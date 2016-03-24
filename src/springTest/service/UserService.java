package springTest.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import springTest.dao.UserDao;

@Service(value="UserService")
public class UserService {
	
	@Resource
	private UserDao userDao;
	
	public UserDao getUserDao(){
		return userDao;
	}
	
	public void setUserDao(){
		this.userDao = userDao;
	}

}
