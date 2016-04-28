package deerSYS.common;

import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/deerSYS")
@SuppressWarnings("unchecked")
public class CommonService {
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	CommonDao commonDao = (CommonDao) context.getBean("commonDao");
	
	public static void addSession(HttpServletRequest request,String key,Object value){
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30*2);
		session.setAttribute(key, value);
	}
	
	public static void removeSession(HttpServletRequest request,String key){
		HttpSession session = request.getSession();
		session.removeAttribute(key);
	}
	
	/**
	 * 公用保存
	 * deer
	 */
	@RequestMapping("/save")
	@ResponseBody
	public boolean save(@RequestParam("tableName")String tableName,@RequestParam("data")String data){
		boolean result = true;
		HashMap tableContent = new HashMap();
		JSONObject messageData = JSONObject.fromObject(data);
		Iterator<String> keys = messageData.keys();
		while(keys.hasNext()){
			String key  = keys.next();
			tableContent.put(key, messageData.get(key));
		}
		commonDao.save(tableName, tableContent);
		return result;
	}
}
