<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="com.dao.CustomerDetailInfoDAO"%>
<%@page import="com.dao.CustomerInfoDAO"%>
<%@page import="com.entity.CustomerDetailInfo"%>
<%@page import="com.entity.CustomerInfo"%>
<%
	String email = (String)session.getAttribute("email");
	String thirdemail = (String)session.getAttribute("thirdemail");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>Fill in delivery information</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    	<script type="text/javascript" src="../js/web/sendInfo.js" charset="gb2312"></script>
  </head>
  
  <body>
  <iframe src="../web/top.jsp" width="100%" height="170" frameborder="0"></iframe>
  <table border="0" cellspacing="0" cellpadding="0" width='960px' align="center">
  <tr height="60">
    <td><font size="2" color="#999999">Where are you now：<a href="../">Homepage</a>&gt; <a href="cart.jsp">Shopping cart</a>&gt; Fill in delivery information</font></td>
  </tr>
</table>
<form action="../servlet/OrderInfo?method=showConfirmSendInfo" method="post" onsubmit="return checkSendInfo()">
    <table id="detail" height="300" border="0" cellpadding="0" cellspacing="0"  width='960px' align="center">
    <tr>
    <td height="40" colspan="3"><img src="../image/icon/peisong_logo.gif" width="24" height="24" /><font color="0099FF" size="3"><strong>Fill in delivery information</strong></font></td>
  </tr>
  <tr>
    <td colspan="3" height="20"><hr color="#99CCFF" style="height:1px"/></td>
  </tr>
  
		<%
		 		
		 		String name = "";
      				String telephone = "";
      				String movePhone = "";
      				String address = "";
		 		CustomerDetailInfoDAO cddao = new CustomerDetailInfoDAO();
 		CustomerInfoDAO cdao = new CustomerInfoDAO();
		      CustomerInfo customerInfo = cdao.getCustomerInfo(email);
                int customerId = customerInfo.getId();
                boolean isExist = cddao.isCustomerDetailInfo(customerId);
      			if(isExist == true){
      				CustomerDetailInfo customerDetailInfo = cddao.getCustomerDetailInfo(customerId);
      				 name = customerDetailInfo.getName();
      				 telephone = customerDetailInfo.getTelphone();
      				 movePhone = customerDetailInfo.getMovePhone();
      				 address = customerDetailInfo.getAddress();
				}
  %>
  <tr>
    <td width="80"><font color="#666666" size="2">Consignee Name：</font></td>
    <td width="320"><input id="name" type="text" name="name" style="width:170px;height:19px;padding-top: 3px" value="<%=name%>"/></td>
    <td width="247" colspan="2"><font color="#666666" size="2">Please fill in your real name</font></td>
  </tr>
  <tr>
    <td><font color="#666666" size="2">Fixed phone：</font></td>
    <td><input id="telephone" type="text" name="telephone" style="width:170px;height:19px;padding-top: 3pxx" value="<%=telephone%>"/></td>
    <td colspan="2"><font color="#666666" size="2"></font></td>
  </tr>
  <tr>
    <td><font color="#666666" size="2">Mobile phone：</font></td>
    <td><input id="movePhone" type="text" name="movePhone" style="width:170px;height:19px;padding-top: 3px" value="<%=movePhone%>"/></td>
    <td colspan="2"><font color="#666666" size="2">Please fill in at least one item for fixed telephone and mobile telephone
    </font></td>
  </tr>
  <tr>
    <td><font color="#666666" size="2">Receiving address：</font></td>
    <td><input id="address" type="text" name="address" style="width:300px;height:19px;padding-top: 3px" value="<%=address%>"/></td>
    <td colspan="2"><font color="#666666" size="2">Please fil in correctly.</font></td>
  </tr>
  <tr height="80">
    <td colspan="3" style="padding-left: 110px">
      <input type="submit" value="Submit" style="height: 32px;width:60px; padding-top: 3px"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="reset" value="Reset" style="height: 32px;width:60px; padding-top: 3px"/>
   </td>
  </tr>
  </table>
  </form>
  <div id="footer"  style="height:60px; background-color:#e54044;clear:both; ">
  <p style="text-align: center;	padding-top:20px;	color:#FFF"> Shopping website </p>
</div>
  </body>
</html>
