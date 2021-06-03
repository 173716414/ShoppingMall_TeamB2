package com.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.common.DBConn;
import com.entity.ServiceAssessment;

public class ServiceAssessmentDAO {

	public void insertServiceAssessment(int customerId,String serviceAssessment,int orderid){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createTime = sdf.format(new Date());
		String sql = "insert into ServiceAssessment values(id,"+customerId+",'"+serviceAssessment+"','"+createTime+"','"+orderid+"')";
		DBConn.ExecuteUD(sql);//执行SQL语句
	}
	
	
	public ArrayList<Object> selectServiceAssessment(int orderid){
		String sql = "select * from ServiceAssessment where orderid="+orderid;
		return DBConn.ExecuteQuery(sql, new ServiceAssessment());
	}
	
	
	public ArrayList<Object> selectGoodsServiceAssessment(int goodsid){
		String sql = "select * from ServiceAssessment where orderid in (select orderid from ordergoodsinfo where goodsid="+goodsid+")";
		return DBConn.ExecuteQuery(sql, new ServiceAssessment());
	}
	public ArrayList<Object> allAssessment(){
		String sql = "select * from ServiceAssessment ";
		return DBConn.ExecuteQuery(sql, new ServiceAssessment());
	}
	
	
	
	public void delete(int Id){
		
		String sql = "delete from ServiceAssessment where Id="+Id;
		DBConn.ExecuteUD(sql);//执行SQL语句
		
	}
}
