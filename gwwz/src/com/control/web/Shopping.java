package com.control.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.GoodsInfoDAO;
import com.entity.GoodsInfo;
import com.util.PublicToolCheckParam;
import com.util.PublicToolParam;

public class Shopping extends HttpServlet {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9192246410194090687L;



	private static float getSum(ArrayList<GoodsInfo> shopList){	
		
		float sum = 0;
		if(shopList!=null){
			for(int i=0;i<shopList.size();i++){
				GoodsInfo gd = shopList.get(i);
				sum += gd.getCount()*gd.getDiscountPrice();
			}
		}
			
		return sum;
	}

	
	public void doClear(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

			
			HttpSession session = request.getSession();
			
			session.removeAttribute(PublicToolParam.SHOPLIST);
			session.setAttribute(PublicToolParam.SUM,"0");			
			response.sendRedirect(PublicToolParam.CART);
}
	
	@SuppressWarnings("unchecked")
	public void doDelete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {


		String str_gid = request.getParameter("gid");	
		
		if (PublicToolCheckParam.checkNullAndEmpty(str_gid)) {
			int gid = Integer.parseInt(str_gid);
		
			
			HttpSession session = request.getSession();
		
			
			ArrayList<GoodsInfo> shopList = (ArrayList<GoodsInfo>)session.getAttribute(PublicToolParam.SHOPLIST);
			
			for(int i=0;i<shopList.size();i++){
				
				GoodsInfo gd = shopList.get(i);
				if(gd.getGoodsId() == gid){
					shopList.remove(i);
					session.setAttribute(PublicToolParam.SHOPLIST, shopList);//保存物品列表供页面读取
					session.setAttribute(PublicToolParam.SUM, getSum(shopList));			
				}
				
			}
			response.sendRedirect(PublicToolParam.CART);
		} 
}

	
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String str_count = request.getParameter("count");
		String str_gid = request.getParameter("gid");
		HttpSession session = request.getSession();
		ArrayList<GoodsInfo> shopList = (ArrayList<GoodsInfo>)session.getAttribute(PublicToolParam.SHOPLIST);
		
		if(PublicToolCheckParam.checkNullAndEmpty(str_count) && PublicToolCheckParam.checkNullAndEmpty(str_gid) && shopList!=null){
			int i;
			for(i=0;i<shopList.size();i++){
				
				GoodsInfo gd = shopList.get(i);
				
				if(gd.getGoodsId()==Integer.parseInt(str_gid)){//int.parse();
					
					gd.mySetCount(Integer.parseInt(str_count)+gd.getCount());
					
					shopList.remove(i);
					
					shopList.add(gd);
					
					break;
				}	
			}
			if(i == shopList.size()){
					shopList = getSessionListValue(shopList, Integer.parseInt(str_gid),Integer.parseInt(str_count));
				}
		}
		else if(PublicToolCheckParam.checkNullAndEmpty(str_count) && PublicToolCheckParam.checkNullAndEmpty(str_gid) && shopList==null){
			shopList = getSessionListValue(shopList, Integer.parseInt(str_gid),Integer.parseInt(str_count));
		}
		
		session.setAttribute(PublicToolParam.SUM, getSum(shopList));		
		
		session.setAttribute(PublicToolParam.SHOPLIST, shopList);//保存物品列表供页面读取
	
		response.sendRedirect(PublicToolParam.CART);
		}
	
	@SuppressWarnings("unchecked")
	//更新购物车
	public void doUpdate(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		String str_count = request.getParameter("count");
		String str_gid = request.getParameter("gid");
		
		
		HttpSession session = request.getSession();
		ArrayList<GoodsInfo> shopList = (ArrayList<GoodsInfo>)session.getAttribute(PublicToolParam.SHOPLIST);
		
		if(PublicToolCheckParam.checkNullAndEmpty(str_count) && PublicToolCheckParam.checkNullAndEmpty(str_gid) && shopList!=null){
			for(int i=0;i<shopList.size();i++){
				
				GoodsInfo gd = shopList.get(i);
				
				if(gd.getGoodsId()==Integer.parseInt(str_gid)){//int.parse();
					
					gd.mySetCount(Integer.parseInt(str_count));
					
					shopList.remove(i);
					
					shopList.add(i,gd);
					
					break;
				}				
			}
		}
		session.setAttribute(PublicToolParam.SUM, getSum(shopList));		
		
		session.setAttribute(PublicToolParam.SHOPLIST, shopList);//保存物品列表供页面读取
	
		response.sendRedirect(PublicToolParam.CART);
	}
	
	
	private ArrayList<GoodsInfo> getSessionListValue(ArrayList<GoodsInfo> shopList,int gid,int count){
		
		if (shopList == null) {
			shopList = new ArrayList<GoodsInfo>();
		}
		
		
		
		boolean flag = false;
		
		for(int i=0;i<shopList.size();i++){ 
			
			GoodsInfo gd = shopList.get(i);
			
			if(gd.getGoodsId()==gid){
				count = gd.getCount()+count;
				gd.mySetCount(count); 
				
				shopList.remove(i);
				
				shopList.add(gd);				
				flag = true;
			}				
		}
		
		if(flag==false){
			
			GoodsInfoDAO gdao = new GoodsInfoDAO();
			GoodsInfo gd = gdao.getQueryGoodsInfo(gid);	
			shopList.add(gd);
			gd.mySetCount(count); 
		}	
		
		return shopList;
	}
	
	

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String method = request.getParameter("method");
		
		if(PublicToolCheckParam.checkNullAndEmpty(method)){
			if(method.equals("g")) {
				doPost(request, response);
			}
			else if(method.equals("u")){
				doUpdate(request, response);
			}
			else if(method.equals("d")){
				doDelete(request, response);
			}
			else if(method.equals("c")){
				doClear(request, response);
			}
		}	
	}

	
}
