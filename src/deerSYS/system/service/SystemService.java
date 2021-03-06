package deerSYS.system.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import redis.clients.jedis.Jedis;

import deerSYS.common.ApplicationContextUtil;
import deerSYS.common.CommonUtil;
import deerSYS.common.RedisUtil;
import deerSYS.system.dao.SystemDao;

@Controller
@RequestMapping("/deerSYS")
@SuppressWarnings("unchecked")
public class SystemService {
	
	ApplicationContext context = ApplicationContextUtil.getContext();
	SystemDao systemDao = (SystemDao) context.getBean("systemDao");
	
	Jedis jedis = RedisUtil.getJedis();
	
	CommonUtil commonUtil = new CommonUtil();
	
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
	 * role维护页面
	 * deer
	 */
	@RequestMapping("/toRole")
	public ModelAndView toRole(){
		ModelAndView mav = new ModelAndView("deerSYS/page/role/role");
        return mav;
	}
	
	/**
	 * 获取roleList数据
	 * deer
	 */
	@RequestMapping("/getRoleList")
	@ResponseBody
	public List<HashMap> getRoleList(){
		List<HashMap> list = systemDao.roleList(new HashMap());
		return list;
	}
	
	/**
	 * 获取roleListTree
	 * deer
	 */
	@RequestMapping("/getRoleTree")
	@ResponseBody
	public List<HashMap> getRoleTree(){
		return getRoleList("");
	}
	
	public List<HashMap> getRoleList(String parentId){
		HashMap searchMap = new HashMap();
		searchMap.put("parentId", parentId);
		List<HashMap> list = systemDao.roleList(searchMap);
		
		if(list.size() > 0 && list != null){
			for(int i = 0; i < list.size(); i++){
				HashMap map = list.get(i);
				String roleId = (String) map.get("roleId");
				List<HashMap> children = getRoleList(roleId);
				map.put("children", children);
			}
		}
		return list;
	}
	
	/**
	 * userrole维护页面
	 * deer
	 */
	@RequestMapping("/toUserRole")
	public ModelAndView toUserRole(){
		ModelAndView mav = new ModelAndView("deerSYS/page/role/userRole");
		List<HashMap> userAccountList = systemDao.userAccountList(new HashMap());
		mav.addObject("userAccountList", userAccountList);
        return mav;
	}
	
	/**
	 * 提交userrole绑定关系
	 * deer
	 * @return
	 */
	@RequestMapping("/submitUserRole")
	@ResponseBody
	public HashMap submitUserRole(@RequestParam("checkedUser") String checkedUser,@RequestParam("checkedRole") String checkedRole){
		HashMap outputData = new HashMap();
		String[] users = checkedUser.substring(0, checkedUser.length()-1).split(",");
		String[] roles = checkedRole.substring(0, checkedRole.length()-1).split(",");
		HashMap searchMap = new HashMap();
		HashMap newUserRole = new HashMap();
		if(users.length > 0){
			for(String user:users){
//				System.out.println("user: "+user);
				searchMap.put("userId", user);
				newUserRole.put("userId", user);
				List<HashMap> list = systemDao.userRoleList(searchMap);
				if(list != null && list.size() > 0){
					systemDao.deleteUserRole(searchMap);
				}
				if(roles.length > 0){
					for(String role:roles){
//						System.out.println("role: "+role);
						newUserRole.put("roleId", role);
						systemDao.insertUserRole(newUserRole);
					}
				}
			}
		}
		outputData.put("result", true);
        return outputData;  
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
			//使用session操作会话
			commonUtil.addSession(request, "username", username);
			//使用redis操作会话
			jedis.setex("username", 5, username);
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
		//使用session操作会话
		commonUtil.removeSession(request, "username");
		//使用redis操作会话
		jedis.del("username");
        return mav; 
	}
}
