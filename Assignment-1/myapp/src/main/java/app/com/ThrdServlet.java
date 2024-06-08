package app.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThrdServlet extends HttpServlet {
	private String color = "";

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("ThirdServlet.init() is called");
		color = config.getInitParameter("color");
	}

	private void destory() {
		System.out.println("ThirdServlet.destroy() is called");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ThirdServlet.doGet() is called");
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ThirdServlet.doPost() is called");
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>third</title>");
		out.println("</head>");
		out.printf("<body bgcolor = '%s'>\n", color);
		out.println("<h1>Heyyyy, ThirdServlet</h1>");
		out.println("</body>");
		out.println("</html>");

	}
}
