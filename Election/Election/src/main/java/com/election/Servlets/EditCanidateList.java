package com.election.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.DAO.CandidateDAO;
import com.election.DAO.CandidateDaoImpl;
import com.election.entity.Candidate;

@WebServlet("/editCandidate")
public class EditCanidateList extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idstr = request.getParameter("id");
		int id = Integer.parseInt(idstr);
		
		// find the candidate details in db
		
		Candidate c = null;
		
		try(CandidateDAO candidate = new CandidateDaoImpl())
		{
			c = candidate.findById(id);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Candidate</title>");
		out.println("</head>");
		out.println("<body>");
		
		ServletContext serv = this.getServletContext();
		// AppTitle will come on Static context inside a web.xml that will be call iinside this 
		String appTitle = serv.getInitParameter("AppTitle");
		out.printf("<h1>%s</h1>",appTitle);
		
		out.println("<form method='post' action='editCandidate'>");
//		out.printf("Id: <input type='text' name='id' value='%d' readonly/><br/><br/>\n", c.getId());
		out.printf("<input type='hidden' name='id' value='%d'/>\n", c.getId());
		out.printf("Name: <input type='text' name='name' value='%s'/><br/><br/>\n", c.getName());
		out.printf("Party: <input type='text' name='party' value='%s'/><br/><br/>\n", c.getParty());
		out.printf("Votes: <input type='text' name='votes' value='%d' readonly/><br/><br/>\n", c.getVotes());
		out.println("<input type='submit' value='Update Candidate'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String idstr = request.getParameter("id");
		int id = Integer.parseInt(idstr);
		
		String name = request.getParameter("name");
		String party = request.getParameter("party");
		String voteStr = request.getParameter("votes");
			
		int votes = Integer.parseInt(voteStr);
		
		Candidate c = new Candidate(id,name,party,votes);
		
		try(CandidateDAO candidate = new CandidateDaoImpl())
		{
			int count = candidate.update(c);
			
			String message = "Candidates Edited : "+count;
			request.setAttribute("message", message);
//			response.sendRedirect("result");
			
//			 RequestDispatcher rd  = request.getRequestDispatcher("result");
			ServletContext serv = this.getServletContext();
			
			// if we use  servlet context then it is calling with /result
			
			 RequestDispatcher rd = serv.getRequestDispatcher("/result");
			 rd.forward(request, response);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
