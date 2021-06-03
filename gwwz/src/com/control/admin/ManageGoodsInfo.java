package com.control.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.GoodsInfoDAO;
import com.dao.GoodsTypeDAO;
import com.dao.GoodsTypeDetailInfoDAO;
import com.dao.ServiceAssessmentDAO;
import com.entity.GoodsInfo;
import com.entity.GoodsTypeDetail;
import com.util.PublicToolCheckParam;
import com.util.PublicToolShowGoodsInfolist;
import com.jspsmart.upload.*;
import com.sun.image.codec.jpeg.*;
import java.awt.image.*;
import java.io.*;
import java.awt.Image;

import javax.servlet.jsp.JspFactory;
import com.jspsmart.upload.SmartUpload;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.jspsmart.upload.*;
import javax.servlet.jsp.*;

public class ManageGoodsInfo extends HttpServlet {

	
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 7321956339019190364L;
	static GoodsInfoDAO gdao = new GoodsInfoDAO();

	public  static void deleteGoodsInfo(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
		String goodsId = request.getParameter("goodsId");
		if(PublicToolCheckParam.checkNullAndEmpty(goodsId)){
			gdao.deleteGoodsInfo(Integer.parseInt(goodsId));
			String isSearching = request.getParameter("isSearching");
			String currentPage = request.getParameter("currentPage");
			if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){
				String key = request.getParameter("key");
				PublicToolShowGoodsInfolist.searchGoodsInfo(request, response, currentPage, key);
				request.setAttribute("isSearching", "yes");
			}
			else{
				PublicToolShowGoodsInfolist.showGoodsInfoList(request, response, currentPage);
			}
		}
		request.getRequestDispatcher("../admin/manageGoodsInfo.jsp").forward(request, response);
			
	}

	public static void deleteMoreGoodsInfo(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		String currentPage = request.getParameter("currentPage");
		String[] ckb = request.getParameterValues("ckb");
		if(ckb != null){
			for(int i=0;i<ckb.length;i++){
				gdao.deleteGoodsInfo(Integer.parseInt(ckb[i]));
			}
		}
		PublicToolShowGoodsInfolist.showGoodsInfoList(request, response, currentPage);
		request.getRequestDispatcher("../admin/manageGoodsInfo.jsp").forward(request, response);
		
	}

	public static void getTypeDetailInfo(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		String typeId = request.getParameter("goodsTypeId");
		GoodsTypeDetailInfoDAO gtddao = new GoodsTypeDetailInfoDAO();
		ArrayList<Object> typeDetailInfoList = gtddao.GoodsTypeDetailAllInfoDAO(Integer.parseInt(typeId));
		if(typeDetailInfoList != null){
			for(int i=0;i<typeDetailInfoList.size();i++){
				GoodsTypeDetail typeDetailInfo = (GoodsTypeDetail)typeDetailInfoList.get(i);
				out.println(typeDetailInfo.getTypeDetailInfo()+","+typeDetailInfo.getId()+"|");
			}
		}
		out.flush();
		out.close();
}

	public static void insertGoodsInfo(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			String str_goodsName = request.getParameter("goodsName");
			String typeDetailInfo = request.getParameter("typeDetailInfo");
			String str_price = request.getParameter("price");
			String str_discount = request.getParameter("discount");
			String[] ckb = request.getParameterValues("ckb");
			String str_photo = request.getParameter("photo");
			String str_remark = request.getParameter("remark");
			String countRequire = request.getParameter("countRequire");
			//String deadline = request.getParameter("deadline");
			float discount = (float)10.0;
			int isNew = 1;
			int isRecommend = 1;
			int status = 1;
String photo = null;
			if(PublicToolCheckParam.checkNullAndEmpty(str_goodsName) && PublicToolCheckParam.checkNullAndEmpty(typeDetailInfo) && PublicToolCheckParam.checkNullAndEmpty(str_price) && PublicToolCheckParam.checkNullAndEmpty(countRequire) ){
				if(PublicToolCheckParam.checkNullAndEmpty(str_discount)){
					discount = Float.parseFloat(str_discount);
				}
				if(ckb != null){
					for(int i=0;i<ckb.length;i++){
						if(ckb[i].equals("isNew")){
							isNew = 0;
						}
						else if(ckb[i].equals("isRecommend")){
							isRecommend = 0;
						}
						else if(ckb[i].equals("status")){
							status = 0;
						}
					}
				}
				if(PublicToolCheckParam.checkNullAndEmpty(str_photo)){
					String[] photoArray = str_photo.split("\\\\");
					photo = photoArray[photoArray.length-1];
					photo = photo.replaceAll("'", "'");
					
				}
				
				str_goodsName = str_goodsName.replaceAll("'", "'");
				gdao.addGoodsInfo(typeDetailInfo, str_goodsName, Double.parseDouble(str_price), discount, isNew, isRecommend, status, photo, str_remark,Integer.parseInt(countRequire),"","0");
				
				String currentPage = request.getParameter("currentPage");
				PublicToolShowGoodsInfolist.showGoodsInfoList(request, response, currentPage);
				
				request.getRequestDispatcher("../admin/manageGoodsInfo.jsp").forward(request, response);
			}	
	}
	
	
	public static void searchGoodsInfo(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			
		String currentPage = request.getParameter("currentPage");
		String key = request.getParameter("key");
		key = new String(key.getBytes("iso-8859-1"),"utf-8");//转换关键词的编码
		PublicToolShowGoodsInfolist.searchGoodsInfo(request, response, currentPage, key);
		request.setAttribute("isSearching", "yes");
		request.setAttribute("key", key);
		request.getRequestDispatcher("../admin/manageGoodsInfo.jsp").forward(request, response);
	}
	
	
	public static void showAddGoodsInfoPage(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			GoodsTypeDAO gtdao = new GoodsTypeDAO();
			ArrayList<Object> typeList = gtdao.getAllType();
			GoodsTypeDetailInfoDAO gtddao = new GoodsTypeDetailInfoDAO();
			ArrayList<Object> typeDetailInfoList = gtddao.GoodsTypeDetailAllInfoDAO(6);
			request.setAttribute("typeList", typeList);
			request.setAttribute("typeDetailInfoList", typeDetailInfoList);
			request.getRequestDispatcher("../admin/addGoodsInfo.jsp").forward(request, response);
		
	}
	
	//显示商品类型添加的页面  
  public static void showAddGoodsTypePage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		//request.setAttribute("url", "../admin/addGoodsType.jsp");
		request.getRequestDispatcher("../admin/addGoodsType.jsp").forward(request, response);
	}

	
	public static void showManageGoodsInfoPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		String currentPage = request.getParameter("currentPage");
		PublicToolShowGoodsInfolist.showGoodsInfoList(request, response, currentPage);
		request.getRequestDispatcher("../admin/manageGoodsInfo.jsp").forward(request, response);
	
	}
	
	//评论管理
	public static void showManageEvaluate(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
				ServiceAssessmentDAO sdao = new ServiceAssessmentDAO();

	
	ArrayList<Object> serviceAssessmentList = sdao.allAssessment();


	request.setAttribute("serviceAssessmentList", serviceAssessmentList);
		
	
		String currentPage = request.getParameter("currentPage");
		PublicToolShowGoodsInfolist.showGoodsInfoList(request, response, currentPage);
		request.getRequestDispatcher("../admin/manageEvaluateInfo.jsp").forward(request, response);
	
	}
	
	
	//删除评论
		public  static void deleteEva(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
				ServiceAssessmentDAO sdao = new ServiceAssessmentDAO();
			
		String Id = request.getParameter("Id");
			sdao.delete(Integer.parseInt(Id));
		request.getRequestDispatcher("../servlet/ManageGoodsInfo?method=showManageEvaluate").forward(request, response);
			
	}


	
	
	public static void updateGoodsInfo(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String currentPage = request.getParameter("currentPage");
		String submit = request.getParameter("submit");
		String goodsId = request.getParameter("goodsId");
		if(PublicToolCheckParam.checkNullAndEmpty(goodsId)){
			if(PublicToolCheckParam.checkNullAndEmpty(submit)){
				if(submit.equals("1")){
					String str_goodsName = request.getParameter("goodsName");
					String typeDetailInfo = request.getParameter("typeDetailInfo");
					String str_price = request.getParameter("price");
					String str_discount = request.getParameter("discount");
					String[] ckb = request.getParameterValues("ckb");
					String str_photo = request.getParameter("photo");
					String str_remark = request.getParameter("remark");
					String countRequire = request.getParameter("countRequire");
				//	String deadline = request.getParameter("deadline");
					float discount = (float)10.0;
					int isNew = 1;
					int isRecommend = 1;
					int status = 1;
					String photo = null;
					if(PublicToolCheckParam.checkNullAndEmpty(str_goodsName) && PublicToolCheckParam.checkNullAndEmpty(typeDetailInfo) && PublicToolCheckParam.checkNullAndEmpty(str_price) && PublicToolCheckParam.checkNullAndEmpty(countRequire) ){
						if(PublicToolCheckParam.checkNullAndEmpty(str_discount)){
							discount = Float.parseFloat(str_discount);
						}
						if(ckb != null){
							for(int i=0;i<ckb.length;i++){
								if(ckb[i].equals("isNew")){
									isNew = 0;
								}
								else if(ckb[i].equals("isRecommend")){
									isRecommend = 0;
								}
								else if(ckb[i].equals("status")){
									status = 0;
								}
							}
						}
						if(PublicToolCheckParam.checkNullAndEmpty(str_photo)){
							String[] photoArray = str_photo.split("\\\\");
							photo = photoArray[photoArray.length-1];
						}
						gdao.updateGoodsInfo(Integer.parseInt(goodsId),typeDetailInfo, str_goodsName, Double.parseDouble(str_price), discount, isNew, isRecommend, status, photo, str_remark,Integer.parseInt(countRequire),"0");

					
					
						PublicToolShowGoodsInfolist.showGoodsInfoList(request, response, currentPage);
						request.getRequestDispatcher("../admin/manageGoodsInfo.jsp").forward(request, response);
					}
				}
				
			}
			else{
				GoodsInfo goodsInfo =  gdao.getQueryGoodsInfo(Integer.parseInt(goodsId));
				GoodsTypeDAO gtdao = new GoodsTypeDAO();
				ArrayList<Object> typeList = gtdao.getAllType();
				GoodsTypeDetailInfoDAO gtddao = new GoodsTypeDetailInfoDAO();
				ArrayList<Object> typeDetailInfoList = gtddao.GoodsTypeDetailAllInfoDAO(6);
				request.setAttribute("typeList", typeList);
				request.setAttribute("typeDetailInfoList", typeDetailInfoList);
				request.setAttribute("goodsInfo", goodsInfo);
				request.getRequestDispatcher("../admin/updateGoodsInfo.jsp").forward(request, response);
			}
		}	
	}
	
	/**
	 * Constructor of the object.
	 */
	public ManageGoodsInfo() {
		super();
	}
	
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
	
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	
	
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
	
		
		
		
		
		
		
		
		
		
		
		
		String method = request.getParameter("method");
		if(PublicToolCheckParam.checkNullAndEmpty(method)){
			if(method.equals("showAddGoodsInfoPage")){
				showAddGoodsInfoPage(request, response);
			}
			else if(method.equals("showManageGoodsInfoPage")){
				showManageGoodsInfoPage(request, response);
			}
			else if(method.equals("showAddGoodsTypePage")){
				showAddGoodsTypePage(request, response);
			}
			else if(method.equals("insert")){
			
				
			
				
				
				
				
				
				
				
				
				insertGoodsInfo(request, response);
			}
			else if(method.equals("delete")){
				deleteGoodsInfo(request, response);
			}
			else if(method.equals("deleteMore")){
				deleteMoreGoodsInfo(request, response);
			}
			else if(method.equals("search")){
				searchGoodsInfo(request, response);
			}
			else if(method.equals("update")){
				updateGoodsInfo(request, response);
			}
			else if(method.equals("getTypeDetailInfo")){
				getTypeDetailInfo(request, response);
			}
			else if(method.equals("showManageEvaluate")){
				showManageEvaluate(request, response);
			}
			else if(method.equals("deleteEva")){
				deleteEva(request, response);
			}
	else if(method.equals("cool")){
		coolGoodsInfo(request, response);
	}
	else if(method.equals("coolMore")){
		coolMoreGoodsInfo(request, response);
	}

		}
	}
	
	public  static void coolGoodsInfo(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			String GoodsId = request.getParameter("GoodsId");
			String isCooled = request.getParameter("isCooled");
			if(PublicToolCheckParam.checkNullAndEmpty(GoodsId) && PublicToolCheckParam.checkNullAndEmpty(isCooled)){
					gdao.coolGoods(Integer.parseInt(GoodsId),Integer.parseInt(isCooled));
					String isSearching = request.getParameter("isSearching");
					String currentPage = request.getParameter("currentPage");
					if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){
						String key = request.getParameter("key");
						PublicToolShowGoodsInfolist.searchGoodsInfo(request, response, currentPage, key);

						request.setAttribute("key", key);
						request.setAttribute("isSearching", "yes");
					}
					else{
						PublicToolShowGoodsInfolist.showGoodsInfoList(request, response, currentPage);
					}
			}
			request.getRequestDispatcher("../admin/manageGoodsInfo.jsp").forward(request, response);
			
	}

	public static void coolMoreGoodsInfo(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			String currentPage = request.getParameter("currentPage");
			String[] ckb = request.getParameterValues("ckb");
			if(ckb != null){
				for(int i=0;i<ckb.length;i++){
	//				cdao.coolGoods(Integer.parseInt(ckb[i]));
				}
			}
			PublicToolShowGoodsInfolist.showGoodsInfoList(request, response, currentPage);
			request.getRequestDispatcher("../admin/manageGoodsInfo.jsp").forward(request, response);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
