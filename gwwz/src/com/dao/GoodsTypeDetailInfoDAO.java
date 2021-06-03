package com.dao;

import java.util.ArrayList;

import com.common.DBConn;
import com.entity.GoodsType;
import com.entity.GoodsTypeDetail;
import com.entity.PageModel;

public class GoodsTypeDetailInfoDAO {

	public void deleteDetailType(int Id){
		
		String sql = "delete from GoodsTypeDetailInfo where Id="+Id;
		DBConn.ExecuteUD(sql);//执行SQL语句
	}
	
		//
		public ArrayList<Object> getPageDetailModel(PageModel pm,int typeid){

		int everyPageGoodsTypeCount = pm.getEveryPageCount();//

		int currentPage = pm.getCurrentPage();//

		if(pm.getSumCount()%everyPageGoodsTypeCount != 0 && currentPage == pm.getLastPage()){
			
			everyPageGoodsTypeCount = pm.getSumCount()%everyPageGoodsTypeCount;
			
		}


		String sql  = "select * from   GoodsTypeDetailInfo where typeid="+typeid+" order by Id  limit  "+((pm.getCurrentPage()-1)*pm.getEveryPageCount())+","+(pm.getEveryPageCount()  );
		
		return DBConn.ExecuteQuery(sql,new GoodsTypeDetail());
		}
		
		//前台显示所有子目录 
		public ArrayList<Object> getallDetailModel(int typeid){

		

		String sql  = "select * from  GoodsTypeDetailInfo where typeid="+typeid+" order by Id";

		return DBConn.ExecuteQuery(sql,new GoodsTypeDetail());
		}
	

	
	//返回子目录 的数量
	public int getTypeDetailCount(int typeId){
		
		String sql = "select * from GoodsTypeDetailInfo where typeId="+typeId;
		ArrayList<Object> list = DBConn.ExecuteQuery(sql, new GoodsTypeDetail());
		
		if(list!=null)
		{
			return list.size();
		}
		return 0;
	}
	//修改时显示单条信息
	public GoodsTypeDetail getTypeDetailInfo(int Id){
	
		String sql = "select * from GoodsTypeDetailInfo where Id ="+Id;
		ArrayList<Object> list = DBConn.ExecuteQuery(sql, new GoodsTypeDetail());
		return (GoodsTypeDetail)list.get(0);
		
	}
	//获取同一上级分类所有子目录

	

	

	public ArrayList<Object> GoodsTypeDetailAllInfoDAO(int typeId){
	
		String sql = "select * from GoodsTypeDetailInfo where typeId ="+typeId;
		
		return DBConn.ExecuteQuery(sql, new GoodsTypeDetail());
	}

	
	
	
	public void updateDetailType(int Id,String typeName){
		
		String sql = "update GoodsTypeDetailInfo set typeDetailInfo = '"+typeName+"' where Id="+Id;
		DBConn.ExecuteUD(sql);//执行SQL语句
	}
}
