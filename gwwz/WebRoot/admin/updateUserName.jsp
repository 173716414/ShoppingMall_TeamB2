<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.entity.BulletinInfo"%>
<%@page import="com.util.PublicToolCheckParam"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Modify user name</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <script type="text/javascript" src="../js/admin/updateUserName.js" charset="gb2312"></script>
  </head>
  
  <body>
  <form method="post" onsubmit="return checkUserName()">
    <table width="280" height="160" border="0" cellpadding="0" cellspacing="0" style="font-size:13px;margin-left: 40px">
  <tr>
    <td width="100%" height="36" colspan="2"><strong><font size="6" color="#0099FF">□&nbsp;</font><font color="#666666" size="3">Modify user name</font></strong></td>
  </tr>
  <tr>
    <td colspan="2"><hr  width="100%"/></td>
  </tr>
  <tr>
    <td><font color="#999999"><strong>username：</strong></font></td>
    <td><input id="userName" type="text" name="userName" style="width: 170px; height: 26px;padding-top: 3px"/></td>
  </tr>
  <tr>
    <td colspan="2" style="padding-left: 90px">
    	<input type="submit" value="confirm" style="width: 50px; height: 26px;padding-top: 3px"/>
  	  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="reset" value="Reset" style="width: 50px; height: 26px;padding-top: 3px"/>
    </td>
  </tr>
</table>
</form>
  </body>
</html>
