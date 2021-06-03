<%@ page language="java" import="java.util.*,java.text.DecimalFormat" pageEncoding="utf-8"%>
<%@page import="com.entity.BulletinInfo"%>
<%@page import="com.util.PublicToolCheckParam"%>
<%@page import="com.entity.UserInfo"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>System user information management</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <script type="text/javascript" charset="gb2312">
    
    function showAddUserInfoPage(){
	window.location.href = "../servlet/UpdateUserInfo?method=showAddUserInfoPage";
}
function deleteUserInfo(Id){
	if(confirm("You are sure you want to delete the currently selected information?")){
		window.location.href = "../servlet/UpdateUserInfo?method=delete&Id="+Id+"";
	}
}

    </script>
  </head>
  
  <body>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" style="font-size:13px;">
  <tr>
    <td width="100%" height="36"><strong><font size="6" color="#0099FF">□&nbsp;</font><font color="#666666" size="3">System user information management</font></strong></td>
    <td><input type="button" value="Add user" style="height: 26px;width: 70px;padding-top: 2px" onClick="showAddUserInfoPage()"/></td>
 
 </tr>
  <tr>
    <td height="40" colspan="5"><hr  width="100%"/></td>
  </tr>
  <tr>
    <td height="147" colspan="12">
    <%
    		String error = (String)request.getAttribute("error");
    		if(error != null){
    			out.println("<font color='#FF0000' size='2'>"+error+"</font>");
    		}
    	 %>
    <table width="100%" border="1" cellpadding="0" cellspacing="0" style="font-size:13px"  bordercolor="#9999FF"> 
      <tr height="30">
        <td width="55"><div align="center"><font color="#666666">The user id</font></div></td>
        <td ><div align="center"><font color="#666666">The user category</font></div></td>
        <td><div align="center"><font color="#666666">User login name</font></div></td>
        <td ><div align="center"><font color="#666666">Operation</font></div></td>
      </tr>
      <%
      	
      	
      	
      	
      	
      	String isSearching = (String)request.getAttribute("isSearching");
 		ArrayList<UserInfo> userInfoList = (ArrayList<UserInfo>)request.getAttribute("userInfoList");
      	if(userInfoList == null || userInfoList.toString().equals("[]")){
      		out.println("<td colspan='12' height='30'><div align='center'>No information currently available!</div></td>");
      	}
      	else{
      		//DecimalFormat df = new DecimalFormat("0.00");
      		for(int i=0;i<userInfoList.size();i++){
      			UserInfo ui = userInfoList.get(i);
      			String userName = ui.getUserName();
      			
      			
      			
      			String role = "System administrator";
      			if(ui.getRole() == 1){
      				role = "General operator";
      			}
      		
      			out.println("<tr height='30'>");
	      		out.println("<td><div align='center'>"+ui.getId()+"</div></td>");
	      		out.println("<td><div align='center'>"+role+"</div></td>");
	      		out.println("<td><div align='center'>"+userName+"</div></td>");
	      		
	      		
				
	      		out.println("<td><div align='center'>");
				
				%>
                
                 <form action="../servlet/UpdateUserInfo?method=edituserInfo" name="formAdd" method="post">
						  <input type="button" value="delete" onclick='deleteUserInfo(<%=ui.getId()%>)'/>   
						    <input type="hidden" name="username" value="<%=userName%>"/>
						    <input type="hidden" name="userrole" value="<%=ui.getRole()%>"/>
						     <input type="hidden" name="Id" value="<%=ui.getId()%>"/>
						     <input type="submit"  value="modify"/>
						</form>
                <%
				//out.println("<a href='../servlet/UpdateUserInfo?method=edituserInfo&Id="+ui.getId()+"'>modify</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick=deleteUserInfo("+ui.getId()+")>delete</a>");
	      		out.println("</div></td></tr>");
      		}
      	}
       %>
      <tr><td colspan="13" height="50"><div align="center">Total <%=request.getAttribute("sumCount")%> has been found&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;the<%=request.getAttribute("currentPage")%>/<%=request.getAttribute("sumPageCount")%>page&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../servlet/ManageGoodsInfo?method=<%if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){out.println("search&key="+request.getAttribute("key")+"");}else{out.println("showManageGoodsInfoPage");}%>&currentPage=<%=request.getAttribute("indexPage")%>">Home page</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../servlet/ManageGoodsInfo?method=<%if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){out.println("search&key="+request.getAttribute("key")+"");}else{out.println("showManageGoodsInfoPage");}%>&currentPage=<%=request.getAttribute("upPage")%>">The previous page</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../servlet/ManageGoodsInfo?method=<%if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){out.println("search&key="+request.getAttribute("key")+"");}else{out.println("showManageGoodsInfoPage");}%>&currentPage=<%=request.getAttribute("nextPage")%>">The next page</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../servlet/ManageGoodsInfo?method=<%if(PublicToolCheckParam.checkNullAndEmpty(isSearching)){out.println("search&key="+request.getAttribute("key")+"");}else{out.println("showManageGoodsInfoPage");}%>&currentPage=<%=request.getAttribute("lastPage")%>">Back page</a> </div></td></tr>
    </table>
    </td>
  </tr>
</table>
</form>
  </body>
</html>
