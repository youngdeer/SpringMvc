package org.swinglife.util;

import org.swinglife.dao.DataSource;

public abstract class TransactionTemplate{  
    private TransactionManager transactionManager;  
       
    protected TransactionTemplate(DataSource dataSource){  
        transactionManager = new TransactionManager(dataSource);  
    }  
       
    public void doJobInTransaction(){  
        try{  
            transactionManager.start();  
            doJob();  
            transactionManager.commit();  
        } catch (Exception e){  
            transactionManager.rollback();  
        } finally{  
            transactionManager.close();  
        }  
    }  
       
    protected abstract void doJob() throws Exception;  
}
