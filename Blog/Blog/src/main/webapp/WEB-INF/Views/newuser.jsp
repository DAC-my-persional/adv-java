<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
</head>
<body>	
	<h1> ${initParam.appTitle} </h1>
		<form method="post" action="ctl?page=register">
			Full Name: <input type="text" name="fullName"/> <br/><br/>
		 	Email: <input type="text" name="email"/> <br/><br/>
		 	Password: <input type="password" name="password"/> <br/><br/>
		 	Phone Number :  <input type="text" name="phoneNo"/> <br/><br/>
		 	Address : <input type="text" name="address" />	<br/><br/>	 	
		 <input type="submit" Value="Register"/>
		</form>
</body>
</html>