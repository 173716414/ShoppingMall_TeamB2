<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>









<html>
<head>
<title> System Control</title>
     <script type="text/javascript" src="js/admin/admin.js" charset="gb2312"></script>
<style type="text/css">
<!--
*{overflow:hidden; font-size:9pt;}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-repeat: repeat-x;
	background-image: url(images/bg.jpg);
	background-color: #1d3e47;
}

-->
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
 
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="1000" height="564" border="0" align="center" cellpadding="0" cellspacing="0" background="images/login.jpg" id="__01">
  <tr>
    <td height="193" colspan="3"><div align="center" style="color: #CCFFCC;font-size: 26pt;font-weight: bold;">Shopping Mall</div></td>
  </tr>
  <tr>
    <td width="352" rowspan="2" valign="top">&nbsp;</td>
    <td width="211" height="152"><table width="195" border="0" align="right" cellpadding="0" cellspacing="0">
			<form action="servlet/CheckAdminLogin?method=login" method="post" onsubmit="return checkLogin()">
        <tr>
          <td width="47" height="30">User:</td>
          <td height="30" colspan="2"><input name="userName" type="text" id="userName" style="width:100px; height:16px; border:solid 1px #000000; color:#666666"></td>
        </tr>
        <tr>
          <td height="30">Password:</td>
          <td height="30" colspan="2"><input name="pwd" type="password" id="pwd" style="width:100px; height:16px; border:solid 1px #000000; color:#666666"></td>
        </tr>
        
        
        <tr>
          <td height="30" colspan="3">
          
   <input type="submit" name="Submit" value="Login" onClick="return checkLogin();" style="background:url(images/button.gif) no-repeat;color:#ffffff;width:80px;height: 24px; border:0px;line-height:10px; font-size:12px;margin-right: 5px; cursor:pointer">
           
               
               
               </td>
        </tr>
      </form>
    </table></td>
    <td width="437" rowspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
</body>
</html>





