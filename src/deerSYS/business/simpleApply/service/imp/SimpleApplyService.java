package deerSYS.business.simpleApply.service.imp;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import osworkflow.service.OsWorkflowUtil;

import com.opensymphony.workflow.InvalidActionException;
import com.opensymphony.workflow.InvalidEntryStateException;
import com.opensymphony.workflow.InvalidInputException;
import com.opensymphony.workflow.InvalidRoleException;
import com.opensymphony.workflow.Workflow;
import com.opensymphony.workflow.WorkflowException;
import com.opensymphony.workflow.spi.Step;

import deerSYS.business.simpleApply.dao.SimpleApplyDao;
import deerSYS.business.simpleApply.service.ISimpleApplyService;
import deerSYS.common.CommonDao;

@SuppressWarnings("unchecked")
public class SimpleApplyService implements ISimpleApplyService{
	
	private SimpleApplyDao simpleApplyDao;
	private CommonDao commonDao;

	public CommonDao getCommonDao() {
		return commonDao;
	}

	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

	public SimpleApplyDao getSimpleApplyDao() {
		return simpleApplyDao;
	}

	public void setSimpleApplyDao(SimpleApplyDao simpleApplyDao) {
		this.simpleApplyDao = simpleApplyDao;
	}

	@Override
	public List<HashMap> simpleApplyList(HashMap searchMap) {
		return simpleApplyDao.simpleApplyList(searchMap);
	}

	@Override
	public HashMap beforeSave(HttpServletRequest request) throws InvalidActionException, InvalidRoleException, InvalidInputException, InvalidEntryStateException, WorkflowException{
		HashMap outputData = new HashMap();
		try {
			Workflow wf = OsWorkflowUtil.getWorkflow(request);
			
			HashMap inputs = new HashMap();
			inputs.put("params1", "params1");  
	        inputs.put("docTitle", "docTitle"); 
			
			long workflowId = wf.initialize("mytest", 100, inputs); 
			Step currentStep = (Step) wf.getCurrentSteps(workflowId).iterator().next();
			String workflowStatus = currentStep.getStatus();
			outputData.put("workflowId", workflowId);
			outputData.put("workflowStatus", workflowStatus);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outputData;
	}

	@Override
	public void doAction(String simpleApplyId,HttpServletRequest request){
		try {
			Workflow wf = OsWorkflowUtil.getWorkflow(request);
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
//			测试事务
//			int j = 1/0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
