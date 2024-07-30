package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.GuestBookEntry;

/**
 * Servlet implementation class EditEntry
 */
@WebServlet("/EditEntry")
public class EditEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEntry() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private GuestBookEntry getEntryByID(int id) {
		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		for (GuestBookEntry entry : entries) {
			if (entry.getId() == id) {
				return entry;
			}
		}
		return null;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int id = Integer.parseInt(request.getParameter("id"));
		GuestBookEntry entry = getEntryByID(id);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<title>Guest Book</title>");
		out.println("<style>");
		
		out.println("</style>");
		out.println("</head><body>");
		out.println("<h2>Edit Comment</h2>");
		out.println("<form id='addCommentForm' action='EditEntry' method='post'>");
		out.println("<input type='hidden' id='id' name='id' value='" + id + "'");
		out.println("<label for='name'>Name: </label>");
		out.println("<input type='text' id='name' name='name' value='" + entry.getName() + " '>");
		out.println("<br />");
		out.println("<textarea id = 'message' name='message' rows='6' cols='40'>" + entry.getMessage() + "</textarea>");
		out.println("<br />");
		out.println("<button>Add Comment</button>");
		out.println("</form>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		int id = Integer.parseInt(request.getParameter("id"));
		GuestBookEntry entry = getEntryByID(id);
		entry.setName(request.getParameter("name"));
		entry.setMessage(request.getParameter("message"));
		
		response.sendRedirect("GuestBook");
		
	}

}