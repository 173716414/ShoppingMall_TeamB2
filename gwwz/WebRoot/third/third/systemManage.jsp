<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Merchant management</title>
    <script type="text/javascript" src="../js/third/systemManage.js" charset="utf-8"></script>
<link href="../css/frame.css" rel="stylesheet" type="text/css" />
<script src="../js/frame.js" language="javascript" type="text/javascript"></script>
</head>
<body class="showmenu">

<div class="pagemask"></div>
<iframe class="iframemask"></iframe>
<div class="allmenu">
	<div class="allmenu-box">

<br style='clear:both' />
	</div>
</div>

<div class="head">
	<div class="top">
		<div class="top_link">
			<ul>
			<li class="welcome">
             <%=session.getAttribute("thirdName")%> Hello,welcome to the system！</li>
			
      	<li>
            <a href="#" onClick="loginOut()">Cancellation</a></li>
			</ul>
		</div>
		
	</div>
	
	
</div>

<div class="left">
	<div class="menu" id="menu">
    
    
    
    
		 <iframe src="../third/left_menu.jsp" id="menufra" name="menu" frameborder="0"></iframe>

  
  
  
  
  	</div>
</div>

<div class="right">
	<div class="main">
        
        <iframe id="iframe" name="iframe" src="<%if(request.getAttribute("url") == null){out.println("../third/welcome.jsp");}else{out.println(""+request.getAttribute("url")+"");}%>"  frameborder="0"></iframe>
	</div>
</div>












</body>
</html>
