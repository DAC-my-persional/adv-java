<%@page import="com.election.entity.Candidate"%>
<%@page import="com.election.beans.CandidateListBin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate List</title>
</head>
<body>
		<h1> ${initParam.appTitle} </h1>
		
		<br/>
		
	
		<jsp:useBean id="clb" class="com.election.beans.CandidateListBin" />
		
		<% clb.fetchCandidate(); %>
		
		${clb.fetchCandidate() }
				
		<form action="vote.jsp" method="post">
			<%-- <%for(Candidate c: clb.getCandidateList()) {%>
				<input type="radio" name="candidate" value = "<%= c.getId()%>"/> <%= c.getName() %> - <%= c.getParty() %> <br/>
			<% } %> --%>
			
			<%-- for each loop using java bean --%>
			<tag:forEach var="c" items="${clb.candidateList }">
				<input type="radio" name="candidate" value="${c.id}"/> ${c.name} - ${c.party} <br/>
			</tag:forEach>
			<br/>
			
			<input  type="submit"  value="vote" />
		</form>
</body>
</html>