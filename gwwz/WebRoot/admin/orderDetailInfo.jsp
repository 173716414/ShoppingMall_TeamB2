<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="com.entity.CustomerDetailInfo"%>
<%@page import="com.entity.CustomerInfo"%>
<%@page import="com.entity.OrderInfo"%>
<%@page import="com.entity.OrderGoodsInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.GoodsInfoDAO"%>
<%@page import="com.entity.GoodsInfo"%>
<%@page import="com.dao.GoodsTypeDAO"%>
<%@page import="com.entity.GoodsType"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.util.Validate"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	ArrayList<OrderGoodsInfo> orderGoodsInfoList = (ArrayList<OrderGoodsInfo>)request.getAttribute("orderGoodsInfoList");
	CustomerDetailInfo customerDetailInfo = (CustomerDetailInfo)request.getAttribute("customerDetailInfo");
	CustomerInfo customerInfo = (CustomerInfo)request.getAttribute("customerInfo");
	OrderInfo orderInfo =  (OrderInfo)request.getAttribute("orderInfo");
 %>
<html>
  <head>
    <title>Order details</title>
    <script type="text/javascript" src="../js/admin/manageOrder.js" charset="gb2312"></script>
  </head>
  <body>
   	<table style="font-size:13px;" width="100%" height="390">
  <tr>
    <td colspan="6"><strong><font size="6" color="#0099FF">□</font><font color="#666666" size="3">&nbsp;Order details</font></strong></td>
  </tr>
  <tr>
    <td height="15" colspan="6"><hr  width="100%" style="height: 2px;"/></td>
  </tr>
  <tr height="40px">
    <td><strong>Order number :</strong></td>
    <td width="200" align="left"><%=orderInfo.getOrderId()%></td>
    <td><strong>Order Status:</strong></td>
    <td width="200" align="left"><%if(orderInfo.getStatus() == 0){out.println("Confirmed");}else{out.println("Unconfirmed");}%></td>
    <td><strong>Ordering time:</strong></td>
     <%Validate v = new Validate();%>


    
    <td width="200" align="left"><%=v.datemmddtime(orderInfo.getOrderTime())%></td>
  </tr>
  <tr height="40px">
    <td><strong>Customer number :</strong></td>
    <td><%=orderInfo.getCustomerId()%></td>
    <td><strong>Customer Account/No. :</strong></td>
    <td><%=customerInfo.getEmail()%></td>
    <td><strong>Registration time:</strong></td>
    <td>
	  <%%>


	
	<%=v.datemmddtime(customerInfo.getRegisterTime())%></td>
  </tr>
  <tr height="40px">
    <td><strong>Name of Consignee:</strong></td>
    <td><%=customerDetailInfo.getName()%></td>
    <td><strong>Landline telephone:</strong></td>
    <td><%if(customerDetailInfo.getTelphone() == null){out.println("null");}else{out.println(""+customerDetailInfo.getTelphone()+"");}%></td>
    <td width="90"><strong>Mobile phone:</strong></td>
    <td><%if(customerDetailInfo.getMovePhone() == null){out.println("null");}else{out.println(""+customerDetailInfo.getMovePhone()+"");}%></td>
  </tr>
  <tr height="40px">
    <td><strong>Receiving address:</strong></td>
    <td colspan="5"><%=customerDetailInfo.getAddress()%></td>
   </tr>
   <tr>
    <td colspan="6">
    	<table width="100%" border="1" cellpadding="0" cellspacing="0" style="font-size:13px"  bordercolor="#9999FF"> 
	      <tr height="30">
	        <td><div align="center"><font color="#666666">Product id</font></div></td>
	        
	        <td><div align="center"><font color="#666666">Commodity name</font></div></td>
	        <td><div align="center"><font color="#666666">Commodity price</font></div></td>
	        <td><div align="center"><font color="#666666">Commodity discount</font></div></td>
	        <td><div align="center"><font color="#666666">The quantity ordered</font></div></td>
	        <td><div align="center"><font color="#666666">subtotal</font></div></td>
	      </tr>
	      <%
	      		double sum = 0;
	      		DecimalFormat df = new DecimalFormat("0.00");
	      		if(orderGoodsInfoList != null){
	      			for(int i=0;i<orderGoodsInfoList.size();i++){
	      				OrderGoodsInfo orderGoodsInfo = orderGoodsInfoList.get(i);
	      				GoodsInfoDAO gdao = new GoodsInfoDAO();
	      				GoodsInfo goodsInfo = gdao.getQueryGoodsInfo(orderGoodsInfo.getGoodsId());
	      				sum += orderGoodsInfo.getQuantity()*0.1*goodsInfo.getDiscount()*goodsInfo.getPrice();
	      				String price = df.format(goodsInfo.getPrice());
	      				String discount = String.format("%.1f",goodsInfo.getDiscount());
	      				if((int)goodsInfo.getDiscount() == 10){
	      					discount = "All";
	      				}
	      				String currentSum = df.format(orderGoodsInfo.getQuantity()*0.1*goodsInfo.getDiscount()*goodsInfo.getPrice());
	      				out.println("<tr height='30'>");
	      				out.println("<td><div align='center'><font color='#666666'>"+goodsInfo.getGoodsId()+"</font></div></td>");
	      				
	      				out.println("<td><div align='center'><font color='#666666'>"+goodsInfo.getGoodsName()+"</font></div></td>");
	      				out.println("<td><div align='center'><font color='#666666'>"+price+"</font></div></td>");
	      				out.println("<td><div align='center'><font color='#666666'>"+discount+"discount</font></div></td>");
	      				out.println("<td><div align='center'><font color='#666666'>"+orderGoodsInfo.getQuantity()+"</font></div></td>");
	      				out.println("<td><div align='center'><font color='#666666'>"+currentSum+"</font></div></td>");
	      			}
	      		}
	       %>
	       <tr height="40">
	        <td><div align="center"><font color="#666666">Total amount:</font></div></td>
	        <td colspan="6"><font color='#FF6633' size='5'><strong>￥<%=df.format(sum)%></strong></font></td>
	      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td colspan="6"><div align="left"><input type="button" value="return" onclick="back()" style="width: 50px; height: 26px;padding-top: 3px"/></div></td>
  </tr>
</table>
  </body>
</html>
