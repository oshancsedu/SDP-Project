/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import schema.admin;
//import org.teacher.login.TeacherLogin;

/**
 *
 * @author User
 */
public class TeacherLoginServlet extends HttpServlet {

   
   

    
    

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
       String username=request.getParameter("username");
       String password=request.getParameter("password");
       
       admin login=new admin();login.setUsername(username);
       login.setPassword(password);
       
        try {
            boolean b=login.Check();
            if(b)
            {
                response.sendRedirect("teacherAccess.jsp");
            }
            else
            {
                response.sendRedirect("Unsuccessful1.jsp");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TeacherLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TeacherLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    
    

}
