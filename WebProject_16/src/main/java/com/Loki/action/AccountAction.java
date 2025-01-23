package com.Loki.action;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.Loki.beans.Account;
import com.Loki.factories.ConnectionFactory;

public class AccountAction {
 public String addAccount(Account account) {
	 String status="";
	 try {
		 Connection connection=ConnectionFactory.getConnection();
		 PreparedStatement pr=connection.prepareStatement("insert into account values(?,?,?,?,?,?)");
		 pr.setString(1,account.getAccNo());
		 pr.setString(2, account.getAccHolderName());
		 pr.setString(3, account.getAccType());
		 pr.setDouble(4, account.getBalance());
		 pr.setString(5, account.getAccBranch());
		 pr.setString(6, account.getAccBank());
		 int rowCount=pr.executeUpdate();
		 if(rowCount==1) {
			 status="success";
		 }else {
			 status="failed";
		 }
		 
		 
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	return status;
 }
}
