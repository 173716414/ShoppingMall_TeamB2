<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.util.PublicToolCheckParam"%>
<%@page import="com.entity.OrderInfo"%>
<%@page import="com.entity.CustomerDetailInfo"%>
<%@page import="com.dao.CustomerDetailInfoDAO"%>
<%@page import="com.dao.CustomerInfoDAO"%>
<%@page import="com.entity.CustomerInfo"%>
<%@page import="com.util.Validate"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Order information management</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <script type="text/javascript" src="../js/admin/manageOrder.js" charset="gb2312"></script>
  </head>
  
  <body>
  <form action="../servlet/ManageOrder?method=deleteMore" method="post">
    <table width="100%" border="0" cellpadding="0" cellspacing="0" style="font-size:13px;">
  <tr>
    <td width="100%" height="36"><strong><font size="6" color="#0099FF">□&nbsp;</font><font color="#666666" size="3">Order information management</font></strong></td>
    <td height="36"><div align="right"><input id="key" type="text" name="key" style="height: 24px;width: 250px;padding-top: 2px;padding-left:20px;background-image: url(../image/icon/key_search.gif);background-repeat: no-repeat"/></div></td>
    <td><input type="button" value="Query" style="height: 26px;width: 70px;padding-top: 2px" onClick="return searchOrder()"/></td>
    <!-- <td><input type="submit" value="delete order" style="height: 26px;width: 70px;padding-top: 2px" onClick="return deletMoreOrder()"/></td>-->
  </tr>
  <tr>
    <td height="40" colspan="4"><hr  width="100%"/></td>
  </tr>
  <tr>
    <td height="147" colspan="4">
    
    
		Statistics: &nbsp;&nbsp;&nbsp;The total number of orders:<%=request.getAttribute("sumCount")%>;  &nbsp;&nbsp;&nbsp;Goods has been confirmed:<%=request.getAttribute("queren")%>;  &nbsp;&nbsp;&nbsp;Not confirmed:<%=request.getAttribute("wqueren")%>;&nbsp;&nbsp;&nbsp;Returns:<%=request.getAttribute("tuihuo")%>

    <table width="100%" border="1" cellpadding="0" cellspacing="0" style="font-size:13px"  bordercolor="#9999FF"> 
      <tr height="30">
         <!--<td width="50"><div align="center"><font color="#666666">全选</font></div></td>
        <td width="40"><div align="center"><input type="checkbox" id="checkAll" value="checkbox" onClick="selectAll()"/></div></td>-->
        <td><div align="center"><font color="#666666">The order no.</font></div></td>
        <td><div align="center"><font color="#666666">The order status</font></div></td>
        <td><div align="center"><font color="#666666">Order time</font></div></td>
        <td><div align="center"><font color="#666666">Customer account/email</font></div></td>
        <td><div align="center"><font color="#666666">The consignee</font></div></td>
        <td><div align="center"><font color="#666666">Fixed telephone</font></div></td>
        <td><div align="center"><font color="#666666">The mobile phone</font></div></td>
        <td><div align="center"><font color="#666666">Operation</font></div></td>
      </tr>
      <%
      	String isSearching = (String)request.getAttribute("isSearching");
 		ArrayList<OrderInfo> orderInfoList = (ArrayList<OrderInfo>)request.getAttribute("orderInfoList");
 		CustomerDetailInfoDAO cddao = new CustomerDetailInfoDAO();
 		CustomerInfoDAO cdao = new CustomerInfoDAO();
      	if(orderInfoList == null || orderInfoList.toString().equals("[]")){
      		out.println("<td colspan='10' height='30'><div align='center'>No order information currently available!</div></td>");
      	}
      	else{
      		for(int i=0;i<orderInfoList.size();i++){
      			OrderInfo od = orderInfoList.get(i);
      			CustomerDetailInfo customerDetailInfo = cddao.getCustomerDetailInfo(od.getCustomerId());
      			CustomerInfo customerInfo = cdao.getCustomerInfo(customerDetailInfo.getCustomerId());
      			out.println("<tr height='30'>");
	      		//out.println("<td><div align='center'>Check</div></td>");
	      		//out.println("<td><div align='center'><input id='ckb' type='checkbox' name='ckb' value='"+od.getOrderId()+"' /></div></td>");
	      		out.println("<td><div align='center'>"+od.getOrderId()+"</div></td>");
	      		if(od.getStatus() == 0){
	      			out.println("<td><div align='center'><font color='#FF0000'>Unconfirmed</font></div></td>");
	      		}
	      		else if(od.getStatus() == 1){
	      			out.println("<td><div align='center'>Confirmed</div></td>");
	      		}
	      		else if(od.getStatus() == 100){
	      			out.println("<td><div align='center'>Confirm reception</div></td>");
	      		}
	      		else if(od.getStatus() == 101){
	      			out.println("<td><div align='center'>Return goods</div></td>");
	      		}
				  Validate v = new Validate();


	      		out.println("<td><div align='center'>"+v.datemmddtime(od.getOrderTime())+"</div></td>");
	      		out.println("<td><div align='center'>"+customerInfo.getEmail()+"</div></td>");
	      		out.println("<td><div align='center'>"+customerDetailInfo.getName()+"</div></td>");
	      		out.println("<td><div align='center'>"+customerDetailInfo.getTelphone()+"</div></td>");
	      		out.println("<td><div align='center'>"+customerDetailInfo.getMovePhone()+"</div></td>");
	      		if(PublicToolCheckParam.checkNullAndEmpty(isSearching) && orderInfoList.size() > 1){
	      			if(od.getStatus() == 0){
	      				out.println("<td><div align='center'><a href='#' onclick=confirmOrderOfSearching("+od.getOrderId()+","+od.getStatus()+","+request.getAttribute("key")+")>Confirm_order</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='../servlet/ManageOrder?method=showDetail&orderId="+od.getOrderId()+"'>Details</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick=deleteOrderOfSearching("+od.getOrderId()+","+request.getAttribute("key")+")>Delete</a></div></td>");
	      			}
	      			else if(od.getStatus() == 1){
	      				out.println("<td><div align='center'><a href='#' onclick=confirmOrderOfSearching("+od.getOrderId()+","+od.getStatus()+","+request.getAttribute("key")+")>Cancel_confirmation</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='../servlet/ManageOrder?method=showDetail&orderId="+od.getOrderId()+"'>Details</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick=deleteOrderOfSearching("+od.getOrderId()+","+request.getAttribute("key")+")>Delete</a></div></td>");
	      			}
	      			else if(od.getStatus() == 100){
	      				out.println("<td><div align='center'>Confirm_goods&nbsp;&nbsp;&nbsp;&nbsp;<a href='../servlet/ManageOrder?method=showDetail&orderId="+od.getOrderId()+"'>etails</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick=deleteOrderOfSearching("+od.getOrderId()+","+request.getAttribute("key")+")>Delete</a></div></td>");
	      			}
	      			else if(od.getStatus() == 101){
	      				out.println("<td><div align='center'>Refund&nbsp;&nbsp;&nbsp;&nbsp;<a href='../servlet/ManageOrder?method=showDetail&orderId="+od.getOrderId()+"'>Details</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick=deleteOrderOfSearching("+od.getOrderId()+","+request.getAttribute("key")+")>Delete</a></div></td>");
	      			}
	      			
	      		}
	      		else{
		      		if(od.getStatus() == 0){
		      			out.println("<td><div align='center'><a href='#' onclick=confirmOrder("+od.getOrderId()+","+od.getStatus()+")>Confirm_order</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='../servlet/ManageOrder?method=showDetail&orderId="+od.getOrderId()+"'>Details</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick=deleteOrder("+od.getOrderId()+")>Delete</a></div></td>");
		      		}
	      			else if(od.getStatus() == 1){
	      				out.println("<td><div align='center'><a href='#' onclick=confirmOrder("+od.getOrderId()+","+od.getStatus()+")>Cancel_confirmation</a>&nbsp;&nbsp;&nbsp;&nbsp;");
						out.println("<a href='../servlet/tManageOrder?method=showaddwuliu&orderId="+od.getOrderId()+"&thirdId="+session.getAttribute("thirdId")+"'>Manage_logistics_information</a>&nbsp;&nbsp;&nbsp;");
						out.print("<a href='../servlet/ManageOrder?method=showDetail&orderId="+od.getOrderId()+"'>Details</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick=deleteOrder("+od.getOrderId()+")>Delete</a></div></td>");
	      			}
	      			else if(od.getStatus() == 100){
	      				out.println("<td><div align='center'>Confirm_goods&nbsp;&nbsp;&nbsp;&nbsp;<a href='../servlet/ManageOrder?method=showDetail&orderId="+od.getOrderId()+"'>Details</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick=deleteOrder("+od.getOrderId()+")>Delete</a></div></td>");
	      			}
	      			else if(od.getStatus() == 101){
	      				out.println("<td><div align='center'>Refund&nbsp;&nbsp;&nbsp;&nbsp;<a href='../servlet/ManageOrder?method=showDetail&orderId="+od.getOrderId()+"'>Details</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick=deleteOrder("+od.getOrderId()+")>Delete</a></div></td>");
	      			}
	      		}
	      		
	      		out.println("</tr>");
      		}
      	}
       %>
      <tr><td colspan="10" height="50"><div align="center">Total <%=request.getAttribute("sumCount")%> has been found&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;the<%=request.getAttribute("currentPage")%>/<%=request.getAttribute("sumPageCount")%>page&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../servlet/ManageOrder?method=<%if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){out.println("search&key="+request.getAttribute("key")+"");}else{out.println("showManageOrderPage");}%>&currentPage=<%=request.getAttribute("indexPage")%>">Home page</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../servlet/ManageOrder?method=<%if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){out.println("search&key="+request.getAttribute("key")+"");}else{out.println("showManageOrderPage");}%>&currentPage=<%=request.getAttribute("upPage")%>">The previous page</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../servlet/ManageOrder?method=<%if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){out.println("search&key="+request.getAttribute("key")+"");}else{out.println("showManageOrderPage");}%>&currentPage=<%=request.getAttribute("nextPage")%>">The next page</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../servlet/ManageOrder?method=<%if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){out.println("search&key="+request.getAttribute("key")+"");}else{out.println("showManageOrderPage");}%>&currentPage=<%=request.getAttribute("lastPage")%>">Back page</a> </div></td></tr>
    </table>
    </td>
  </tr>
</table>
</form>
  </body>
</html>
