<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean"></jsp:useBean>
	<jsp:setProperty property="email" name="lb" param="username" />
	<jsp:setProperty property="password" name="lb" param="pw" />
	<%
	lb.authenticate();
	%>
	<%
	if (lb.getUser() != null) {
	%>
	<jsp:forward page="candlist.jsp"/>
	<%
	} else {
	%>
	<h3>Login Failed</h3>
	<%
	}
	%>
</body>
</html>