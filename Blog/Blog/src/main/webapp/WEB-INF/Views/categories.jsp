<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Categories</title>
</head>
<body>
		<h1> ${initParam.appTitle} </h1>
		<br/>
		<br/>
		
		<jsp:useBean id="clb" class="com.blog.Bin.CategoryListBin"/>
		
		${clb.fetchCategories() }
		<table border="1">
			<thead>
				<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Description</th>
				</tr>
			</thead>
			
			<tbody>
			<%-- // internally called getBlogList(); --%>
				<tag:forEach var="c" items="${clb.categroiesList}">
					<tr>
						<td>${c.id }</td>
						<td>${c.title }</td>
						<td>${c.description }</td>
					</tr>				
				</tag:forEach>
			</tbody>
		</table>
		<br/><br/>		
		
</body>
</html>