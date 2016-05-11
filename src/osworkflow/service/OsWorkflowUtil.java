package osworkflow.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.workflow.Workflow;
import com.opensymphony.workflow.basic.BasicWorkflow;

public class OsWorkflowUtil {

	public static Workflow getWorkflow(){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Workflow wf = (BasicWorkflow) context.getBean("workflowTarget");
		return wf;
	}
}
