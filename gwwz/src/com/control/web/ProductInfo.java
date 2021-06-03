package com.control.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.GoodsEvaluateDAO;
import com.dao.GoodsInfoDAO;
import com.dao.OrderGoodsInfoDAO;
import com.dao.ServiceAssessmentDAO;
import com.entity.GoodsEvaluate;
import com.entity.GoodsInfo;
import com.dao.GoodsTypeDAO;
import com.entity.GoodsType;
import com.util.PublicToolCheckParam;
import com.util.PublicToolShowGooodsTypeList;



public class ProductInfo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2351901279935584494L;

	/**
	 * Constructor of the object.
	 */
	public ProductInfo() {
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

			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			String email = (String)session.getAttribute("email");
			String str_gid = request.getParameter("gid");
			int gid = Integer.parseInt(str_gid);
			GoodsInfoDAO gdao = new GoodsInfoDAO();
			GoodsInfo productInfo = gdao.getQueryGoodsInfo(gid);
			String goodsEvaluate= request.getParameter("goodsEvaluate");
			String method = request.getParameter("method");
			//GoodsEvaluateDAO gedao = new GoodsEvaluateDAO();
			ServiceAssessmentDAO sdao = new ServiceAssessmentDAO();
			
		/*	if(method != null){
				if(method.equals("insert")){
					gedao.insertGoodsEvaluate(gid, goodsEvaluate, email);
					ArrayList<Object> goodsEvaluateList = gedao.selectGoodsEvaluateInfo(gid);
					if(goodsEvaluateList != null){
						out.println("<font color='#FF6699'><strong>用户评价记录：</strong></font><br/><br/>");
						for(int i=0;i<goodsEvaluateList.size();i++){
							GoodsEvaluate goodsEvaluateInfo = (GoodsEvaluate)goodsEvaluateList.get(i);
							out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color='#666666'>"+goodsEvaluateInfo.getEmail()+"</font>&nbsp;&nbsp;说：&nbsp;&nbsp;"+goodsEvaluateInfo.getGoodsEvaluate()+"<br/><br/>");
						}
						out.println("<font color='#0099FF'><strong>我也说两句：</strong></font><br/><br/>");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textarea id='goodsEvaluate' name='goodsEvaluate' style='width: 500px;height: 100px'></textarea><br/>");
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' value='提交评价' style='height: 30px;padding-top: 3px' onclick='return sendRequest()'/>");
						
					}
				}
			}
			else{
			*/
	ArrayList<Object> serviceAssessmentList = sdao.selectGoodsServiceAssessment(gid);


	request.setAttribute("serviceAssessmentList", serviceAssessmentList);
		
				
				
				
			//	ArrayList<Object> goodsEvaluateList = gedao.selectGoodsEvaluateInfo(gid);
				
	
	
	OrderGoodsInfoDAO ogdao = new OrderGoodsInfoDAO();
				int goodsOrderCount = ogdao.getGoodsOrderCount(gid);
							String currentPage = request.getParameter("currentPage");
PublicToolShowGooodsTypeList.showGoodsTypeList(request, response, currentPage);
				request.setAttribute("productInfo", productInfo);
				request.setAttribute("goodsOrderCount", goodsOrderCount);
				//request.setAttribute("goodsEvaluateList", goodsEvaluateList);
				request.getRequestDispatcher("../web/productInfo.jsp").forward(request, response);
		//	}
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
