<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
    <script language="javascript">
        function check()
        {
            if(document.formAdd.photo.value=="")
            {
                alert("Please select file");
                return false;
            }
            return true;
        }
    </script>
  </head>
  
  <body>
       <form action="<%=path %>/upload/upload_re.jsp" name="formAdd" method="post"  enctype="multipart/form-data">
           <input type="file" name="fujian" id="fujian" onKeyDown="javascript:alert('This information cannot be entered manually');return false;" />
           <input type="submit" value="OK" onclick="return check()"/>
       </form>
  </body>
</html>
