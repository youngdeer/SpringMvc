package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class IpFilter implements Filter{
	
	protected FilterConfig config;
	protected String rejectedIp;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/error.html");
		String remoteIp = request.getRemoteAddr(); //获取客户请求lP
		int i = remoteIp.lastIndexOf(".");
		int j = rejectedIp.lastIndexOf(".");
		String rejectScope = rejectedIp.substring(0, j);
		String remoteScope = remoteIp.substring(0, i);
		if(rejectScope.equals(remoteScope)){
			System.out.println("**************************");
			dispatcher.forward(request, response);
			return;
		}else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config = filterConfig; //从Web务器获取过滤器配置对象  
		rejectedIp = config.getInitParameter("rejectedIp");  //从配置中取得过滤lP
	}
	
    public  String getIpAddr(HttpServletRequest request)  {  
        String ip  =  request.getHeader( " x-forwarded-for " );  
         if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {  
            ip  =  request.getHeader( " Proxy-Client-IP " );  
        }   
         if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {  
            ip  =  request.getHeader( " WL-Proxy-Client-IP " );  
        }   
         if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {  
           ip  =  request.getRemoteAddr();  
       }   
        return  ip;  
   }  

}
