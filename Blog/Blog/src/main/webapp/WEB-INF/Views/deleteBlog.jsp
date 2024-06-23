<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Blog</title>
</head>
<body>
	<h1>${initParam.appTitle }</h1>
	<jsp:useBean id="db" class="com.blog.Bin.DeleteBlogBin"/>
	<jsp:setProperty property="id" name="db" param="id"/>
	
	${db.deleteCandidate() }
	
	<tag:choose>
		<tag:when test="${db.count == 1 }">
			Deleted Successfully ..
			<tag:redirect url="ctl?page=bloglist"/>
		</tag:when>
		
		<tag:otherwise>
			Deleted Failed ..
		</tag:otherwise>
	</tag:choose>
</body>
</html>