package deerSYS.business.simpleApply.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.workflow.InvalidActionException;
import com.opensymphony.workflow.InvalidEntryStateException;
import com.opensymphony.workflow.InvalidInputException;
import com.opensymphony.workflow.InvalidRoleException;
import com.opensymphony.workflow.WorkflowException;

@SuppressWarnings("unchecked")
public interface ISimpleApplyService {
	
	public List<HashMap> simpleApplyList(HashMap searchMap);
	
	public HashMap beforeSave(HttpServletRequest request) throws InvalidActionException, InvalidRoleException, InvalidInputException, InvalidEntryStateException, WorkflowException;
	
	public void doAction(String simpleApplyId,HttpServletRequest request);
}
