package osworkflow.test;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;

import com.opensymphony.workflow.InvalidActionException;
import com.opensymphony.workflow.InvalidEntryStateException;
import com.opensymphony.workflow.InvalidInputException;
import com.opensymphony.workflow.InvalidRoleException;
import com.opensymphony.workflow.Workflow;
import com.opensymphony.workflow.WorkflowException;
import com.opensymphony.workflow.basic.BasicWorkflow;
import com.opensymphony.workflow.config.Configuration;

import deerSYS.common.ApplicationContextUtil;

public class SpringOsworkflowTest {

	public static void main(String[] args) throws InvalidActionException, InvalidRoleException, InvalidInputException, InvalidEntryStateException, WorkflowException{
		ApplicationContext context = ApplicationContextUtil.getContext();
		Configuration config = (Configuration) context.getBean("osworkflowConfiguration");
		
		Workflow workflow  = new BasicWorkflow("luyang");
		workflow.setConfiguration(config);
		
		HashMap inputs = new HashMap();  
		inputs.put("params1", "1");  
        inputs.put("docTitle", "2"); 
		
		workflow.initialize("mytest", 100, inputs);
	}
	
}
