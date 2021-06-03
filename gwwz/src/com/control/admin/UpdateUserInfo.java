package com.control.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserInfoDAO;
import com.entity.UserInfo;
import com.util.PublicToolCheckParam;
import com.util.PublicToolPageModel;
import com.entity.PageModel;
import java.util.ArrayList;
import com.entity.PageModel;

public class UpdateUserInfo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6101002376282176066L;

	public static void checkOldUserPwd(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
			
			PrintWriter out = response.getWriter();
			String oldUserPwd = request.getParameter("oldUserPwd");
			HttpSession session = request.getSession();
			String userName = (String)session.getAttribute("userName");
			if(PublicToolCheckParam.checkNullAndEmpty(userName)){
				UserInfoDAO udao = new UserInfoDAO();
				UserInfo ur =  udao.getUserId(userName);
				if(udao.checkOldUserPwd(ur.getId(), oldUserPwd) == false){
					out.println("旧密码不正确!请重新输入!");
				}
				else{
					out.println("旧密码正确!");
				}
		}
}

	public static void showUpdatePasswordPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		request.getRequestDispatcher("../admin/updatePassword.jsp").forward(request, response);
}

	public static void showUpdateUserNamedPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		request.getRequestDispatcher("../admin/updateUserName.jsp").forward(request, response);
}

	public static void updateUserName(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
			
			String newUserName = request.getParameter("userName");
			HttpSession session = request.getSession();
			String userName = (String)session.getAttribute("userName");
			if(PublicToolCheckParam.checkNullAndEmpty(userName)){
				UserInfoDAO udao = new UserInfoDAO();
				UserInfo ur =  udao.getUserId(userName);
				udao.updateUserName(ur.getId(), newUserName);
				request.setAttribute("url", "../admin/ok.jsp");
				session.setAttribute("userName", newUserName);
				session.setAttribute("msg", "修改用户名成功");
				request.getRequestDispatcher("../admin/systemManage.jsp").forward(request, response);
		}
}
	



//删除 用户信息
public  static void deleteInfo(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
		String Id = request.getParameter("Id");
			UserInfoDAO udao = new UserInfoDAO();
			udao.deleteUserInfo(Integer.parseInt(Id));
						request.setAttribute("error", "成功删除！");
		request.getRequestDispatcher("../servlet/UpdateUserInfo?method=showManageUserInfoPage").forward(request, response);
			
	}


//保存增加用户信息
public static void insertInfo(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			String str_userName = request.getParameter("username");
			String str_userRole = request.getParameter("userrole");
			String str_userPwd = "111111";
			//String deadline = request.getParameter("deadline");
			UserInfoDAO udao = new UserInfoDAO();

				udao.addUserInfo(str_userName,str_userPwd, str_userRole);
						request.setAttribute("error", "成功增加用户，用户初始密码为111111 ！");
		
		request.getRequestDispatcher("../servlet/UpdateUserInfo?method=showManageUserInfoPage").forward(request, response);
		
	}


	//显示增加用户页面
	public static void showAddUserInfoPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		request.getRequestDispatcher("../admin/addUserInfo.jsp").forward(request, response);
}
	
	//显示系统用户管理页面
	
		public static void showManageUserInfoPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		String currentPage = request.getParameter("currentPage");
		
		
			UserInfoDAO udao = new UserInfoDAO();
			
			int sumCount = udao.getSumUserCount();
	
			//设置分页PageModel对象
			PageModel pm = PublicToolPageModel.getPageInfo(request, sumCount,7,currentPage);
				
			//查询所有的信息		
			ArrayList<Object>  userInfoList = udao.getPageModelOfAllUser(pm);
			request.setAttribute("userInfoList", userInfoList);
		
		
		request.getRequestDispatcher("../admin/manageUserInfo.jsp").forward(request, response);
	
	}





//编辑用户信息
	public static void edituserInfo(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String submit = request.getParameter("submit");
		String userId = request.getParameter("Id");
		if(PublicToolCheckParam.checkNullAndEmpty(submit)){
				if(submit.equals("1")){
					
					String str_userName = request.getParameter("username");
					String str_userRole = request.getParameter("userrole");
					//String deadline = request.getParameter("deadline");
					UserInfoDAO udao = new UserInfoDAO();
					
					
					
					
					
					udao.updateUserInfo(Integer.parseInt(userId),str_userName, str_userRole);
					
					
					request.setAttribute("error", "成功修改用户 ！");		
					request.getRequestDispatcher("../servlet/UpdateUserInfo?method=showManageUserInfoPage").forward(request, response);
					
					
					
				
				}
		}else{
						//String userId = request.getParameter("Id");
					String str_userName = request.getParameter("username");
					String str_userRole = request.getParameter("userrole");
					 userId = request.getParameter("Id");
						request.setAttribute("userId", userId);
						request.setAttribute("userName", str_userName);
						request.setAttribute("userRole", str_userRole);
						request.getRequestDispatcher("../admin/updateUserInfo.jsp").forward(request, response);
				}
	}
	


	
	public static void updateUserPwd(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String userPwd = request.getParameter("newUserPwd");
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("userName");
		if(PublicToolCheckParam.checkNullAndEmpty(userName) && PublicToolCheckParam.checkNullAndEmpty(userPwd)){
			UserInfoDAO udao = new UserInfoDAO();
			UserInfo ur =  udao.getUserId(userName);
			udao.updateUserPwd(ur.getId(), userPwd);
			request.setAttribute("msg", "修改密码成功");
			request.getRequestDispatcher("../admin/ok.jsp").forward(request, response);
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
			else if(method.equals("showManageUserInfoPage")){
				showManageUserInfoPage(request, response);
			}
			else if(method.equals("showAddUserInfoPage")){
				showAddUserInfoPage(request, response);
			}
			
						else if(method.equals("insert")){
			
				insertInfo(request, response);
			}
			else if(method.equals("delete")){
				deleteInfo(request, response);
			}
			else if(method.equals("edituserInfo")){
				edituserInfo(request, response);
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
