package deerSYS.business.simpleApply.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

import deerSYS.business.simpleApply.dao.SimpleApplyDao;
import deerSYS.common.CommonDao;

@Controller
@RequestMapping("/deerSYS/SimpleApply")
@SuppressWarnings("unchecked")
public class SimpleApplyService {
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	SimpleApplyDao simpleApplyDao = (SimpleApplyDao) context.getBean("simpleApplyDao");
	CommonDao commonDao = (CommonDao) context.getBean("commonDao");
	
	Workflow wf = OsWorkflowUtil.getWorkflow();

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
	 * simpleApplyList页面
	 * deer
	 */
	@RequestMapping("/toSimpleApplyList")
	public ModelAndView toSimpleApplyList(){
		ModelAndView mav = new ModelAndView("deerSYS/page/simpleApply/simpleApplyList");  
		HashMap searchMap = new HashMap();
		List simpleApplyList = simpleApplyDao.simpleApplyList(searchMap);
		mav.addObject("simpleApplyList", simpleApplyList);
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
	
	/**
	 * simpleApply doAction方法
	 * deer
	 * @throws WorkflowException 
	 * @throws InvalidInputException 
	 */
	@RequestMapping("/doAction")
	@ResponseBody
	public boolean doAction(@RequestParam("simpleApplyId")String simpleApplyId) throws InvalidInputException, WorkflowException{
		boolean result = true;
		HashMap searchMap = new HashMap();
		searchMap.put("simpleApplyId", simpleApplyId);
		List simpleApplyList = simpleApplyDao.simpleApplyList(searchMap);
		HashMap simpleApplyMap = (HashMap) simpleApplyList.get(0);
		long workflowId = Integer.parseInt((String) simpleApplyMap.get("workflowId"));
		
		HashMap inputs = new HashMap();
		inputs.put("params1", "params1");  
        inputs.put("docTitle", "docTitle"); 
		
		wf.doAction(workflowId, 1, inputs);
		Step currentStep = (Step) wf.getCurrentSteps(workflowId).iterator().next();
		String workflowStatus = currentStep.getStatus();
		simpleApplyMap.put("workflowStatus", workflowStatus);
		commonDao.update("simpleApply", simpleApplyMap);
		return result;
	}
}
