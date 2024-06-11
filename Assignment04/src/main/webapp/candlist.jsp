<%@page import="com.sunbeam.pojos.Candidate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate List</title>
</head>
<body>
	<form action="index.jsp">
		<h3>Online Voting</h3>
		<jsp:useBean id="cl" class="com.sunbeam.beans.CandidateListBean"></jsp:useBean>
		<%
		List<Candidate> list = cl.candidateList();
		%>
		<%
		for (Candidate c : list) {
		%>
		<%
		out.println("<input type='radio' name='candidate' value=" + c.getId() + "/>" + c.getName() + " (" + c.getParty() + ")\n");
		%>
		<br />
		<%
		}
		%>
		<br /> <input type="submit" value="VOTE">
	</form>
</body>
</html>