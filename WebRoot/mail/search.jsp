<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cc.test.vo.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<%
   List<Book> booklist=null;
   booklist=(List<Book>) session.getAttribute("Search");
   %>
  
  欢迎买家用户:<%=session.getAttribute("username")%> &nbsp<a href="Cart">查看购物车</a>&nbsp
  <a href="/ShopSys/index.jsp">退出登录</a> &nbsp&nbsp<form action="Search" method="post"><input type="text" name="search"/> <input type="submit" value="搜索"/></form>
   
   <br><h3>关键字:<%=session.getAttribute("search") %></h3>
    <table border=1> 
    <tr>
    <td>书号</td>
    <td>书名</td>
    <td>封面</td>
    <td>原价</td>
    <td>现价</td>
    <td>卖家</td>
    <td>库存</td>
    </tr>
    <%   for(Book book:booklist){
    String button="shopping.view?id="+book.getBookId();%>
    <tr> 
        <td><%=book.getBookId()%>
		</td>
		<td><%=book.getBookName() %> 
        </td>
        <td><img src=<%=book.getBookImg() %> width="80" height="100">
        </td>
        <td><%=book.getPrice() %>
        </td>
        <td><%=book.getSellprice() %>
        </td>
        <td><%=book.getSeller() %>
        </td>
        <td><%=book.getNumber() %>
        </td>
        <td><a href=<%=button%>>购买</a></td>
    </tr>
    <%} %>
  </table>
 
   
  </body>
</html>
