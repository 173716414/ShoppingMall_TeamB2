<%@ page language="java" import="java.util.*,java.text.DecimalFormat" pageEncoding="utf-8"%>
<%@page import="com.util.PublicToolCheckParam"%>
<%@page import="com.entity.OrderGoodsInfo"%>
<%@page import="com.dao.GoodsInfoDAO"%>
<%@page import="com.entity.GoodsInfo"%>
<%@page import="com.entity.OrderDetailInfo"%>
<%@page import="com.entity.ServiceAssessment"%>
<%@page import="com.util.Validate"%>
<%
	String orderId = (String)request.getAttribute("orderId");
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>Order information</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <script type="text/javascript" src="../js/web/cart.js" charset="gb2312"></script>
     <script type="text/javascript" src="../js/web/orderinfo.js" charset="gb2312"></script>
 </head>
  
  <body>
  <iframe src="../web/top.jsp" width="100%" height="170" frameborder="0"></iframe>
  <table border="0" cellspacing="0" cellpadding="0"  width='960px' align="center">
  <tr height="60">
    <td><font size="2" color="#999999">Where are you now：<a href="../" target="_top">Homepage</a>&gt; <a href="../servlet/DoMethod?method=showMyInformation" target="_top">My information</a>&gt; View order information</font></td>
  </tr>
</table>
    <table  width='960px' align="center" border="1" cellpadding="0" cellspacing="0" bordercolor="#9999FF" style="font-size:13px;">
  <tr bgcolor="#CCFFFF">
    <td height="25" colspan="2"><div align="center">Goods name</div></td>
    
    <td width="101"><div align="center">price</div></td>
    <td width="80"><div align="center">discount</div></td>
    <td width="122"><div align="center">quantity</div></td>
    <td width="143"><div align="center">subtotal</div></td>
  </tr>
   <%
   		ArrayList<OrderGoodsInfo> orderList =(ArrayList<OrderGoodsInfo>) request.getAttribute("orderList");
   		DecimalFormat df = new DecimalFormat("0.00");
   		GoodsInfoDAO gdao = new GoodsInfoDAO();
   		double sumFee = 0;
   		for(int i=0;i<orderList.size();i++){
   			OrderGoodsInfo orderInfo = orderList.get(i);
   			int goodsId = orderInfo.getGoodsId();
   			GoodsInfo goodsInfo = gdao.getQueryGoodsInfo(goodsId);
   			String price = df.format(goodsInfo.getPrice());
   			sumFee += goodsInfo.getDiscountPrice()*orderInfo.getQuantity();
   			String sum = df.format(goodsInfo.getDiscountPrice()*orderInfo.getQuantity());
   			String discout = String.format("%.1f",goodsInfo.getDiscount());
   			if((int)goodsInfo.getDiscount() == 10){
   				discout = "All";
   			}
   			out.println("<tr>");
   			if(PublicToolCheckParam.checkNullAndEmpty(goodsInfo.getPhoto())){
   				out.println("<td style='border-right:none'><img src='../"+goodsInfo.getPhoto()+"' width='50' height='50'/></td>");
   			}
   			else{
   				out.println("<td style='border-right:none' width='50' height='50'/><div align='center'><font color='#FF6699'>Not yet</font></div></td>");
   			}
   			out.println("<td width='400' style='border-left:none'>"+goodsInfo.getGoodsName()+"</td>");
   			
   			out.println("<td><div align='center'>"+price+"</div></td>");
   			out.println("<td><div align='center'>"+discout+"</div></td>");
   			out.println("<td><div align='center'>"+orderInfo.getQuantity()+"</div></td>");
   			out.println("<td><div align='center'>"+sum+"</div></td>");
     		out.println("</tr>");        
   		}
       %>     
</table>
<table height="82" style="font-size:13px; "  width='960px' align="center">
	<tr>
		<%
			String str_sum = df.format(sumFee);
			out.println("<td>Total amount of goods：<font color='#FF6633' size='5'><strong>￥"+str_sum+"</strong></font></td>");
		 %>
	</tr>
	
    <tr><td>
    
    
     <p>&nbsp;</p>
  <table style="font-size:13px;" width="100%" height="168">
    <tr>
      <td width="690" height="43"><strong><font size="6" color="#0099FF">□</font><font color="#666666" size="3">&nbsp;Order logistics information
	</font></strong></td>
    </tr>
    <tr>
      <td height="15"><hr  width="100%" style="height: 2px;"/></td>
    </tr>
    <tr>
      <td height="100"><table width="100%" border="1" cellpadding="0" cellspacing="0" style="font-size:13px; text-align: center;"  bordercolor="#9999FF">
        <% 		
Validate v = new Validate();
	ArrayList<OrderDetailInfo> orderWuliuInfoList = (ArrayList<OrderDetailInfo>)request.getAttribute("orderWuliuInfoList");

	      		if(orderWuliuInfoList != null){
					%>
					
        <tr height="30">
          <td><div align="center"><font color="#666666">Operation date</font></div></td>
          <td><div align="center"><font color="#666666">Logistics information
		</font></div></td>
        </tr>
					<%
	      			for(int i=0;i<orderWuliuInfoList.size();i++){
      			OrderDetailInfo wd = orderWuliuInfoList.get(i);
	      				out.println("<tr height='30'>");
	      				out.println("<td><div align='center'><font color='#666666'>"+v.datemmdd(wd.getaddtime())+"</font></div></td>");
	      				out.println("<td><div><font color='#666666'>"+wd.getremark()+"</font></div></td>");
	      				out.println("</tr>");
	      			}
	      		}else{
	       %>
        <tr height="40">
          <td colspan="2"><font color='#FF6633' size='5'><strong>No logistics information added
		</strong></font></td>
        </tr><%}%>
      </table></td>
    </tr>
  </table>
    
    
    
    
    </td></tr>
    
    <%
	    		ArrayList<ServiceAssessment> serviceAssessmentList = (ArrayList<ServiceAssessment>)request.getAttribute("serviceAssessmentList");

	out.println("<tr><td height='40' style='padding-left:20px'><font color='#666666'><strong>Historical service evaluation record
		：</strong></font></td></tr>");
			if(serviceAssessmentList.size() == 0){
				out.println("<tr><td style='padding-left:40px' colspan='2'><div id='serviceAssessmentTable'>You haven't made any service evaluation yet
					!</div></td></tr>");
			}
			else{
				out.print("<tr><td style='padding-left:40px' colspan='2'><div id='serviceAssessmentTable'>");
			
				for(int i=0;i< serviceAssessmentList.size();i++){
					ServiceAssessment assessmentInfo = serviceAssessmentList.get(i);
					out.print(""+v.datemmdd(assessmentInfo.getAssessmentTime())+"&nbsp;&nbsp;&nbsp;&nbsp;You said：&nbsp;&nbsp;"+assessmentInfo.getServiceAssessment()+"<br/><br/>");
				}
				out.println("</div></td></tr>");
			}
			out.println("<tr><td height='40' style='padding-left:20px' colspan='2'><font color='#666666'><strong>Service evaluation：</strong></font></td></tr>");
			out.println("<tr><td style='padding-left:40px' colspan='2'><textarea id='serviceAssessment' name='serviceAssessment' style='width:500px;height:100px'></textarea></td></tr>");
			out.println("<tr><td style='padding-left:40px' colspan='2'><input type='button' value='Submit evaluation' style='height: 30px;padding-top: 3px' onclick='return sendRequest("+orderId+")'/></td></tr>");
			out.println("<tr><td colspan='2'><hr color='#FF6699' style='height:1px'/></td></tr");
    %>
    
    
    <tr><td><input type="button" value="Come&nbsp;&nbsp;&nbsp;back" style="height:30px;padding-top: 1px;width: 80px" onclick="history.go(-1)"/></td></tr>
</table>
<br />


  <div id="footer"  style="height:60px; background-color:#e54044;clear:both; ">
  <p style="text-align: center;	padding-top:20px;	color:#FFF"> Shopping website </p>
</div>
  </body>
</html>
