package com.control.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dao.UserInfoDAO;
import com.entity.UserInfo;

public class CheckAdminLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1918708208545995271L;

	// 管理员登录
	// 管理员登录
	// 管理员登录
	public static void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		UserInfoDAO udao = new UserInfoDAO();
		boolean isExist = udao.checkAdminLogin(userName, pwd);
		if (isExist == true) {
			// 取得当前的时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(new Date());
			// 取权限
			UserInfo ur = udao.getUserId(userName);
			int role = ur.getRole();
			session.setAttribute("role", String.valueOf(role));
			session.setAttribute("userName", userName);
			session.setAttribute("currentTime", currentTime);
			request.getRequestDispatcher("../admin/systemManage.jsp").forward(request, response);
		} else {
			PrintWriter out = response.getWriter();

			out.println("<script type='text/javascript' content='text/html; charset=UTF-8'>alert('Your Password Wrong');window.location.href='../admin.jsp';</script>");
		}
	}

	// 管理员退出
	//注销退出    
     public static void loginOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.removeAttribute("userName");
		session.removeAttribute("role");
		response.sendRedirect("../admin.jsp");
	}

	/**
	 * Constructor of the object.
	 */
	public CheckAdminLogin() {
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
		if (method.equals("login")) {
			login(request, response);
		} else if (method.equals("loginOut")) {
			loginOut(request, response);
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
