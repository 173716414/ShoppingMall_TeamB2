<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>




  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>头部</title>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
<link rel="stylesheet" type="text/css" href="../css/top.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
 

<script language="javascript" type="text/javascript" charset="utf-8" src="../js/topmenu.js"></script>
<script src="../js/frame.js" language="javascript" type="text/javascript"></script>
    <script type="text/javascript" src="../js/admin/systemManage.js" charset="gb2312"></script>

<script language="javascript" type="text/javascript">

var displayBar=true;
function switchBar(obj)
{
	if (document.all) //IE
	{
		if (displayBar)
		{
			parent.frame.cols="0,*";
			displayBar=false;
			obj.value="Open left menu";
		}
		else{
			parent.frame.cols="210,*";
			displayBar=true;
			obj.value="Close left menu";
		}
	}
	else //Firefox 
	{  
		if (displayBar)
		{
			self.top.document.getElementById('frame').cols="0,*";
			displayBar=false;
			obj.value="Open left menu";
		}
		else{
			self.top.document.getElementById('frame').cols="210,*";
			displayBar=true;
			obj.value="Close left menu";
		}
	}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body oncontextmenu="return false" ondragstart="return false" onSelectStart="return false">
<div class="top_box">
    <div class="top_logo"><div align="center" style="color: #CCFFCC;font-size: 16pt;font-weight: bold;">Smart Mall</div></div>
    <div class="top_nav">
      <div class="top_nav_sm">
		 		 <span style="float:right; padding-right:12px"><!-- [<a href="index.php" target='_parent' ><strong>前台首页</strong></a>]-->   </span>
		 		Welcome!  <%=session.getAttribute("userName")%> &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;		</div>
         <div class="top_nav_xm">
             <div class="navtit" id="navtit">
                <span onclick="changeMenu(this);"  class="hover"><a href="welcome.jsp" target='main'><i>Console</i></a></span>
				 
           </div>
         </div>
    </div>
    <div class="top_bar"><input onClick="switchBar(this)" type="button" value="Close left menu" name="SubmitBtn" class="bntof"/> 
    <div class="top_she">  
		<a href="javascript:void(0);" onClick="self.top.location.href='../admin.jsp'">Log out</a> <a onClick="javascript:window.parent.main.history.go(-1);" style="cursor:pointer;">Forward</a>
		 <a onclick="javascript:window.parent.main.location.reload();" style="cursor:pointer;">Refresh</a>    </div>
    </div>
</div>
</body>
</html>






 