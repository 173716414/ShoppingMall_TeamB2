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
    <title>Add goods</title>
     <script type="text/javascript" src="../js/admin/addGoodsInfo.js" charset="gb2312"></script>
         <script type="text/javascript" src="../js/popup.js"></script>
<script language="javascript">
            function up()
		    {
		        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
	            pop.setContent("contentUrl","<%=path %>/upload/upload.jsp");
	            pop.setContent("title","File upload");
	            pop.build();
	            pop.show();
		    }
        </script>
 
 
  </head>
  <body onload= "document.form1.goodsTypeId.onchange() " >
  <form action="../servlet/ManageGoodsInfo?method=insert" method="post" onSubmit="return checkGoodsInfo()" name="form1">
   	<table style="font-size:13px;margin-left: 40px" width="800" height="390">
  <tr>
    <td colspan="2"><strong><font size="6" color="#0099FF">□</font><font color="#666666" size="3">&nbsp;Add goods</font></strong></td>
  </tr>
  <tr>
    <td height="15" colspan="2"><hr  width="100%" style="height: 2px;"/></td>
  </tr>
  <tr>
    <td><strong>Product Name:</strong></td>
    <td><input id="goodsName" type="text" name="goodsName" style="width:350px; height:25px;padding-top: 2px;"/></td>
  </tr>
  <tr>
    <td><strong>Product Category:</strong></td>
    <td>
    	<select name="goodsTypeId" id="goodsTypeId"  onChange="sendRequest()">
    		<%
    			ArrayList<GoodsType> typeList = (ArrayList<GoodsType>)request.getAttribute("typeList");
    			if(typeList != null){
    				for(int i=0;i<typeList.size();i++){
    					GoodsType gt = typeList.get(i);
    					out.println("<option value='"+gt.getTypeId()+"'>"+gt.getTypeName()+"</option>");
    				}
    				
    			}
    		 %>
    	</select>
        <script> document.form1.goodsTypeId.selectedIndex=1 </script>
    	
    	<select name="typeDetailInfo" id="typeDetailInfo">
    		<%
    			ArrayList<GoodsTypeDetail> typeDetailInfoList = (ArrayList<GoodsTypeDetail>)request.getAttribute("typeDetailInfoList");
    			if(typeDetailInfoList != null){
    				for(int i=0;i<typeDetailInfoList.size();i++){
    					GoodsTypeDetail gtd = typeDetailInfoList.get(i);
    					
    					out.println("<option value='"+gtd.getId()+"'>"+gtd.getTypeDetailInfo().trim()+"</option>");
    				}
    				
    			}
    		 %>
    	</select>
    	
    	
    </td>
  </tr>
  <tr>
    <td><strong>Product price/discount/quantity:</strong></td>
    <td>
    	Price:<input  id="price" type="text" name="price"   style="width:80px; height:25px;padding-top: 2px" value=""/>&nbsp;&nbsp;yuan
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	Discount:<input id="discount" type="text" name="discount"  style="width:80px; height:25px;padding-top: 2px" value=""/>&nbsp;&nbsp;off
    	&nbsp;&nbsp;&nbsp;&nbsp;
    	<font color="#FF6699">Format such as: 20% off</font>
    	&nbsp;&nbsp;&nbsp;&nbsp;
    	Quantity:<input id="countRequire" type="text" name="countRequire"  style="width:60px; height:25px;padding-top: 2px" value=""/>&nbsp;&nbsp;pieces
    </td>
  </tr>
  
  <tr>
    <td><strong>Listed/Recommended/New:</strong></td>
    <td>
    	<input type="checkbox" name="ckb" value="status" checked="checked">shelves
    	<input type="checkbox" name="ckb" value="isRecommend">recommended
    	<input type="checkbox" name="ckb" value="isNew">New product</td>
  </tr>
  <tr>
    <td><strong>Product picture:</strong></td>
    <td><input id="photo" type="text" name="photo"  style="width:500px; height:26px;padding-top: 4px"  readonly="readonly"/>
    
						        <input type="button" value="upload" onClick="up()"/>
						        <input type="hidden" name="fujianYuanshiming" id="fujianYuanshiming"/>
    
    
    </td>
  </tr>
  <tr>
    <td><strong>Product Description:</strong></td>
    <td><textarea name="remark" style="width:500px; height:50px;"></textarea></td>
  </tr>
  <tr>
    <td colspan="2" style="padding-left:360px"><input type="submit" name="Submit" value="OK" style="height: 28px;width: 50px;padding-top: 2px"/>&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="reset" value="reset" style="height: 28px;width: 50px;padding-top: 2px"/></td>
  </tr>
</table>
</form>
  </body>
</html>
