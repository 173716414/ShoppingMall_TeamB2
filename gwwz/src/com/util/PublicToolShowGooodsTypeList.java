package com.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsTypeDAO;

import com.dao.GoodsTypeDetailInfoDAO;
import com.entity.PageModel;

public class PublicToolShowGooodsTypeList {
	
public static void searchGoodsType(HttpServletRequest request, HttpServletResponse response,String currentPage,String key){
	
	
	GoodsTypeDAO gtdao = new GoodsTypeDAO();

	int sumCount = gtdao.getSumSearchGoodsTypeCount(key);
	//设置分页PageModel对象
	PageModel pm = PublicToolPageModel.getPageInfo(request, sumCount,10,currentPage);
		
	//查询所有的商品信息		
	ArrayList<Object>  goodsTypeList = gtdao.searchGoodsType(pm, key);
	request.setAttribute("goodsTypeList",goodsTypeList);
}


	
	//列表主分类	
	public static void showGoodsTypeList(HttpServletRequest request, HttpServletResponse response,String currentPage){
			
			
			GoodsTypeDAO gtdao = new GoodsTypeDAO();
			
			int sumCount = gtdao.getSumGoodsTypeCount();
	
			//设置分页PageModel对象
			PageModel pm = PublicToolPageModel.getPageInfo(request, sumCount,10,currentPage);
				
			//查询所有的商品信息		
			ArrayList<Object>  goodsTypeList = gtdao.getPageModel(pm);
			request.setAttribute("goodsTypeList",goodsTypeList);
	
		}
	
	//前台列表所有主分类	
	public static void showGoodsallTypeList(HttpServletRequest request, HttpServletResponse response){
			
			
			GoodsTypeDAO gtdao = new GoodsTypeDAO();
			
			//int sumCount = gtdao.getSumGoodsTypeCount();
	
			//设置分页PageModel对象
			//PageModel pm = PublicToolPageModel.getPageInfo(request, sumCount,10,currentPage);
				
			//查询所有的商品信息		
			ArrayList<Object>  goodsTypeList = gtdao.getalltype();
			request.setAttribute("goodsTypeList",goodsTypeList);
	
		}
	

}
