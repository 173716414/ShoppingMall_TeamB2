package com.control.third;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ThirdInfoDAO;
import com.entity.ThirdInfo;
import com.util.PublicToolCheckParam;

public class UpdateUserInfo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6101002376282176066L;

	public static void checkOldUserPwd(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
			
			PrintWriter out = response.getWriter();
			String oldUserPwd = request.getParameter("oldUserPwd");
			//HttpSession session = request.getSession();
			//String thirdId = (String)session.getAttribute("thirdId");
							String thirdId = request.getParameter("thirdId");

			
			if(PublicToolCheckParam.checkNullAndEmpty(thirdId)){
				ThirdInfoDAO udao = new ThirdInfoDAO();
				//ThirdInfo ur =  udao.getThirdInfo(thirdId);
				if(udao.checkOldUserPwd( Integer.parseInt(thirdId), oldUserPwd) == false){
					out.println("旧密码不正确!请重新输入!");
				}
				else{
					out.println("旧密码正确!");
				}
		}
}

	public static void showUpdatePasswordPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
				String thirdId = request.getParameter("thirdId");

		request.setAttribute("thirdId",thirdId);
		request.getRequestDispatcher("../third/updatePassword.jsp").forward(request, response);
}

	public static void showUpdateUserNamedPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

				String thirdId = request.getParameter("thirdId");
	
				ThirdInfoDAO udao = new ThirdInfoDAO();
				ThirdInfo ur =  udao.getThirdInfo(Integer.parseInt(thirdId));

                // GoodsInfo goodsInfo =  gdao.getThirdInfo(Integer.parseInt(thirdId));
				//GoodsTypeDAO gtdao = new GoodsTypeDAO();
				
				
				request.setAttribute("ur", ur);
				request.setAttribute("thirdId", thirdId);

	
		request.getRequestDispatcher("../third/updateUserName.jsp").forward(request, response);
}

	public static void updateUserName(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
			
			//String newUserName = request.getParameter("userName");
			String newphone = request.getParameter("phone");
			String newaddress = request.getParameter("address");
			HttpSession session = request.getSession();
		String thirdId = request.getParameter("thirdId");
			if(PublicToolCheckParam.checkNullAndEmpty(thirdId)){
				ThirdInfoDAO udao = new ThirdInfoDAO();
				//ThirdInfo ur =  udao.getThirdInfo(thirdId);
				//udao.updateThirdName(Integer.parseInt(thirdId), newUserName,newphone,newaddress);
				udao.updateThirdName(Integer.parseInt(thirdId), newphone,newaddress);
				request.setAttribute("url", "../third/ok.jsp");
				//session.setAttribute("userName", newUserName);
				session.setAttribute("msg", "修改成功");
			request.getRequestDispatcher("../third/ok.jsp").forward(request, response);
		}
}
	
	public static void updateUserPwd(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String userPwd = request.getParameter("newUserPwd");
		String thirdId = request.getParameter("thirdId");
		if(PublicToolCheckParam.checkNullAndEmpty(thirdId) && PublicToolCheckParam.checkNullAndEmpty(userPwd)){
			ThirdInfoDAO udao = new ThirdInfoDAO();
			//ThirdInfo ur =  udao.getThirdInfo(thirdId);
			udao.updateThirdPwd( Integer.parseInt(thirdId), userPwd);
			request.setAttribute("msg", "修改密码成功");
			request.getRequestDispatcher("../third/ok.jsp").forward(request, response);
		}
}
	
	
	
	/**
	 * Constructor of the object.
	 */
	public UpdateUserInfo() {
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
			if(method.equals("showUpdatePasswordPage")){
				showUpdatePasswordPage(request, response);
			}
			else if(method.equals("showUpdateUserNamedPage")){
				showUpdateUserNamedPage(request, response);
			}
			else if(method.equals("updateUserPwd")){
				updateUserPwd(request, response);
			}
			else if(method.equals("updateUserName")){
				updateUserName(request, response);
			}
			else if(method.equals("checkOldUserPwd")){
				checkOldUserPwd(request, response);
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
