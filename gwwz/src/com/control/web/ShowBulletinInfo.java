package com.control.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BulletinDAO;
import com.dao.UserInfoDAO;
import com.entity.BulletinInfo;
import com.entity.UserInfo;

public class ShowBulletinInfo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6827121727486630898L;

	/**
	 * Constructor of the object.
	 */
	public ShowBulletinInfo() {
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

		String str_id = request.getParameter("id");
		int id = Integer.parseInt(str_id);
		BulletinDAO bdao = new BulletinDAO();
		BulletinInfo bulletinInfo = bdao.getBulletinInfo(id);
		UserInfoDAO udao = new UserInfoDAO();
		UserInfo ur = udao.getUserName(bulletinInfo.getUserId());
		request.setAttribute("ur", ur.getUserName());
		request.setAttribute("bulletinInfo", bulletinInfo);//保存公告内容 供页面读取
		
		request.getRequestDispatcher("../web/bulletin.jsp").forward(request, response);
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
