<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.entity.BulletinInfo"%>
<%@page import="com.util.PublicToolCheckParam"%>
<%@page import="com.entity.GoodsType"%>
<%
	GoodsType goodsTypeInfo = (GoodsType)request.getAttribute("goodsTypeInfo");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>View/modify product type information</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <script type="text/javascript" src="../js/admin/addGoodsType.js" charset="gb2312"></script>
    <style type="text/css">
<!--
#Layer1 {
	position:absolute;
	left:175px;
	top:92px;
	z-index:1;
}
-->
    </style>
  </head>
  
  <body>
  <div id="Layer1" style="width:100px;height: 20px"><font color="#999999"><strong><%=goodsTypeInfo.getTypeId()%></strong></font></div>
  <form action="../servlet/ManageGoodsType?method=update&typeId=<%=goodsTypeInfo.getTypeId()%>&submit=1" method="post" onsubmit="return addTypeName()">
    <table width="370" height="200" border="0" cellpadding="0" cellspacing="0" style="font-size:13px;margin-left: 40px">
  <tr>
    <td width="100%" height="36" colspan="2"><strong><font size="6" color="#0099FF">□&nbsp;</font><font color="#666666" size="3">View/modify product type information</font></strong></td>
  </tr>
  <tr>
    <td colspan="2"><hr  width="100%"/></td>
  </tr>
  <tr>
    <td><font color="#999999"><strong>Commodity type number：</strong></font></td>
    <td><input type="text" style="width: 60px; height: 26px;padding-top: 3px"/></td>
  </tr>
  <tr>
    <td><font color="#999999"><strong>Commodity type name:</strong></font></td>
    <td><input id="typeName" type="text" name="typeName" style="width: 250px; height: 26px;padding-top: 3px" value="<%=goodsTypeInfo.getTypeName()%>"/></td>
  </tr>
  <tr>
    <td colspan="2" style="padding-left: 150px">
    	<input type="submit" value="OK" style="width: 50px; height: 26px;padding-top: 3px"/>
  	  	 
    </td>
  </tr>
</table>
</form>
  </body>
</html>
