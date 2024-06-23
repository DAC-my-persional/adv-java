<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blog List</title>
</head>
<body>
		<h1> ${initParam.appTitle} </h1>
		
		<br/>
		<br/>
		
		<jsp:useBean id="blb" class="com.blog.Bin.BlogListBin" />
		
		${ blb.fecthBlogs()}
		
		<a href="ctl?page=myBlogList">My Blogs</a>
		<br/><br/>
		<table border="1">
			<thead>
				<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Contents</th>
				<th>Created Time</th>
				<th>User Id</th>
				<th>Category Id</th>
				<th>Actions</th>
				</tr>
			</thead>
			
			<tbody>
			<%-- // internally called getBlogList(); --%>
				<tag:forEach var="b" items="${blb.blogList}">
					<tr>
						<td>${b.id }</td>
						<td>${b.title }</td>
						<td>${b.contents }</td>
						<td>${b.l1 }</td>
						<td>${b.userId }</td>
						<td>${b.categoryId }</td>
						<td>
							<a href="ctl?page=deleteBlog&id=${b.id }">
								<img src="http://pluspng.com/img-png/delete-button-png-delete-icon-1600.png" width='24' height='24'>
							</a>
						</td>
					</tr>				
				</tag:forEach>
			</tbody>
		</table>
		<br/>
		<br/>
		<a href="ctl?page=categories">Categories</a>
		<br/><br/>		
		
		<a href="ctl?page=logout">Logout</a>
</body>
</html>