<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
		<%-- <h3>Online Voting</h3> --%>
		
		<h1> ${initParam.appTitle} </h1>
		<form method="post" action="login.jsp">
		 Email: <input type="text" name="email"/> <br/><br/>
		 Password: <input type="password" name="password"/> <br/><br/>		 
		 <input type="submit" Value="Sign In"/>
		 <a href="newuser.jsp">Sign Up</a>
		</form>
</body>
</html>