<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cc.test.vo.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
    <%
   List<Book> booklist=null;
   booklist=(List<Book>) session.getAttribute("Sell");
   %>
  欢迎卖家用户:<%=session.getAttribute("username")%>&nbsp<a href="mail/add.jsp">添加商品</a>&nbsp<a href=<%="ChangePassword?username="+session.getAttribute("username")%>>修改密码</a>&nbsp<a href="/ShopSys/index.jsp">退出登录</a>
  <h3>出售中的商品</h3>
        <table border=1> 
    <tr>
    <td>书号</td>
    <td>书名</td>
    <td>封面</td>
    <td>原价</td>
    <td>现价</td>
    <td>库存</td>
    </tr>
    <%   for(Book book:booklist){
    String button1="ChangePrice?id="+book.getBookId();
    String button2="Delete3?id="+book.getBookId();%>
    <tr> 
        <td><%=book.getBookId()%>
		</td>
		<td><%=book.getBookName() %> 
        </td>
        <td><img src=<%=book.getBookImg() %>  width="80" height="100">
        </td>
        <td><%=book.getPrice() %>
        </td>
        <td><%=book.getSellprice() %>
        </td>
        <td><%=book.getNumber() %>
        </td>
        <td><form  action="ChangePrice" method="get"><input type=hidden name=id value=<%=book.getBookId()%>><input type="text" name=price  style="width:70px;" onKeypress="if (event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;"><br><input type="submit" value="修改价格"/></form></td>
        <td><a href=<%=button2%>>删除</a></td>
    </tr>
    <%} %>
  </table>
    </body>
</html>  