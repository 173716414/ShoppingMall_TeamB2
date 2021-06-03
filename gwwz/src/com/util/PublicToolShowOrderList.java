package com.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OrderInfoDAO;
import com.entity.PageModel;


public class PublicToolShowOrderList {

//show all order for admin	
public static void searchOrder(HttpServletRequest request, HttpServletResponse response,String currentPage,String key){
	
	
	OrderInfoDAO odao = new OrderInfoDAO();
	
	int sumCount = odao.getSumSearchOrderCount(key);
	
	//设置分页PageModel对象
	PageModel pm = PublicToolPageModel.getPageInfo(request, sumCount,10,currentPage);
		
	//查询所有的商品信息		
	ArrayList<Object>  orderList = odao.searchBulletin(pm, key);
	
	request.setAttribute("orderInfoList", orderList);
	}
	
	
	public static void showOrderList(HttpServletRequest request, HttpServletResponse response,String currentPage){
			
			
			OrderInfoDAO odao = new OrderInfoDAO();
		
			int sumCount = odao.getSumOrderCount();
			//设置分页PageModel对象
			PageModel pm = PublicToolPageModel.getPageInfo(request, sumCount,10,currentPage);
				
			//查询所有的商品信息		
			ArrayList<Object>  orderList = odao.getPageModel(pm);
			request.setAttribute("orderInfoList",orderList);
		}











//show all order for third

public static void searchOrderforthird(HttpServletRequest request, HttpServletResponse response,String currentPage,String key,String thirdId){
	
	
	OrderInfoDAO odao = new OrderInfoDAO();
	
	int sumCount = odao.getSumSearchOrderCountforthird(key,thirdId);
	
	//设置分页PageModel对象
	PageModel pm = PublicToolPageModel.getPageInfo(request, sumCount,10,currentPage);
		
	//查询所有的商品信息		
	ArrayList<Object>  orderList = odao.searchBulletinforthird(pm, key,thirdId);
	
	request.setAttribute("orderInfoList", orderList);
	}
	
	
	public static void showOrderListforthird(HttpServletRequest request, HttpServletResponse response,String currentPage,String thirdId){
			
			
			OrderInfoDAO odao = new OrderInfoDAO();
		
			int sumCount = odao.getSumOrderCountforthird(thirdId);
			//设置分页PageModel对象
			PageModel pm = PublicToolPageModel.getPageInfo(request, sumCount,10,currentPage);
				
			//查询所有的商品信息		
			ArrayList<Object>  orderList = odao.getPageModelforthird(pm,thirdId);
			request.setAttribute("orderInfoList",orderList);
		}



}
