<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Categories</title>
</head>
<body>
		<h1>${initParam.appTitle }</h1>
		<jsp:useBean id="cl" class="com.blog.Bin.CategoryListBin"/>
		<jsp:setProperty property="id" name="cl" param="id"/>
		
		${cl.fetchCategories() }
		
		<form method="post" action="ctl?page=updateBlogs">
		<input type="hidden" name="id" value="${cl.categories.id}"/>
		Name: <input type="text" name="name" value="${cl.categories.title}"/> <br/><br/>
		Party: <input type="text" name="party" value="${fcb.categories.description}"/> <br/><br/>
		Votes: <input type="text" name="votes" value="${fcb.candidate.votes}" readonly="readonly"/> <br/><br/>
		<input type="submit" value="Update Candidate"/>
	</form>
		
</body>
</html>