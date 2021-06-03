package com.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerInfoDAO;
import com.entity.PageModel;

public class PublicToolShowCustomerInfoList {

	
public static void searchCustomerInfo(HttpServletRequest request, HttpServletResponse response,String currentPage,String key){
	
	
	CustomerInfoDAO  cdao = new CustomerInfoDAO();
	
	int sumCount = cdao.getSumSearchCustomerCount(key);
	
	//设置分页PageModel对象
	PageModel pm = PublicToolPageModel.getPageInfo(request, sumCount,10,currentPage);
		
	//查询所有的商品信息		
	ArrayList<Object>  customerInfoList = cdao.searchCustomerInfo(pm, key);
	request.setAttribute("customerInfoList",customerInfoList);
	}
	
	
	public static void showCustomerInfoList(HttpServletRequest request, HttpServletResponse response,String currentPage){
			
			
			CustomerInfoDAO  cdao = new CustomerInfoDAO();
		
			int sumCount = cdao.getSumCustomerCount();
			//设置分页PageModel对象
			PageModel pm = PublicToolPageModel.getPageInfo(request, sumCount,10,currentPage);
				
			//查询所有的商品信息		
			ArrayList<Object>  customerInfoList = cdao.getPageModel(pm);
			request.setAttribute("customerInfoList",customerInfoList);
		}
}
