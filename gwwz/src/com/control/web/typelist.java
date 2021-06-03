package com.control.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsInfoDAO;
import com.dao.OrderGoodsInfoDAO;
import com.entity.GoodsInfo;
import com.entity.PageModel;
import com.entity.SalesGoods;
import com.util.PublicToolPageModel;
import com.dao.GoodsTypeDAO;
import com.entity.GoodsType;
import com.util.PublicToolCheckParam;
import com.util.PublicToolShowGooodsTypeList;
import com.util.PublicToolCheckParam;
import com.util.PublicToolShowGoodsInfolist;
public class typelist extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1978070320141148080L;

	/**
	 * Constructor of the object.
	 */
	public typelist() {
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

		/*String key = request.getParameter("key");
		String currentPage = request.getParameter("currentPage");
		key = new String(key.getBytes("iso-8859-1"),"utf-8");//转换关键词的编码
		GoodsInfoDAO gdao = new GoodsInfoDAO();
		ArrayList<Object> searchProductList =  gdao.searchProduct(key);
		
		//设置分页PageModel对象
		PageModel pm = PublicToolPageModel.getPageInfo(request,searchProductList.size(),15,currentPage);
			
		//查询所有的商品信息		
		ArrayList<Object>  searchProductInfoList = gdao.searchProductPageModel(pm, key);
		
		
		OrderGoodsInfoDAO ogdao = new OrderGoodsInfoDAO();
		ArrayList<SalesGoods> topTenList = ogdao.getTopTen();
		
		if(topTenList != null){
			ArrayList<String> goodsNameList = new ArrayList<String>();
			for(int i=0;i<topTenList.size();i++){
				SalesGoods sg = topTenList.get(i);
				GoodsInfo gd = gdao.getQueryGoodsInfo(sg.getGoodsId());
				goodsNameList.add(gd.getGoodsName());
			}
			request.setAttribute("goodsNameList", goodsNameList);
		}*/
		
				String currentPage = request.getParameter("currentPage");
		String typeid = request.getParameter("typeid");
		String order = request.getParameter("order");
			if(!PublicToolCheckParam.checkNullAndEmpty(order)){
			order="goodsid";
			}
		//typename = new String(typename.getBytes("iso-8859-1"),"utf-8");
		PublicToolShowGoodsInfolist.typelistGoodsInfoweb(request, response, currentPage, typeid,order);
		request.setAttribute("isSearching", "yes");
		request.setAttribute("typeid", typeid);
		
		//*翻页有问题待处理
		/*request.setAttribute("currentPage", currentPage);
		if(currentPage==null)		request.setAttribute("currentPage", "0");
*/
		
		
									// String currentPage1 = request.getParameter("currentPage1");
PublicToolShowGooodsTypeList.showGoodsallTypeList(request, response);
//request.setAttribute("topTenList", topTenList);
		//request.setAttribute("searchProductInfoList", searchProductInfoList);
		//request.setAttribute("typeid", typeid);
		request.getRequestDispatcher("../web/typelist.jsp").forward(request, response);
		
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
