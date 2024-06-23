package com.election.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.DAO.CandidateDAO;
import com.election.DAO.CandidateDaoImpl;

@WebServlet("/deleteCandidate")
public class DeleteCandidateList extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idstr = request.getParameter("id");
		int id = Integer.parseInt(idstr);
		
		try(CandidateDAO candidate = new CandidateDaoImpl())
		{
			int count = candidate.deleteById(id);
			String message = "Candidates Deleted : "+count;
			request.setAttribute("message",message);
			
			ServletContext serv = this.getServletContext();
			// here only the difference is that if we use servlet context then we add "/result"
			RequestDispatcher rd = serv.getRequestDispatcher("/result");
			rd.forward(request, response);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
	

}
