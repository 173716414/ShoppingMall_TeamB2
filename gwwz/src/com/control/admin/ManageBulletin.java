package com.control.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BulletinDAO;
import com.dao.UserInfoDAO;
import com.entity.BulletinInfo;
import com.entity.UserInfo;
import com.util.PublicToolCheckParam;
import com.util.PublicToolShowBulletinList;

public class ManageBulletin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -341667641518147144L;
	static BulletinDAO bdao = new BulletinDAO();

	//删除公告
  public static void deleteBulletin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bid = request.getParameter("bid");
		if (PublicToolCheckParam.checkNullAndEmpty(bid)) {
			bdao.deleteBulletin(Integer.parseInt(bid));
			String isSearching = request.getParameter("isSearching");
			String currentPage = request.getParameter("currentPage");
			if (PublicToolCheckParam.checkNullAndEmpty(isSearching)) {
				String key = request.getParameter("key");
				PublicToolShowBulletinList.searchBulletin(request, response, currentPage, key);
				request.setAttribute("key", key);
				request.setAttribute("isSearching", "yes");
			} else {
				PublicToolShowBulletinList.showBulletinList(request, response, currentPage);
			}
		}
		request.getRequestDispatcher("../admin/manageBulletin.jsp").forward(request, response);

	}

	public static void deleteMoreBulletin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String currentPage = request.getParameter("currentPage");
		String[] ckb = request.getParameterValues("ckb");
		if (ckb != null) {
			for (int i = 0; i < ckb.length; i++) {
				bdao.deleteBulletin(Integer.parseInt(ckb[i]));
			}
		}
		PublicToolShowBulletinList.showBulletinList(request, response, currentPage);
		request.getRequestDispatcher("../admin/manageBulletin.jsp").forward(request, response);

	}

	//增加公告 
  //增加公告 
  public static void insertBulletin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String currentPage = request.getParameter("currentPage");
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		UserInfoDAO udao = new UserInfoDAO();
		UserInfo ur = udao.getUserId(userName);
		bdao.addBulletin(title, content, ur.getId());
		PublicToolShowBulletinList.showBulletinList(request, response, currentPage);
		request.getRequestDispatcher("../admin/manageBulletin.jsp").forward(request, response);
	}

	public static void searchBulletin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String currentPage = request.getParameter("currentPage");
		String key = request.getParameter("key");
		key = new String(key.getBytes("iso-8859-1"), "utf-8");
		PublicToolShowBulletinList.searchBulletin(request, response, currentPage, key);
		request.setAttribute("isSearching", "yes");
		request.setAttribute("key", key);
		request.getRequestDispatcher("../admin/manageBulletin.jsp").forward(request, response);

	}

	public static void showAddBulletinPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("../admin/addBulletin.jsp").forward(request, response);

	}

	public static void showManageBulletinPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String currentPage = request.getParameter("currentPage");
		PublicToolShowBulletinList.showBulletinList(request, response, currentPage);
		request.getRequestDispatcher("../admin/manageBulletin.jsp").forward(request, response);
	}

	public static void updateBulletin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String currentPage = request.getParameter("currentPage");
		String submit = request.getParameter("submit");
		String bid = request.getParameter("bid");
		if (PublicToolCheckParam.checkNullAndEmpty(bid)) {
			if (PublicToolCheckParam.checkNullAndEmpty(submit) && submit.equals("1")) {
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				bdao.updateBulletin(Integer.parseInt(bid), title, content);
				PublicToolShowBulletinList.showBulletinList(request, response, currentPage);
				request.getRequestDispatcher("../admin/manageBulletin.jsp").forward(request, response);

			} else {
				BulletinInfo bulletinInfo = bdao.getBulletinInfo(Integer.parseInt(bid));
				UserInfoDAO udao = new UserInfoDAO();
				UserInfo userName = udao.getUserName(bulletinInfo.getUserId());
				request.setAttribute("userName", userName.getUserName());
				request.setAttribute("bulletinInfo", bulletinInfo);//保存公告内容 供页面读取
				request.getRequestDispatcher("../admin/updateBulletin.jsp").forward(request, response);
			}
		}
	}

	/**
	 * Constructor of the object.
	 */
	public ManageBulletin() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String method = request.getParameter("method");
		if (PublicToolCheckParam.checkNullAndEmpty(method)) {
			if (method.equals("showAddBulletinPage")) {
				showAddBulletinPage(request, response);
			} else if (method.equals("showManageBulletinPage")) {
				showManageBulletinPage(request, response);
			} else if (method.equals("insert")) {
				insertBulletin(request, response);
			} else if (method.equals("delete")) {
				deleteBulletin(request, response);
			} else if (method.equals("deleteMore")) {
				deleteMoreBulletin(request, response);
			} else if (method.equals("search")) {
				searchBulletin(request, response);
			} else if (method.equals("update")) {
				updateBulletin(request, response);
			}
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
