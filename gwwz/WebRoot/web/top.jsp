<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.GoodsEvaluate"%>
<%@page import="com.entity.GoodsType"%>
<%@page import="com.util.PublicToolShowDetailTypeList"%>
<%@page import="com.util.PublicToolGetTypeDetailInfo"%>
<%@page import="com.dao.GoodsTypeDetailInfoDAO"%>
<%@page import="com.entity.GoodsType"%>
<%@page import="com.entity.GoodsTypeDetail"%>
<%@page import="com.util.PublicToolCheckParam"%>
<%@page import="com.entity.SalesGoods"%>
<%@page import="com.util.PublicToolShowGooodsTypeList"%>
<%
	String email = (String) session.getAttribute("email");
	String thirdemail = (String) session.getAttribute("thirdemail");
%>


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
 
 


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping site</title>

<link rel="stylesheet" href="../webstyle/base.css" type="text/css" media="screen">
<link rel="stylesheet" href="../webstyle/common.css" type="text/css" media="screen">
<link rel="stylesheet" href="../webstyle/mall.css" type="text/css" media="screen">
<script type="text/javascript" src="../js/web/top.js" charset="gb2312"></script>
<script type="text/javascript">
	function checkLogin(){
		if("<%=email%>" == "" || "<%=email%>" == "null"){
			alert("Log in first, please!");
			return false;
		}
		else{
                top.location.href = "<%=path%>/servlet/DoMethod?method=showMyInformation";
				return true;
		}
	}
	function checkUserLogin(){
		if("<%=email%>" == "" || "<%=email%>" == "null"){
			alert("Log in first, please!");
			return false;
		}
		else{
                top.location.href = "<%=path%>/servlet/DoChatMethod?method=login";
			return true;
		}
	}
</script>
</head>
<body>

<div id="wrap">
  <div id="header">
   
    <div class="fl logo"> <img src="../webstyle/logo.jpg" > </div>
    <div class="fr searchbox">
       <input type="text" id="key"  class="fl sinput" /> <input  type="button" onClick="getKey()" class="fl sbtn"/> 
        <div class="fl adsearch"> </div>
      <div class="clr"></div>
      <!-- <p class="keywords">Popular commodities: clothing accessories, beauty care, essentials for sleeping and living, food guides, digital electronics, culture and sports, various services... </p> -->
   &nbsp;&nbsp;</td>
      			<td></td>
    
    
    
    
    
    
    </div>
    <div class="clr"></div>
    <div class="navbar">
      <ul class="fl">
       
        <li class="nobg"><a href="<%=path%>/" title=""  target="_top">Home page</a></li>
				
       
       
       
       
        <% PublicToolShowGooodsTypeList.showGoodsallTypeList(request, response);
 ArrayList<GoodsType> goodsTypeList = (ArrayList<GoodsType>)request.getAttribute("goodsTypeList");
      	if(goodsTypeList == null || goodsTypeList.toString().equals("[]")){
      		out.println("<td colspan='5' height='30'><div align='center'>No type info!</div></td>");
      	}
      	else{
      		for(int i=0;i<goodsTypeList.size();i++){
      			GoodsType gt = goodsTypeList.get(i);
      			String typeName = gt.getTypeName();
				%>
      		<%
											
	
			PublicToolShowDetailTypeList.showDetailallTypeList(request, response,gt.getTypeId());

			ArrayList<GoodsTypeDetail> goodsTypeList1 = (ArrayList<GoodsTypeDetail>)request.getAttribute("goodsDetailallTypeList");
            	if(goodsTypeList1 == null || goodsTypeList1.toString().equals("[]")){
            		out.println("<div align='center'>No type info!</td>");
            	}
            	else{
            		
            			GoodsTypeDetail gt1 = goodsTypeList1.get(0);
            			String typeName1 = gt1.getTypeDetailInfo();
            			int Id=gt1.getId();
            			%>
            <li><a href="<%=path%>/servlet/typelist?typeid=<%=Id%>"  target="_top"><%=typeName%></a>  </li>
            		
					
					<%
            	}%>
			
			
		
			
			<%	}
			
	                  
		
      }
       %>
        
        <li>		<a href="<%=path%>/web/cart.jsp" target="_top">shopping cart</a></li>
       

      </ul>
      <span class="fr">
      <%
				if(email != null){
					out.println("<font color='#ffffff'>"+email+"&nbsp;&nbsp;Hello! </font><a href='#' onClick='return checkLogin()'><font color='#ffffff'>My Information</font></a> <a href='../servlet/DoMethod?method=loginOut' target='_top'><font color='#ffffff'>Log Out</font></a>");
				}
				else{
					out.println("<font color='#ffffff'>Hello! </font><a href='loginOrRegister.jsp' target='_top'><font color='#ffffff'>Click to Sign in!</font></a> <a href='loginOrRegister.jsp' target='_top'> <font color='#ffffff'>Click to sign up!</font></a>  ");
				}
			 %>
      
    
       
        </span> </div>
  </div>
 </div>
</body>
</html>

