<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>

		<h1>${initParam.appTitle}</h1>
		<jsp:useBean id="rb" class="com.election.beans.RegistartionBin" />
		<jsp:setProperty name="rb" property="firstName" param="firstName"/>
		<jsp:setProperty name="rb" property="lastName" param="lastName"/>
		<jsp:setProperty name="rb" property="email" param="email"/>
		<jsp:setProperty name="rb" property="password" param="password"/>
		<jsp:setProperty name="rb" property="date" param="date"/>
		<jsp:setProperty name="rb" property="status" value="0"/>
		<jsp:setProperty name="rb" property="role" value="voter"/>
		
		<%-- <% rb.registerUser(); %> --%>
		
		${ rb.registerUser() }
		<%-- <% if(rb.getCount() == 1) {%>
			Registration Successful 
			<a href="index.jsp">Sign In</a>
		<% } else { %>
			Registration Failed.
			<a href="newuser.jsp">Sign In</a>
		<% } %> --%>
		<tag:choose>
			<tag:when test="${rb.count == 1 }">
				Registration Successful .
				<a href="index.jsp">Sign In</a>
			</tag:when>
			<tag:otherwise>
				Registration Failed .
				<a href="newuser.jsp">Sign Up</a>
			</tag:otherwise>
		</tag:choose>
		
</body>
</html>