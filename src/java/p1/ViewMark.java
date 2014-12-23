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
@WebServlet(name = "ViewMark", urlPatterns = {"/ViewMark"})
public class ViewMark extends HttpServlet {

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
        Boolean flag=false,table=false;
        HttpSession session=request.getSession();
        session.setAttribute("ViewMark_msg", " ");
        if(request.getParameter("btViewMark").equalsIgnoreCase("Submit"))
        {
             flag=true;
             String reg_num=(String) request.getParameter("ViewMarkreg_num");
             String course=(String) request.getParameter("course_code");
             if(reg_num.equalsIgnoreCase(""))
             {
                 session.setAttribute("ViewMark_msg", "Enter a registration number");
                 session.setAttribute("showViewMarkMsgTable", table);
             }
             else if(course.equalsIgnoreCase("-1"))
             {
                  session.setAttribute("ViewMark_msg", "Enter course code");
                  session.setAttribute("showViewMarkMsgTable", table);
             }
             else
             {
                session.setAttribute("ViewMark_msg", " ");
                user.u.getMark(session,reg_num,course);
             }
        }
        else
             session.setAttribute("showViewMarkMsgTable", table);
        session.setAttribute("showViewMarkMsg", flag);
        String logType=(String) session.getAttribute("loginType");
        if(logType.equalsIgnoreCase("teacher"))
        request.getRequestDispatcher("viewMark_teacher.jsp").forward(request, response);
        else if(logType.equalsIgnoreCase("student"))
        request.getRequestDispatcher("viewMark_student.jsp").forward(request, response);
        else
        request.getRequestDispatcher("viewMark_admin.jsp").forward(request, response);
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
