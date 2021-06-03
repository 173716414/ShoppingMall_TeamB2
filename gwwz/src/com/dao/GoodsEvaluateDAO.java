package com.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.common.DBConn;
import com.entity.GoodsEvaluate;

public class GoodsEvaluateDAO {

	public void insertGoodsEvaluate(int goodsId,String goodsEvaluate,String email){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createTime = sdf.format(new Date());
		String sql = "insert into GoodsEvaluate values("+goodsId+",'"+goodsEvaluate+"','"+email+"','"+createTime+"')";
		DBConn.ExecuteUD(sql);//执行SQL语句
	}
	
	
	public ArrayList<Object> selectGoodsEvaluateInfo(int goodsId){
		
		String sql = "select * from GoodsEvaluate where goodsId="+goodsId;
		
		return DBConn.ExecuteQuery(sql, new GoodsEvaluate());
	}
	
	
public ArrayList<Object> selectGoodsEvaluateInfoByEmail(String email){
		
		String sql = "select * from GoodsEvaluate where email = '"+email+"'";
		
		return DBConn.ExecuteQuery(sql, new GoodsEvaluate());
	}
}
