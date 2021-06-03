package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.entity.OrderDetailInfo;
import com.common.DBConn;
import com.entity.PageModel;
import com.util.PublicToolCheckParam;
public class OrderDetailDAO {
	
	


//物流列表
public ArrayList<Object> getOrderWuliuInfo(int orderId){

	String sql  = "select * from OrderDetailInfo where orderId="+orderId+" order by id desc ";
	
	return DBConn.ExecuteQuery(sql, new OrderDetailInfo());
}

//插入新物流
	public void addWuliu(String orderId,String remark,String addtime){
		String sql  = "insert into OrderDetailInfo values(id,"+orderId+",'"+remark+"','"+addtime+"')";
		//Connection conn = DBConn.getConn();
			DBConn.ExecuteUD(sql);//执行SQL语句

	}
//删除物流信息
	public void deleteWuliu(int wuliuId){
		String sql1 = "delete from OrderDetailInfo where Id="+wuliuId;
		DBConn.ExecuteUD(sql1);
	}


	


}
