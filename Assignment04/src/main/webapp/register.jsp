<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<jsp:useBean id="rb" class="com.sunbeam.beans.RegisterBean"></jsp:useBean>
	<jsp:setProperty name="rb" property="firstName" param="first_name" />
	<jsp:setProperty name="rb" property="lastName" param="last_name" />
	<jsp:setProperty name="rb" property="email" param="email" />
	<jsp:setProperty name="rb" property="password" param="password" />
	<jsp:setProperty name="rb" property="dob" param="dob" />
	<jsp:setProperty name="rb" property="role" param="role" />

	<%
	int count = rb.registerUser();
	%>
	<%
	out.println(rb.getFirstName());
	%>
	<%
	if (count != 0) {
	%>
	<h3>Registration is Successful !!!</h3>
	Now you can 
	<a href="index.jsp">Login now</a>
	<%
	} else {
	%>
	<h3>Something went wrong!</h3>
	<%
	}
	%>
</body>
</html>