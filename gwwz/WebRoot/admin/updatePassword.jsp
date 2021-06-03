<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.entity.BulletinInfo"%>
<%@page import="com.util.PublicToolCheckParam"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>change password</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <script type="text/javascript" src="../js/admin/updatePassword.js" charset="gb2312"></script>
  </head>
  
  <body>
  <form action="../servlet/UpdateUserInfo?method=updateUserPwd" method="post" onsubmit="return checkUserPwd()">
    <table width="440" height="260" border="0" cellpadding="0" cellspacing="0" style="font-size:13px;margin-left: 40px">
  <tr>
    <td width="100%" height="36" colspan="3"><strong><font size="6" color="#0099FF">□&nbsp;</font><font color="#666666" size="3">change password</font></strong></td>
  </tr>
  <tr>
    <td colspan="3"><hr  width="100%"/></td>
  </tr>
  <tr>
    <td><font color="#999999"><strong>old&nbsp;&nbsp;password：</strong></font></td>
    <td><input id="oldUserPwd" type="password" name="oldUserPwd" style="width: 170px; height: 26px;padding-top: 3px" onblur="return sendRequest()"/></td>
    <td width="180">&nbsp;&nbsp;<font id="msg" color="#FF0000"></font></td>
  </tr>
  <tr>
    <td><font color="#999999"><strong>new&nbsp;&nbsp;password：</strong></font></td>
    <td colspan="2"><input id="newUserPwd" type="password" name="newUserPwd" style="width: 170px; height: 26px;padding-top: 3px"/></td>
  </tr>
  <tr>
    <td><font color="#999999"><strong>Confirm Password:</strong></font></td>
    <td colspan="2"><input id="confirmNewUserPwd" type="password" name="confirmNewUserPwd" style="width: 170px; height: 26px;padding-top: 3px"/></td>
  </tr>
  <tr>
    <td colspan="3" style="padding-left: 90px">
    	<input type="submit" value="confirm" style="width: 50px; height: 26px;padding-top: 3px"/>
  	  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="submit" value="reset" style="width: 50px; height: 26px;padding-top: 3px"/>
    </td>
  </tr>
</table>
</form>
  </body>
</html>
