<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="product_bean" 
class="com.sunbeam.beans.ProductBea" scope="session"/>
<body>
	<h3>
		Welcome 2 Web App with Hibernate @
		<%=new Date()%></h3>
	<h5>
		<a href="add_product.jsp">Add Product</a>
	</h5>
</body>
</html>