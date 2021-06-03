<%@ page language="java" import="java.util.*,com.entity.BulletinInfo" pageEncoding="utf-8"%>
<%@page import="com.entity.BulletinInfo"%>
<%@page import="com.util.PublicToolCheckParam"%>
<%@page import="com.entity.GoodsType"%>
<%@page import="com.entity.GoodsTypeDetail"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Add Product Type</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <script type="text/javascript" src="../js/admin/addGoodsType.js" charset="gb2312"></script>
  </head>
  
  <body>
  <form action="../servlet/ManageGoodsType?method=insert" method="post" onSubmit="return addTypeName()">
    <table width="370" height="160" border="0" cellpadding="0" cellspacing="0" style="font-size:13px;margin-left: 40px">
  <tr>
    <td width="100%" height="36" colspan="2"><strong><font size="6" color="#0099FF">□&nbsp;</font><font color="#666666" size="3">Add Product Type</font></strong></td>
  </tr>
  <tr>
    <td colspan="2"><hr  width="100%"/></td>
  </tr>
  <tr>
    <td><font color="#999999"><strong>Name of superior commodity type:</strong></font></td>
    <td><select name="goodsTypeId" >
    	<option value='0'>no</option>
    		<%
    			ArrayList<GoodsType> typeList1 = (ArrayList<GoodsType>)request.getAttribute("typeList1");
    			if(typeList1 != null){
    				for(int i=0;i<typeList1.size();i++){
    					GoodsType gt = typeList1.get(i);
    					out.println("<option value='"+gt.getTypeId()+"'>"+gt.getTypeName()+"</option>");
    				}
    				
    			}
    		 %>
    	</select> *Choose no, the main classification
        
        
      
        
        </td>
  </tr>
 <tr>
    <td><font color="#999999"><strong>Product Type Name:</strong></font></td>
    <td><input id="typeName" type="text" name="typeName" style="width: 250px; height: 26px;padding-top: 3px"/></td>
  </tr>
    <tr>
    <td colspan="2" style="padding-left: 150px">
    	<input type="submit" value="OK" style="width: 50px; height: 26px;padding-top: 3px"/>
  	  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="reset" value="Reset" style="width: 50px; height: 26px;padding-top: 3px"/>
    </td>
  </tr>
</table>
</form>
  </body>
</html>
