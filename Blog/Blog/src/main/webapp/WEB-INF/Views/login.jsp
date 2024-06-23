<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
		<jsp:useBean id="lb" class="com.blog.Bin.LoginBin" scope="session"/>
		<jsp:setProperty property="*" name="lb"/>
		
		${lb.authenticate()}
		
		<tag:choose>
			<tag:when test="${lb.getUser() != null }">
				<tag:redirect url="ctl?page=bloglist"/>
			</tag:when>
			
			<tag:otherwise>
				<h1> ${initParam.appTitle} </h1>
				Invalid email or Password 
				<a href="ctl?page=index">Login Again</a>
			</tag:otherwise>
		</tag:choose>
		
</body>
</html>