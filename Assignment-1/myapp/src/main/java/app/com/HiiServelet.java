package app.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")

public class HiiServelet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("HiiServelet.init() called");
	}
	@Override
	public void destroy() {
		System.out.println("HiiServlet.destroy() called");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HiiServelet.doGet() called");
		processRequest(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HiiServelet.doPost() called");
		processRequest(req, resp);

	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hii</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hii from HiiServlet</h1>");
		Date now = new Date();
		out.println(now.toString());
		out.println("</body>");
		out.println("</html>");

		


		
		
	}
	

}
