<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>















<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<title> Background control panel</title>
    <script type="text/javascript" src="../js/admin/systemManage.js" charset="gb2312"></script>
<script src="../js/frame.js" language="javascript" type="text/javascript"></script>
</head>
<frameset rows="96,*,4" frameborder="no" border="0" framespacing="0">
	<frame src="../admin/top.jsp" noresize="noresize" id="topFrame" frameborder="0" name="topFrame" marginwidth="0" marginheight="0" scrolling="no">
	<frameset rows="*" cols="185,*" id="frame" framespacing="0" frameborder="no" border="0">
		<frame src="../admin/left_menu.jsp" name="leftFrame" id="leftFrame" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0" scrolling="yes">
		<frame src="<%if(request.getAttribute("url") == null){out.println("../admin/welcome.jsp");}else{out.println(""+request.getAttribute("url")+"");}%>" name="main" id="main" marginwidth="8" marginheight="5" frameborder="0" scrolling="yes">
	</frameset>
	<frame src="bottom.jsp" noresize="noresize" id="bottomFrame" frameborder="0" name="bottomFrame" marginwidth="0" marginheight="0" scrolling="no">
<noframes>
	<body>Frames are not currently supported in browsers!</body>
</noframes>
</frameset>
</html>




