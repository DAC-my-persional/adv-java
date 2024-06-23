<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
		<jsp:useBean id="lb" class="com.election.beans.LoginBin" scope="session"/>
		<jsp:setProperty property="*" name="lb"/>
		
		<%-- <% lb.authenticate(); %> --%>
		
		${lb.authenticate()}
		
		<%-- <% if(lb.getUser() != null) { %>
				<% if(lb.getUser().getRole().equals("voter")) { %>
						<%-- <jsp:forward page="candidateList.jsp" /> --%>
						<%-- <tag:redirect url = "candidateList.jsp"/> --%>
				<%-- else --%>
						<%-- <jsp:forward page="result.jsp" /> --%>
						<%-- <tag:redirect url = "result.jsp" /> --%>
				<%-- } --%>
		<%--  else --%>
				<%-- <h1>Online Voting</h1>
				Hello , <jsp:getProperty property="email" name="lb"/> <br/> --%>
				<%-- <h1>${initParam.appTitle})</h1>
				Hello , ${lb.email} <br/>
				Invalid Email or Password <br/><br/>
				<a href="index.jsp">Login Again</a> --%>
		<%-- }-- --%>
		
		<tag:choose>
				<tag:when test="${lb.user.role == 'voter'}">
					<tag:redirect url="candidateList.jsp" />
				</tag:when>
				<tag:when test="${lb.user.role == 'admin' }">
					 <tag:redirect  url= "result.jsp" />
				</tag:when>
				
				<tag:otherwise>
					<h1>${initParam.appTitle}</h1>
					Hello , ${lb.email }<br/>
					Invalid email or password 
					<a href="index.jsp">Login Again</a>
				</tag:otherwise>
		</tag:choose>
</body>
</html>