/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import schema.db_connect;

/**
 *
 * @author Oshan
 */
@WebServlet(name = "Request", urlPatterns = {"/Request"})
public class Request extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
                String name=request.getParameter("name");
		String user_name=request.getParameter("username");
		String pass=request.getParameter("password");
		String email=request.getParameter("emailid");
		String sex=request.getParameter("sex");
                String fname=request.getParameter("fathername");
                String mname=request.getParameter("mothername");
		String add=request.getParameter("address");
		String divi=request.getParameter("division");
                String course=request.getParameter("course");
                String city=request.getParameter("city");
                String mobile=request.getParameter("mobileno");
                String status=request.getParameter("status");
                String year=request.getParameter("year");
                String pin=request.getParameter("pin");
                String reg_num=year;
        
                db_connect db= db_connect.get_connection();
                Statement st=db.statement;
        try {
            st.execute("insert into request (name,father_name,mother_name,address,division,"
                    + "city,course,year,mobile_no,email,sex,pin,user_name,password,status)"
                    + " values('"+name+"','"+fname+"','"+mname+"','"+add+"','"+divi+"',"
                    + "'"+city+"','"+course+"','"+year+"','"+mobile+"','"+email+"',"
                    + "'"+sex+"',"
                    + "'"+pin+"','"+user_name+"','"+pass+"','"+status+"')");
        } catch (SQLException ex) {
            Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        request.getRequestDispatcher("request.jsp").forward(request, response);
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