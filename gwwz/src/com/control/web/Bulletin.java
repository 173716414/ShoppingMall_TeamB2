package com.control.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BulletinDAO;
import com.entity.PageModel;
import com.util.PublicToolPageModel;

public class Bulletin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 576120301744910058L;

	/**
	 * Constructor of the object.
	 */
	public Bulletin() {
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
		
		String currentPage = request.getParameter("currentPage");
		
		BulletinDAO bdao = new BulletinDAO();
		int sumBulletinCount = bdao.getSumBulletinCount();
		
		//设置分页PageModel对象
		PageModel pm = PublicToolPageModel.getPageInfo(request, sumBulletinCount,12,currentPage);
			
		//查询所有的商品信息		
		ArrayList<Object>  moreBulletinInfoList = bdao.getPageModel(pm);
		
		//将moreProductInfoList信息存放在Request中,然后跳转到显示页面
		request.setAttribute("moreBulletinInfoList", moreBulletinInfoList);
		request.getRequestDispatcher("../web/moreBulletin.jsp").forward(request, response);
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
