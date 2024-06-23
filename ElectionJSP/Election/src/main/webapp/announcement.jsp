<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Announcement</title>
</head>
<body>
		<h1>${initParam.appTitle }</h1>
		<form action="result.jsp" method="post">
			Announcement : <br/>
			<textarea name="announce" rows="6" cols="80"></textarea>
			<br/><br/>
			
			<input type="submit" value="Announce" />
		</form>
</body>
</html>