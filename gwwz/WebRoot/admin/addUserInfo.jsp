<%@ page language="java" import="java.util.*,com.entity.BulletinInfo" pageEncoding="utf-8"%>
<%@page import="com.entity.GoodsType"%>
<%@page import="com.entity.GoodsTypeDetail"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Add user</title>

 
  </head>
  <body  >
  <form action="../servlet/UpdateUserInfo?method=insert" method="post"  name="form1">
   	<table style="font-size:13px;margin-left: 40px" width="800" height="390">
  <tr>
    <td colspan="2"><strong><font size="6" color="#0099FF">□</font><font color="#666666" size="3">&nbsp;Add user</font></strong></td>
  </tr>
  <tr>
    <td height="15" colspan="2"><hr  width="100%" style="height: 2px;"/></td>
  </tr>
  <tr>
    <td><strong>User login name:</strong></td>
    <td><input id="username" type="text" name="username" style="width:350px; height:25px;padding-top: 2px;"/></td>
  </tr>
  <tr>
    <td><strong>User classification:</strong></td>
    <td>
    	<select name="userrole"  >
    		<option value="0">System administrator</option>
    		<option value="1">System operator</option>            
    	</select>
      
    	
    	
    </td>
  </tr>
  <tr>
    <td colspan="2" style="padding-left:360px"><input type="submit" name="Submit" value="Submit" style="height: 28px;width: 50px;padding-top: 2px"/>&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="reset" value="reset" style="height: 28px;width: 50px;padding-top: 2px"/></td>
  </tr>
</table>
</form>
  </body>
</html>
