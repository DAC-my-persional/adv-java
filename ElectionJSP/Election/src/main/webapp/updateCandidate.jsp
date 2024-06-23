<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Candidate</title>
</head>
<body>
		<h1>${initParam.appTitle }</h1>
		<jsp:useBean id="ucb" class="com.election.beans.UpdateCandidateBin" />
		<jsp:setProperty property="*" name="ucb" />
		
		${ucb.updateCandidate() }
		
		<tag:choose>
			<tag:when test="${ucb.count == 1 }">
				<tag:redirect url="result.jsp"/>
			</tag:when>
			
			<tag:otherwise>
				Candidate update failed ..
				<br/><br/>
				<a href="result.jsp">Show Result</a>
			</tag:otherwise>
		</tag:choose>
		
		
</body>
</html>