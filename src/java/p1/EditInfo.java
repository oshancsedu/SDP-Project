/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p1;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
@WebServlet(name = "EditInfo", urlPatterns = {"/EditInfo"})
public class EditInfo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
     Statement Newst=null;
    
    public void init(){
         db_connect db= db_connect.get_connection();
             Newst=db.statement;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       init();
       HttpSession session= request.getSession();
       String address=(String) request.getParameter("address");
       String division=(String) request.getParameter("division");
       String city=(String) request.getParameter("city");
       String mobile=(String) request.getParameter("mobile");
       String mail=(String) request.getParameter("mail");
       String user=(String)session.getAttribute("loginType");
       String reg_num=(String)session.getAttribute("reg_num");
       String table=null;
       if(user.equalsIgnoreCase("admin"))
           table="admin_info";
       else if(user.equalsIgnoreCase("student"))
           table="student_info";
       else
           table="teacher_info";
       try {
           
       if(!division.equalsIgnoreCase(""))
           Newst.execute("UPDATE `"+table+"` SET `Division`='"+division+"' WHERE Registration_Number='"+reg_num+"'");
       if(!city.equalsIgnoreCase(""))
           Newst.execute("UPDATE `"+table+"` SET `City`='"+city+"' WHERE Registration_Number='"+reg_num+"'");
       if(!mobile.equalsIgnoreCase(""))
           Newst.execute("UPDATE `"+table+"` SET `Mobile_No`='"+mobile+"' WHERE Registration_Number='"+reg_num+"'");
       if(!address.equalsIgnoreCase(""))
           Newst.execute("UPDATE `"+table+"` SET `Address`='"+address+"' WHERE Registration_Number='"+reg_num+"'");
       if(!mail.equalsIgnoreCase(""))
           Newst.execute("UPDATE `"+table+"` SET `Email`='"+mail+"' WHERE Registration_Number='"+reg_num+"'");
       } catch (SQLException ex) {
           Logger.getLogger(EditInfo.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       request.setAttribute("username", session.getAttribute("username"));
       request.setAttribute("password", session.getAttribute("password"));
        request.getRequestDispatcher("/login").forward(request, response);
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
