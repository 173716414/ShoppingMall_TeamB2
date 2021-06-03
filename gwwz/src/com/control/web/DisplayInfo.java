package com.control.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BulletinDAO;
import com.dao.GoodsInfoDAO;
import com.dao.GoodsTypeDetailInfoDAO;

import com.util.PublicToolPageModel;
import com.dao.GoodsTypeDAO;
import com.entity.GoodsType;
import com.util.PublicToolCheckParam;
import com.util.PublicToolShowGooodsTypeList;
import com.util.PublicToolCheckParam;
import com.util.PublicToolShowGoodsInfolist;


public class DisplayInfo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3037171377028193287L;

	/**
	 * Constructor of the object.
	 */
	public DisplayInfo() {
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
								// String currentPage1 = request.getParameter("currentPage1");
		
		GoodsInfoDAO gdao = new GoodsInfoDAO();
		ArrayList<Object> recommendGoodsInfoList = gdao.getRecommendGoodsInfo();
		ArrayList<Object> newGoodsInfoList = gdao.getNewGoodsInfo();  //读取内容供显示使用
		ArrayList<Object> specialGoodsInfoList = gdao.getSpecialGoodsInfo();
		
		GoodsTypeDetailInfoDAO gtdao = new GoodsTypeDetailInfoDAO();
		ArrayList<Object> type1GoodsInfoList = gtdao.GoodsTypeDetailAllInfoDAO(1);
		ArrayList<Object> type2GoodsInfoList = gtdao.GoodsTypeDetailAllInfoDAO(2);
		ArrayList<Object> type3GoodsInfoList = gtdao.GoodsTypeDetailAllInfoDAO(3);
		ArrayList<Object> type4GoodsInfoList = gtdao.GoodsTypeDetailAllInfoDAO(4);
		ArrayList<Object> type5GoodsInfoList = gtdao.GoodsTypeDetailAllInfoDAO(5);
		ArrayList<Object> type6GoodsInfoList = gtdao.GoodsTypeDetailAllInfoDAO(6);
		ArrayList<Object> type7GoodsInfoList = gtdao.GoodsTypeDetailAllInfoDAO(7);
		
		BulletinDAO bdao = new BulletinDAO();
		ArrayList<Object> bulletinList = bdao.getBulletin();  //读取内容供显示使用
		
		request.setAttribute("recommendGoodsInfoList", recommendGoodsInfoList);
		request.setAttribute("newGoodsInfoList", newGoodsInfoList);
		request.setAttribute("specialGoodsInfoList", specialGoodsInfoList);
		request.setAttribute("bulletinList", bulletinList);
		request.setAttribute("type1GoodsInfoList", type1GoodsInfoList);
		request.setAttribute("type2GoodsInfoList", type2GoodsInfoList);
		request.setAttribute("type3GoodsInfoList", type3GoodsInfoList);
		request.setAttribute("type4GoodsInfoList", type4GoodsInfoList);
		request.setAttribute("type5GoodsInfoList", type5GoodsInfoList);
		request.setAttribute("type6GoodsInfoList", type6GoodsInfoList);
		request.setAttribute("type7GoodsInfoList", type7GoodsInfoList);
		request.getRequestDispatcher("../index.jsp").forward(request, response);
		
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
