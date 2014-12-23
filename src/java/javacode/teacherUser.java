package javacode;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import schema.db_connect;


public class teacherUser extends user{

    Statement st=null;
    String reg_num=null;
    HttpSession s=null;
    db_connect db=null;
    ResultSet rs=null;
    public void init(){
        db=db_connect.get_connection();
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
       init();
       String xam=null,mark=null,totalMark=null,course=null;
       course=req.getParameter("course_code");
       if(Rnum.equalsIgnoreCase(""))
       {
           session.setAttribute("SetMark_msg", "Enter registration number");
           return;
       }
       else if(course.equals("-1"))
       {
           session.setAttribute("SetMark_msg", "Enter course code");
           return;
       }
       else
       {
           int check;
        try{
           xam=req.getParameter("exam_type1"); mark=req.getParameter("mark1");totalMark=req.getParameter("totalmark1");
           check=InsertMark(xam,course,Rnum,mark,totalMark);
           if(check==0)
                session.setAttribute("SetMark_msg1", "Fill up all the field");
           else if(check==1)
                session.setAttribute("SetMark_msg1", "Success!!");
           else if(check==3)
               session.setAttribute("SetMark_msg1", " ");
           else if(check==4)
               session.setAttribute("SetMark_msg1", "Updated!!");
           else
                session.setAttribute("SetMark_msg1", "Error occur!!");
           
           xam=req.getParameter("exam_type2"); mark=req.getParameter("mark2");totalMark=req.getParameter("totalmark2");
           check=InsertMark(xam,course,Rnum,mark,totalMark);
           if(check==0)
                session.setAttribute("SetMark_msg2", "Fill up all the field");
           else if(check==1)
                session.setAttribute("SetMark_msg2", "Success!!");
           else if(check==3)
               session.setAttribute("SetMark_msg2", " ");
           else if(check==4)
               session.setAttribute("SetMark_msg2", "Updated!!");
           else
                session.setAttribute("SetMark_msg2", "Error occur!!");
           
           xam=req.getParameter("exam_type3"); mark=req.getParameter("mark3");totalMark=req.getParameter("totalmark3");
           check=InsertMark(xam,course,Rnum,mark,totalMark);
           if(check==0)
                session.setAttribute("SetMark_msg3", "Fill up all the field");
           else if(check==1)
                session.setAttribute("SetMark_msg3", "Success!!");
           else if(check==3)
               session.setAttribute("SetMark_msg3", " ");
           else if(check==4)
               session.setAttribute("SetMark_msg3", "Updated!!");
           else
                session.setAttribute("SetMark_msg3", "Error occur!!");
           
           xam=req.getParameter("exam_type4"); mark=req.getParameter("mark4");totalMark=req.getParameter("totalmark4");
           check=InsertMark(xam,course,Rnum,mark,totalMark);
           if(check==0)
                session.setAttribute("SetMark_msg4", "Fill up all the field");
           else if(check==1)
                session.setAttribute("SetMark_msg4", "Success!!");
           else if(check==3)
               session.setAttribute("SetMark_msg4", " ");
           else if(check==4)
               session.setAttribute("SetMark_msg4", "Updated!!");
           else
                session.setAttribute("SetMark_msg4", "Error occur!!");
           
           xam=req.getParameter("exam_type5"); mark=req.getParameter("mark5");totalMark=req.getParameter("totalmark5");
           check=InsertMark(xam,course,Rnum,mark,totalMark);
           if(check==0)
                session.setAttribute("SetMark_msg5", "Fill up all the field");
           else if(check==1)
                session.setAttribute("SetMark_msg5", "Success!!");
           else if(check==3)
               session.setAttribute("SetMark_msg5", " ");
           else if(check==4)
               session.setAttribute("SetMark_msg5", "Updated!!");
           else
                session.setAttribute("SetMark_msg5", "Error occur!!");
           
           xam=req.getParameter("exam_type6"); mark=req.getParameter("mark6");totalMark=req.getParameter("totalmark6");
           check=InsertMark(xam,course,Rnum,mark,totalMark);
           if(check==0)
                session.setAttribute("SetMark_msg6", "Fill up all the field");
           else if(check==1)
                session.setAttribute("SetMark_msg6", "Success!!");
           else if(check==3)
               session.setAttribute("SetMark_msg6", " ");
           else if(check==4)
               session.setAttribute("SetMark_msg6", "Updated!!");
           else
                session.setAttribute("SetMark_msg6", "Error occur!!");
           
        }catch(Exception ex){
           session.setAttribute("SetMark_msg", "Error Occur!!");
        }
       }
        
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
            ResultSet rs=st.executeQuery(" SELECT * FROM `teacher_info` WHERE registration_number like '"+reg_num+"'");
            if(rs.next()){
                String display[][] = new String[40][40];
                display[0][0]="Name:";display[0][1]=rs.getString(1);
                display[1][0]="Father's Name:";display[1][1]=rs.getString(2);
                display[2][0]="Mother's Name:";display[2][1]=rs.getString(3);
                display[3][0]="Address:";display[3][1]=rs.getString(4);
                display[4][0]="Division:";display[4][1]=rs.getString(5);
                display[5][0]="City:";display[5][1]=rs.getString(6);
                display[6][0]="Year:";display[6][1]=rs.getString(8);
                display[7][0]="Mobile Number:";display[7][1]=rs.getString(9);
                display[8][0]="Email:";display[8][1]=rs.getString(10);
                display[9][0]="Sex:";display[9][1]=rs.getString(11);
                display[10][0]="Registration Number:";display[10][1]=rs.getString(12);
                
                s.setAttribute("table",display);
                s.setAttribute("row","11");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(studentUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String[][] viewresult(double [] num,double tnum[],String[] course,String type,int l) {
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
    
    public int InsertMark(String xam,String course,String Rnum,String mark,String totalMark){
        if(((xam.equals("-1") || xam.equals("")) && mark.equals("") && totalMark.equals("")) || (xam.equals(null) && mark.equals(null) && totalMark.equals(null)))
            return 3;
        else if(xam.equals(""))
            return 0;
        else if(mark.equals(""))
            return 0;
        else if(totalMark.equals(""))
            return 0;
        try{
            ResultSet rs=st.executeQuery("SELECT * FROM `mark` WHERE reg_num='"+Rnum+"' and exam='"+xam+"' and course_code='"+course+"'");
            if(rs.next()){
                st.execute("UPDATE `mark` SET `Mark`="+mark+",`Total_mark`="+totalMark+" WHERE reg_num='"+Rnum+"' and exam='"+xam+"' and course_code='"+course+"'");
                return 4;
            }
            
           st.execute("INSERT INTO `mark`(`Reg_num`, `Exam`, `Mark`, `Total_mark`, `Course_code`) VALUES ('"+Rnum+"','"+xam+"',"+mark+","+totalMark+",'"+course+"')");
        
        
        
        }catch(Exception ex){
            return 2;
        }
        return 1;
    }
 }