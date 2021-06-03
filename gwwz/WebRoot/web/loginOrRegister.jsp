<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="com.util.CheckCode"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Login/Register</title>
<style type="text/css">
<!--
#Layer1 {
	position: relative;
	left: 800px;
	top: -210px;
	z-index: 1;
}
#Layer2 {
	position: relative;
	top: -190px;
	z-index: 2;
}
-->
</style>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../js/web/loginOrRegister.js" charset="gb2312"></script>
</head>
<body>
<%
	String yzm=CheckCode.getCheckCode();
%>
<iframe src="../web/top.jsp" width="100%" height="170" frameborder="0"></iframe>
<table border="0" cellspacing="0" cellpadding="0" width="960PX"  align="center">
  <tr height="60">
    <td align="left"><font size="2" color="#999999">Your present location：<a href="../">Homepage</a>&gt; Register/Login</font></td>
  </tr>
</table>
<table  border="0" cellspacing="0" cellpadding="0" width="960PX"  align="center">
  <tr>
    <td valign="top"><form action="../servlet/DoMethod?method=checkLogin" method="post" onsubmit="return checkLogin()">
        <table width="427" height="171" border="0" cellpadding="0" cellspacing="0"   align="center">
          <tr>
            <td height="81" colspan="2"><img src="../image/icon/login_logo.gif" width="230" height="47" /></td>
          </tr>
          <tr>
            <td   height="45"><font color="#666666" size="2" >User's e-mail：</font></td>
            <td  ><input id="email" name="email" style="width:200px; height:19px;padding-top: 3px"/></td>
          </tr>
          <tr>
            <td height="45"><font color="#666666" size="2">Userpassword：</font></td>
            <td><input id="pwd" type="password" name="pwd" style="width:200px;height:19px;padding-top: 3px"/></td>
          </tr>
          <tr>
            <td height="45"><font color="#666666" size="2">Verification Code

：</font></td>
            <td><input type="hidden" name="yzm"   id="yzm"   value="<%=yzm %>" >
              <INPUT class=input_new id=checkcode size=5 maxlength="4" name=checkcode onKeyUp="this.value=this.value.replace(/\D/gi,'')"  style="width:100px;height:19px;padding-top: 3px">
              <%=yzm %></td>
          </tr>
          <tr>
            <td height="40" colspan="2"><%
    		String error = (String)request.getAttribute("error");
    		if(error != null){
    			out.println("<font color='#FF0000' size='2'>"+error+"</font>");
    		}
    	 %></td>
          </tr>
          <tr>
            <td height="40" colspan="2" align="center"><a href="lost.jsp"><span style="padding-top: 10px">
              <input type="image" src="../image/icon/btn_login.gif" style="cursor: pointer;"/>
              </span> Find password</a></td>
          </tr>
        </table>
    </form></td>
    <td><form action="../servlet/DoMethod?method=register" method="post" onsubmit="return checkRegister()">
        <table width="590" height="251" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="75" colspan="4"><img src="../image/icon/register_logo.gif" width="230" height="47"/>Register</td>
          </tr>
          <tr>
            <td width="124" height="45"><font color="#666666" size="2">Account/E-mail：</font></td>
            <td width="304"><input id="regEmail" type="text" name="regEmail" style="width:200px; height:19px;padding-top: 3pxx" value="<%String regEmail = (String)request.getAttribute("regEmail");if(regEmail != null){out.println(regEmail);}%>" onblur="return sendRequest()"/>
            
            <input type="button" value="Check e-mail" style="height: 30px;cursor:pointer" onclick="return sendRequest()"/>
            &nbsp;&nbsp;&nbsp;<font id="msg" size="2" color="#FF0000"></font>
            </td>
           </tr>
          <tr>
            <td height="45"><font color="#666666" size="2">Pass&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;word：</font></td>
            <td><input id="regPwd" type="password" name="regPwd" style="width:200px;height:19px;padding-top: 3px"/></td>
          </tr>
          <tr>
            <td height="43"><font color="#666666" size="2">Confirm password：</font></td>
            <td><input id="regConPwd" type="password" name="regConPwd" style="width:200px;height:19px;padding-top: 3px"/></td>
          </tr>
          <TR class=black >
            <td height="45"><font color="#666666" size="2">Security question：</font></td>
            <TD width="304"  height=30 align=left><INPUT class=inputb   size=22 name=question id="question"  style="width:200px;height:19px;padding-top: 3px"/ ></TD>
           </TR>
          <TR class=black >
            <td height="45"><font color="#666666" size="2">Answer of security question：</font></td>
            <TD width="304"  height=30 align=left><INPUT class=inputb  size=22 name=answer id="answer" style="width:200px;height:19px;padding-top: 3px"/></TD>
           </TR>
          <tr>
            <td height="43" colspan="4"><input id="ck" type="checkbox" name="ck" value="checkbox" onclick="showAndHideTalbe()"/>
              <strong>Advanced options</strong><font color="#666666" size="2">&nbsp;Advanced options fill in information about distribution. If this option is checked, the following is required。</font></td>
          </tr>
        </table>
        <table id="detail" height="180" border="0" cellpadding="0" cellspacing="0" style="display: none">
          <tr>
            <td width="124" height="45"><font color="#666666" size="2">Consignee Name：</font></td>
            <td  ><input id="name" type="text" name="name" style="width:170px;height:19px;padding-top: 3px"/><font color="#666666" size="2">Please fill in the real name.</font></td>
           </tr>
          <tr>
            <td height="45"><font color="#666666" size="2">Fixed number：</font></td>
            <td><input id="telephone" type="text" name="telephone" style="width:170px;height:19px;padding-top: 3px"/><font color="#666666" size="2">Please fill in at least one item for fixed telephone and mobile telephone</font></td>
           </tr>
          <tr>
            <td height="45"><font color="#666666" size="2">Moblie number：</font></td>
            <td><input id="movePhone" type="text" name="movePhone" style="width:170px;height:19px;padding-top: 3px"/><font color="#666666" size="2">Please fill in at least one item for fixed telephone and mobile telephone</font></td>
           </tr>
          <tr>
            <td height="45"><font color="#666666" size="2">Receiving address：</font></td>
            <td><input id="address" type="text" name="address" style="width:300px;height:19px;padding-top: 3px"/><font color="#666666" size="2">Please fill in it correctly.</font></td>
           </tr>
        </table>
        <table style="margin-left: 150px">
          <tr>
            <td colspan="4"><input type="image" src="../image/icon/btn_register.gif" style="cursor: pointer;"/></td>
          </tr>
        </table>
      </form></td>
  </tr>
</table>
  <div id="footer"  style="height:60px; background-color:#e54044;clear:both; ">
  <p style="text-align: center;	padding-top:20px;	color:#FFF"> Shopping website </p>
</div>
  </body>
</html>
