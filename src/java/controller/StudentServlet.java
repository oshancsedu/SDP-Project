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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import schema.student;
//import org.student.model.student;

/**
 *
 * @author User
 */
public class StudentServlet extends HttpServlet {

   

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
        String name=request.getParameter("txtName");
        String username=request.getParameter("Username");
        String password=request.getParameter("password");
        String reg_num=request.getParameter("RegNo");
        String email=request.getParameter("emailContact");
        String mobile_no=request.getParameter("Contact");
        String gender= request.getParameter("gender");
        String dept_name=request.getParameter("Dept");
        String faculty=request.getParameter("facs");
        String session=request.getParameter("Session");
        
        student st=new student();
        
        st.setName(name);
        st.setUsername(username);
        st.setPassword(password);
        st.setReg_num(reg_num);
        st.setEmail(email);
        st.setMobile_no(mobile_no);
        st.setGender(gender);
        st.setDept_name(dept_name);
        st.setFaculty(faculty);
        st.setSession(session);
        
        try {   
            int p=st.store();
             if(p>0)
             {
                 response.sendRedirect("registrationsuccessful.jsp");
             }
             else
             {
                 response.sendRedirect("registrationUnsuccessful.jsp");
             }
        } catch (Exception ex) {
            Logger.getLogger(StudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //request.setAttribute("st", st);
        
        //RequestDispatcher dispatcher=request.getRequestDispatcher("result.jsp");
        
        //dispatcher.forward(request,response);
      
       
    }

    

}
