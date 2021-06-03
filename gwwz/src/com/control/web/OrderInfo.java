package com.control.web;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.entity.OrderDetailInfo;
import com.dao.OrderDetailDAO;
import com.dao.CustomerDetailInfoDAO;
import com.dao.CustomerInfoDAO;
import com.dao.OrderGoodsInfoDAO;
import com.entity.CustomerDetailInfo;
import com.entity.CustomerInfo;
import com.entity.GoodsInfo;
import com.util.PublicToolCheckParam;
import com.util.PublicToolParam;
import com.entity.ServiceAssessment;
import com.dao.ServiceAssessmentDAO;
import com.dao.OrderInfoDAO;

import com.util.Validate;

@SuppressWarnings("serial")
public class OrderInfo extends HttpServlet {

	@SuppressWarnings({ "unchecked", "static-access" })
	//读取确认界面需要的信息    
     public static void showConfirmSendInfo(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		String name = request.getParameter("name");
		String telephone = request.getParameter("telephone");
		String movePhone = request.getParameter("movePhone");
		if(!PublicToolCheckParam.checkNullAndEmpty(telephone)){
			telephone = "无";
		}
		if(!PublicToolCheckParam.checkNullAndEmpty(movePhone)){
			movePhone = "无";
		}
		String address = request.getParameter("address");
		HttpSession session = request.getSession();
		ArrayList<GoodsInfo> shopList = (ArrayList<GoodsInfo>)session.getAttribute(PublicToolParam.SHOPLIST);
		CustomerInfoDAO cdao= new CustomerInfoDAO();
		CustomerInfo customerInfoList = cdao.getCustomerInfo(session.getAttribute("email").toString());
		int customerId = customerInfoList.getId();
		CustomerDetailInfoDAO cddao = new CustomerDetailInfoDAO();
		if(cddao.isCustomerDetailInfo(customerId) == true){
			cddao.updateCustomerDdtailInfo(customerId, name, telephone, movePhone, address);
			CustomerDetailInfo customerDetailInfoList = cddao.getCustomerDetailInfo(customerId);
			request.setAttribute("customerDetailInfoList", customerDetailInfoList);
		}
		else{
			cddao.addCustomerDetailInfo(customerId, name, telephone, movePhone, address);
			CustomerDetailInfo customerDetailInfoList = cddao.getCustomerDetailInfo(customerId);
			request.setAttribute("customerDetailInfoList", customerDetailInfoList);
		}
		request.setAttribute(PublicToolParam.SHOPLIST, shopList);
		request.setAttribute("customerInfoList", customerInfoList);
		request.getRequestDispatcher("../filterWeb/confirmSendInfo.jsp").forward(request, response);
}

	public static void showOrderInfo(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException, ParseException {
			PrintWriter out = response.getWriter();

		String orderId = (String)request.getParameter("orderId");
		OrderGoodsInfoDAO ogdao = new OrderGoodsInfoDAO();
		ArrayList<Object> orderList = ogdao.getOrderGoodsInfo(Integer.parseInt(orderId));
		
					//物流列表

			OrderDetailDAO wgdao = new OrderDetailDAO();

			ArrayList<Object> orderWuliuInfoList =  wgdao.getOrderWuliuInfo(Integer.parseInt(orderId));
			request.setAttribute("orderWuliuInfoList", orderWuliuInfoList);
		HttpSession session = request.getSession();

		CustomerInfoDAO cdao= new CustomerInfoDAO();
		CustomerInfo customerInfoList = cdao.getCustomerInfo(session.getAttribute("email").toString());
		int customerId = customerInfoList.getId();
		ServiceAssessmentDAO sdao = new ServiceAssessmentDAO();
			String isInsert = request.getParameter("isInsert");
			if(isInsert != null){
				if(isInsert.equals("insert")){
					String serviceAssessment = request.getParameter("serviceAssessment");
					sdao.insertServiceAssessment(customerId, serviceAssessment,Integer.parseInt(orderId));
					ArrayList<Object> serviceAssessmentList = sdao.selectServiceAssessment(Integer.parseInt(orderId));
					if(serviceAssessmentList != null){
						for(int i=0;i<serviceAssessmentList.size();i++){
							ServiceAssessment serviceAssessmentInfo = (ServiceAssessment)serviceAssessmentList.get(i);
							 Validate v = new Validate();
							 out.println(""+v.datemmddtime(serviceAssessmentInfo.getAssessmentTime())+"&nbsp;&nbsp;&nbsp;&nbsp;您评价道：&nbsp;&nbsp;"+serviceAssessmentInfo.getServiceAssessment()+"<br/><br/>");
						}
					}
				}
			}
			else{
				ArrayList<Object> serviceAssessmentList = sdao.selectServiceAssessment(Integer.parseInt(orderId));
				
				request.setAttribute("serviceAssessmentList", serviceAssessmentList);
		request.setAttribute("orderList", orderList);
		
		request.setAttribute("orderId", orderId);
		
		request.getRequestDispatcher("../filterWeb/orderInfo.jsp").forward(request, response);
			}
		}
		
		
		
		
		
		
			//设定状态为101    
     public static void th(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		String orderId = request.getParameter("orderId");
			OrderInfoDAO odao = new OrderInfoDAO();
			odao.updateOrderStatus(Integer.parseInt(orderId),101);
			OrderGoodsInfoDAO ogdao = new OrderGoodsInfoDAO();
			ogdao.updateOrderStatus(Integer.parseInt(orderId),101);
			
				response.sendRedirect("../servlet/DoMethod?method=showMyInformation");
		
	
}

			//设定状态为100    
     public static void sh(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		String orderId = request.getParameter("orderId");
			OrderInfoDAO odao = new OrderInfoDAO();
			odao.updateOrderStatus(Integer.parseInt(orderId),100);
			OrderGoodsInfoDAO ogdao = new OrderGoodsInfoDAO();
			ogdao.updateOrderStatus(Integer.parseInt(orderId),100);
			
				response.sendRedirect("../servlet/DoMethod?method=showMyInformation");
		
	
}


	/**
	 * Constructor of the object.
	 */
	public OrderInfo() {
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
		String method = (String)request.getParameter("method");
		if(method.equals("showConfirmSendInfo")){
			showConfirmSendInfo(request, response);
		}
		else if(method.equals("showOrderInfo")){
			try {
				showOrderInfo(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(method.equals("sh")){
			sh(request, response);
		}
		else if(method.equals("th")){
			th(request, response);
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
