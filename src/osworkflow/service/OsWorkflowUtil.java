package osworkflow.service;

import org.springframework.context.ApplicationContext;

import com.opensymphony.workflow.Workflow;
import com.opensymphony.workflow.basic.BasicWorkflow;

import deerSYS.common.ApplicationContextUtil;

public class OsWorkflowUtil {

	public static Workflow getWorkflow(){
		ApplicationContext context = ApplicationContextUtil.getContext();
        Workflow wf = (BasicWorkflow) context.getBean("workflowTarget");
		return wf;
	}
}
