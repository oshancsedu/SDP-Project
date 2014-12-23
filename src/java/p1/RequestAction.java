/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
@WebServlet(name = "RequestAction", urlPatterns = {"/RequestAction"})
public class RequestAction extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
     Statement st=null;
    
    public void init(){
         db_connect db= db_connect.get_connection();
             st=db.statement;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if(request.getParameter("btReq").equalsIgnoreCase("Add"))
        {
           request.getRequestDispatcher("/Reg1").forward(request, response);
        }
        else
        {
            ResultSet rs;
            try {
                rs = st.executeQuery("SELECT * FROM `request`");
                rs.next();
                String name=null,fname=null,pin=null;
                name=rs.getString(1);
                fname=rs.getString(2);
                pin=rs.getString(12);
                st.execute("DELETE FROM `request` WHERE name='"+name+"' and father_name='"+fname+"' and pin='"+pin+"'");
                
            } catch (SQLException ex) {
                Logger.getLogger(RequestAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        request.getRequestDispatcher("/ShowRequest").forward(request, response);
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
