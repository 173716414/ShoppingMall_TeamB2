package com.control.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.CustomerInfoDAO;
import com.util.PublicToolCheckParam;
import com.util.PublicToolShowCustomerInfoList;

public class ManageCustomerInfo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3099608914702213565L;
	static CustomerInfoDAO cdao = new CustomerInfoDAO();

	//冻结
	public  static void coolCustomerInfo(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			String customerId = request.getParameter("customerId");
			String isCooled = request.getParameter("isCooled");
			if(PublicToolCheckParam.checkNullAndEmpty(customerId) && PublicToolCheckParam.checkNullAndEmpty(isCooled)){
					cdao.coolCustomer(Integer.parseInt(customerId),Integer.parseInt(isCooled));
					String isSearching = request.getParameter("isSearching");
					String currentPage = request.getParameter("currentPage");
					if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){
						String key = request.getParameter("key");
						PublicToolShowCustomerInfoList.searchCustomerInfo(request, response, currentPage, key);
						request.setAttribute("key", key);
						request.setAttribute("isSearching", "yes");
					}
					else{
						PublicToolShowCustomerInfoList.showCustomerInfoList(request, response, currentPage);
					}
			}
			request.getRequestDispatcher("../admin/manageCustomerInfo.jsp").forward(request, response);
			
	}

	public static void coolMoreCustomerInfo(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			String currentPage = request.getParameter("currentPage");
			String[] ckb = request.getParameterValues("ckb");
			if(ckb != null){
				for(int i=0;i<ckb.length;i++){
	//				cdao.coolCustomer(Integer.parseInt(ckb[i]));
				}
			}
			PublicToolShowCustomerInfoList.showCustomerInfoList(request, response, currentPage);
			request.getRequestDispatcher("../admin/manageCustomerInfo.jsp").forward(request, response);
		
	}

	public static void searchCustomerInfo(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			String currentPage = request.getParameter("currentPage");
			String key = request.getParameter("key");
			PublicToolShowCustomerInfoList.searchCustomerInfo(request, response, currentPage, key);
			request.setAttribute("isSearching", "yes");
			request.setAttribute("key", key);
	
				CustomerInfoDAO  cdao = new CustomerInfoDAO();
		
			int dongjie = cdao.getsdongjie(key);
			int zhengchang = cdao.getszhengchang(key);
			request.setAttribute("dongjie", dongjie);
			request.setAttribute("zhengchang", zhengchang);

			request.getRequestDispatcher("../admin/manageCustomerInfo.jsp").forward(request, response);
		
	}

	public static void showManageCustomerInfoPage(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		
		
			CustomerInfoDAO  cdao = new CustomerInfoDAO();
		
			int dongjie = cdao.getdongjie();
			int zhengchang = cdao.getzhengchang();
			request.setAttribute("dongjie", dongjie);
			request.setAttribute("zhengchang", zhengchang);

			String currentPage = request.getParameter("currentPage");
			PublicToolShowCustomerInfoList.showCustomerInfoList(request, response, currentPage);
			request.getRequestDispatcher("../admin/manageCustomerInfo.jsp").forward(request, response);
	
	}


/**
 * Constructor of the object.
 */
public ManageCustomerInfo() {
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
	if(method.equals("showManageCustomerInfoPage")){
		showManageCustomerInfoPage(request, response);
	}
	else if(method.equals("cool")){
		coolCustomerInfo(request, response);
	}
	else if(method.equals("coolMore")){
		coolMoreCustomerInfo(request, response);
	}
	else if(method.equals("search")){
		searchCustomerInfo(request, response);
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
