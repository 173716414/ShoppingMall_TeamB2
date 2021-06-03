<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>Order submitted successfully	</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <script type="text/javascript" src="../js/web/ok2.js" charset="gb2312"></script>
  </head>
  
  <body>
   <iframe src="../web/top.jsp" width="100%" height="170" frameborder="0"></iframe>
   <table border="0" cellspacing="0" cellpadding="0" width='960px' align="center">
  <tr height="60">
    <td><font size="2" color="#999999">Where are you now：<a href="../" target="_top">Homepage</a>&gt; Order submitted successfully</font></td>
  </tr>
</table>
   <table align="center">
   		<tr>
   			<td><img src="../image/icon/ok.png" /></td><td>&nbsp;&nbsp;&nbsp;&nbsp;<font size="+5" color="#99CC00"><strong>Order submitted successfully</strong></font></td>
   		</tr>
   	</table>
   	<table style="margin-top: 50px;font-size: 13px" width='960px' align="center">
   		<tr><td><font color="#FF6633" size="4"><strong>Choose payment method：</strong></font></td></tr>
   		<tr><td height="40" style="padding-left: 20px"><font color="#666666">Mode 1：</font></td></tr>
   		<tr><td height="10" style="padding-left: 40px"><font color="#CC3366">Cash on delivery: please wait for the pick-up notice within three days, and the pick-up place will inform you by phone</font></td></tr>
   		<tr><td height="50" style="padding-left: 40px"><input type="button" value="Click this button to send SMS to inform the staff that there is a new order"  style="width: 330px;height: 32px;padding-top: 3px;cursor: pointer;" onclick="sendMessage()"/></td></tr>
   		<tr><td height="40" style="padding-left: 20px"><font color="#666666">Mode 2：</font></td></tr>
   		<tr>
   			<td height="10" style="padding-left: 30px">
   				<table width="700">
   					<tr><td><input type="radio" name="radiobutton" checked="checked"/></td><td><img src="../image/bankLogo/bjyh.png" width="100" height="32"/></td><td><input type="radio" name="radiobutton"/></td><td><img src="../image/bankLogo/shpdfzyh.png" width="100" height="32"/></td><td><input type="radio" name="radiobutton"/></td><td><img src="../image/bankLogo/zgjsyh.png" width="100" height="32"/></td><td><input type="radio" name="radiobutton"/></td><td><img src="../image/bankLogo/zgyzcxyh.png" width="100" height="32"/></td></tr>
   					<tr><td><input type="radio" name="radiobutton"/></td><td><img src="../image/bankLogo/gdfzyh.png" width="100" height="32"/></td><td><input type="radio" name="radiobutton"/></td><td><img src="../image/bankLogo/xyyh.png" width="100" height="32"/></td><td><input type="radio" name="radiobutton"/></td><td><img src="../image/bankLogo/zglyyh.png" width="100" height="32"/></td><td><input type="radio" name="radiobutton"/></td><td><img src="../image/bankLogo/zsfzyh.png" width="100" height="32"/></td></tr>
   					<tr><td><input type="radio" name="radiobutton"/></td><td><img src="../image/bankLogo/jtyh.png" width="100" height="32"/></td><td><input type="radio" name="radiobutton"/></td><td><img src="../image/bankLogo/zggdyh.png" width="100" height="32"/></td><td><input type="radio" name="radiobutton"/></td><td><img src="../image/bankLogo/zgmsyh.png" width="100" height="32"/></td><td><input type="radio" name="radiobutton"/></td><td><img src="../image/bankLogo/zsyh.png" width="100" height="32"/></td></tr>
   					<tr><td><input type="radio" name="radiobutton"/></td><td><img src="../image/bankLogo/payh.png" width="100" height="32"/></td><td><input type="radio" name="radiobutton"/></td><td><img src="../image/bankLogo/zggsyh.png" width="100" height="32"/></td><td><input type="radio" name="radiobutton"/></td><td><img src="../image/bankLogo/zgyh.png" width="100" height="32"/></td><td><input type="radio" name="radiobutton"/></td><td><img src="../image/bankLogo/zxyh.png" width="100" height="32"/></td></tr>
   				</table>
   			</td>
   		</tr>
   		<tr><td height="60" style="padding-left: 34px"><a href="#"><img src="../image/icon/payOnline.jpg" border="0" onclick=" return payOnline()"/></a></td></tr>
   	</table>
   	<br />
<div id="footer"  style="height:60px; background-color:#e54044;clear:both; ">
  <p style="text-align: center;	padding-top:20px;	color:#FFF"> Shopping website </p>
</div>
  </body>
</html>
