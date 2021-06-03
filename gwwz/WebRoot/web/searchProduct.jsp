<%@ page language="java" import="com.entity.GoodsInfo,java.text.DecimalFormat" pageEncoding="utf-8"%>
<%@page import="com.util.PublicToolCheckParam"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.GoodsEvaluate"%>
<%@page import="com.entity.GoodsType"%>
<%@page import="com.util.PublicToolShowDetailTypeList"%>
<%@page import="com.util.PublicToolGetTypeDetailInfo"%>
<%@page import="com.dao.GoodsTypeDetailInfoDAO"%>
<%@page import="com.entity.GoodsType"%>
<%@page import="com.entity.GoodsTypeDetail"%>
<%@page import="com.util.PublicToolCheckParam"%>
<%@page import="com.entity.SalesGoods"%>
<%
	GoodsInfo productInfo = (GoodsInfo)request.getAttribute("productInfo");
	String email = (String)session.getAttribute("email");
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Search Results</title>

<link rel="stylesheet" href="../webstyle/base.css" type="text/css" media="screen">
<link rel="stylesheet" href="../webstyle/common.css" type="text/css" media="screen">
<link rel="stylesheet" href="../webstyle/mall.css" type="text/css" media="screen">
<script type="text/javascript" src="../js/web/checkGo.js" charset="gb2312"></script>
</head>
<body >
<div id="wrap">
  <iframe src="../web/top.jsp" width="100%" frameborder="0"></iframe>
  
  <!-- end header-->
  <div id="main" class="mt10">
    <div class="fl lsort">
      <div class="sort">
        
        </div>
      </div>
    </div>
    <div class="fr rightbox">
      <div class="position"> Your current location: <a href="../" target="_top">Home page</a> &gt;&gt;Search for goods </div>
      <div class="mt10 arrangement"> <span class="fl">arrangement</span>
        <ul class="fl ml10">
          <li> <a href='../servlet/SearchProduct?key=<%=request.getAttribute("key")%>&order=price'>Price</a> </li>
          
          <li style="border-right: 1px solid #d9d9d9;"> <a href='../servlet/SearchProduct?key=<%=request.getAttribute("key")%>&order=createdate'>Time</a> </li>
        </ul>
      </div>
      <div class="mt10 listbox">
        <ul>
          <%	
		  
		        	String isSearching = (String)request.getAttribute("isSearching");
 		ArrayList<GoodsInfo> goodsInfoList = (ArrayList<GoodsInfo>)request.getAttribute("goodsInfoList");
      	if(goodsInfoList == null || goodsInfoList.toString().equals("[]")){
      		out.println("<td colspan='12' height='30'><div align='center'>No product information is available at this time!</div></td>");
      	}
      	else{

		DecimalFormat df = new DecimalFormat("0.00");
      		for(int i=0;i<goodsInfoList.size();i++){
      			GoodsInfo gd = goodsInfoList.get(i);
      			String goodsName = gd.getGoodsName();
      			if(goodsName.length() >19){
      				goodsName = goodsName.substring(0,18)+"...";
      			}
      			String price = df.format(gd.getPrice());
      			String createdate=gd.getCreatedate();
      			int countrequire=gd.getCountRequire();
      			String userid=gd.getUserid();
      			 String thirdName ="";  
		  
		  
		
			if(PublicToolCheckParam.checkNullAndEmpty(gd.getPhoto())){
				
				%>
          <li>
            <div class="bor1 plistinfo"> <a href='ProductInfo?gid=<%=gd.getGoodsId()%>'><img src='../<%=gd.getPhoto()%>' width='220' height='220' border='0'/></a> <span class="pltitle"> <a href='ProductInfo?gid=<%=gd.getGoodsId()%>'><%=gd.getGoodsName()%> </a> </span>
              <div class="plprice"> <span class="pnormal">￥<%=price%></span> </div>
            </div>
            <div class="clr"></div>
          </li>
          <%
			}
			
			else{
				
				%>
          <li>
            <div class="bor1 plistinfo"> <a href='ProductInfo?gid=<%=gd.getGoodsId()%>'><img src='../webstyle/defaultpic.gif'  height='220' width='220' /></a> <span class="pltitle"> <a href='ProductInfo?gid=<%=gd.getGoodsId()%>'><%=gd.getGoodsName()%> </a> </span>
              <div class="plprice"> <span class="pnormal">￥<%=price%></span> </div>
            </div>
            <div class="clr"></div>
          </li>
          <%}
	  		
	  		
	  		
			
		}
	  		
	%>
        </ul>
      </div>
      <div class="clr"></div>
      <div class="productpage">
        <%	
		out.println("Total"+request.getAttribute("sumCount")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println("the"+request.getAttribute("currentPage")+"/"+request.getAttribute("sumPageCount")+"page&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println("<a href='../servlet/SearchProduct?currentPage="+request.getAttribute("indexPage")+"&key="+request.getAttribute("key")+"'>Home page</a>&nbsp;&nbsp;&nbsp;");
		out.println("<a href='../servlet/SearchProduct?currentPage="+request.getAttribute("upPage")+"&key="+request.getAttribute("key")+"'>The previous page</a>&nbsp;&nbsp;&nbsp;");
		out.println("<a href='../servlet/SearchProduct?currentPage="+request.getAttribute("nextPage")+"&key="+request.getAttribute("key")+"'>The next page</a>&nbsp;&nbsp;&nbsp;");
		out.println("<a href='../servlet/SearchProduct?currentPage="+request.getAttribute("lastPage")+"&key="+request.getAttribute("key")+"'>Back Page</a>");
		
  		}
%>
      </div>
    </div>
  </div>
  
  <!--end footer-->
  
</div>

  <div id="footer"  style="height:60px; background-color:#e54044;clear:both; ">
  <p style="text-align: center;	padding-top:20px;	color:#FFF"> SmartMall </p>
</div>
</body>
</html>
