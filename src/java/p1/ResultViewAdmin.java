package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javacode.user;
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
@WebServlet(name = "ResultViewAdmin", urlPatterns = {"/ResultViewAdmin"})
public class ResultViewAdmin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        db_connect db=db_connect.get_connection();
        Statement st=db.statement;
        String req=(String)request.getParameter("btResultYear");
        HttpSession session=request.getSession();
        session.setAttribute("result_status"," ");
        session.setAttribute("ViewResultMsg"," ");
        session.setAttribute("ResultGrade",null);
        session.setAttribute("ResultCourse",null);
        session.setAttribute("RV#ofcourse", 0);
        String semi=request.getParameter("semester");
        String year=request.getParameter("year");
        String type=request.getParameter("resultType");
        String Rnum=request.getParameter("RV_reg_num");
        if(req.equalsIgnoreCase("Complete"))
        {
            if(semi.equalsIgnoreCase("-1"))
                session.setAttribute("result_status","Enter semester correctly");
            else if(year.equals(""))
                 session.setAttribute("result_status","Enter year correctly");
            else
            try {
                ResultSet rs=st.executeQuery("SELECT * FROM `result_status` WHERE year='"+year+"' and semester='"+semi+"'");
                if(rs.next()){
                    session.setAttribute("result_status","This result has already been published");
                }
                else{
                    st.execute("INSERT INTO `result_status`(`semester`, `result_status`, `year`) VALUES ('"+semi+"','complete',"+year+")");
                    session.setAttribute("result_status","Result has been published");
                }
                
            } catch (SQLException ex) {
               session.setAttribute("result_status","Erron occur "+ex);
            }
        }
        else if(req.equalsIgnoreCase("submit")){
            if(semi.equalsIgnoreCase("-1"))
                session.setAttribute("ViewResultMsg","Enter semester correctly");
            else if(year.equals(""))
                 session.setAttribute("ViewResultMsg","Enter year correctly");
            else if(Rnum.equals(""))
                 session.setAttribute("ViewResultMsg","Enter registration number correctly");
            else{
                 try {
                     double num[]=new double[20];
                     double tnum[]=new double[20];
                     String g[][]=new String[15][2];
                     String course[]=new String[15];
                     int i=0;
                     ResultSet rs=st.executeQuery("SELECT * FROM `result_status` WHERE year='"+year+"' and semester='"+semi+"'");
                     if(rs.next()){
                     rs= st.executeQuery("select course_code,sum(mark) mark,sum(total_mark) totalmark,credit from mark natural join course where semester = '"+semi+"' and reg_num='"+Rnum+"' group by course_code");             
                     while(rs.next()){
                         course[i]=rs.getString(1);
                         num[i]=rs.getDouble(2);
                         tnum[i]=rs.getDouble(3);
                         i++;
                     }
               
                     g=user.u.viewresult(num, tnum,course,type,i);
                     //st.executeQuery("INSERT INTO `result`(`reg_num`, `course_code`, `gpa`) VALUES ('"+Rnum+"','"+course[i]+"',"+g[i][0]+")");
                     course[i]="Final Result";
                     session.setAttribute("ResultGrade",g);
                     session.setAttribute("ResultCourse",course);
                     session.setAttribute("RV#ofcourse", i);
                     session.setAttribute("ViewResultMsg","Result has published");
                     }
                     else{
                         session.setAttribute("ViewResultMsg","Result hasn't published yet");
                     }
                     
                     } catch (SQLException ex) {
                     session.setAttribute("ViewResultMsg","Error occur");
                 }
            }
        }
        
        String logType=(String) session.getAttribute("loginType");
        
        if(logType.equalsIgnoreCase("admin"))
        request.getRequestDispatcher("result_admin.jsp").forward(request, response);
        else if(logType.equalsIgnoreCase("student"))
        request.getRequestDispatcher("result_student.jsp").forward(request, response);
        else if(logType.equalsIgnoreCase("teacher"))
        request.getRequestDispatcher("result_teacher.jsp").forward(request, response);
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
