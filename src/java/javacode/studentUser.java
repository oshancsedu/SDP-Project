package javacode;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import schema.db_connect;

/**
 *
 * @author Oshan
 */
public class studentUser extends user{

    
    Statement st=null;
    String reg_num=null;
    HttpSession s=null;
    db_connect db=null;
    
    public void init(){
    db= db_connect.get_connection();
    st=db.statement;
}
    
    
    
    @Override
    public void getMark(HttpSession session,String Rnum,String course) {
       init();
        try {
            Boolean table=false;
            Statement state=db.con.createStatement();
            ResultSet rsViewMark=state.executeQuery("SELECT exam,mark,total_mark FROM `mark` WHERE reg_num like '"+Rnum+"' and course_code like '"+course+"'");
            session.setAttribute("rsViewMark",rsViewMark);
            if(rsViewMark.next()){
             session.setAttribute("ViewMark_msg", "Data found!!");
             table=true;
            }
            else
                session.setAttribute("ViewMark_msg", "No data found!!");
                session.setAttribute("showViewMarkMsgTable", table);
        } catch (SQLException ex) {
             session.setAttribute("ViewMark_msg", "Error Occur!! "+ex);
        }
    }

    @Override
    public void setmark(HttpSession session,String Rnum,HttpServletRequest req) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteReg(HttpSession session,String reg_num,String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void profile(HttpSession session) {
        init();
        s=session;
        reg_num= (String) s.getAttribute("reg_num");
        try {
            ResultSet rs=st.executeQuery(" SELECT * FROM `student_info` WHERE registration_number like '"+reg_num+"'");
            if(rs.next()){
                String display[][] = new String[40][40];
                display[0][0]="Name:";display[0][1]=rs.getString(1);
                display[1][0]="Father's Name:";display[1][1]=rs.getString(2);
                display[2][0]="Mother's Name:";display[2][1]=rs.getString(3);
                display[3][0]="Address:";display[3][1]=rs.getString(4);
                display[4][0]="Division:";display[4][1]=rs.getString(5);
                display[5][0]="City:";display[5][1]=rs.getString(6);
                display[6][0]="Course:";display[6][1]=rs.getString(7);
                display[7][0]="Year:";display[7][1]=rs.getString(8);
                display[8][0]="Mobile Number:";display[8][1]=rs.getString(9);
                display[9][0]="Email:";display[9][1]=rs.getString(10);
                display[10][0]="Sex:";display[10][1]=rs.getString(11);
                display[11][0]="Registration Number:";display[11][1]=rs.getString(12);
                
                s.setAttribute("table",display);
                s.setAttribute("row","12");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(studentUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String[][] viewresult(double [] num,double tnum[],String[] course,String type,int l) {
        init();
    int i;
        double n=0.0,tn=0.0;
        double grade[]=new double[20];
        String result[][]=new String[20][2];
        CalculateResult res = null;
        if(type.equalsIgnoreCase("cgpa"))
         res=new cgpa();
        else if(type.equalsIgnoreCase("division"))
         res=new division();
        
        for(i=0;i<l;i++)
        {
                n=num[i];
                tn=tnum[i];
                grade[i]=1.0*n*100.0/(1.0*tn);
        }
        result=res.cal_res(grade,course,i);
        return result;    
    }

    @Override
    public void reg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
