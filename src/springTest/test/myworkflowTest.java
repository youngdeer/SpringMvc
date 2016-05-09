package springTest.test;

import java.util.HashMap;

import com.opensymphony.workflow.InvalidActionException;
import com.opensymphony.workflow.InvalidEntryStateException;
import com.opensymphony.workflow.InvalidInputException;
import com.opensymphony.workflow.InvalidRoleException;
import com.opensymphony.workflow.Workflow;
import com.opensymphony.workflow.WorkflowException;
import com.opensymphony.workflow.basic.BasicWorkflow;

public class myworkflowTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InvalidActionException, InvalidRoleException, InvalidInputException, InvalidEntryStateException, WorkflowException{
		String caller = "testUser";  
        String params1 = "params1";  
        String docTitle = "docTitle";  
        long workflowId = 1;  
        HashMap inputs = new HashMap();  
  
        Workflow wf = new BasicWorkflow(caller);  
        inputs.put("params1", params1);  
        inputs.put("docTitle", docTitle);  
        workflowId = wf.initialize("mytest", 100, inputs);  
          
        //执行第1步动作  
        wf.doAction(workflowId, 1, inputs);  
	}
}
