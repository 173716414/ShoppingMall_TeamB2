<%@ page language="java" import="java.util.*,com.entity.GoodsInfo,java.text.DecimalFormat" pageEncoding="utf-8"%>
<%@page import="com.util.PublicToolCheckParam"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	//从session中取出购物车信息
    ArrayList<GoodsInfo> shopList =(ArrayList<GoodsInfo>) session.getAttribute("shopList");
    String email = (String)session.getAttribute("email"); 
%>
<html>
  <head>    
    <title>Shopping cart</title>    
  	<script type="text/javascript" src="../js/web/cart.js" charset="gb2312"></script>
  	<script type="text/javascript">
  		function sendInfo(){
  			if("<%=shopList%>" == "[]" || "<%=shopList%>" == "null"){
  				alert("You haven't bought anything yet");
  				return false;
  			}
  			else if("<%=email%>" == "" || "<%=email%>" == "null"){
  				alert("You haven't logged in yet! Please log in first");
  				return false;
  			}
  			else{
  				window.location.href = "../filterWeb/sendInfo.jsp";
  				return true;
  			}
  		}
  	</script>
  </head>
  <body>
  <div >
  <form id="frm" name="frm" action="../servlet/Shopping" method="get">
  		<input type="hidden" name="method" value="u" />
  		<input type="hidden" id="txtcount" name="count"  />
  		<input type="hidden" id="txtgid"  name="gid" />
  	</form>
	<iframe src="../web/top.jsp" width="100%" height="170" frameborder="0"></iframe>
  	<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr height="60">
    <td><font size="2" color="#999999">Where are you now：<a href="../" target="_top">Homepage</a>&gt; Shopping cart</font></td>
  </tr>
  <tr>
    <td colspan="7"><img src="../image/icon/buycart_logo.gif" width="165" height="53" /></td>
  </tr>
</table>

<table border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#9999FF" style="font-size:13px;">
  <tr bgcolor="#CCFFFF">
    <td height="25" colspan="2"><div align="center">Goods name</div></td>
    
    <td width="101"><div align="center">price</div></td>
    <td width="80"><div align="center">discount</div></td>
    <td width="122"><div align="center">quantity/div></td>
    <td width="143"><div align="center">subtotal</div></td>
    <td width="153"><div align="center">operation</div></td>
  </tr>
   <%
   		DecimalFormat df = new DecimalFormat("0.00");
       	if(shopList==null || shopList.size() == 0){
      		out.println("<tr><td height='30' colspan='8' align='center'>There are no items in the shopping cart！</td></tr>");
      	}
      	else{
      		for(int i=0;i<shopList.size();i++){
      			GoodsInfo shopGD = shopList.get(i);
      			String price = df.format(shopGD.getPrice());
      			String sum = df.format(shopGD.getDiscountPrice()*shopGD.getCount());
      			String discout = String.format("%.1f",shopGD.getDiscount());
      			if((int)shopGD.getDiscount() == 10){
      				discout = "All";
      			}
      			out.println("<tr>");
      			if(PublicToolCheckParam.checkNullAndEmpty(shopGD.getPhoto())){
      				out.println("<td style='border-right:none'><img src='../"+shopGD.getPhoto()+"' width='50' height='50'/></td>");
      			}
      			else{
      				out.println("<td style='border-right:none' width='50' height='50'/><div align='center'><font color='#FF6699'>Not yet</font></div></td>");
      			}
      			out.println("<td width='263' style='border-left:none'><a href='../servlet/ProductInfo?gid="+shopGD.getGoodsId()+"'>"+shopGD.getGoodsName()+"</a></td>");
      			
      			out.println("<td><div align='center'>"+price+"yuan</div></td>");
      			out.println("<td><div align='center'>"+discout+"</div></td>");
      			out.println("<td><div align='center'><input id='gc"+shopGD.getGoodsId()+"' type='text' name='txtcount' value='"+shopGD.getCount()+"' style='width:50px'/></div></td>");
      			out.println("<td><div align='center'>"+sum+"yuan</div></td>");
      			out.println("<td><div align='center'><input type='button' onclick=updateCount(" + shopGD.getGoodsId() + ") value='Change quantity'> <br><a href='../servlet/Shopping?method=d&gid="+shopGD.getGoodsId()+"'>delete goods</a></div></td>");
        		out.println("</tr>");        
      		}
      	}
       %>     
</table>
<table  height="82" align="center" style="font-size:13px; margin-left:120px">
<tr>
  <td colspan="2"><div align="right">
    <table  height="82" align="center" style="font-size:13px; margin-left:120px">
      <tr>
        <%
			Object sum = session.getAttribute("sum");
			if(sum != null){
				String str_sum = df.format(Double.parseDouble(session.getAttribute("sum").toString()));
				out.println("<td colspan='2'>Total amount of goods：<font color='#FF6633' size='5'><strong>￥"+str_sum+"</strong></font></td>");
			}
			else{
				out.println("<td colspan='2'>Total amount of goods：<font color='#FF6633' size='5'><strong>￥0.00</strong></font></td>");
			}
		 %>
        <td colspan="2"><div align="right"><a href="../servlet/Shopping?method=c">empty cart</a></div></td>
      </tr>
      <tr>
        <td ><div align="right">You can</div></td>
        <td ><a href="#" onclick=sendInfo()><img src="../image/icon/jrjs.gif" border="0"/></a></td>
        <td >，also can</td>
        <td ><a href="../"><img src="../image/icon/jxgm.gif" border="0"/></a></td>
      </tr>
    </table>
    <a href="../servlet/Shopping?method=c"></a></div></td>
</tr>
</table>
<br />
  <div id="footer"  style="height:60px; background-color:#e54044;clear:both; ">
  <p style="text-align: center;	padding-top:20px;	color:#FFF"> Shopping website </p>
</div>
	</div>
  </body>
</html>