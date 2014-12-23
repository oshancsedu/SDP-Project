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
@WebServlet(name = "regDelete", urlPatterns = {"/regDelete"})
public class regDelete extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Boolean flag=false;
        HttpSession session=request.getSession();
        String type=request.getParameter("type");
        if(request.getParameter("btDelete").equalsIgnoreCase("Delete"))
        {
             flag=true;
             String reg_num=(String) request.getParameter("del_reg_num");
             if(reg_num.equalsIgnoreCase(""))
                  session.setAttribute("del_msg", "Enter a registration number"+reg_num);
             else
                 // session.setAttribute("del_msg", "Enter am registration number");
             user.u.deleteReg(session,reg_num,type);
        }
        session.setAttribute("showDeleteMsg", flag);
        request.getRequestDispatcher("del_reg.jsp").forward(request, response);
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
