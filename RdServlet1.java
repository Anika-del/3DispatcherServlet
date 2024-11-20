import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class RdServlet1 extends HttpServlet
{
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		
		PrintWriter out=res.getWriter();
		out.println("<html><body>");
	   // out.println("hello this login page");
		
		//out.println("<br>");
		
		
	    req.setAttribute("name","codesqadze");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		
		
		try
		{
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 
             Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
             Statement st=conn.createStatement();
			 
			// ResultSet rs = st.executeQuery("select * from emp101");
			 String s1 = "select * from emp102 where name='"+name+"' and pass='"+pass+"'";
			ResultSet rs1 = st.executeQuery(s1);
			
			out.println("before dispatcher");
		    out.println("</br>");
			 
			if(rs1.next())
			{
				
			 RequestDispatcher rd = req.getRequestDispatcher("wel");
            rd.include(req,res);
			  //rd.forward(req, res);
			}
			else
			{
				 RequestDispatcher rd = req.getRequestDispatcher("err");

				rd.forward(req, res);
		    }
		}catch(Exception e)
			 {
				 out.println(e);
				
			 }
			 out.println("</br>");
			 out.println("after request dispatcher from RdServlet1");
			out.println("</body></html>");
		
		
	}
	
}