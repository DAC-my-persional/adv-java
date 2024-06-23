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

//@WebServlet("/candidateList");
public class CandidateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException
	{
		List<Candidate> candidateList = new ArrayList<Candidate>();
		try(CandidateDAO candidate = new CandidateDaoImpl())
		{
			 candidateList = candidate.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidate List</title>");
		out.println("</head>");
		out.println("<body>");
//		out.println("<h1>Online Voting</h1>");
		
		ServletContext serv1 = this.getServletContext();
		// Here AppTitle will come on web.xml
		String appTitle = serv1.getInitParameter("AppTitle");
		out.printf("<h1>%s</h1>",appTitle);
		
		String username = "";
		Cookie[] arr = request.getCookies();
		if(arr != null)
		{
			for(Cookie c : arr)
			{
				if(c.getName().equals("uname"))
				{
					username = c.getValue();
					break;	
				}
			}
		}
		
		out.printf("Hello , %s<hr/>\n",username);
		
		ServletContext serv = this.getServletContext();
		 String message = (String) serv.getAttribute("announcement");
		 if(message != null)
			 out.printf("Announcement : %s <br/><br/>\n",message);
		out.println("<form method='post' action='vote'>");
		for(Candidate c: candidateList)
		{
			out.printf("<input type = 'radio' name= 'candidate' value='%d'/> %s (%s) <br/> \n",c.getId(), c.getName(), c.getParty());
		}
		out.println("<input type='submit' value='vote'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
