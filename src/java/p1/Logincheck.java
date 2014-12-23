package p1;
import java.io.*;
import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class sample
 */

@WebServlet(name = "Logincheck", urlPatterns = {"/Logincheck"})
public class Logincheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter Out=response.getWriter();
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		
		/*try
		{		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/versity?user=root");
	    Statement st=con.createStatement();
	    ResultSet rs=st.executeQuery("select user,pass from log where user='"+name+"' and pass='"+pass+"'");
	    if(rs.next())
	    {*/
	         
	            
	        	 request.getRequestDispatcher("welcome.jsp").forward(request, response);
	   /* }
	    else
	    {
	        	 request.getRequestDispatcher("loginerror.jsp").forward(request, response);
	    }*/
	        
	         
                /*}catch(IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException | ServletException e)
		 {
		   Out.println("error in connection:"+e);
		 }*/
	}
	}