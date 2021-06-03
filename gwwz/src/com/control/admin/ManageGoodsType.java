package com.control.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsInfoDAO;
import com.dao.GoodsTypeDAO;
import com.entity.GoodsType;
import com.util.PublicToolCheckParam;
import com.util.PublicToolShowGooodsTypeList;

public class ManageGoodsType extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 903516041045550470L;
	static GoodsTypeDAO gtdao = new GoodsTypeDAO();

	//删除商品类型  
  //删除商品类型  
  public  static void deleteGoodsType(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			String typeId = request.getParameter("typeId");
			if(PublicToolCheckParam.checkNullAndEmpty(typeId)){
				GoodsInfoDAO gdao = new GoodsInfoDAO();
				boolean isExist = gdao.isGoodsExistInGooodsType(Integer.parseInt(typeId));
					if(isExist == false){
						gtdao.deleteGoodsType(Integer.parseInt(typeId));
						String isSearching = request.getParameter("isSearching");
						String currentPage = request.getParameter("currentPage");
						if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){
							String key = request.getParameter("key");
							PublicToolShowGooodsTypeList.searchGoodsType(request, response, currentPage, key);
							request.setAttribute("key", key);
							request.setAttribute("isSearching", "yes");
						}
						else{
							PublicToolShowGooodsTypeList.showGoodsTypeList(request, response, currentPage);
						}
						request.getRequestDispatcher("../admin/manageGoodsType.jsp").forward(request, response);
					}
					else{
						request.setAttribute("error", "删除失败!商品类型下还存在商品!");
						request.getRequestDispatcher("../admin/error.jsp").forward(request, response);
					}
			}
			
	}

	public static void deleteMoreGoodsType(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			String currentPage = request.getParameter("currentPage");
			String[] ckb = request.getParameterValues("ckb");
			if(ckb != null){
				int isDeleteMethodPass = 1;
				for(int i=0;i<ckb.length;i++){
					GoodsInfoDAO gdao = new GoodsInfoDAO();
					boolean isExist = gdao.isGoodsExistInGooodsType(Integer.parseInt(ckb[i]));
					if(isExist == true){
						isDeleteMethodPass = 0;
						break;
					}
				}
				if(isDeleteMethodPass == 1){
					for(int i=0;i<ckb.length;i++){
						GoodsInfoDAO gdao = new GoodsInfoDAO();
						boolean isExist = gdao.isGoodsExistInGooodsType(Integer.parseInt(ckb[i]));
						if(isExist)
							gtdao.deleteGoodsType(Integer.parseInt(ckb[i]));
						}
					PublicToolShowGooodsTypeList.showGoodsTypeList(request, response, currentPage);
					request.getRequestDispatcher("../admin/manageGoodsType.jsp").forward(request, response);
				}
				else{
					request.setAttribute("error", "删除失败!商品类型下还存在商品!");
					request.getRequestDispatcher("../admin/error.jsp").forward(request, response);
				}
			}
		}

	//添加商品类型  
  public static void insertGoodsType(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			String currentPage = request.getParameter("currentPage");
			String goodsTypeId = request.getParameter("goodsTypeId");
			String typeName = request.getParameter("typeName");
			//typeName = new String(typeName.getBytes("iso-8859-1"),"utf-8");
			if(PublicToolCheckParam.checkNullAndEmpty(typeName)){
				if(Integer.parseInt(goodsTypeId) == 0){
					gtdao.addGoodsType(typeName);
				}
				if(Integer.parseInt(goodsTypeId)!=0){
					gtdao.addGoodsType_c(typeName,goodsTypeId);
				
				}
				PublicToolShowGooodsTypeList.showGoodsTypeList(request, response, currentPage);
				request.getRequestDispatcher("../admin/manageGoodsType.jsp").forward(request, response);
			}
	}

	public static void searchGoodsType(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			String currentPage = request.getParameter("currentPage");
			String key = request.getParameter("key");
			key = new String(key.getBytes("iso-8859-1"),"utf-8");//转换关键词的编码
			PublicToolShowGooodsTypeList.searchGoodsType(request, response, currentPage, key);
			request.setAttribute("isSearching", "yes");
			request.setAttribute("key", key);
			request.getRequestDispatcher("../admin/manageGoodsType.jsp").forward(request, response);
		
	}
	
	
	//显示商品类型添加的页面  
  public static void showAddGoodsTypePage(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			
			GoodsTypeDAO gtdao = new GoodsTypeDAO();
			ArrayList<Object> typeList1 = gtdao.getAllType();
		//	GoodsTypeDetailInfoDAO gtddao = new GoodsTypeDetailInfoDAO();
			//ArrayList<Object> typeDetailInfoList = gtddao.getTypeDetailInfo(6);
			request.setAttribute("typeList1", typeList1);
			//request.setAttribute("typeDetailInfoList", typeDetailInfoList);
			
			request.getRequestDispatcher("../admin/addGoodsType.jsp").forward(request, response);
		
			
		
}
	
	//管理员管理商品类型  
  public static void showManageGoodsTypePage(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			String currentPage = request.getParameter("currentPage");
			//		String typeId = request.getParameter("typeId");
//			if(typeId!=null  && typeId.trim().length()>0){
//				PublicToolShowGooodsTypeList.showDetailTypeList(request, response, currentPage,  Integer.parseInt(typeId));
//			}
		//	if(typeId==null){
				PublicToolShowGooodsTypeList.showGoodsTypeList(request, response, currentPage);
		//	}
		
			request.getRequestDispatcher("../admin/manageGoodsType.jsp").forward(request, response);
			
	}
	
	
	
	
	public static void updateGoodsType(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String currentPage = request.getParameter("currentPage");
		String submit = request.getParameter("submit");
		String typeId = request.getParameter("typeId");
		String typeName = request.getParameter("typeName");
		if(PublicToolCheckParam.checkNullAndEmpty(typeId)){
			if(PublicToolCheckParam.checkNullAndEmpty(submit) && submit.equals("1")){
				gtdao.updateGoodsType(Integer.parseInt(typeId),typeName);//保存修改的内容到数据库
				PublicToolShowGooodsTypeList.showGoodsTypeList(request, response, currentPage);
				request.getRequestDispatcher("../admin/manageGoodsType.jsp").forward(request, response);
				
			}
			else{
				GoodsType goodsTypeInfo = gtdao.getGoodsTypeInfo(Integer.parseInt(typeId));
				request.setAttribute("goodsTypeInfo", goodsTypeInfo);  //读取内容供显示使用
				request.getRequestDispatcher("../admin/updateGoodsType.jsp").forward(request, response);
			}
		}
	}
	
	/**
	 * Constructor of the object.
	 */
	public ManageGoodsType() {
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
			if(method.equals("showAddGoodsTypePage")){
				showAddGoodsTypePage(request, response);
			}
			else if(method.equals("showManageGoodsTypePage")){
				showManageGoodsTypePage(request, response);
			}
			//else if(method.equals("showManageTypedetailInfoPage")){
			//	showManageGoodsTypePage(request, response);
		//	}
			else if(method.equals("insert")){
				insertGoodsType(request, response);
			}
			else if(method.equals("delete")){
				deleteGoodsType(request, response);
			}
			else if(method.equals("deleteMore")){
				deleteMoreGoodsType(request, response);
			}
			else if(method.equals("search")){
				searchGoodsType(request, response);
			}
			else if(method.equals("update")){
				updateGoodsType(request, response);
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
