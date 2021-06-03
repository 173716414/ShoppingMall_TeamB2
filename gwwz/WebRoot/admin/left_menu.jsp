<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>








<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
<link href="../css/left.css" type="text/css" rel="stylesheet" />
<title>The left side menu</title>
<script src="../js/jquery.min.js"></script>
<script language="javascript" type="text/javascript" charset="utf-8" src="../js/admin.js"></script>
</head>
<body style="height:150%">
<body oncontextmenu="return false" ondragstart="return false" onSelectStart="return false">
	  <% String role = (String)session.getAttribute("role");
 
  if(role.equals("0")){%>  
	    <div class="div_bigmenu">
 		<div class="div_bigmenu_nav_down" id="nav_1" onclick="javascript:lefttoggle(1);">News Management</div>
		<ul id="ul_1">
			<li><a href="../servlet/ManageBulletin?method=showAddBulletinPage" target="main">ReleaseNews</a></li>
              <li><a href="../servlet/ManageBulletin?method=showManageBulletinPage" target="main">NewsManage</a></li>
		</ul>
	    </div>
		  <%}%>  
		
		<div class="div_bigmenu">
		<div class="div_bigmenu_nav_down" onclick="javascript:lefttoggle(2);" id="nav_2">Commodity management</div>
		<ul id="ul_2">
		   
           <li> <a href="../servlet/ManageGoodsInfo?method=showAddGoodsInfoPage" target="main">Add goods</a></li>
  <li><a href="../servlet/ManageGoodsInfo?method=showManageGoodsInfoPage" target="main">GoodsManage</a></li>
  <li><a href="../servlet/ManageGoodsType?method=showAddGoodsTypePage" target="main">AddType</a></li>
  <li><a href="../servlet/ManageGoodsType?method=showManageGoodsTypePage" target="main">TypeManage</a></li>
  <li><a href="../servlet/ManageGoodsInfo?method=showManageEvaluate" target="main">CommentManage</a></li> 
		</ul>
	    </div> 
		
		<div class="div_bigmenu">
		<div class="div_bigmenu_nav_down" onclick="javascript:lefttoggle(3);" id="nav_3">Order management</div>
		<ul id="ul_3">
              <li><a href="../servlet/ManageOrder?method=showManageOrderPage" target="main">OrderManage</a></li>
		</ul>
		</div>
		
		<div class="div_bigmenu">
		<div class="div_bigmenu_nav_down" onclick="javascript:lefttoggle(4);" id="nav_4">Customer info management</div>
		<ul id="ul_4">
              <li><a href="../servlet/ManageCustomerInfo?method=showManageCustomerInfoPage" target="main">CustomerManage</a></li>
		</ul>
		</div> 
		
		
	
		<div class="div_bigmenu">
		<div class="div_bigmenu_nav_down" onclick="javascript:lefttoggle(5);" id="nav_5">System management</div>
		<ul id="ul_5">
<li><a href="../servlet/UpdateUserInfo?method=showUpdatePasswordPage" target="main">ChangePassword</a></li>
	
	     <% if(role.equals("0")){%>
<li>              <a href="../servlet/UpdateUserInfo?method=showUpdateUserNamedPage" target="main">Change Name</a></li>
<li>              <a href="../servlet/UpdateUserInfo?method=showManageUserInfoPage" target="main">User Manage</a></li>		</ul>
 <%}%>  		</div>
		
		 
		   
        
	</body>
</html>



   
  