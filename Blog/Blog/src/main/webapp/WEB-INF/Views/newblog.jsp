<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Blog</title>
</head>
<body>
		<h1>${initParam.appTitle }</h1>
		
		<br/><br/>
		
		<form method="post" action="ctl?page=addBlog">
			Title: <input type="text" name="title"/> <br/><br/>
		 	Contents: <input type="text" name="contents"/> <br/><br/>
		 	User Id: <input type="text" name="userId"/> <br/><br/>
		 	Category Id :  <input type="text" name="categoryId"/> <br/><br/>
		 			 	
		 <input type="submit" Value="Add Blog"/>
		</form>
		
</body>
</html>