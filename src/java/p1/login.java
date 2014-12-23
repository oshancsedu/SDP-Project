package p1;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javacode.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import schema.db_connect;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {
  
    Statement st=null;
    
    public void init(){
         db_connect db= db_connect.get_connection();
             st=db.statement;
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter Out=response.getWriter();
        String name=null,pass=null,reg_num=null;
       HttpSession session= request.getSession();
        if(request.getParameter("username")!=null && request.getParameter("password")!=null){
        session.setAttribute("username", request.getParameter("username"));
        session.setAttribute("password", request.getParameter("password"));}
        name=(String) session.getAttribute("username");
        pass=(String) session.getAttribute("password");
        try {
            ResultSet r= st.executeQuery("SELECT `Course_code` FROM `course`");
            String courseCode[]=new String[10000];
            int i=0;
            while(r.next()){
            courseCode[i]=r.getString(1);
            i++;
            }
            session.setAttribute("CourseCode", courseCode);
            session.setAttribute("#ofCourseCode", i);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        
	/*	name=request.getParameter("username");
		pass=request.getParameter("password");*/
                
                out.print("name "+name+" "+pass);
        try{
           ResultSet rs=st.executeQuery("select user_name,password,type,reg_num from login where user_name='"+name+"' and password='"+pass+"'");
           if(rs.next())
	    {
                user_factory uf=new user_factory();
                reg_num=rs.getString(4);
                
                session.setAttribute("reg_num",reg_num);
                session.setAttribute("loginType", rs.getString(3));
                if(rs.getString(3).equalsIgnoreCase("admin"))
                {
                    user.u=null;
                    user.u=uf.setUser("admin");
                    user.u.profile(session);
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                }
                else if(rs.getString(3).equalsIgnoreCase("teacher"))
                {
                    user.u=null;
                    user.u=uf.setUser("teacher");
                    user.u.profile(session);
                    request.getRequestDispatcher("teacher.jsp").forward(request, response);
                }
                else if(rs.getString(3).equalsIgnoreCase("student"))
                {
                    user.u=uf.setUser("student");
                    user.u.profile(session);
                    request.getRequestDispatcher("student.jsp").forward(request, response);
                }
                else
	       	 request.getRequestDispatcher("loginerror.jsp").forward(request, response);
	    }
	    else
	    {
	       	 request.getRequestDispatcher("loginerror.jsp").forward(request, response);
                /*response.getWriter().print("<h1>Hello</h1> "+ request.getParameter("username"));
                  response.getWriter().print("<h1>Hello</h1> "+name+" "+pass );*/
	    }   
                 }catch(Exception e){
                   Out.println("error in connection: "+e);
                 }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
