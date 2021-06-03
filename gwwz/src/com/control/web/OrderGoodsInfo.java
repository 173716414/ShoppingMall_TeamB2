package com.control.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerInfoDAO;
import com.dao.GoodsInfoDAO;
import com.dao.OrderGoodsInfoDAO;
import com.dao.OrderInfoDAO;
import com.entity.CustomerInfo;
import com.entity.GoodsInfo;
import com.entity.OrderInfo;
import com.util.PublicToolParam;

public class OrderGoodsInfo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8014446063818255854L;

	/**
	 * Constructor of the object.
	 */
	public OrderGoodsInfo() {
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
	@SuppressWarnings({ "unchecked", "static-access" })
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.getAttribute("email");
		CustomerInfoDAO cdao = new CustomerInfoDAO();
		CustomerInfo customerInfo = cdao.getCustomerInfo(session.getAttribute("email").toString());
		int customerId= customerInfo.getId();
		OrderInfoDAO od = new OrderInfoDAO();
		OrderInfo orderInfoList = od.addAndGetOrderInfo(customerId);
		int orderId = orderInfoList.getOrderId();
		ArrayList<GoodsInfo> shopList = (ArrayList<GoodsInfo>)session.getAttribute(PublicToolParam.SHOPLIST);
		for(int i=0;i<shopList.size();i++){
			GoodsInfo gd = shopList.get(i);
			OrderGoodsInfoDAO ogdao = new OrderGoodsInfoDAO();
			ogdao.addOrderGoodsInfo(orderId, gd.getGoodsId(), gd.getCount(),0);
		
		
		
		//减少商品剩余数量
			GoodsInfoDAO gdao = new GoodsInfoDAO();
gdao.updateOrderGoodscount( gd.getGoodsId(),gd.getCount());
		
		}
		
		
		
		//确认购买后清空购物车
		
		
			
			session.removeAttribute(PublicToolParam.SHOPLIST);
			session.setAttribute(PublicToolParam.SUM,"0");			
		
		response.sendRedirect("../filterWeb/ok2.jsp");
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
