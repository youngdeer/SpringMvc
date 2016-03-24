package org.swinglife.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.swinglife.dao.DataSource;
import org.swinglife.service.ConnectionHolderBankService;

import com.mysql.jdbc.PreparedStatement;

public class TestTransaction {
	
	protected DataSource dataSource = new DataSource();
	protected int getBankAmount(int bankId) throws SQLException{  
        Connection connection = dataSource.getConnection();  
        PreparedStatement selectStatement = (PreparedStatement) connection.prepareStatement("SELECT BANK_AMOUNT FROM BANK_ACCOUNT WHERE BANK_ID = ?");  
        selectStatement.setInt(1, bankId);  
        ResultSet resultSet = selectStatement.executeQuery();  
        resultSet.next();  
        int amount = resultSet.getInt(1);  
        resultSet.close();  
        selectStatement.close();  
        connection.close();  
        return amount;  
    }  
                                    
    protected int getInsuranceAmount(int insuranceId) throws SQLException{  
        Connection connection = dataSource.getConnection();  
        PreparedStatement selectStatement = (PreparedStatement) connection.prepareStatement("SELECT INSURANCE_AMOUNT FROM INSURANCE_ACCOUNT WHERE INSURANCE_ID = ?");  
        selectStatement.setInt(1, insuranceId);  
        ResultSet resultSet = selectStatement.executeQuery();  
        resultSet.next();  
        int amount = resultSet.getInt(1);  
        resultSet.close();  
        selectStatement.close();  
        connection.close();  
        return amount;  
    }
    
    public String assertEquals(int a , int b){
    	if(a == b){
    		return "success";
    	}else{
    		return "error";
    	}
    }
    
    public String transferSuccess() throws SQLException{   
                                  
    	ConnectionHolderBankService bankService = new ConnectionHolderBankService(dataSource);  
                                  
        bankService.transfer(1, 2, 200);  
                                  
        String a = assertEquals(800, getBankAmount(1));  
        String b = assertEquals(1200, getInsuranceAmount(2));  
        if(a.equals(b) && a.equals("success")){
        	return "success";
        }else{
        	return "error";
        }                          
    }  
                                  
    public String transferFailure() throws SQLException{  
    	ConnectionHolderBankService bankService = new ConnectionHolderBankService(dataSource);    
                                  
        int toNonExistId = 3;  
        bankService.transfer(1, toNonExistId, 200);  
                                  
        String a = assertEquals(1200, getInsuranceAmount(2));  
        String b = assertEquals(800, getBankAmount(1));  
        if(a.equals(b) && a.equals("success")){
        	return "success";
        }else{
        	return "error";
        } 
    }  
    
    public static void main(String[] args) throws SQLException{
    	TestTransaction test = new TestTransaction();
    	System.out.println(test.transferSuccess());
    	System.out.println(test.transferFailure());
    }
}
