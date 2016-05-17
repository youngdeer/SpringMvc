package osworkflow.test;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.context.ApplicationContext;

import com.opensymphony.workflow.InvalidActionException;
import com.opensymphony.workflow.InvalidEntryStateException;
import com.opensymphony.workflow.InvalidInputException;
import com.opensymphony.workflow.InvalidRoleException;
import com.opensymphony.workflow.Workflow;
import com.opensymphony.workflow.WorkflowException;
import com.opensymphony.workflow.spi.Step;

import deerSYS.common.ApplicationContextUtil;

public class myworkflowTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InvalidActionException, InvalidRoleException, InvalidInputException, InvalidEntryStateException, WorkflowException{
		String caller = "testUser";  
        String params1 = "params1";  
        String docTitle = "docTitle";  
        long workflowId = 1;  
        HashMap inputs = new HashMap();  
  
//        传统配置
//        Workflow wf = new BasicWorkflow(caller);
        
//        spring方式
        ApplicationContext context = ApplicationContextUtil.getContext();
        Workflow wf = (Workflow) context.getBean("workflowTarget");
        
        inputs.put("params1", params1);  
        inputs.put("docTitle", docTitle);  
        workflowId = wf.initialize("mytest", 100, inputs);  
        
          
        Collection currentSteps = wf.getCurrentSteps(workflowId);
        System.out.println("size: "+currentSteps.size());
        
        Step currentStep = (Step) currentSteps.iterator().next();
        System.out.println("stepId: "+currentStep.getStepId());
        System.out.println("ststus: "+currentStep.getStatus());
        
        int[] availableActions = wf.getAvailableActions(workflowId, inputs);
        System.out.println("availableActions length: "+availableActions.length);
        
        System.out.println("availableAction: "+availableActions[0]);
        
        System.out.println("after doAction---------------------------------");
        //执行第1步动作  
        wf.doAction(workflowId, 1, inputs);  
        
        Collection nextCurrentSteps = wf.getCurrentSteps(workflowId);
        System.out.println("size: "+nextCurrentSteps.size());
        
        Step nextCurrentStep = (Step) nextCurrentSteps.iterator().next();
        System.out.println("stepId: "+nextCurrentStep.getStepId());
        System.out.println("ststus: "+nextCurrentStep.getStatus());
        
        int[] nextAvailableActions = wf.getAvailableActions(workflowId, inputs);
        System.out.println("availableActions length: "+nextAvailableActions.length);
        
        System.out.println("availableAction: "+nextAvailableActions[0]);
        
        System.out.println("after doAction---------------------------------");
        
      //执行第2步动作  
        wf.doAction(workflowId, 2, inputs);
        
        Collection nextCurrentSteps1 = wf.getCurrentSteps(workflowId);
        System.out.println("size: "+nextCurrentSteps1.size());
        
        Step nextCurrentStep1 = (Step) nextCurrentSteps1.iterator().next();
        System.out.println("stepId: "+nextCurrentStep1.getStepId());
        System.out.println("ststus: "+nextCurrentStep1.getStatus());
        
        int[] nextAvailableActions1 = wf.getAvailableActions(workflowId, inputs);
        System.out.println("availableActions length: "+nextAvailableActions1.length);
        
        System.out.println("availableAction: "+nextAvailableActions1[0]);
	}
}
