<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'changepwd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body><h3>修改密码</h3>
  <form action="ChangePassword2" method="post">
  <table border=1>
  <tr>
    <td>账号:</td>
    <td><input type="text" name="username" value=<%=request.getParameter("username")%> disabled></td>
  </tr>
   <tr>
    <td>新密码:</td>
    <td><input type="password" name="pwd1"></td>
   </tr>
    <tr>
    <td>再次输入新密码:</td>
    <td><input type="password" name="pwd2"></td>
   </tr>
   <tr><td><input type="submit" value="确认修改"/></td></tr>
   </form>
   
    </table>
  </body>
</html>
