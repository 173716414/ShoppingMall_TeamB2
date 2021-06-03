<%@ page language="java" import="java.util.*,com.entity.BulletinInfo,com.entity.GoodsInfo" pageEncoding="utf-8"%>
<%@page import="com.util.PublicToolIndexProductShow"%>
<%@page import="com.entity.GoodsTypeDetail"%>
<%@page import="com.util.Validate"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>




<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <base href="<%=basePath%>">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping website</title>

<link rel="stylesheet" href="./webstyle/base.css" type="text/css" media="screen">
<link rel="stylesheet" href="./webstyle/common.css" type="text/css" media="screen">
<link rel="stylesheet" href="./webstyle/mall.css" type="text/css" media="screen">
<script type="text/javascript" src="js/web/index.js" charset="gb2312"></script>
</head>
<body>

<div id="wrap">
  
  
  
  
  
      <iframe src="web/top.jsp" width="100%" frameborder="0"></iframe>

  <!-- end header-->
  <div id="main" >
    <div class="fr">
      <div class="mallnews">
        <h2> <%
				ArrayList<BulletinInfo> bulletinList = (ArrayList<BulletinInfo>)request.getAttribute("bulletinList");
				if(bulletinList.size() != 0){
					out.println("<b>Announcement</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='servlet/Bulletin'>More&gt;&gt;</a>");
				}
			 %></h2>
        <ul>
         	<%
  					if(bulletinList != null && bulletinList.size() >= 15){
	  					for(int i=0;i<15;i++){
	  						BulletinInfo bulletin = bulletinList.get(i);
	  						String title = bulletin.getTitle();
	  						Validate v = new Validate();
	  						String createTime = v.datemmdd(bulletin.getCreateTime());
if(title.length() >9){
	  							title = title.substring(0,8)+"...";
	  						}
	  						out.println("<li><a href='servlet/ShowBulletinInfo?id="+bulletin.getId()+"'>"+title+"</a> "+createTime+"</li>");
	  					}
  					}
  					else if(bulletinList != null && bulletinList.size() < 15 && bulletinList.size() != 0){
	  					for(int i=0;i<bulletinList.size();i++){
	  						BulletinInfo bulletin = bulletinList.get(i);
	  						String title = bulletin.getTitle();
	  						if(title.length() >15){
	  							title = title.substring(0,8)+"...";
	  						}
	  						Validate v = new Validate();
	  						String createTime = v.datemmdd(bulletin.getCreateTime());
	  						

out.println("<li><a href='servlet/ShowBulletinInfo?id="+bulletin.getId()+"'>"+title+"</a> "+createTime+"</li>");
	  					}
	  					for(int i=0;i<15-bulletinList.size();i++){
	  						out.println("<li>&nbsp;</li>");
	  					}
  					}
  					else{
  						out.print("<li><font size='2' color='#666666'>暂无公告</font></li>");
  						for(int i=0;i<15;i++){
  							out.print("<li>&nbsp;</li>");
  						}
  					}
				%>
       
        
        
        
        </ul>
      </div>
    </div>
    <div class="mallrecommended">
      <h1><span>Mall</span>New Arrivals</h1>
      <ul class="fl">
        <!--Recommendation1 -->
     <%
		ArrayList<GoodsInfo> newGoodsInfoList = (ArrayList<GoodsInfo>)request.getAttribute("newGoodsInfoList");
  		PublicToolIndexProductShow.typeInfo(request,response,newGoodsInfoList,out);
%> 
      </ul>
    </div>
    <div class="mt10 licensed">
      <h2>Special offer</h2>
      <div class="bor1 licenseditem"> <img src="./webstyle/licensedpic.jpg" alt="" class="fl" width="239" height="405">
        <ul class="fr">
         <%
		ArrayList<GoodsInfo> specialGoodsInfoList = (ArrayList<GoodsInfo>)request.getAttribute("specialGoodsInfoList");
  		PublicToolIndexProductShow.typeInfo(request,response,specialGoodsInfoList,out);
%> 
        </ul>
      </div>
    </div>
 
 
 
 
    <div class="mt10 recommended">
      <h2>Recommended products</h2>
      <div class="bor1 recommendeditem"> <img src="./webstyle/recommendedpic.jpg" alt="" class="fl" width="239" height="405">
        <ul class="fr">
        
        
         <%
  		ArrayList<GoodsInfo> recommendGoodsInfoList = (ArrayList<GoodsInfo>)request.getAttribute("recommendGoodsInfoList");
  		PublicToolIndexProductShow.typeInfo(request,response,recommendGoodsInfoList,out);
%> 
         
         
         
         
      
        </ul>
      </div>
    </div>
    <div class="mt10"><img src="./webstyle/banner.jpg" alt=""></div>
  </div>
  <!--end main-->
  
  <!--end footer-->
  
  

  
  
</div>
<div id="footer"  style="height:60px; background-color:#e54044;clear:both; ">
  <p style="text-align: center;	padding-top:20px;	color:#FFF">
   copyright
  
  
  
  
   <a href="<%=path%>/admin.jsp" ><font color="#FFFFFF">Management login</font></a> 
   
   
   </p>
</div>
</body>
</html>





















