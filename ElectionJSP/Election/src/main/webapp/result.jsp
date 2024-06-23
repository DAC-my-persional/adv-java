<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="tag" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
		<h1>${initParam.appTitle }</h1>
		
		<jsp:useBean id="res" class="com.election.beans.CandidateListBin"/>
		${res.fetchCandidate()}
		<table border="1">
			<thead>
				<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Party</th>
				<th>Votes</th>
				<th>Action</th>
				</tr>
			</thead>
			
			<tbody>
				<tag:forEach var="C" items="${res.candidateList }">
					<tr>
						<td>${C.id }</td>
						<td>${C.name }</td>
						<td>${C.party }</td>
						<td>${C.votes }</td>
						<td>
							<a href="editCandidate.jsp?id=${C.id }">
								<img src="https://webstockreview.net/images/how-to-edit-png-images-6.png" width='24' height='24'>
							</a>
							
							<a href="deleteCandidate.jsp?id=${C.id}">
								
								<img src="http://pluspng.com/img-png/delete-button-png-delete-icon-1600.png" width='24' height='24'>	
							</a>
						</td>
					</tr>				
				</tag:forEach>
			</tbody>
		</table>
		<br/><br/>
		
		<a href="announcement.jsp">Announcement</a>
		<a href="logout.jsp">Logout</a>
		
		
</body>
</html>