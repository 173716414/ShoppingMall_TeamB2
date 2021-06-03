package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.common.DBConn;
import com.entity.OrderGoodsInfo;
import com.entity.OrderInfo;
import com.entity.SalesGoods;
import com.util.PublicToolCheckParam;

public class OrderGoodsInfoDAO {

public static ArrayList<Object> getOrderInfo(){
	String sql = "select * from OrderInfo where status = 1";
	return DBConn.ExecuteQuery(sql, new OrderInfo());
}


public void addOrderGoodsInfo(int orderId,int goodsId,int quantity,int status){

		String sql  = "insert into OrderGoodsInfo values("+orderId+","+goodsId+","+quantity+","+status+")";
		
		DBConn.ExecuteUD(sql);//执行SQL语句
	}


//统计出售数量,(不在退货的状态 )
public int getGoodsOrderCount(int goodsId){

	String sql = "select goodsId,sum(quantity) as quantity from OrderGoodsInfo where goodsId = "+goodsId+" and status <> 101 group by goodsId ";
	
	Connection conn = DBConn.getConn();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();   
		
		if(rs.next()){							
			SalesGoods sg = new SalesGoods();		
			sg.setGoodsId(rs.getInt("goodsId"));
			sg.setQuantity(rs.getInt("quantity"));
			
			return sg.getQuantity();
		}
		
		return 0;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally{
		
		DBConn.CloseConn(rs, pstmt, conn);
	}
	return 0;
}



public ArrayList<Object> getOrderGoodsInfo(int orderId){

	String sql  = "select * from OrderGoodsInfo where orderId="+orderId;
	
	return DBConn.ExecuteQuery(sql, new OrderGoodsInfo());
}

@SuppressWarnings("unchecked")
public ArrayList<SalesGoods> getTopTen(){
	String sql = "select   goodsId,sum(quantity) as quantity from OrderGoodsInfo group by goodsId order by quantity desc limit 0,10";
	
	Connection conn = DBConn.getConn();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	ArrayList list = new ArrayList();
	try {
		
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();   
		
		while(rs.next()){							
			SalesGoods sg = new SalesGoods();		
			sg.setGoodsId(rs.getInt("goodsId"));
			sg.setQuantity(rs.getInt("quantity"));
			
			list.add(sg);
		}
		
		return list;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally{
		
		DBConn.CloseConn(rs, pstmt, conn);
	}
	return null;
}


public void updateOrderStatus(int orderId,int status){
	if(PublicToolCheckParam.checkNullAndEmpty(status)){
		if(status == 1){
			status = 0;
		}
		else if(status == 0){
			status = 1;
		}
		
	}
	
	
	String sql  = "update OrderGoodsInfo set status = "+status+" where orderId="+orderId;
	DBConn.ExecuteUD(sql);//执行SQL语句
}
}
