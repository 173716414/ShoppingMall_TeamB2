package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.common.DBConn;
import com.entity.OrderInfo;
import com.entity.PageModel;
import com.util.PublicToolCheckParam;
public class OrderInfoDAO {
	
	public OrderInfo addAndGetOrderInfo(int customerId){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String orderTime = sdf.format(new Date());
		String sql  = "insert into OrderInfo values(orderId,"+customerId+",0,'"+orderTime+"')";
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.executeUpdate();
			
			pstmt.close();
			pstmt = conn.prepareStatement("select * from OrderInfo where orderId = @@identity");   
			rs = pstmt.executeQuery();   
			
			if(rs.next()){							
				OrderInfo od = new OrderInfo();				
				od.setOrderId(rs.getInt("orderId"));
				od.setCustomerId(rs.getInt("customerId"));
				od.setStatus(rs.getInt("status"));
				od.setOrderTime(rs.getString("orderTime"));
				
				return od;
			}
			
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			
			DBConn.CloseConn(rs, pstmt, conn);
		}
		return null;
	}
	
	
	public void deleteOrder(int orderId){
		String sql1 = "delete from OrderGoodsInfo where orderId="+orderId;
		DBConn.ExecuteUD(sql1);
		String sql2 = "delete from OrderInfo where orderId="+orderId;
		DBConn.ExecuteUD(sql2);
	}
	
	public OrderInfo getOrderInfo(int orderId){
		
		String sql = "select * from OrderInfo where orderId="+orderId;
		ArrayList<Object> list = DBConn.ExecuteQuery(sql, new OrderInfo());
		
		if(list != null){
			if(list.size() == 1){
				return (OrderInfo)list.get(0);
			}
		}
		return null;
	}
	
	
public ArrayList<Object> getOrderInfoByCustomerId(int customerId){
		
		String sql = "select * from OrderInfo where customerId="+customerId;
		return DBConn.ExecuteQuery(sql, new OrderInfo());
	}
	


	
//****************show all order for admin	*******************
public ArrayList<Object> getPageModel(PageModel pm){
		
		//int everyPageBulletinCount = pm.getEveryPageCount();//
		
		//int currentPage = pm.getCurrentPage();//当前页
		
		//if(pm.getSumCount()%everyPageBulletinCount != 0 && currentPage == pm.getLastPage()){
			
		//	everyPageBulletinCount = pm.getSumCount()%everyPageBulletinCount;
			
		//}
		
		////Debug.println("sql",sql);
	String sql  = "select * from   OrderInfo  limit "+((pm.getCurrentPage()-1)*pm.getEveryPageCount())+","+(pm.getEveryPageCount()  );
	////Debug.println("sql",sql);
		return DBConn.ExecuteQuery(sql, new OrderInfo());
	}



public int getSumOrderCount(){

	String sql = "select * from OrderInfo";
	ArrayList<Object> list = DBConn.ExecuteQuery(sql, new OrderInfo());
	
	if(list != null){
		return list.size();
	}
	return 0;
}

//已确认总数
public int getqueren(){

	String sql = "select * from OrderInfo where status=1";
	ArrayList<Object> list = DBConn.ExecuteQuery(sql, new OrderInfo());
	
	if(list != null){
		return list.size();
	}
	return 0;
}
//未确认总数
public int getwqueren(){

	String sql = "select * from OrderInfo where status=0";
	ArrayList<Object> list = DBConn.ExecuteQuery(sql, new OrderInfo());
	
	if(list != null){
		return list.size();
	}
	return 0;
}
//退货总数
public int gettuihuo(){

	String sql = "select * from OrderInfo where status=101";
	ArrayList<Object> list = DBConn.ExecuteQuery(sql, new OrderInfo());
	
	if(list != null){
		return list.size();
	}
	return 0;
}



public int getSumSearchOrderCount(String key){
	
	String sql  = "select * from OrderInfo where orderTime like '%"+key+"%'";
	
	ArrayList<Object> list = DBConn.ExecuteQuery(sql, new OrderInfo());
	if(list != null){
		return list.size();
	}
	return 0;

}

//已确认总数
public int getsqueren(String key){

	String sql = "select * from OrderInfo where status=1 and  orderTime like '%"+key+"%'";
	ArrayList<Object> list = DBConn.ExecuteQuery(sql, new OrderInfo());
	
	if(list != null){
		return list.size();
	}
	return 0;
}
//未确认总数
public int getswqueren(String key){

	String sql = "select * from OrderInfo where status=0  and  orderTime like '%"+key+"%'";
	ArrayList<Object> list = DBConn.ExecuteQuery(sql, new OrderInfo());
	
	if(list != null){
		return list.size();
	}
	return 0;
}
//退货总数
public int getstuihuo(String key){

	String sql = "select * from OrderInfo where status=101 and  orderTime like '%"+key+"%'";
	ArrayList<Object> list = DBConn.ExecuteQuery(sql, new OrderInfo());
	
	if(list != null){
		return list.size();
	}
	return 0;
}









public ArrayList<Object> searchBulletin(PageModel pm,String key){
	
	
	 String sql  = "select * from   OrderInfo where orderTime like '%"+key+"%'  limit  "+((pm.getCurrentPage()-1)*pm.getEveryPageCount())+","+(pm.getEveryPageCount()  );
	 
	 //String sql  = "select * from (select top "+everyPageBulletinCount+" * from (select top "+pm.getEveryPageCount()*pm.getCurrentPage()+" * from OrderInfo where orderTime like '%"+key+"%' order by orderId desc) as a order by orderId desc) as b order by orderId desc";
	return DBConn.ExecuteQuery(sql, new OrderInfo());
}

//****************show all order for admin	*******************



	
//****************show all order for third	*******************
public ArrayList<Object> getPageModelforthird(PageModel pm,String thirdId){
		
	
		
	String sql  = "select * from   OrderInfo where ";

	//多级查询先从商品表查询第三方的商品，然后从订单详细表查询对应的端口的订单号，然后到订单表查询对应的订单号 
			sql=sql+ " orderid in (select orderid from OrdergoodsInfo where  goodsid in (select goodsid from goodsinfo where userid='"+thirdId+"')) ";
			
		sql=sql+  "   limit  "+((pm.getCurrentPage()-1)*pm.getEveryPageCount())+","+(pm.getEveryPageCount()  );
		return DBConn.ExecuteQuery(sql, new OrderInfo());
	}





public int getSumOrderCountforthird(String thirdId){

	String sql = "select * from OrderInfo where   orderid in (select orderid from OrdergoodsInfo where  goodsid in (select goodsid from goodsinfo where userid='"+thirdId+"')) ";
	ArrayList<Object> list = DBConn.ExecuteQuery(sql, new OrderInfo());
	
	if(list != null){
		return list.size();
	}
	return 0;
}



public int getSumSearchOrderCountforthird(String key,String thirdId){
	
	String sql  = "select * from OrderInfo where orderTime like '%"+key+"%' and  orderid in (select orderid from OrdergoodsInfo where  goodsid in (select goodsid from goodsinfo where userid='"+thirdId+"')) ";
	
	ArrayList<Object> list = DBConn.ExecuteQuery(sql, new OrderInfo());
	if(list != null){
		return list.size();
	}
	return 0;

}


public ArrayList<Object> searchBulletinforthird(PageModel pm,String key,String thirdId){
	

    String sql  = "select * from ( select ROW_NUMBER() OVER(order by orderId desc) as RowNum,* from OrderInfo where orderTime like '%"+key+"%'  and   orderid in (select orderid from OrdergoodsInfo where  goodsid in (select goodsid from goodsinfo where userid='"+thirdId+"'))) as b where RowNum between "+((pm.getCurrentPage()-1)*pm.getEveryPageCount()+1)+" and "+(pm.getEveryPageCount()  );

//	String sql  = "select * from (select top "+everyPageBulletinCount+" * from (select top "+pm.getEveryPageCount()*pm.getCurrentPage()+" * from OrderInfo where orderTime like '%"+key+"%' and   orderid in (select orderid from OrdergoodsInfo where  goodsid in (select goodsid from goodsinfo where userid='"+thirdId+"'))  order by orderId desc) as a order by orderId desc) as b order by orderId desc";
	return DBConn.ExecuteQuery(sql, new OrderInfo());
}

//****************show all order for third	*******************










public void updateOrderStatus(int orderId,int status){
	
	if(PublicToolCheckParam.checkNullAndEmpty(status)){
		if(status == 1){
			status = 0;
		}
		else if(status == 0){
			status = 1;
		}
	}
	
	String sql  = "update OrderInfo set status = "+status+" where orderId="+orderId;
	DBConn.ExecuteUD(sql);//执行SQL语句
}



}
