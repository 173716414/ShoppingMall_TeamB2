package com.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsTypeDAO;

import com.dao.GoodsTypeDetailInfoDAO;
import com.entity.PageModel;

public class PublicToolShowDetailTypeList {
	
public static void searchDetailType(HttpServletRequest request, HttpServletResponse response,String currentPage,String key){
	
	
	GoodsTypeDAO gtdao = new GoodsTypeDAO();

	int sumCount = gtdao.getSumSearchGoodsTypeCount(key);
	//设置分页PageModel对象
	PageModel pm = PublicToolPageModel.getPageInfo(request, sumCount,10,currentPage);
		
	//查询所有的商品信息		
	ArrayList<Object>  goodsTypeList = gtdao.searchGoodsType(pm, key);
	request.setAttribute("goodsTypeList",goodsTypeList);
}
	
	
	//显示子分类
	public static void showDetailTypeList(HttpServletRequest request, HttpServletResponse response,String currentPage,int typeid){
			
			
		GoodsTypeDetailInfoDAO gtdao = new GoodsTypeDetailInfoDAO();
			
			int sumCount = gtdao.getTypeDetailCount(typeid);
	
			//设置分页PageModel对象
			PageModel pm = PublicToolPageModel.getPageInfo(request, sumCount,10,currentPage);
				
			//GoodsTypeDAO gtddao = new GoodsTypeDAO();
			//查询所有的商品信息		
			ArrayList<Object>  goodsTypeList = gtdao.getPageDetailModel(pm,typeid);
			request.setAttribute("goodsTypeList",goodsTypeList);
	
		}
	
	
	//前台显示子分类菜单用
	public static void showDetailallTypeList(HttpServletRequest request, HttpServletResponse response,int typeid){
			
			
		GoodsTypeDetailInfoDAO gtdao = new GoodsTypeDetailInfoDAO();
			
			//int sumCount = gtdao.getTypeDetailCount(typeid);
	
			//设置分页PageModel对象
		//	PageModel pm = PublicToolPageModel.getPageInfo(request, sumCount,10,currentPage);
				
			//GoodsTypeDAO gtddao = new GoodsTypeDAO();
			//查询所有的商品信息		
			ArrayList<Object>  goodsDetailallTypeList = gtdao.getallDetailModel(typeid);
			request.setAttribute("goodsDetailallTypeList",goodsDetailallTypeList);
	
		}

}
