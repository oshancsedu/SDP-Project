package p1;

import java.io.IOException;
import java.io.PrintWriter;
import javacode.user;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Oshan
 */
@WebServlet(name = "setMark", urlPatterns = {"/setMark"})
public class setMark extends HttpServlet {

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
        
        Boolean flag=false;
        HttpSession session=request.getSession();
        session.setAttribute("SetMark_msg", " ");session.setAttribute("SetMark_msg1", " ");session.setAttribute("SetMark_msg2", " ");
        session.setAttribute("SetMark_msg3", " ");session.setAttribute("SetMark_msg4", " ");session.setAttribute("SetMark_msg5", " ");
        session.setAttribute("SetMark_msg6", " ");
        
        if(request.getParameter("btSetMark").equalsIgnoreCase("Submit"))
        {
             flag=true;
             String reg_num=(String) request.getParameter("SetMarkreg_num");
             if(reg_num.equalsIgnoreCase(""))
                  session.setAttribute("SetMark_msg", "Enter a registration number");
             else
             {
                session.setAttribute("SetMark_msg", " ");
                user.u.setmark(session,reg_num,request);
             }
        }
        session.setAttribute("showSetMarkMsg", flag);
        String logType=(String) session.getAttribute("loginType");
        if(logType.equalsIgnoreCase("teacher"))
        request.getRequestDispatcher("setMark_teacher.jsp").forward(request, response);
        else if(logType.equalsIgnoreCase("admin"))
        request.getRequestDispatcher("setMark_admin.jsp").forward(request, response);
        
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
