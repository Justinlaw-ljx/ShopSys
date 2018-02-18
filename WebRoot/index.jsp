<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>欢迎访问吉珠商城</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
        
<style type="text/css">
@import url("txt.css");
.unnamed1 {	
}
.STYLE6 {font-size: 14px}
.STYLE7 {color: #000000}
.STYLE8 {color: #70db93}
.STYLE10 {
	color: #0000ff;
	font-size: 18px;
	font-weight: bold;
}
.STYLE13 {
font-size:15px;
color: #000000; 
font-weight:bold;
}
.STYLE22 {
font-weight: bold

}
.STYLE20
{
position: absolute;  
left: 30px; 
top: 80px; 
height: 200px
}
</STYLE>

<script type="text/javascript">      
function changeValidateCode(obj) 
{      
var timenow = new Date().getTime();          
obj.src="servlet/Code?d="+timenow;      
}      
</script>
   </head> 
    <body style="background-image:url(img/schol.gif);"> 
      <form action="Login" method="post">
        <div class="STYLE20"> 
          <table style="background-image:url(img/blue.gif);" align="left" width="350" height="230" border="1"> 
           <tr><td style="text-align:center"><span class="STYLE13">用户名:</span></td><td><input type="text" name="username"/></td></tr>
          <tr><td style="text-align:center"><span class="STYLE13">密码:</span></td><td><input type="password" name="pwd"/></td></tr>
          <tr><td style="text-align:center"><span class="STYLE13">用户类型:</span></td><td><select type="select" name="Item" id="type"><option value="0">买家 </option>
          <option value="1">卖家</option>
          <option value="2">管理员 </option></select></td></tr>    
        <tr><td style="text-align:center"><span class="STYLE13">验证码:</span> </td><td><input type="text" name="code" size="11">&nbsp;&nbsp;<img src="servlet/Code" onclick="
changeValidateCode(this)" title="点击图片刷新验证码"/></td></tr> 
    <tr><td style="text-align:right"><input type="submit" value="登录"/></td><td><input type="button" onclick="window.location.href='mail/rigst.html'" value="注册"></td></tr>
        </table>  
      </div>
    </form>
  </body>
</html>
