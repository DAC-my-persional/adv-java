<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vote</title>
</head>
<body>
		
		<h1>${initParam.appTitle }</h1>
		<jsp:useBean id="lb" class="com.election.beans.LoginBin" scope="session"/>
		<jsp:useBean id="vb" class="com.election.beans.VoteBin" />
		<jsp:setProperty property="id" name="vb" param="candidate"/>
		<jsp:setProperty property="user" name="vb"  value = "${lb.user}"/>
		
		${vb.voteIncrement()}
		
		<tag:choose>
			<tag:when test="${vb.count == 1}">
				Voted Done ..
			</tag:when>
			
			<tag:otherwise>
				Already Voted ..
			</tag:otherwise>
		</tag:choose>
		
		<a href="logout.jsp">Sign Out</a>
</body>
</html>