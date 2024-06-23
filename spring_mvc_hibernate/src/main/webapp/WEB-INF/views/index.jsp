<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>Welcome to Spring MVC !!!!!</h5>
	<h5>
		<c:url var="url" value="/test/multiply?num1=123&num2=456" />
		<a href="${url}">Test Model Map with Request Parameters</a>
	</h5>
	<h5>
		<c:url var="url" value="/posts/view?categoryName=category-1" />
		<a href="${url}">List Blog Posts By Category Name</a>
	</h5>
</body>
</html>