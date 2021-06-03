package com.control.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDetailInfoDAO;
import com.dao.CustomerInfoDAO;
import com.dao.OrderGoodsInfoDAO;
import com.dao.OrderInfoDAO;
import com.entity.CustomerDetailInfo;
import com.entity.CustomerInfo;
import com.entity.OrderInfo;
import com.util.PublicToolCheckParam;
import com.util.PublicToolShowOrderList;

public class ManageOrder extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3433108879388967026L;
	static OrderInfoDAO odao = new OrderInfoDAO();

	public static void confirmOrder(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		String isSearching = request.getParameter("isSearching");
		String key = request.getParameter("key");
		String currentPage = request.getParameter("currentPage");
		String orderId = request.getParameter("orderId");
		String status = request.getParameter("status");
		if(PublicToolCheckParam.checkNullAndEmpty(orderId) && PublicToolCheckParam.checkNullAndEmpty(status)){
			OrderInfoDAO odao = new OrderInfoDAO();
			odao.updateOrderStatus(Integer.parseInt(orderId),Integer.parseInt(status));
			OrderGoodsInfoDAO ogdao = new OrderGoodsInfoDAO();
			ogdao.updateOrderStatus(Integer.parseInt(orderId),Integer.parseInt(status));
			if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){
				PublicToolShowOrderList.searchOrder(request, response, currentPage, key);
				request.setAttribute("key", key);
				request.setAttribute("isSearching", "yes");
			}
			else{
				PublicToolShowOrderList.showOrderList(request, response, currentPage);
			}
			
			request.getRequestDispatcher("../admin/manageOrder.jsp").forward(request, response);
		}
		
	
}

	public static void deleteMoreOrder(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			String currentPage = request.getParameter("currentPage");
			String[] ckb = request.getParameterValues("ckb");
			if(ckb != null){
				for(int i=0;i<ckb.length;i++){
					odao.deleteOrder(Integer.parseInt(ckb[i]));
				}
			}
			PublicToolShowOrderList.showOrderList(request, response, currentPage);
			request.getRequestDispatcher("../admin/manageOrder.jsp").forward(request, response);
		
	}

	public  static void deleteOrder(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			String orderId = request.getParameter("orderId");
			if(PublicToolCheckParam.checkNullAndEmpty(orderId)){
					odao.deleteOrder(Integer.parseInt(orderId));
					String isSearching = request.getParameter("isSearching");
					String currentPage = request.getParameter("currentPage");
					if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){
						String key = request.getParameter("key");
						PublicToolShowOrderList.searchOrder(request, response, currentPage, key);
						request.setAttribute("key", key);
						request.setAttribute("isSearching", "yes");
					}
					else{
						PublicToolShowOrderList.showOrderList(request, response, currentPage);
					}
			}
			request.getRequestDispatcher("../admin/manageOrder.jsp").forward(request, response);
			
	}

	public static void searchOrder(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			String currentPage = request.getParameter("currentPage");
			String key = request.getParameter("key");
			PublicToolShowOrderList.searchOrder(request, response, currentPage, key);
			
			
					OrderInfoDAO odao = new OrderInfoDAO();
	int queren = odao.getsqueren(key);
			int wqueren = odao.getswqueren(key);
			int tuihuo = odao.getstuihuo(key);
			request.setAttribute("queren", queren);
			request.setAttribute("wqueren", wqueren);	
			request.setAttribute("tuihuo", tuihuo);	
		

			request.setAttribute("isSearching", "yes");
			
			
			
			request.setAttribute("key", key);
			request.getRequestDispatcher("../admin/manageOrder.jsp").forward(request, response);
		
	}

	
	public static void showDetailOrder(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		String orderId = request.getParameter("orderId");
		if(PublicToolCheckParam.checkNullAndEmpty(orderId)){
			OrderInfoDAO odao = new OrderInfoDAO();
			OrderInfo orderInfo = odao.getOrderInfo(Integer.parseInt(orderId));
			CustomerInfoDAO cdao = new CustomerInfoDAO();
			CustomerInfo customerInfo =  cdao.getCustomerInfo(orderInfo.getCustomerId());
			CustomerDetailInfoDAO cddao = new CustomerDetailInfoDAO();
			CustomerDetailInfo customerDetailInfo = cddao.getCustomerDetailInfo(orderInfo.getCustomerId());
			OrderGoodsInfoDAO ogdao = new OrderGoodsInfoDAO();
			ArrayList<Object> orderGoodsInfoList =  ogdao.getOrderGoodsInfo(orderInfo.getOrderId());
			request.setAttribute("orderGoodsInfoList", orderGoodsInfoList);
			request.setAttribute("customerDetailInfo", customerDetailInfo);
			request.setAttribute("customerInfo", customerInfo);
			request.setAttribute("orderInfo", orderInfo);
			request.getRequestDispatcher("../admin/orderDetailInfo.jsp").forward(request, response);
		}
	
}
	
	
	public static void showManageOrderPage(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		
		OrderInfoDAO odao = new OrderInfoDAO();
	int queren = odao.getqueren();
			int wqueren = odao.getwqueren();
			int tuihuo = odao.gettuihuo();
			request.setAttribute("queren", queren);
			request.setAttribute("wqueren", wqueren);	
			request.setAttribute("tuihuo", tuihuo);	
		
			String currentPage = request.getParameter("currentPage");
			PublicToolShowOrderList.showOrderList(request, response, currentPage);
			request.getRequestDispatcher("../admin/manageOrder.jsp").forward(request, response);
			
	}
	
	/**
	 * Constructor of the object.
	 */
	public ManageOrder() {
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
			if(method.equals("showManageOrderPage")){
				showManageOrderPage(request, response);
			}
			else if(method.equals("delete")){
				deleteOrder(request, response);
			}
			else if(method.equals("deleteMore")){
				deleteMoreOrder(request, response);
			}
			else if(method.equals("search")){
				searchOrder(request, response);
			}
			else if(method.equals("confirm")){
				confirmOrder(request, response);
			}
			else if(method.equals("showDetail")){
				showDetailOrder(request, response);
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
