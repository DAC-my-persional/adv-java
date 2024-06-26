<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blogger's Home Page</title>
</head>
<body>
	<h5 align="center">${requestScope.message}</h5>

	<c:set var="role" value="${sessionScope.user_details.role }" />
	<table style="background-color: lightgrey; margin: auto" border="1">
		<caption>All Blogs</caption>
		<tr>
			<th>Post ID</th>
			<th>Last Updated</th>
			<th>Post Title</th>
			<th>Description</th>

			<th>Action</th>
			<th>Action</th>
		</tr>
		<c:forEach var="post" items="${requestScope.posts}">
			<tr>
				<td>${post.id}</td>
				<td>${post.updatedOn}</td>
				<td>${post.title}</td>
				<td>${post.description}</td>
				<td><a
					href="<c:url value='/blogger/update_post?id=${post.id}'/>">Update
				</a></td>
				<td><a
					href="<c:url value='/blogger/delete_post?postId=${post.id}'/>">Delete
				</a></td>

			</tr>

		</c:forEach>

	</table>
	<h5>
		<a href="<c:url value='/blogger/new_blog'/>">Create New Blog</a>
	</h5>
	<h5>
		<c:url var="url" value="/user/logout" />
		<a href="${url}">Log Me Out</a>
	</h5>

</body>
</html>