package osworkflow.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;

import com.opensymphony.workflow.Workflow;
import com.opensymphony.workflow.basic.BasicWorkflow;
import com.opensymphony.workflow.config.Configuration;

import deerSYS.common.ApplicationContextUtil;

public class OsWorkflowUtil {

	public static Workflow getWorkflow(HttpServletRequest request) throws NullPointerException{
		ApplicationContext context = ApplicationContextUtil.getContext();
		Configuration config = (Configuration) context.getBean("osworkflowConfiguration");
		String caller = (String) request.getSession().getAttribute("username");
		if(caller == null){
			throw new NullPointerException("caller is null");
		}
		Workflow workflow  = new BasicWorkflow(caller);
		workflow.setConfiguration(config);
		return workflow;
	}
}
