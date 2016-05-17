package deerSYS.business.simpleApply.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.opensymphony.workflow.InvalidActionException;
import com.opensymphony.workflow.InvalidEntryStateException;
import com.opensymphony.workflow.InvalidInputException;
import com.opensymphony.workflow.InvalidRoleException;
import com.opensymphony.workflow.WorkflowException;

import deerSYS.business.simpleApply.service.imp.SimpleApplyService;
import deerSYS.common.ApplicationContextUtil;

@Controller
@RequestMapping("/deerSYS")
@SuppressWarnings("unchecked")
public class SimpleApplyController {

	ApplicationContext context = ApplicationContextUtil.getContext();
	SimpleApplyService simpleApplyService = (SimpleApplyService) context.getBean("simpleApplyService");

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
		List simpleApplyList = simpleApplyService.simpleApplyList(searchMap);
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
	public HashMap beforeSave(HttpServletRequest request){
		HashMap outputData = new HashMap();
		try {
			outputData = simpleApplyService.beforeSave(request);
		} catch (InvalidActionException e) {
			e.printStackTrace();
		} catch (InvalidRoleException e) {
			e.printStackTrace();
		} catch (InvalidInputException e) {
			e.printStackTrace();
		} catch (InvalidEntryStateException e) {
			e.printStackTrace();
		} catch (WorkflowException e) {
			e.printStackTrace();
		}
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
	public boolean doAction(@RequestParam("simpleApplyId")String simpleApplyId,HttpServletRequest request){
		boolean result = true;
		simpleApplyService.doAction(simpleApplyId,request);
		return result;
	}
}
