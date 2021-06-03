<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.entity.CustomerDetailInfo"%>
<%@page import="com.entity.CustomerInfo"%>
<%@page import="com.entity.OrderGoodsInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.GoodsInfoDAO"%>
<%@page import="com.entity.GoodsInfo"%>
<%@page import="com.dao.GoodsTypeDAO"%>
<%@page import="com.entity.GoodsType"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.entity.OrderDetailInfo"%>
<%@page import="com.entity.OrderInfo"%>
<%@page import="com.util.Validate"%>
<%
	String thirdId = (String)request.getAttribute("thirdId");
 %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	ArrayList<OrderGoodsInfo> orderGoodsInfoList = (ArrayList<OrderGoodsInfo>)request.getAttribute("orderGoodsInfoList");
	ArrayList<OrderDetailInfo> orderWuliuInfoList = (ArrayList<OrderDetailInfo>)request.getAttribute("orderWuliuInfoList");
	CustomerDetailInfo customerDetailInfo = (CustomerDetailInfo)request.getAttribute("customerDetailInfo");
	CustomerInfo customerInfo = (CustomerInfo)request.getAttribute("customerInfo");
	OrderInfo orderInfo =  (OrderInfo)request.getAttribute("orderInfo");
 %>
<html>
  <head>
    <title>Order details</title>
    <script type="text/javascript" src="../js/third/manageOrder.js" charset="utf-8"></script>
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
    <td><strong>Order number：</strong></td>
    <td width="200" align="left"><%=orderInfo.getOrderId()%></td>
    <td><strong>Order state：</strong></td>
    <td width="200" align="left"><%if(orderInfo.getStatus() == 0){out.println("Confirmed");}else{out.println("Unconfirmed");}%></td>
    <td><strong>Order time：</strong></td>
     <%Validate v = new Validate();%>


    
    <td width="200" align="left"><%=v.datemmddtime(orderInfo.getOrderTime())%></td>
  </tr>
  <tr height="40px">
    <td><strong>Customer number：</strong></td>
    <td><%=orderInfo.getCustomerId()%></td>
    <td><strong>Customer account number/number：</strong></td>
    <td><%=customerInfo.getEmail()%></td>
    <td><strong>Registration time：</strong></td>
    <td>
	  <%%>


	
	<%=v.datemmddtime(customerInfo.getRegisterTime())%></td>
  </tr>
  <tr height="40px">
    <td><strong>Consignee name：</strong></td>
    <td><%=customerDetailInfo.getName()%></td>
    <td><strong>Fixed telephone：</strong></td>
    <td><%if(customerDetailInfo.getTelphone() == null){out.println("无");}else{out.println(""+customerDetailInfo.getTelphone()+"");}%></td>
    <td width="90"><strong>Mobile phone：</strong></td>
    <td><%if(customerDetailInfo.getMovePhone() == null){out.println("无");}else{out.println(""+customerDetailInfo.getMovePhone()+"");}%></td>
  </tr>
  <tr height="40px">
    <td><strong>Receiving address：</strong></td>
    <td colspan="5"><%=customerDetailInfo.getAddress()%></td>
   </tr>
   <tr>
    <td colspan="6">
    	<table width="100%" border="1" cellpadding="0" cellspacing="0" style="font-size:13px"  bordercolor="#9999FF"> 
	      <tr height="30">
	        <td><div align="center"><font color="#666666">number</font></div></td>
	          <td><div align="center"><font color="#666666">name</font></div></td>
	        <td><div align="center"><font color="#666666">price</font></div></td>
	        <td><div align="center"><font color="#666666">discount</font></div></td>
	        <td><div align="center"><font color="#666666">order quantity</font></div></td>
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
	      				sum += orderGoodsInfo.getQuantity()*goodsInfo.getDiscount()*goodsInfo.getPrice()/10;
	      				String price = df.format(goodsInfo.getPrice());
	      				String discount = String.format("%.1f",goodsInfo.getDiscount());
	      				if((int)goodsInfo.getDiscount() == 10){
	      					discount = "All";
	      				}
	      				String currentSum = df.format(orderGoodsInfo.getQuantity()*goodsInfo.getDiscount()*goodsInfo.getPrice()/10);
	      				out.println("<tr height='30'>");
	      				out.println("<td><div align='center'><font color='#666666'>"+goodsInfo.getGoodsId()+"</font></div></td>");
	      			 	out.println("<td><div align='center'><font color='#666666'>"+goodsInfo.getGoodsName()+"</font></div></td>");
	      				out.println("<td><div align='center'><font color='#666666'>"+price+"</font></div></td>");
	      				out.println("<td><div align='center'><font color='#666666'>"+discount+"</font></div></td>");
	      				out.println("<td><div align='center'><font color='#666666'>"+orderGoodsInfo.getQuantity()+"</font></div></td>");
	      				out.println("<td><div align='center'><font color='#666666'>"+currentSum+"</font></div></td>");
	      			}
	      		}
	       %>
	       <tr height="40">
	        <td><div align="center"><font color="#666666">Total amount：</font></div></td>
	        <td colspan="6"><font color='#FF6633' size='5'><strong>￥<%=df.format(sum)%></strong></font></td>
	      </tr>
    </table>
    </td>
  </tr>
 
</table>
  <p>&nbsp;</p>
  <table style="font-size:13px;" width="100%" height="168">
    <tr>
      <td width="690" height="43"><strong><font size="6" color="#0099FF">□</font><font color="#666666" size="3">&nbsp;order logistics information</font></strong></td>
    </tr>
    <tr>
      <td height="15"><hr  width="100%" style="height: 2px;"/></td>
    </tr>
    <tr>
      <td height="100"><table width="100%" border="1" cellpadding="0" cellspacing="0" style="font-size:13px; text-align: center;"  bordercolor="#9999FF">
        <tr height="30">
          <td><div align="center"><font color="#666666">Operation date</font></div></td>
          <td><div align="center"><font color="#666666">Logistics information</font></div></td>
          <td><div align="center"><font color="#666666">Operation</font></div></td>
        </tr>
        <% 		

	      		if(orderWuliuInfoList != null){
	      			for(int i=0;i<orderWuliuInfoList.size();i++){
      			OrderDetailInfo wd = orderWuliuInfoList.get(i);
	      				out.println("<tr height='30'>");
	      				out.println("<td><div align='center'><font color='#666666'>"+v.datemmddtime(wd.getaddtime())+"</font></div></td>");
	      				out.println("<td><div><font color='#666666'>"+wd.getremark()+"</font></div></td>");
	      				out.println("<td><div align='center'><a href='#' onclick=deleteWuliu("+wd.getid()+","+wd.getOrderId()+","+session.getAttribute("thirdId")+")>delete</a></div></td>");
	      				out.println("</tr>");
	      			}
	      		}else{
	       %>
        <tr height="40">
          <td colspan="2"><font color='#FF6633' size='5'><strong>No logistics information added</strong></font></td>
        </tr><%}%>
      </table></td>
    </tr>
  </table>
  <p>&nbsp;</p>
  <form action="../servlet/tManageOrder?method=insertwuliu&thirdId=<%=thirdId%>&orderId=<%=orderInfo.getOrderId()%>" method="post"  name="form1">
   	<table width="800" height="390" align="center" style="font-size:13px;margin-left: 40px">
  <tr>
    <td colspan="2"><strong><font size="6" color="#0099FF">□</font><font color="#666666" size="3">&nbsp;Add logistics information</font></strong></td>
  </tr>
  <tr>
    <td height="15" colspan="2"><hr  width="100%" style="height: 2px;"/></td>
  </tr>
  <tr>
    <td><strong>Operation date：</strong></td>
    <td>
    <script type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>
    <input id="addtime" type="text" name="addtime" style="width:150px; height:25px;padding-top: 2px;" readonly class="Wdate"  onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> 
      *</td>
  </tr>
  <tr>
    <td><strong>Logistics information：</strong></td>
    <td><textarea name="remark" style="width:500px; height:150px;"></textarea></td>
  </tr>
  <tr>
    <td colspan="2" style="padding-left:360px"><input type="submit" name="Submit" value="OK" style="height: 28px;width: 50px;padding-top: 2px"/>&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="reset" value="reset" style="height: 28px;width: 50px;padding-top: 2px"/></td>
  </tr>
</table>
</form>
  </body>
</html>
