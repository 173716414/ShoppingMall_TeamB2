package com.control.third;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.ThirdInfoDAO;
import com.util.PublicToolCheckParam;
import com.util.PublicToolShowThirdInfoList;

public class ManageThirdInfo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3099608914702213565L;
	static ThirdInfoDAO cdao = new ThirdInfoDAO();

	public  static void coolThirdInfo(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			String thirdId = request.getParameter("thirdId");
			String isCooled = request.getParameter("isCooled");
			if(PublicToolCheckParam.checkNullAndEmpty(thirdId) && PublicToolCheckParam.checkNullAndEmpty(isCooled)){
					cdao.coolThird(Integer.parseInt(thirdId),Integer.parseInt(isCooled));
					String isSearching = request.getParameter("isSearching");
					String currentPage = request.getParameter("currentPage");
					if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){
						String key = request.getParameter("key");
						PublicToolShowThirdInfoList.searchThirdInfo(request, response, currentPage, key);
						request.setAttribute("key", key);
						request.setAttribute("isSearching", "yes");
					}
					else{
						PublicToolShowThirdInfoList.showThirdInfoList(request, response, currentPage);
					}
			}
			request.getRequestDispatcher("../third/manageThirdInfo.jsp").forward(request, response);
			
	}

	public static void coolMoreThirdInfo(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			String currentPage = request.getParameter("currentPage");
			String[] ckb = request.getParameterValues("ckb");
			if(ckb != null){
				for(int i=0;i<ckb.length;i++){
	//				cdao.coolThird(Integer.parseInt(ckb[i]));
				}
			}
			PublicToolShowThirdInfoList.showThirdInfoList(request, response, currentPage);
			request.getRequestDispatcher("../third/manageThirdInfo.jsp").forward(request, response);
		
	}

	public static void searchThirdInfo(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			String currentPage = request.getParameter("currentPage");
			String key = request.getParameter("key");
			PublicToolShowThirdInfoList.searchThirdInfo(request, response, currentPage, key);
			request.setAttribute("isSearching", "yes");
			request.setAttribute("key", key);
			request.getRequestDispatcher("../third/manageThirdInfo.jsp").forward(request, response);
		
	}

	public static void showManageThirdInfoPage(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			String currentPage = request.getParameter("currentPage");
			PublicToolShowThirdInfoList.showThirdInfoList(request, response, currentPage);
			request.getRequestDispatcher("../third/manageThirdInfo.jsp").forward(request, response);
	
	}


/**
 * Constructor of the object.
 */
public ManageThirdInfo() {
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
	if(method.equals("showManageThirdInfoPage")){
		showManageThirdInfoPage(request, response);
	}
	else if(method.equals("cool")){
		coolThirdInfo(request, response);
	}
	else if(method.equals("coolMore")){
		coolMoreThirdInfo(request, response);
	}
	else if(method.equals("search")){
		searchThirdInfo(request, response);
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
