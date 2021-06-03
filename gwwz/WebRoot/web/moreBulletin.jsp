<%@ page language="java" import="java.util.*,com.entity.BulletinInfo" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>More announcements</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <script type="text/javascript" src="../js/web/checkGo.js" charset="gb2312"></script>
  </head>
  
  <body>
  <iframe src="../web/top.jsp" width="100%" height="170" frameborder="0"></iframe>
    <table border="0" cellspacing="0" cellpadding="0" width='960px' align="center">
  <tr height="60">
    <td><font size="2" color="#999999">Your current location:<a href="../" target="_top">Homepage</a>&gt; Web site announcement</font></td>
  </tr>
</table>
<form id="form1" name="form1" method="post" action="../servlet/Bulletin" onsubmit="return checkGo()">
<table  height="110" border="0" cellpadding="0" cellspacing="0" style="font-size:13px; " width='960px' align="center">
  <%
		ArrayList<BulletinInfo> moreBulletinInfoList = (ArrayList<BulletinInfo>)request.getAttribute("moreBulletinInfoList");
			for(int i=0;i<moreBulletinInfoList.size();i++){
				BulletinInfo bulletin = moreBulletinInfoList.get(i);
				out.println("<tr><td width='296' height='24'><a href='ShowBulletinInfo?id="+bulletin.getId()+"'>"+bulletin.getTitle()+"</a></td><td width='804'><font color='#666666'>"+bulletin.getCreateTime()+"</font></td></tr>");
			}
	%> 	
  <tr>
    <td colspan="2" width="1080" align="right">
    There are<%=request.getAttribute("sumCount")%>announcements
    &nbsp;&nbsp;&nbsp;
    the<%=request.getAttribute("currentPage")%>/<%=request.getAttribute("sumPageCount")%>page
    &nbsp;&nbsp;&nbsp;
    <a href="../servlet/Bulletin?currentPage=<%=request.getAttribute("indexPage")%>">Home page</a>
    &nbsp;&nbsp;
    <a href="../servlet/Bulletin?currentPage=<%=request.getAttribute("upPage")%>">The previous page</a>
    &nbsp;&nbsp;
    <a href="../servlet/Bulletin?currentPage=<%=request.getAttribute("nextPage")%>">The next page</a>
    &nbsp;&nbsp;
    <a href="../servlet/Bulletin?currentPage=<%=request.getAttribute("lastPage")%>">back</a>
    &nbsp;&nbsp;&nbsp;
    Jump to the &nbsp;&nbsp;<input type="text" id="go" name="currentPage" style="width: 35px"/>&nbsp;&nbsp;page
    <input type="submit" value="go" style="width: 30px;cursor:pointer;"/></td>
  </tr>
</table>
</form>
  <div id="footer"  style="height:60px; background-color:#e54044;clear:both; ">
  <p style="text-align: center;	padding-top:20px;	color:#FFF"> SmartMall </p>
</div>
  </body>
</html>
