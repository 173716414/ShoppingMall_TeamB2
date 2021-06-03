package com.control.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDetailInfoDAO;
import com.dao.CustomerInfoDAO;
import com.dao.GoodsEvaluateDAO;
import com.dao.OrderInfoDAO;
import com.entity.CustomerDetailInfo;
import com.entity.CustomerInfo;
import com.util.PublicToolCheckParam;
import com.util.PublicToolParam;

public class DoMethod extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 712262377940917206L;

	public static void checkEmail(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String regEmail = request.getParameter("regEmail");
		CustomerInfoDAO cdao = new CustomerInfoDAO();
		boolean isRegEmailExist = cdao.checkEmail(regEmail);
		if(isRegEmailExist == true){
			out.println("该邮箱已被注册!请换个邮箱!");
			
		}
		else{
			out.println("该邮箱未被注册!");
		}
	}

	public static void checkLogin(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		CustomerInfoDAO cdao = new CustomerInfoDAO();
		boolean isRegisted = cdao.checkLogin(email, pwd);
		if(isRegisted == false){
			
			request.setAttribute("error", "用户名或密码不正确,请重新输入!");
			request.getRequestDispatcher(PublicToolParam.LOGINORREGISTER).forward(request, response);
		}
		else{
			boolean isCooled = cdao.isCooled(email);
			if(isCooled == true){
				request.setAttribute("error", "该账号已被冻结!请换用其他账号登陆!");
				request.getRequestDispatcher(PublicToolParam.LOGINORREGISTER).forward(request, response);
			}
			else{
				session.setAttribute("email",email);
				response.sendRedirect("../");
			}
		}

	
}

//验证密码问题并设定初始密码为111111
public static void lost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		//HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		CustomerInfoDAO cdao = new CustomerInfoDAO();
		boolean islosted = cdao.checklost(email, question,answer);
		if(islosted == false){
			
			request.setAttribute("error", "用户名、提示问题和答案不对应,请重新输入!");
			request.getRequestDispatcher("../web/lost.jsp").forward(request, response);
		}
		else{
			
			
			cdao.setdefaultpwd(email);
			
			request.setAttribute("error", "您的密码已经重置为111111，请尽快登录系统修改密码!");
			request.getRequestDispatcher("../web/lost.jsp").forward(request, response);
		}

	
}
//修改密码
public static void updatepwd(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		//HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String pwd = request.getParameter("regPwd");
		CustomerInfoDAO cdao = new CustomerInfoDAO();
		
			
			
			cdao.updatepwd(email,pwd);
			
			request.setAttribute("error", "密码修改成功!");
			request.getRequestDispatcher("../servlet/DoMethod?method=showMyInformation").forward(request, response);
	

	
}




	//注销退出    
     //注销退出    
     public static void loginOut(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		session.removeAttribute("email");
		session.removeAttribute(PublicToolParam.SHOPLIST);
		response.sendRedirect("../");
	
}

	@SuppressWarnings("static-access")
	//保存用户注册信息到数据库    
     public static void register(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		String regEmail = request.getParameter("regEmail");
		String regPwd = request.getParameter("regPwd");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");


		String name = request.getParameter("name");
		String telephone = request.getParameter("telephone");
		String movePhone = request.getParameter("movePhone");
		String address = request.getParameter("address");
		CustomerInfoDAO cdao = new CustomerInfoDAO();
		cdao.addCustomer(regEmail, regPwd,question,answer);
		CustomerInfo customerInfo = cdao.getCustomerInfo(regEmail);
		int customerId = customerInfo.getId();
		CustomerDetailInfoDAO cddao = new CustomerDetailInfoDAO();
		cddao.addCustomerDetailInfo(customerId, "无", "无", "无", "无");
		//if(!PublicToolCheckParam.checkNullAndEmpty(name)){
			if(!PublicToolCheckParam.checkNullAndEmpty(name)){
				name = "无";
			}
			if(!PublicToolCheckParam.checkNullAndEmpty(telephone)){
				telephone = "无";
			}
			if(!PublicToolCheckParam.checkNullAndEmpty(movePhone)){
				movePhone = "无";
			}
			if(!PublicToolCheckParam.checkNullAndEmpty(address)){
				address = "无";
			}
			cddao.updateCustomerDdtailInfo(customerId, name, telephone, movePhone, address);
	//	}
		session.setAttribute("email", regEmail);
		response.sendRedirect("../filterWeb/ok1.jsp");
}
	
	
	@SuppressWarnings("static-access")
	//我的信息界面,读取相关信息,供页面显示使用    
     public static void showMyInformation(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		if(email != null){
			CustomerInfoDAO cdao = new CustomerInfoDAO();
			CustomerInfo customerInfo = cdao.getCustomerInfo(email);
			int customerId = customerInfo.getId();
			
			CustomerDetailInfoDAO cddao = new CustomerDetailInfoDAO();
			CustomerDetailInfo customerDetailInfo = cddao.getCustomerDetailInfo(customerId);
			
			OrderInfoDAO odao = new OrderInfoDAO();
			ArrayList<Object> orderList = odao.getOrderInfoByCustomerId(customerId);
			
			GoodsEvaluateDAO gedao = new GoodsEvaluateDAO();
			//ArrayList<Object> goodsEvaluateList = gedao.selectGoodsEvaluateInfoByEmail(email);
			
			
			//	request.setAttribute("goodsEvaluateList", goodsEvaluateList);
				request.setAttribute("orderList", orderList);
				request.setAttribute("customerDetailInfo", customerDetailInfo);
				request.setAttribute("customerInfo", customerInfo);
				request.getRequestDispatcher("../filterWeb/myInformation.jsp").forward(request, response);
			
		}
}
	
	
	/**
	 * Constructor of the object.
	 */
	public DoMethod() {
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
			if(method.equals("checkEmail")){
				checkEmail(request, response);
			}
			else if(method.equals("checkLogin")){
				checkLogin(request, response);
			}
			else if(method.equals("lost")){
				lost(request, response);
			}
			else if(method.equals("register")){
				register(request, response);
			}
			else if(method.equals("updatepwd")){
				updatepwd(request, response);
			}
			else if(method.equals("loginOut")){
				loginOut(request, response);
			}
			else if(method.equals("showMyInformation")){
				showMyInformation(request, response);
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
