<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Blog List</title>
</head>
<body>
	<h1> ${initParam.appTitle} </h1>
		
		<br/>
		<br/>
		
		<jsp:useBean id="mb" class="com.blog.Bin.MyBlogListBin" scope="session" />
		<jsp:useBean id="lb" class="com.blog.Bin.LoginBin"/>
		<jsp:setProperty property="user" name="mb" value="${mb.user }"/>
		
		${ mb.myBlogList() }
		
		<table border="1">
			<thead>
				<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Contents</th>
				<th>Created Time</th>
				<th>User Id</th>
				<th>Category Id</th>
				</tr>
			</thead>
			
			<tbody>
			<%-- // internally called getBlogList(); --%>
				<tag:forEach var="b" items="${mb.blogList }">
					<tr>
						<td>${b.id }</td>
						<td>${b.title }</td>
						<td>${b.contents }</td>
						<td>${b.l1 }</td>
						<td>${b.userId }</td>
						<td>${b.categoryId }</td>
					</tr>				
				</tag:forEach>
			</tbody>
		</table>
		<br/>
		<br/>
		<a href="ctl?page=bloglist">Blogs</a>
		<br/><br/>		
</body>
</html>