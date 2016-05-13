package deerSYS.common;

import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import deerSYS.common.service.ICommonService;

@Controller
@RequestMapping("/deerSYS")
@SuppressWarnings("unchecked")
public class CommonUtil {
	ApplicationContext context = ApplicationContextUtil.getContext();
	
	ICommonService commonService = (ICommonService) context.getBean("commonService");
	
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
	 * 单表公用保存
	 * deer
	 */
	@RequestMapping("/save")
	@ResponseBody
	public boolean save(@RequestParam("tableName")String tableName,@RequestParam("data")String data){
		boolean result = true;
		HashMap tableContent = parseData(data);
		commonService.save(tableName, tableContent);
		return result;
	}
	
	/**
	 * 单表公用更新
	 * deer
	 */
	@RequestMapping("/update")
	@ResponseBody
	public boolean update(@RequestParam("tableName")String tableName,@RequestParam("data")String data){
		boolean result = true;
		HashMap tableContent = parseData(data);
		commonService.update(tableName, tableContent);
		return result;
	}
	
	/**
	 * 解析单表数据
	 * @param data
	 * @return
	 */
	public HashMap parseData(String data){
		HashMap map = new HashMap();
		JSONObject messageData = JSONObject.fromObject(data);
		Iterator<String> keys = messageData.keys();
		while(keys.hasNext()){
			String key  = keys.next();
			map.put(key, messageData.get(key));
		}
		return map;
	}
}
