package com.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ThirdInfoDAO;
import com.entity.PageModel;

public class PublicToolShowThirdInfoList {

	
public static void searchThirdInfo(HttpServletRequest request, HttpServletResponse response,String currentPage,String key){
	
	
	ThirdInfoDAO  cdao = new ThirdInfoDAO();
	
	int sumCount = cdao.getSumSearchThirdCount(key);
	
	//设置分页PageModel对象
	PageModel pm = PublicToolPageModel.getPageInfo(request, sumCount,10,currentPage);
		
	//查询所有的商品信息		
	ArrayList<Object>  ThirdInfoList = cdao.searchThirdInfo(pm, key);
	request.setAttribute("ThirdInfoList",ThirdInfoList);
	}
	
	
	public static void showThirdInfoList(HttpServletRequest request, HttpServletResponse response,String currentPage){
			
			
			ThirdInfoDAO  cdao = new ThirdInfoDAO();
		
			int sumCount = cdao.getSumThirdCount();
			//设置分页PageModel对象
			PageModel pm = PublicToolPageModel.getPageInfo(request, sumCount,10,currentPage);
				
			//查询所有的商品信息		
			ArrayList<Object>  ThirdInfoList = cdao.getPageModel(pm);
			request.setAttribute("ThirdInfoList",ThirdInfoList);
		}
}
