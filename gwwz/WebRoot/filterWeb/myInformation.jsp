<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.entity.GoodsEvaluate"%>
<%@page import="com.entity.OrderInfo"%>
<%@page import="com.entity.CustomerDetailInfo"%>
<%@page import="com.entity.CustomerInfo"%>
<%@page import="com.dao.GoodsInfoDAO"%>
<%@page import="com.entity.GoodsInfo"%>
<%@page import="com.util.Validate"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>My information</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <script type="text/javascript" src="../js/web/myInformation.js" charset="gb2312"></script>
  </head>
  
  <body>
  <iframe src="../web/top.jsp" width="100%" height="170" frameborder="0"></iframe>
  <table border="0" cellspacing="0" cellpadding="0" width='960px' align="center">
  <tr height="60">
    <td><font size="2" color="#999999">Where you are now：<a href="../" target="_top">Home page</a>&gt; My information</font></td>
  </tr>
</table>
    <table style="font-size: 13px;margin-top: 20px" width='960px' align="center">
    	<%
    		//ArrayList<GoodsEvaluate> goodsEvaluateList = (ArrayList<GoodsEvaluate>)request.getAttribute("goodsEvaluateList");
			ArrayList<OrderInfo> orderList= (ArrayList<OrderInfo>)request.getAttribute("orderList");
			CustomerDetailInfo customerDetailInfo =	(CustomerDetailInfo)request.getAttribute("customerDetailInfo");
			CustomerInfo  customerInfo = (CustomerInfo)request.getAttribute("customerInfo");
			out.println("<tr><td colspan='2'>");
			
			 Validate v = new Validate();
			
    		String error = (String)request.getAttribute("error");
    		if(error != null){
    			out.println("<font color='#FF0000' size='2'>"+error+"</font>");
    		}
    	 
			out.print("<hr color='#FF6699' style='height:1px'/></td></tr>");
			out.println("<tr><td height='30' colspan='2'><font color='#0099FF' size='3'><strong>Account Inf:</strong></font></td></tr>");
			out.println("<tr><td height='30' style='padding-left:20px'><font color='#666666'><strong>Account:</strong></font></td><td width='600' style='padding-left:20px'>"+customerInfo.getEmail()+"</td></tr>");
			out.println("<tr><td height='30' style='padding-left:20px'><font color='#666666'><strong>Register Time:</strong></font></td><td style='padding-left:20px'>"+v.datemmddtime(customerInfo.getRegisterTime())+"</td></tr>");
			out.println("<tr><td colspan='2'><hr color='#FF6699' style='height:1px'/></td></tr>");
			
			
			out.println("    <form action='../servlet/DoMethod?method=updatepwd' method='post' onsubmit='return checkupdate()'><tr><td colspan='2'></td></tr>");
			out.println("<input type='hidden' name='email' value='"+customerInfo.getEmail()+"'><tr><td height='30' colspan='2'><font color='#0099FF' size='3'><strong>change password:</strong></font></td></tr>");
			out.println("<tr><td height='30' style='padding-left:20px'><font color='#666666'><strong>password:</strong></font></td><td width='600' style='padding-left:20px'><input id='regPwd' type='password' name='regPwd' style='width:200px;height:19px;padding-top: 3px'/></td></tr>");
			out.println("<tr><td height='30' style='padding-left:20px'><font color='#666666'><strong>confirm password:</strong></font></td><td style='padding-left:20px'><input id='regConPwd' type='password' name='regConPwd' style='width:200px;height:19px;padding-top: 3px'/></td></tr>");
			out.println("<tr><td colspan='2'  align='center'><input type='image' style='cursor: pointer;' src='../image/icon/payOnline.jpg' align='middle'/><br><hr color='#FF6699' style='height:1px'/></td></tr></form>");
			
			
			out.println("<tr><td  height='30' colspan='2'><font color='#0099FF' size='3'><strong>The latest personal shipping information:</strong></font></td></tr>");
			if(customerDetailInfo == null){
				out.println("<tr><td height='30' style='padding-left:20px'><font color='#666666'><strong>Name:</strong></font></td><td style='padding-left:20px'>Never written</td></tr>");
				out.println("<tr><td height='30' style='padding-left:20px'><font color='#666666'><strong>Fixed-line phone:</strong></font></td><td style='padding-left:20px'>Never written</td></tr>");
				out.println("<tr><td height='30' style='padding-left:20px'><font color='#666666'><strong>Mobile phone:</strong></font></td><td style='padding-left:20px'>Never written</td></tr>");
				out.println("<tr><td height='30' style='padding-left:20px'><font color='#666666'><strong>Address:</strong></font></td><td style='padding-left:20px'>Never written</td></tr>");
				
			}
			else{
				out.println("<tr><td height='30' style='padding-left:20px'><font color='#666666'><strong>Name: </strong></font></td><td style='padding-left:20px'>"+customerDetailInfo.getName()+"</td></tr>");
				out.println("<tr><td height='30' style='padding-left:20px'><font color='#666666'><strong>Fixed-line phone:</strong></font></td><td style='padding-left:20px'>"+customerDetailInfo.getTelphone()+"</td></tr>");
				out.println("<tr><td height='30' style='padding-left:20px'><font color='#666666'><strong>Mobile phone:</strong></font></td><td style='padding-left:20px'>"+customerDetailInfo.getMovePhone()+"</td></tr>");
				out.println("<tr><td height='30' style='padding-left:20px'><font color='#666666'><strong>Address:</strong></font></td><td style='padding-left:20px'>"+customerDetailInfo.getAddress()+"</td></tr>");
			}
			out.println("<tr><td colspan='2'><hr color='#FF6699' style='height:1px'/></td></tr>");
			out.println("<tr><td height='30' colspan='2'><font color='#0099FF' size='3'><strong>Former orders：</strong></font></td></tr>");
			out.println("<tr><td style='padding-left:20px' colspan='2'>");
			out.println("<table border='1' cellpadding='0' cellspacing='0' style='font-size:13px'  bordercolor='#9999FF'>");
			out.println("<tr height='30'>");
			out.println("<td width='170'><div align='center'><font color='#666666'>Order number</font></div></td>");
        	out.println("<td width='170'><div align='center'><font color='#666666'>Order state</font></div></td>");
        	out.println("<td width='170'><div align='center'><font color='#666666'>Order time</font></div></td>");
 			out.println("<td width='170'><div align='center'><font color='#666666'>Operation</font></div></td>");
 			out.println("</tr>");
 			if(orderList.size() == 0){
 				out.println("<tr><td height='30' colspan='4'><div align='center'>You never order!</div></td></tr>");
 			}
 			else{
 				for(int i=0;i<orderList.size();i++){
 					OrderInfo orderInfo = orderList.get(i);
 					String status = "Not confirm <a href='#' onclick=th("+orderInfo.getOrderId()+")>Return goods.</a>";
 					if(orderInfo.getStatus() == 1){
 						status = "Already confirmed! <a href='#' onclick=sh("+orderInfo.getOrderId()+")> Confirm order.</a>";
 					}
					if(orderInfo.getStatus() == 100){
 						status = "Confirm order.";
 					}
					if(orderInfo.getStatus() == 101){
 						status = "Return goods";
 					}
 					out.println("<tr>");
 					out.println("<td height='30'><div align='center'><font color='#666666'>"+orderInfo.getOrderId()+"</font></div></td>");
 					if(orderInfo.getStatus() == 0){
 						out.println("<td><div align='center'><font color='red'>"+status+"</font></div></td>");
 					}
        			else{
        				out.println("<td><div align='center'><font color='#666666'>"+status+"</font></div></td>");
        			}
        			


					
					out.println("<td><div align='center'><font color='#666666'>"+v.datemmddtime(orderInfo.getOrderTime())+"</font></div></td>");
        		
        			out.println("<td><div align='center'><a href='../servlet/OrderInfo?method=showOrderInfo&orderId="+orderInfo.getOrderId()+"'>check detail.</a></div></td>");
      
        			out.println("</tr>");
 					
 				}
 			}
 			out.println("</table>");
			out.println("</td></tr>");
			
			/*out.println("<tr><td height='30' colspan='2'><font color='#0099FF' size='3'><strong>The goods you have comment</strong></font></td></tr>");
			if(goodsEvaluateList.size() == 0){
				out.println("<tr><td height='40' style='padding-left:20px' colspan='2'>No comments.</td></tr>");
			}
			else{
				GoodsInfoDAO gdao = new GoodsInfoDAO();
				for(int i=0;i<goodsEvaluateList.size();i++){
					GoodsEvaluate goodsEvaluateInfo =goodsEvaluateList.get(i);
					int goodsId = goodsEvaluateInfo.getGoodsId();
					GoodsInfo goodsInfo = gdao.getQueryGoodsInfo(goodsId);
					out.println("<tr><td height='40' style='padding-left:20px'>"+goodsEvaluateInfo.getEvaluateTime()+"</td><td>Your &nbsp;&nbsp;<font color='#666666'><strong>"+goodsInfo.getGoodsName()+"</strong></font>&nbsp;&nbsp;comment :"+goodsEvaluateInfo.getGoodsEvaluate()+"</td></tr>");
				}
			}
			out.println("<tr><td colspan='2'><hr color='#FF6699' style='height:1px'/></td></tr>");*/
    	%>
    </table>
  <div id="footer"  style="height:60px; background-color:#e54044;clear:both; ">
  <p style="text-align: center;	padding-top:20px;	color:#FFF"> Shopping center </p>
</div>
  </body>
</html>
