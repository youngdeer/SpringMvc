package deerSYS.business.simpleApply.service;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import osworkflow.service.OsWorkflowUtil;

import com.opensymphony.workflow.InvalidActionException;
import com.opensymphony.workflow.InvalidEntryStateException;
import com.opensymphony.workflow.InvalidInputException;
import com.opensymphony.workflow.InvalidRoleException;
import com.opensymphony.workflow.Workflow;
import com.opensymphony.workflow.WorkflowException;
import com.opensymphony.workflow.spi.Step;

@Controller
@RequestMapping("/deerSYS/SimpleApply")
@SuppressWarnings("unchecked")
public class SimpleApplyService {

	/**
	 * simpleApply编辑页面
	 * deer
	 */
	@RequestMapping("/toSimpleApply")
	public ModelAndView toSimpleApply(){
		ModelAndView mav = new ModelAndView("deerSYS/page/simpleApply/simpleApply");  
        return mav;  
	}
	
	/**
	 * beforeSave方法
	 * deer
	 * @throws WorkflowException 
	 * @throws InvalidEntryStateException 
	 * @throws InvalidInputException 
	 * @throws InvalidRoleException 
	 * @throws InvalidActionException 
	 */
	@RequestMapping("/beforeSave")
	@ResponseBody
	public HashMap beforeSave() throws InvalidActionException, InvalidRoleException, InvalidInputException, InvalidEntryStateException, WorkflowException{
		HashMap outputData = new HashMap();
		Workflow wf = OsWorkflowUtil.getWorkflow();
		
		HashMap inputs = new HashMap();
		inputs.put("params1", "params1");  
        inputs.put("docTitle", "docTitle"); 
		
		long workflowId = wf.initialize("mytest", 100, inputs); 
		Step currentStep = (Step) wf.getCurrentSteps(workflowId).iterator().next();
		String workflowStatus = currentStep.getStatus();
		outputData.put("workflowId", workflowId);
		outputData.put("workflowStatus", workflowStatus);
		return outputData;
	}
}
