<%@ page language="java" import="com.entity.GoodsInfo,java.text.DecimalFormat" pageEncoding="utf-8"%>
<%@page import="com.util.PublicToolCheckParam"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.ServiceAssessment"%>
<%@page import="com.entity.GoodsType"%>
<%@page import="com.util.PublicToolShowDetailTypeList"%>
<%@page import="com.util.PublicToolGetTypeDetailInfo"%>
<%@page import="com.dao.GoodsTypeDetailInfoDAO"%>
<%@page import="com.entity.GoodsType"%>
<%@page import="com.entity.GoodsTypeDetail"%>
<%@page import="com.entity.CustomerDetailInfo"%>
<%@page import="com.dao.CustomerDetailInfoDAO"%>
<%@page import="com.dao.CustomerInfoDAO"%>
<%@page import="com.util.Validate"%>

			<%@page import="com.dao.CustomerInfoDAO"%>
<%@page import="com.entity.CustomerInfo"%>		
					
<%
	GoodsInfo productInfo = (GoodsInfo)request.getAttribute("productInfo");
	String email = (String)session.getAttribute("email");
 %>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product details</title>

<link rel="stylesheet" href="../webstyle/base.css" type="text/css" media="screen">
<link rel="stylesheet" href="../webstyle/common.css" type="text/css" media="screen">
<link rel="stylesheet" href="../webstyle/mall.css" type="text/css" media="screen">
    <script type="text/javascript" src="../js/web/productInfo.js" charset="gb2312"></script>
    <script type="text/javascript">
    	function checkGoodsEvaluate(){
	
			var goodsEvaluateContent = document.getElementById("goodsEvaluate").value;
			if("<%=email%>" == "" || "<%=email%>" == "null"){
				alert("You are not logged in!Please log in and then evaluate the goods!");
				return false;
			}
			else if(goodsEvaluateContent == ""){
				alert("The content of the evaluation cannot be empty!");
				return false;
			}	
		}
		
    	function remainTime(){
    		var date = new Date();
 
    		var deadlineArray = deadline.split("-");
    		var remainTime = document.getElementById("remainTime");
    		remainTime.innerText = (deadlineArray[1]-date.getMonth()-1)*30+(deadlineArray[2]-date.getDate());
		}
		
		
		function sendRequest(){
			var goodsEvaluate = document.getElementById("goodsEvaluate").value;
			var method = "insert";
			var gid = "<%=productInfo.getGoodsId()%>";
			if("<%=email%>" == "" || "<%=email%>" == "null"){
				alert("You are not logged in!Please log in and then evaluate the goods!");
				return false;
			}
			else if(goodsEvaluate == ""){
				alert("The content of the evaluation cannot be empty!");
				return false;
			}	
			else{
				if(xmlHttp == null){
					createXMLHttpRequest();
				}	
				xmlHttp.open("POST","../servlet/ProductInfo",true);
				//指定一个HTTP报头
				xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
				xmlHttp.onreadystatechange = callback;
				xmlHttp.send("goodsEvaluate="+goodsEvaluate+"&method="+method+"&gid="+gid);
				document.getElementById("goodsEvaluate").value = "";
				return true;
			}
		}
		
		
		function callback(){
			if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
				var evaluateTable = document.getElementById("evaluateTable");
				evaluateTable.innerHTML = xmlHttp.responseText;
			}		
		}
		
		
    </script>
</head>
  <body onload="remainTime()">

<div id="wrap">
  
  
  
  
  
      <iframe src="../web/top.jsp" width="100%" frameborder="0"></iframe>

  <!-- end header-->
    <div id="main" class="mt10">
    <div class="fl lsort">
      <div class="sort">
        <h2>Choose classification</h2>
        <div class="sortbox">
         
       <%  ArrayList<GoodsType> goodsTypeList = (ArrayList<GoodsType>)request.getAttribute("goodsTypeList");
      	if(goodsTypeList == null || goodsTypeList.toString().equals("[]")){
      		out.println("<td colspan='5' height='30'><div align='center'>No product type information is currently available!</div></td>");
      	}
      	else{
      		for(int i=0;i<goodsTypeList.size();i++){
      			GoodsType gt = goodsTypeList.get(i);
      			String typeName = gt.getTypeName();
				%>
      			      		          <h3><%=typeName%></h3>
            			<ul>

      		<%
											
	
			PublicToolShowDetailTypeList.showDetailallTypeList(request, response,gt.getTypeId());

			ArrayList<GoodsTypeDetail> goodsTypeList1 = (ArrayList<GoodsTypeDetail>)request.getAttribute("goodsDetailallTypeList");
            	if(goodsTypeList1 == null || goodsTypeList1.toString().equals("[]")){
            		out.println("<div align='center'>No product type information is currently available!</td>");
            	}
            	else{
            		for(int ii=0;ii<goodsTypeList1.size();ii++){
            			GoodsTypeDetail gt1 = goodsTypeList1.get(ii);
            			String typeName1 = gt1.getTypeDetailInfo();
            			int Id=gt1.getId();
            			%>
            <li><a href="../servlet/typelist?typeid=<%=Id%>"><%=typeName1%></a>  </li>
            		
					
					<%}
            	}%>
			
			
			 </ul>
			
			<%	}
			
	                  
		
      }
       %>

         
         
         
         
          
        </div>
      </div>
     
    </div>
    <div class="fr rightbox">
      <div class="position"> Your current location: <a href="../" target="_top">Home page</a> &gt;&gt;Product information </div>
    <%
			String photoadd="";
			out.println("<tr><td rowspan='10' style='border:#FF99FF solid 1px' width='400'><div align='center'>");
			if(PublicToolCheckParam.checkNullAndEmpty(productInfo.getPhoto())){
				 photoadd="<img src='../"+productInfo.getPhoto()+"'  height='252' width='352' />";
			}
			else{
				photoadd="<img src='../webstyle/defaultpic.gif'  height='352' width='352' />";
			}
			out.println("</div></td></tr>");
			DecimalFormat df = new DecimalFormat("0.00");
			String currentPrice = df.format(productInfo.getDiscountPrice());
			int countRequire = productInfo.getCountRequire();
			if(countRequire == 0){
				//countRequire = 1;
			}
			%>

      <div class="mt10 productsinfo">
        <div class="fl preview"> <%=photoadd%> </div>
        <div class="fr textinfo">
          <h2><%=productInfo.getGoodsName()%></h2>
          <ul class="pinfo1">
            <li> <span>price&nbsp;&nbsp;&nbsp;&nbsp;：</span><strong>¥<%=currentPrice%></strong> </li>
            <li> <span>Product Number:</span> <%=productInfo.getGoodsId()%> </li>
          
            <li> <span>Have been sold:</span> <%=request.getAttribute("goodsOrderCount")%></li>
            <li> <span>Inventory:</span> <%=countRequire%>
               </li>
             <% Validate v= new Validate();%>
      	
<li> <span>Date of Issue:</span> <%=v.datemmddtime(productInfo.getCreatedate())%></li>
          </ul>
	<!--剩余数量显示和购买数量判断不能超过剩余数量-->
   <% if(countRequire == 0){%>
				
			<div class="productsnum"> We are sorry that this item is out of stock
            </div>
    
    <%}else{%>
    <form action="../servlet/Shopping?method=g&gid=<%=productInfo.getGoodsId()%>" method="post" onsubmit="return getCount(<%=countRequire%>)">
            <div class="productsnum"> Purchase quantity:
              <input id='count' type='text' name='count' value='1' style='width: 50px;height:20px'/>&nbsp;&nbsp;<font color='#666666' size='2'>件</font>
            </div>
          <input type='image' src='../image/icon/addtocart.gif' style='cursor: pointer;'/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='../web/cart.jsp'>View shopping cart</a>
          </form>
  <% } %>      <div class="clr"></div>
       
        </div>

        <div class="clr"></div>
      </div>
      <div class="clr"></div>
      <div class="mt10 productsbox">
        <h2> Commodity information </h2>
        <div class="productscontent">
         
         <%=productInfo.getRemark()%>
            </div>
     
     <br>
  
  <br><br><br>
  <table style="font-size: 13px">
			
					<div id="evaluateTable">
						
						
						
						
						
						
					</div>
			
		</table>
     
     
     
     
     
      </div>
   
   
   
   
   
    </div>
 
 
   
 Mall
  </div>
  
  

  <!--end footer-->
  </div>
  <div id="footer"  style="height:60px; background-color:#e54044;clear:both; ">
  <p style="text-align: center;	padding-top:20px;	color:#FFF"> SmartMall </p>
</div>

  
  

</body>
</html>





















