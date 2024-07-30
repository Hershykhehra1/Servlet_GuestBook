package cs3220.servlet;

import cs3220.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuestBook
 */
@WebServlet(urlPatterns="/GuestBook", loadOnStartup=1)
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestBook() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	List<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
    	entries.add(new GuestBookEntry("John", "Hello!"));
    	entries.add(new GuestBookEntry("Jane", "Hello Again!"));
    	
    	getServletContext().setAttribute("entries", entries);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<title>Guest Book</title>");
		out.println("<style>");
		out.println("table {"
	            + "margin: auto;"
	            + "border-collapse: collapse;"
	            + "border: 1px solid black;"
	            + "}");
	    out.println("th, td {"
	            + "border: 1px solid black;"
	    		+ "padding: 5px"
	            + "}");
		out.println("</style>");
		out.println("</head><body>");
		out.println("<h2>Guest Book</h2>");
		out.println("<table>");
		out.println("<tr><th>Name</th><th>Message</th><th>Edit | Delete</th>");
		for (GuestBookEntry entry : entries) {
			out.println("<tr>");
			out.println("<td>" + entry.getName() + "</td>");
			out.println("<td>" + entry.getMessage() + "</td>");
			out.println("<td><a href='EditEntry?id=" + entry.getId() + "'>Edit<a/> | "
					+ "<a href='DeleteEntry?id=" + entry.getId() + "'>Delete</a></td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<p><a href='AddComment'>Add Comment</a></p>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}