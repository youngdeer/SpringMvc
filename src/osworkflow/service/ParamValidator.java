package osworkflow.service;

import java.util.Map;

import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.workflow.InvalidInputException;
import com.opensymphony.workflow.Validator;
import com.opensymphony.workflow.WorkflowException;

public class ParamValidator implements Validator{

	@Override
	public void validate(Map transientVars, Map map1, PropertySet propertyset) throws InvalidInputException, WorkflowException {
		String params1 = (String) transientVars.get("params1");
		if(params1 == null)
	      throw new InvalidInputException("Missing params1");
	    if(params1.length() > 30)
	      throw new InvalidInputException("params1 title too long");
	}

}
