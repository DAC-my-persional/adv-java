<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<h1>${initParam.appTitle}</h1>
	<jsp:useBean id="rb" class="com.blog.Bin.RegistrationBin" />
	<jsp:setProperty property="*" name="rb"/>
	
	${rb.registerUser() }
	
		<tag:choose>
			<tag:when test="${rb.count == 1 }">
				Registration Successful .
				<a href="ctl?page=index">Sign In</a>
			</tag:when>
			<tag:otherwise>
				Registration Failed .
				<a href="ctl?page=newuser">Sign Up</a>
			</tag:otherwise>
		</tag:choose>
		
</body>
</html>