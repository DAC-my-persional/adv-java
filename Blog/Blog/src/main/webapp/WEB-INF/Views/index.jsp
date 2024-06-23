<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body>
		<h1> ${initParam.appTitle} </h1>
		<form method="post" action="ctl?page=login">
		 Email: <input type="text" name="email"/> <br/><br/>
		 Password: <input type="password" name="password"/> <br/><br/>		 
		 <input type="submit" Value="Sign In"/>
		 <br/><br/>
		 <a href="ctl?page=newuser">Sign Up</a>
		</form>
</body>
</html>