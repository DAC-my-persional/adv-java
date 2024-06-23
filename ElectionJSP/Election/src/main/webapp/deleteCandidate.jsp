<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Candidate</title>
</head>
<body>
		<h1>${initParam.appTitle }</h1>
		<jsp:useBean id="dcb" class="com.election.beans.DeleteCandidateBin"/>
		<jsp:setProperty property="id" name="dcb" param="id"/>
		
		 ${dcb.deleteCandidate() }
		 
		 <tag:choose>
		 	<tag:when test="${dcb.count == 1 }">
		 		Deleted Successfully ..
		 		<tag:redirect url="result.jsp"/>
		 	</tag:when>
		 	
		 	<tag:otherwise>
		 		Deleted Failed ..
		 	</tag:otherwise>

		 </tag:choose>
		 
</body>
</html>