package org.swinglife.service;

import org.swinglife.dao.DataSource;
import org.swinglife.dao.FailureBankDao;
import org.swinglife.dao.FailureInsuranceDao;
import org.swinglife.util.TransactionManager;
import org.swinglife.util.TransactionTemplate;

public class ConnectionHolderBankService implements BankService{  
	private DataSource dataSource; 
    private FailureBankDao failureBankDao;  
    private FailureInsuranceDao failureInsuranceDao;  
         
    public ConnectionHolderBankService(DataSource dataSource){  
    	this.dataSource = dataSource;  
        failureBankDao = new FailureBankDao(dataSource);  
        failureInsuranceDao = new FailureInsuranceDao(dataSource);  
         
    }  
         
    public void transfer(final int fromId, final int toId, final int amount){  
    	new TransactionTemplate(dataSource)  
        {  
            @Override  
            protected void doJob() throws Exception  
            {  
            	failureBankDao.withdraw(fromId, amount);  
            	failureInsuranceDao.deposit(toId, amount);  
            }  
        }.doJobInTransaction();
    }  
}
