import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class ErrServlet extends GenericServlet
{
	
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body>");
	    out.println("invalid user babri pooch");
		out.println("<br>");
		
		out.println("<br>");
		
		
			out.println("</body></html>");
		}
		
	
	
}