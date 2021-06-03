<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.entity.BulletinInfo"%>
<%@page import="com.util.PublicToolCheckParam"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><%if(request.getAttribute("msg") != null){out.println(""+request.getAttribute("msg")+"");}else{out.println(""+session.getAttribute("msg")+"");}%></title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <script type="text/javascript" src="../js/admin/showBulletinInfo.js" charset="utf-8"></script>
  </head>
  
  <body>
    <table width="90%" height="80" border="0" cellpadding="0" cellspacing="0" style="font-size:13px;margin-left: 40px">
  <tr>
    <td width="100%" height="36" colspan="2"><strong><font size="6" color="#0099FF">□&nbsp;</font><font color="#666666" size="3"><%if(request.getAttribute("msg") != null){out.println(""+request.getAttribute("msg")+"");}else{out.println(""+session.getAttribute("msg")+"");}%></font></strong></td>
  </tr>
  <tr>
    <td colspan="2"><hr  width="100%"/></td>
  </tr>
  </table>
  <table align="center">
  <tr>
   	<td align="right"><img src="../image/icon/ok.png" width="70" height="70"/></td>
   	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size="+3" color="#99CC00"><strong><%if(request.getAttribute("msg") != null){out.println(""+request.getAttribute("msg")+"");}else{out.println(""+session.getAttribute("msg")+"");}%></strong></font></td>
  </tr>
  <tr>
    <td colspan="2" style="padding-left: 170px"><a href="#" onclick="history.go(-1)">return</a></td>
  </tr>
</table>
  </body>
</html>
