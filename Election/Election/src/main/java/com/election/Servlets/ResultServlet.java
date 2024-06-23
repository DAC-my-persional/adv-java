package com.election.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.DAO.CandidateDAO;
import com.election.DAO.CandidateDaoImpl;
import com.election.entity.Candidate;

//@WebServlet("/result");
public class ResultServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resposnse) throws ServletException, IOException {
		processRequest(request, resposnse);
	}

	protected  void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException , IOException
	{
		List<Candidate> candidateList = new ArrayList<Candidate>();
		try(CandidateDAO candidate = new CandidateDaoImpl())
		{
			candidateList = candidate.findAll();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidates Result</title>");
		out.println("</head>");
		out.println("<body>");
		

		ServletContext serv = this.getServletContext();
		String appTitle = serv.getInitParameter("AppTitle");
		out.printf("<h1>%s</h1>",appTitle);
		
//		out.println("<h3>Candidates List</h3>");
		
//		
//		String userName = "";
//		Cookie[] arr = request.getCookies();
		
//		if(arr != null)
//		{
//			for(Cookie c :arr)
//			{
//				if(c.getName().equals("uname"))
//				{
//				
//		userName = c.getValue();
//					break;
//				}
//			}
//		}
//		
//		out.printf("Hello , %s<hr/>\n",userName);
		out.println("<table border = '1'>");
		out.println("<thead>");
		out.println("<th>id</th>");
		out.println("<th>name</th>");
		out.println("<th>party</th>");
		out.println("<th>votes</th>");
		out.println("<th>Action</th>");
		out.println("</thead>");
		out.println("<tbody>");
		for(Candidate c: candidateList)
		{
			out.println("<tr>");
			out.printf("<td>%d</td>\n",c.getId());
			out.printf("<td>%s</td>\n",c.getName());
			out.printf("<td>%s</td>\n",c.getParty());
			out.printf("<td>%d</td>\n",c.getVotes());
			out.printf("<td><a href='editCandidate?id=%d'><img width='24' height='24' src='https://webstockreview.net/images/how-to-edit-png-images-6.png'/></a> <a href='deleteCandidate?id=%d'><img width='24' height='24' src='http://pluspng.com/img-png/delete-button-png-delete-icon-1600.png'/></a></td>\n", c.getId(), c.getId());
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("<br/>");
		out.println("<br/>");
		String message = (String) request.getAttribute("message");
		if(message != null)
			out.println("<br/><br/>" +message + "<br/><br/>");
		
		out.println("<br/>");
		out.println("<a href='announcement.html'>Announcement</a>");
		out.println("<a href='logout'>Sign Out</a>");
		out.println("</body>");
		out.println("</html>");
	}
}
