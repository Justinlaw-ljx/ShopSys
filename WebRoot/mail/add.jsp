<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
  欢迎卖家用户:<%=session.getAttribute("username")%>&nbsp<a href="/ShopSys/index.jsp">退出登录</a>
        <form action="/ShopSys/Upload" method="post" enctype="multipart/form-data">
        <h3>添加新商品</h3>
        <table border="1">
              <tr> <td>书号:</td><td><input type="text" name="id"></td></tr>
              <tr> <td>书名:</td><td><input type="text" name="bookname"></td></tr>
              <tr> <td>原价:</td><td><input type="text" name="price"></td></tr>
              <tr> <td>现价:</td><td><input type="text" name="sellprice"></td></tr>
              <tr> <td>库存:</td><td><input type="text" name="number"></td></tr>
              <tr> <td>上传相片:</td><td><input type="file" name="photo" /></td></tr>
              <tr> <td><input type="submit" value="上传" name="upload" /></td>
                   <td><input type="button" onclick="window.location.href='/ShopSys/mail/log2.jsp'" value="返回"></td></td></tr>
           </table>
        </form>
    </body>
</html>  