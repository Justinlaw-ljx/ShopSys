<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cc.test.vo.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Car.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<table border="1">
  <tr><td>封面</td> <td>书号</td> <td>书名</td> <td>单价</td> <td>数量</td> <td>卖家</td> </tr>
  <%
   List<Car> booklist=null;
   booklist=(List<Car>) session.getAttribute("Car"); 
   double sum=0;
   %>
 <%   for(Car book:booklist){
    String button="delete.view?id="+book.getBookId();%>
    <tr> 
		<td><img src=<%=book.getBookImg() %> width="80" height="100"></td>
		<td><%=book.getBookId()%></td>
        <td><%=book.getBookName() %></td>
        <td><%=book.getPrice()%></td>
        <td><%=book.getNum() %></td>
        <td><%=book.getSeller() %>
        <td><a href=<%=button%>>删除</a>
    </tr>
    <%sum+=book.getPrice()*book.getNum();} %>
    <tr><td>总价</td><td><%=sum%></td></tr>
  </table>
  <input type="button" onclick="window.location.href='Order'" value="提交订单">
  </body>
</html>

