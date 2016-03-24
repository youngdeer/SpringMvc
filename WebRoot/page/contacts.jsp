<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
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
    <h2>Contact Manager</h2> 
	<form action="addContact.html" method="post">  
		First Name:<input type="text" name="firstname" />
		<p>
		Last Name:<input type="text" name="lastname" />
		<p>
		Email:<input type="text" name="email" />
		<p>
		Telephone:<input type="text" name="telephone" />
		<p>
		<input type="submit" value="Add Contact" />  
	</form>
  </body>
</html>
