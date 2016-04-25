package deerSYS.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommonService {
	
	public static void addSession(HttpServletRequest request,String key,Object value){
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30*2);
		session.setAttribute(key, value);
	}
	
	public static void removeSession(HttpServletRequest request,String key){
		HttpSession session = request.getSession();
		session.removeAttribute(key);
	}
}