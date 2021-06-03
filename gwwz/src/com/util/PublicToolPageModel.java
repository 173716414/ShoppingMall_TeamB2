package com.util;
import javax.servlet.http.HttpServletRequest;

import com.entity.PageModel;

//分页类    
    public class PublicToolPageModel {
	
	public static PageModel getPageInfo(HttpServletRequest request,int sumCount,int everyPageCount,String currentPage){
	
		
		PageModel pm = new PageModel();
		pm.setEveryPageCount(everyPageCount);
		pm.setSumCount(sumCount);
		
		if(PublicToolCheckParam.checkNullAndEmpty(currentPage)){
			if(Integer.parseInt(currentPage) < pm.getSumPageCount()){
				pm.setCurrentPage(Integer.parseInt(currentPage));
			}
			else{
				pm.setCurrentPage(pm.getSumPageCount());
			}
			
		}
		else{
			pm.setCurrentPage(1);
		}
		
		
		if(pm.getCurrentPage() == 1){
			pm.setUpPage(1);
		}
		else{
			pm.setUpPage(pm.getCurrentPage()-1);
		}
		
		
		if(pm.getCurrentPage() == pm.getSumPageCount()){
			
			pm.setNextPage(pm.getCurrentPage());
		}
		else{
			
			pm.setNextPage(pm.getCurrentPage()+1);
		}
		pm.setLastPage(pm.getSumPageCount());
		

		request.setAttribute("sumCount",pm.getSumCount());
		request.setAttribute("currentPage",pm.getCurrentPage());
		request.setAttribute("sumPageCount",pm.getSumPageCount());
		request.setAttribute("indexPage",1);
		request.setAttribute("nextPage",pm.getNextPage());
		request.setAttribute("upPage",pm.getUpPage());
		request.setAttribute("lastPage",pm.getLastPage());


		return pm;
	}

}
