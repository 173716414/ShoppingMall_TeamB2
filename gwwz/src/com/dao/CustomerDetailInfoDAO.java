package com.dao;
import java.util.ArrayList;

import com.common.DBConn;
import com.entity.CustomerDetailInfo;

public class CustomerDetailInfoDAO {

	
public void addCustomerDetailInfo(int customerId,String name,String telephone,String movePhone,String address){
		
		String sql  = "insert into  CustomerDetailInfo values("+customerId+",'"+name+"','"+telephone+"','"+movePhone+"','"+address+"')";
		DBConn.ExecuteUD(sql);//执行SQL语句
	}
	
public CustomerDetailInfo getCustomerDetailInfo(int customerId){
	
	boolean isCustomerDetailInfo = isCustomerDetailInfo(customerId);
	if(isCustomerDetailInfo == true){
		String sql = "select * from CustomerDetailInfo where customerId="+customerId;
		ArrayList<Object> list = DBConn.ExecuteQuery(sql, new CustomerDetailInfo());
		return (CustomerDetailInfo)list.get(0);
	}
	return null;
}


public boolean isCustomerDetailInfo(int customerId){
	
	String sql = "select * from CustomerDetailInfo where customerId="+customerId;
	ArrayList<Object> list = DBConn.ExecuteQuery(sql, new CustomerDetailInfo());
	if(list != null){
		if(list.size() == 1){
			return true;
		}
	}
	return false;
}

public void updateCustomerDdtailInfo(int customerId,String name,String telephone,String movePhone,String address){
		
		String sql  = "update CustomerDetailInfo set name='"+name+"',telphone='"+telephone+"',movePhone='"+movePhone+"',address='"+address+"' where customerId ="+customerId;
		
		DBConn.ExecuteUD(sql);//执行SQL语句
	}
}
