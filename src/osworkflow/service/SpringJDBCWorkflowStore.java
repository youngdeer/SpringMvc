package osworkflow.service;

import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
  
import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.datasource.DataSourceUtils;  
import org.springframework.jdbc.support.JdbcUtils;

import com.opensymphony.workflow.spi.jdbc.JDBCWorkflowStore;

public class SpringJDBCWorkflowStore extends JDBCWorkflowStore implements InitializingBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		entryTable = "OS_WFENTRY";  
        entryId = "ID";  
        entryName = "NAME";  
        entryState = "STATE";  
        historyTable = "OS_HISTORYSTEP";  
        currentTable = "OS_CURRENTSTEP";  
        currentPrevTable = "OS_CURRENTSTEP_PREV";  
        historyPrevTable = "OS_HISTORYSTEP_PREV";  
        stepId = "ID";  
        stepEntryId = "ENTRY_ID";  
        stepStepId = "STEP_ID";  
        stepActionId = "ACTION_ID";  
        stepOwner = "OWNER";  
        stepCaller = "CALLER";  
        stepStartDate = "START_DATE";  
        stepFinishDate = "FINISH_DATE";  
        stepDueDate = "DUE_DATE";  
        stepStatus = "STATUS";  
        stepPreviousId = "PREVIOUS_ID";
	}

	public void setDataSource(DataSource dataSource){  
        this.ds = dataSource;  
    }  
      
    public DataSource getDataSource(){  
        return this.ds;  
    }  
      
    @Override  
    protected Connection getConnection() throws SQLException {  
        return DataSourceUtils.getConnection(this.ds);  
    }  
      
    @Override  
    protected void cleanup(Connection connection, Statement statement,ResultSet result) {  
        JdbcUtils.closeStatement(statement);  
        JdbcUtils.closeResultSet(result);  
        DataSourceUtils.releaseConnection(connection, this.ds);  
          
    }  
      
    public void setEntrySequence(String entrySequence){  
        this.entrySequence = entrySequence;  
    }  
      
    public void setStepSequence(String stepSequence){  
        this.stepSequence = stepSequence;  
    }  
}
