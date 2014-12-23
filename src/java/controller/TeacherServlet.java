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
import schema.teacher;
//import org.teacher.model.teacher;

/**
 *
 * @author User
 */
public class TeacherServlet extends HttpServlet {

    

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
        String id=request.getParameter("id");
        String name=request.getParameter("Name");
        String username=request.getParameter("Username");
        String password=request.getParameter("Password");
        String designation=request.getParameter("Designation");
        String email=request.getParameter("Email");
        String mobile_no= request.getParameter("contact");
        String dept_name=request.getParameter("Department");
        String gender=request.getParameter("Gender");
        
        teacher th=new teacher();
        
        th.setId(id);
        th.setName(name);
        th.setUsername(username);
        th.setPassword(password);
        th.setDesignation(designation);
        th.setEmail(email);
        th.setMobile_no(mobile_no);
        th.setDept_name(dept_name);
        th.setGender(gender);
        
        try {
            int p=th.store();
            if(p>0)
            {
                response.sendRedirect("registrationSuccessful1.jsp");
            }
            else
            {
                response.sendRedirect("registrationUnsuccessful1.jsp");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TeacherServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TeacherServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    

}
