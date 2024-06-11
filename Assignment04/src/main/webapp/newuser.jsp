<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
</head>
<body>
	<div style="text-align: center;">
		<form action="register.jsp">
			<h2>Register Here Now!</h2>
			First Name <input type="text" name="first_name"> <br /> <br />
			Last Name <input type="text" name="last_name"> <br /> <br />
			Email <input type="text" name="email"> <br /> <br />
			Password <input type="text" name="password"> <br /> <br />
			Date of Birth <input type="date" name="dob"> <br /> <br />
			Select your Role. <br /> Admin <input type="radio" name="role"
				value="Admin"> <br /> Voter <input type="radio" name="role"
				value="Voter"> <br /> <br /> <input type="submit"
				value="Register!"> <br /> Already have an Account? <a
				href="index.jsp">Log In</a> <br />
		</form>
	</div>
</body>
</html>