package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javax.swing.JOptionPane;
import schema.db_connect;

/**
 *
 * @author Oshan
 */
@WebServlet(name = "Reg1", urlPatterns = {"/Reg1"})
public class Reg1 extends HttpServlet {

    
     Statement st=null;
    
    public void init(){
         db_connect db= db_connect.get_connection();
             st=db.statement;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out=response.getWriter();
       String name=null,user_name=null,pass=null,email=null,sex=null,fname=null,mname=null,add=null,divi=null,course=null,city=null,mobile=null,status=null,year=null,pin=null;
       init();
            try {
                ResultSet rs= st.executeQuery("SELECT * FROM `request`");
                rs.next();
                name=rs.getString(1);
		user_name=rs.getString(13);
		pass=rs.getString(14);
		email=rs.getString(10);
                sex=rs.getString(11);
                fname=rs.getString(2);
                mname=rs.getString(3);
		add=rs.getString(4);
		divi=rs.getString(5);
                course=rs.getString(7);
                city=rs.getString(6);
                mobile=rs.getString(9);
                status=rs.getString(15);
                year=rs.getString(8);
                pin=rs.getString(12);
                st.execute("DELETE FROM `request` WHERE name='"+name+"' and father_name='"+fname+"' and pin='"+pin+"'");
                
            } catch (SQLException ex) {
                Logger.getLogger(RequestAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                String reg_num=year;
                
                try{
                    ResultSet rs=null;
                    if(status.equalsIgnoreCase("Student"))
                     rs=st.executeQuery("SELECT * FROM `student_reg` WHERE reg_num like '"+year+"%'");
                    else if(status.equalsIgnoreCase("Teacher")) 
                     rs=st.executeQuery("SELECT * FROM `teacher_reg` WHERE reg_num like '"+year+"%'");
                    else
                     rs=st.executeQuery("SELECT * FROM `admin_reg` WHERE reg_num like '"+year+"%'");
                    
                     if(rs.next()){
                         int num=Integer.parseInt(rs.getString(1));
                         num++;
                         reg_num=Integer.toString(num);
                         
                         if(status.equalsIgnoreCase("Student"))
                            st.execute("UPDATE `student_reg` SET `Reg_num`='"+reg_num+"' WHERE reg_num like '"+year+"%'");
                         else if(status.equalsIgnoreCase("Teacher")) 
                            st.execute("UPDATE `teacher_reg` SET `Reg_num`='"+reg_num+"' WHERE reg_num like '"+year+"%'");
                         else
                            st.execute("UPDATE `admin_reg` SET `Reg_num`='"+reg_num+"' WHERE reg_num like '"+year+"%'");
                     
                     }
                     else{
                         reg_num=year+"001";
                         if(status.equalsIgnoreCase("Student"))
                            st.execute("INSERT INTO student_reg (Reg_num) VALUES ('"+reg_num+"')");
                         else if(status.equalsIgnoreCase("Teacher")) 
                            st.execute("INSERT INTO teacher_reg (Reg_num) VALUES ('"+reg_num+"')");
                         else
                             st.execute("INSERT INTO admin_reg (Reg_num) VALUES ('"+reg_num+"')");
                       }
              
                 if(status.equalsIgnoreCase("Student"))
                     st.execute("insert into student_info (name,father_name,mother_name,address,division,"
                    + "city,course,year,mobile_no,email,sex,registration_number)"
                    + " values('"+name+"','"+fname+"','"+mname+"','"+add+"','"+divi+"',"
                    + "'"+city+"','"+course+"','"+year+"','"+mobile+"','"+email+"',"
                    + "'"+sex+"',"
            + "'"+reg_num+"')");
                     
                 else if(status.equalsIgnoreCase("Teacher"))
                  st.execute("insert into teacher_info (name,father_name,mother_name,address,division,"
                    + "city,course,year,mobile_no,email,sex,registration_number)"
                    + " values('"+name+"','"+fname+"','"+mname+"','"+add+"','"+divi+"',"
                    + "'"+city+"','"+course+"','"+year+"','"+mobile+"','"+email+"',"
                    + "'"+sex+"',"
            + "'"+reg_num+"')");
                 else
                     st.execute("insert into admin_info (name,father_name,mother_name,address,division,"
                    + "city,course,year,mobile_no,email,sex,registration_number)"
                    + " values('"+name+"','"+fname+"','"+mname+"','"+add+"','"+divi+"',"
                    + "'"+city+"','"+course+"','"+year+"','"+mobile+"','"+email+"',"
                    + "'"+sex+"',"
            + "'"+reg_num+"')");
                 
                     
            st.execute("insert into login (user_name,password,type,reg_num) values ('"+user_name+"','"+pass+"','"+status+"','"+reg_num+"')");
	    out.println("You are registered Successfully.");
            //JOptionPane.showMessageDialog(null,"Your Registration Number is "+reg_num);
            HttpSession session= request.getSession();
            session.setAttribute("reg_num", reg_num);
            session.setAttribute("send_reg", "true");
            request.getRequestDispatcher("/ShowRequest").forward(request, response);
                    
                }catch(Exception ex){
                    out.println("error in connection:"+ex);
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