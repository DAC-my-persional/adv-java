<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blog Post List Page</title>
</head>
<body>

	<table style="background-color: lightgrey; margin: auto" border="1">
		<caption>Blog Posts by Category ${param.categoryName}</caption>
		<tr>
			<th>Post ID</th>
			<th>Last Updated</th>
			<th>Title</th>
			<th>Description</th>
		</tr>
		<c:forEach var="post" items="${requestScope.blog_list}">
			<tr>
				<td>${post.id}</td>
				<td>${post.updatedOn}</td>
				<td>${post.title}</td>
				<td>${post.description}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>