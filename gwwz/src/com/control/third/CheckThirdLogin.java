package com.control.third;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dao.ThirdInfoDAO;
import com.entity.ThirdInfo;

public class CheckThirdLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1918708208545995271L;

	public static void login(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		ThirdInfoDAO udao = new ThirdInfoDAO();
		boolean isExist = udao.checkThirdLogin(email, pwd);
		if(isExist == true){
			boolean isCooled = udao.isCooled(email);
			if(isCooled == true){
				
			PrintWriter out = response.getWriter();

	out.println("<script type='text/javascript' content='text/html; charset=UTF-8'>alert('Account did not audit');window.location.href='../third.jsp';</script>");

			}
			else{//取得当前的时间
			ThirdInfo ThirdInfo = udao.getThirdInfo(email);
			String thirdName = ThirdInfo.getthirdName();
			int thirdId = ThirdInfo.getId();
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(new Date());
			session.setAttribute("thirdId", thirdId);
			session.setAttribute("email", email);
			session.setAttribute("thirdName", thirdName);
			session.setAttribute("currentTime", currentTime);
			request.getRequestDispatcher("../third/systemManage.jsp").forward(request, response);
			}
		}
		else{
	
			PrintWriter out = response.getWriter();

	out.println("<script type='text/javascript' content='text/html; charset=UTF-8'>alert('Your Password Wrong');window.location.href='../third.jsp';</script>");
		}
		
		
		
	
		
		
}

	//注销退出    
     public static void loginOut(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		session.removeAttribute("userName");
		response.sendRedirect("../third.jsp");
}

	/**
	 * Constructor of the object.
	 */
	public CheckThirdLogin() {
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
		if(method.equals("login")){
			login(request, response);
		}
		else if(method.equals("loginOut")){
			loginOut(request, response);
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
