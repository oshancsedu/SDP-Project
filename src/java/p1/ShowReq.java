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
import javax.servlet.http.HttpSession;
import schema.db_connect;

/**
 *
 * @author Oshan
 */
@WebServlet(name = "ShowReq", urlPatterns = {"/ShowReq"})
public class ShowReq extends HttpServlet {

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
        
        db_connect db= db_connect.get_connection();
        Statement st=db.statement;
        HttpSession session=request.getSession();
        String name[]=new String[10000];
        String Fathername[]=new String[10000];
        String pin[]=new String[10000];
        try {
            ResultSet rs= st.executeQuery("SELECT name,father_name,pin FROM `request`");
            int i=0;
            while(rs.next())
            {
                name[i]=rs.getString(1);
                Fathername[i]=rs.getString(2);
                pin[i]=rs.getString(3);
                i++;
            }
            session.setAttribute("NumOfReq",i);
            session.setAttribute("name_req", name);
            session.setAttribute("pin_req", pin);
            session.setAttribute("fathername_req", Fathername);
            
        } catch (SQLException ex) {
            Logger.getLogger(ShowReq.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("show_req.jsp").forward(request, response);
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
