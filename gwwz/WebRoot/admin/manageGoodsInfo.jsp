<%@ page language="java" import="java.util.*,java.text.DecimalFormat" pageEncoding="utf-8"%>
<%@page import="com.entity.BulletinInfo"%>
<%@page import="com.util.PublicToolCheckParam"%>
<%@page import="com.entity.GoodsInfo"%>
<%@page import="com.dao.ThirdInfoDAO"%>
<%@page import="com.entity.ThirdInfo"%>
<%@page import="com.util.PublicToolGetGoodsTypeName"%>
<%@page import="com.util.Validate"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Commodity information management</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <script type="text/javascript" src="../js/admin/manageGoodsInfo.js" charset="gb2312"></script>
  </head>
  
  <body>
  <form action="../servlet/ManageGoodsInfo?method=deleteMore" method="post">
    <table width="100%" border="0" cellpadding="0" cellspacing="0" style="font-size:13px;">
  <tr>
    <td width="100%" height="36"><strong><font size="6" color="#0099FF">□&nbsp;</font><font color="#666666" size="3">Commodity information management</font></strong></td>
    <td height="36"><div align="right"><input type="text" name="key"  id="key" style="height: 24px;width: 250px;padding-top: 2px;padding-left:20px;background-image: url(../image/icon/key_search.gif);background-repeat: no-repeat"/></div></td>
    <td><input type="button" value="Query" style="height: 26px;width: 70px;padding-top: 2px" onClick="return searchGoodsInfo()"/></td>
    <td><input type="button" value="Add goods" style="height: 26px;width: 70px;padding-top: 2px" onClick="showAddGoodsInfoPage()"/></td>
    <!-- <td><input type="submit" value="delete goods" style="height: 26px;width: 70px;padding-top: 2px" onClick="return deletMoreGoodsInfo()"/></td>
  -->
 </tr>
  <tr>
    <td height="40" colspan="5"><hr  width="100%"/></td>
  </tr>
  <tr>
    <td height="147" colspan="10">
    <table width="100%" border="1" cellpadding="0" cellspacing="0" style="font-size:13px"  bordercolor="#9999FF"> 
      <tr height="30">
         <!-- <td width="40"><div align="center"><font color="#666666">全选</font></div></td>
        <td width="35"><div align="center"><input type="checkbox" id="checkAll" value="checkbox" onClick="selectAll()"/></div></td>
        --><td width="55"><div align="center"><font color="#666666">Product id</font></div></td>
        <td width="85"><div align="center"><font color="#666666">Commodity categories</font></div></td>
        <td><div align="center"><font color="#666666">Name of commodity</font></div></td>
        <td width="65"><div align="center"><font color="#666666">Commodity prices</font></div></td>
        <td width="55"><div align="center"><font color="#666666">Release time</font></div></td>
        <td width="110"><div align="center"><font color="#666666">Number remaining</font></div></td>
              <td width="110"><div align="center"><font color="#666666">Release people</font></div></td>
        <td width="55"><div align="center"><font color="#666666">Goods state</font></div></td>
        <td><div align="center"><font color="#666666">Review the status</font></div></td>
        <td width="70"><div align="center"><font color="#666666">operation</font></div></td>
      </tr>
      <%
      	String isSearching = (String)request.getAttribute("isSearching");
 		ArrayList<GoodsInfo> goodsInfoList = (ArrayList<GoodsInfo>)request.getAttribute("goodsInfoList");
      	if(goodsInfoList == null || goodsInfoList.toString().equals("[]")){
      		out.println("<td colspan='12' height='30'><div align='center'>No product information is available at this time!</div></td>");
      	}
      	else{
      		DecimalFormat df = new DecimalFormat("0.00");
      		for(int i=0;i<goodsInfoList.size();i++){
      			GoodsInfo gd = goodsInfoList.get(i);
      			String goodsName = gd.getGoodsName();
      			if(goodsName.length() >19){
      				goodsName = goodsName.substring(0,18)+"...";
      			}
      			String price = df.format(gd.getPrice());
      			String createdate=gd.getCreatedate();
      			int countrequire=gd.getCountRequire();
      			String userid=gd.getUserid();
      			 String thirdName ="";
				if(userid == null){
      				thirdName = "The administrator";
      			}else{
					
		
				ThirdInfoDAO udao = new ThirdInfoDAO();
				ThirdInfo ThirdInfo = udao.getThirdInfo(Integer.parseInt(userid));
			    thirdName = ThirdInfo.getthirdName();
					
					}
      			/*String discount = "All discount";
      			if((int)gd.getDiscount() != 10){
      				discount = String.format("%.1f",gd.getDiscount());
      			}
      			String photo = gd.getPhoto();
      			if(photo == null){
      				photo = "no";
      			}
      			String isNew = "New product";
      			if(gd.getIsNew() == 1){
      				isNew = "Not new product";
      			}*/
      			String isRecommend = "Recommend";
      			if(gd.getIsRecommend() == 1){
      				isRecommend = "Not recommend";
      			}
      			String status = "On shelves";
      			if(gd.getStatus() == 1){
      				status = "Off shelves";
      			}
      			out.println("<tr height='30'>");
	      		//out.println("<td><div align='center'>Check</div></td>");
	      		//out.println("<td><div align='center'><input id='ckb' type='checkbox' name='ckb' value='"+gd.getGoodsId()+"' /></div></td>");
	      		out.println("<td><div align='center'>"+gd.getGoodsId()+"</div></td>");
	      		
	      		out.println("<td><div align='center'>"+ PublicToolGetGoodsTypeName.getGoodDetailTypeName(Integer.parseInt(gd.getTypeDetailInfo()))+"</div></td>");
	      		out.println("<td><div align='center'>"+goodsName+"</div></td>");
	      		out.println("<td><div align='center'>￥"+price+"</div></td>");
	      		  Validate v = new Validate();


	      		out.println("<td><div align='center'>"+v.datemmdd(createdate)+"</div></td>");
	      		out.println("<td><div align='center'>"+countrequire+"</div></td>");
	      		out.println("<td><div align='center'>"+thirdName+"</div></td>");
	      		
	      		out.println("<td><div align='center'>"+status+"</div></td>");
	      		//out.println("<td><div align='center'>"+gd.getGoodsId()+"</div></td>");
	      		if(gd.getIsCooled() == 1){
	      			out.println("<td><div align='center'><font color='#FF0000'>Not audit</font></div></td>");
	      		}
	      		else{
	      			out.println("<td><div align='center'>The approved</div></td>");
	      		}
				out.println("<td><div align='center'>");
				if(PublicToolCheckParam.checkNullAndEmpty(isSearching) && goodsInfoList.size() > 1){
	      			out.println("<a href='../servlet/ManageGoodsInfo?method=update&goodsId="+gd.getGoodsId()+"'>Modify</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick=deleteGoodsInfoOfSearching("+gd.getGoodsId()+","+request.getAttribute("key")+")>delete</a>");
	      		
				
				if(gd.getIsCooled() == 1){
	      				out.println(" <a href='#' onclick=coolGoodsInfoOfSearching("+gd.getGoodsId()+","+gd.getIsCooled()+","+request.getAttribute("key")+")>approved</a>");
	      			}
	      			else{
	      				out.println(" <a href='#' onclick=coolGoodsInfoOfSearching("+gd.getGoodsId()+","+gd.getIsCooled()+","+request.getAttribute("key")+")>Cancel the audit</a>");
	      			}
				
				
				}
	      		else{
	      			out.println("<a href='../servlet/ManageGoodsInfo?method=update&goodsId="+gd.getGoodsId()+"'>Modify</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick=deleteGoodsInfo("+gd.getGoodsId()+")>delete</a>");
	      		    
					if(gd.getIsCooled() == 1){
	      				out.println(" <a href='#' onclick=coolGoodsInfo("+gd.getGoodsId()+","+gd.getIsCooled()+")>approved</a>");
	      			}
	      			else{
	      				out.println(" <a href='#' onclick=coolGoodsInfo("+gd.getGoodsId()+","+gd.getIsCooled()+")>Cancel the audit</a>");
	      			}

			
			
				}
	      		
	      		out.println("</div></td></tr>");
      		}
      	}
       %>
      <tr><td colspan="13" height="50"><div align="center">Total <%=request.getAttribute("sumCount")%> has been found&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;the<%=request.getAttribute("currentPage")%>/<%=request.getAttribute("sumPageCount")%>page&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../servlet/ManageGoodsInfo?method=<%if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){out.println("search&key="+request.getAttribute("key")+"");}else{out.println("showManageGoodsInfoPage");}%>&currentPage=<%=request.getAttribute("indexPage")%>">Home Page</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../servlet/ManageGoodsInfo?method=<%if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){out.println("search&key="+request.getAttribute("key")+"");}else{out.println("showManageGoodsInfoPage");}%>&currentPage=<%=request.getAttribute("upPage")%>">The previous page</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../servlet/ManageGoodsInfo?method=<%if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){out.println("search&key="+request.getAttribute("key")+"");}else{out.println("showManageGoodsInfoPage");}%>&currentPage=<%=request.getAttribute("nextPage")%>">The next page</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../servlet/ManageGoodsInfo?method=<%if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){out.println("search&key="+request.getAttribute("key")+"");}else{out.println("showManageGoodsInfoPage");}%>&currentPage=<%=request.getAttribute("lastPage")%>">Back</a> </div></td></tr>
    </table>
    </td>
  </tr>
</table>
</form>
  </body>
</html>
