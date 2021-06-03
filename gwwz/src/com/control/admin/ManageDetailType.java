package com.control.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsInfoDAO;
import com.dao.GoodsTypeDetailInfoDAO;
import com.entity.GoodsTypeDetail;
import com.util.PublicToolCheckParam;
import com.util.PublicToolGetTypeDetailInfo;
import com.util.PublicToolShowDetailTypeList;
public class ManageDetailType extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 903516041045550470L;
	static GoodsTypeDetailInfoDAO gtdao = new GoodsTypeDetailInfoDAO();

	//删除二级目录
	public  static void deleteDetailType(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			String typeId = request.getParameter("typeId");
			String Id = request.getParameter("Id");
			if(PublicToolCheckParam.checkNullAndEmpty(typeId)){
				GoodsTypeDetailInfoDAO gdao = new GoodsTypeDetailInfoDAO();
				//boolean isExist = gdao.isGoodsExistInGooodsType(Integer.parseInt(typeId));
				
						gdao.deleteDetailType(Integer.parseInt(Id));
						String isSearching = request.getParameter("isSearching");
						String currentPage = request.getParameter("currentPage");
						if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){
							String key = request.getParameter("key");
							PublicToolShowDetailTypeList.searchDetailType(request, response, currentPage, key);
							request.setAttribute("key", key);
							request.setAttribute("isSearching", "yes");
						}
						else{
							PublicToolShowDetailTypeList.showDetailTypeList(request, response, currentPage, Integer.parseInt(typeId));
						}
						request.getRequestDispatcher("../admin/manageDetailType.jsp").forward(request, response);
					
			}
			
	}

	public static void searchDetailType(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			String currentPage = request.getParameter("currentPage");
			String key = request.getParameter("key");
			key = new String(key.getBytes("iso-8859-1"),"utf-8");//转换关键词的编码
			PublicToolShowDetailTypeList.searchDetailType(request, response, currentPage, key);
			request.setAttribute("isSearching", "yes");
			request.setAttribute("key", key);
			request.getRequestDispatcher("../admin/manageDetailType.jsp").forward(request, response);
		
	}

	public static void showManageDetailTypePage(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			String currentPage = request.getParameter("currentPage");
					String typeId = request.getParameter("typeId");
			
				PublicToolShowDetailTypeList.showDetailTypeList(request, response, currentPage,  Integer.parseInt(typeId));
			
		
			request.getRequestDispatcher("../admin/manageDetailType.jsp").forward(request, response);
			
	}

	public static void updateDetailType(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String currentPage = request.getParameter("currentPage");
		String submit = request.getParameter("submit");
		String Id = request.getParameter("Id");
		String typeId = request.getParameter("typeId");
		String typeName = request.getParameter("typeName");
		if(PublicToolCheckParam.checkNullAndEmpty(Id)){
			if(PublicToolCheckParam.checkNullAndEmpty(submit) && submit.equals("1")){
				gtdao.updateDetailType(Integer.parseInt(Id),typeName);
				PublicToolShowDetailTypeList.showDetailTypeList(request, response, currentPage,Integer.parseInt(typeId));
				request.getRequestDispatcher("../admin/manageDetailType.jsp").forward(request, response);
				
			}
			else{
				GoodsTypeDetail goodsDetailInfo = gtdao.getTypeDetailInfo(Integer.parseInt(Id));
				request.setAttribute("goodsDetailInfo", goodsDetailInfo);
				request.getRequestDispatcher("../admin/updateDetailType.jsp").forward(request, response);
			}
		}
	}
	
	

	
	/**
	 * Constructor of the object.
	 */
	public ManageDetailType() {
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
			if(method.equals("showManageDetailTypePage")){
				showManageDetailTypePage(request, response);
			}
			//else if(method.equals("showManageTypedetailInfoPage")){
			//	showManageDetailTypePage(request, response);
		//	}
			
			else if(method.equals("delete")){
				deleteDetailType(request, response);
			}
			
			else if(method.equals("search")){
				searchDetailType(request, response);
			}
			else if(method.equals("update")){
				updateDetailType(request, response);
			}
		}
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
