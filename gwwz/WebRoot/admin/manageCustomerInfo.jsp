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
    <title>Customer Information Management</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <script type="text/javascript" src="../js/admin/manageCustomerInfo.js" charset="gb2312"></script>
  </head>
  
  <body>
  <form action="../servlet/ManageCustomerInfo?method=coolMore&isCooled" method="post">
    <table width="100%" border="0" cellpadding="0" cellspacing="0" style="font-size:13px;">
  <tr>
    <td width="100%" height="36"><strong><font size="6" color="#0099FF">□&nbsp;</font><font color="#666666" size="3">Customer Information Management</font></strong></td>
    <td height="36"><div align="right"><input type="text" name="key"  id="key"  style="height: 24px;width: 250px;padding-top: 2px;padding-left:20px;background-image: url(../image/icon/key_search.gif);background-repeat: no-repeat"/></div></td>
    <td><input type="button" value="Seletct" style="height: 26px;width: 70px;padding-top: 2px" onclick="return searchCustomerInfo()"/></td>
  </tr>
  <tr>
    <td height="40" colspan="4"><hr  width="100%"/></td>
  </tr>
  <tr>
    <td height="147" colspan="4">
    
		Statistics: &nbsp;&nbsp;&nbsp;Total number of customers:<%=request.getAttribute("sumCount")%>;   &nbsp;&nbsp;&nbsp;Number of the frozen:<%=request.getAttribute("dongjie")%>;  &nbsp;&nbsp;&nbsp;Number of normal state:<%=request.getAttribute("zhengchang")%>
    <table width="100%" border="1" cellpadding="0" cellspacing="0" style="font-size:13px"  bordercolor="#9999FF"> 
      <tr height="30">
        <td><div align="center"><font color="#666666">Customer number</font></div></td>
        <td><div align="center"><font color="#666666">frozen</font></div></td>
        <td><div align="center"><font color="#666666">Customer account/email</font></div></td>
        <td><div align="center"><font color="#666666">Registration time</font></div></td>
        <td><div align="center"><font color="#666666">Name of consignee</font></div></td>
        <td><div align="center"><font color="#666666">Fixed telephone</font></div></td>
        <td><div align="center"><font color="#666666">The mobile phone</font></div></td>
        <td><div align="center"><font color="#666666">Shipping address</font></div></td>
        <td  width="70"><div align="center"><font color="#666666">operation</font></div></td>
      </tr>
      <%
      	String isSearching = (String)request.getAttribute("isSearching");
      	String name = "null";
      	String telephone = "null";
      	String movePhone = "null";
      	String address = "null";
 		ArrayList<CustomerInfo> customerInfoList = (ArrayList<CustomerInfo>)request.getAttribute("customerInfoList");
 		CustomerDetailInfoDAO cddao = new CustomerDetailInfoDAO();
      	if(customerInfoList == null || customerInfoList.toString().equals("[]")){
      		out.println("<td colspan='11' height='30'><div align='center'>No customer information currently available!</div></td>");
      	}
      	else{
      		for(int i=0;i<customerInfoList.size();i++){
      			CustomerInfo ct = customerInfoList.get(i);
      			boolean isExist = cddao.isCustomerDetailInfo(ct.getId());
      			if(isExist == true){
      				CustomerDetailInfo customerDetailInfo = cddao.getCustomerDetailInfo(ct.getId());
      				name = customerDetailInfo.getName();
      				telephone = customerDetailInfo.getTelphone();
      				movePhone = customerDetailInfo.getMovePhone();
      				address = customerDetailInfo.getAddress();
				}
      			out.println("<tr height='30'>");
	      		out.println("<td><div align='center'>"+ct.getId()+"</div></td>");
	      		if(ct.getIsCooled() == 1){
	      			out.println("<td><div align='center'><font color='#FF0000'>Has been frozen</font></div></td>");
	      		}
	      		else{
	      			out.println("<td><div align='center'>Has not been frozen</div></td>");
	      		}
	      		out.println("<td><div align='center'>"+ct.getEmail()+"</div></td>");
				  Validate v = new Validate();


				out.println("<td><div align='center'>"+v.datemmddtime(ct.getRegisterTime())+"</div></td>");
	      		out.println("<td><div align='center'>"+name+"&nbsp;</div></td>");
	      		out.println("<td><div align='center'>"+telephone+"&nbsp;</div></td>");
	      		out.println("<td><div align='center'>"+movePhone+"&nbsp;</div></td>");
	      		out.println("<td><div align='center'>"+address+"&nbsp;</div></td>");
	      		if(PublicToolCheckParam.checkNullAndEmpty(isSearching) && customerInfoList.size() > 1){
	      			if(ct.getIsCooled() == 1){
	      				out.println("<td><div align='center'><a href='#' onclick=coolCustomerInfoOfSearching("+ct.getId()+","+ct.getIsCooled()+","+request.getAttribute("key")+")>Cancel the freeze</a></div></td>");
	      			}
	      			else{
	      				out.println("<td><div align='center'><a href='#' onclick=coolCustomerInfoOfSearching("+ct.getId()+","+ct.getIsCooled()+","+request.getAttribute("key")+")>Freeze customers</a></div></td>");
	      			}
	      		}
	      		else{
	      			if(ct.getIsCooled() == 1){
	      				out.println("<td><div align='center'><a href='#' onclick=coolCustomerInfo("+ct.getId()+","+ct.getIsCooled()+")>Cancel the freeze</a></div></td>");
	      			}
	      			else{
	      				out.println("<td><div align='center'><a href='#' onclick=coolCustomerInfo("+ct.getId()+","+ct.getIsCooled()+")>Freeze customers</a></div></td>");
	      			}
	      			
	      		}
	      		
	      		out.println("</tr>");
      		}
      	}
       %>
      <tr><td colspan="11" height="50"><div align="center">Total <%=request.getAttribute("sumCount")%> has been found&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;the<%=request.getAttribute("currentPage")%>/<%=request.getAttribute("sumPageCount")%>page&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../servlet/ManageCustomerInfo?method=<%if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){out.println("search&key="+request.getAttribute("key")+"");}else{out.println("showManageCustomerInfoPage");}%>&currentPage=<%=request.getAttribute("indexPage")%>">Home page</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../servlet/ManageCustomerInfo?method=<%if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){out.println("search&key="+request.getAttribute("key")+"");}else{out.println("showManageCustomerInfoPage");}%>&currentPage=<%=request.getAttribute("upPage")%>">The previous page</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../servlet/ManageCustomerInfo?method=<%if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){out.println("search&key="+request.getAttribute("key")+"");}else{out.println("showManageCustomerInfoPage");}%>&currentPage=<%=request.getAttribute("nextPage")%>">The next page</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../servlet/ManageCustomerInfo?method=<%if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){out.println("search&key="+request.getAttribute("key")+"");}else{out.println("showManageCustomerInfoPage");}%>&currentPage=<%=request.getAttribute("lastPage")%>">back</a> </div></td></tr>
    </table>
    </td>
  </tr>
</table>
</form>
  </body>
</html>
