<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cc.test.vo.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<%
   List<User> userlist=null;
   userlist=(List<User>) session.getAttribute("User");
   %>
  
  欢迎管理员用户:<%=session.getAttribute("username")%> &nbsp
  <a href="/ShopSys/index.jsp">退出登录</a> 
   
   <br><h3>所有用户</h3>
    <table border=1> 
    <tr>
    <td>用户名</td>
    <td>密码</td>
    <td>用户类型</td>
    </tr>
    <%   for(User User:userlist){
    String button="Delete2?username="+User.getName();
    String pwd="ChangePassword?username="+User.getName();%>
    <tr> 
        <td><%=User.getName()%>
		</td>
		<td><%=User.getPassword() %> 
        </td>
        <td><%=User.getKind()%>
        </td>
        <td><a href=<%=button%>>删除</a></td>
        <td><a href=<%=pwd%>>修改密码</a></td>
    </tr>
    <%} %>
  </table>
 
   
  </body>
</html>
