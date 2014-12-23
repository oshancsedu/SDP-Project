package javacode;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import schema.db_connect;

public class cgpa implements CalculateResult{

    String grade[][]=new String[15][2];
    
    @Override
    public String[][] cal_res(double grd[],String[] course,int l) {
        int i;
        double n,tn;
        db_connect db=db_connect.get_connection();
        Statement st=db.statement;
        double Tcredit=0.0,gpa,credit=0.0,finalgpa=0.0;
        for(i=0;i<l;i++)
        {
            
                if(grd[i]>=79.5)
                {
                    grade[i][0]="A+";
                    grade[i][1]="4.00";
                    gpa=4.00;
                }
                else if(grd[i]>=74.5)
                {
                    grade[i][0]="A";
                    grade[i][1]="3.75";
                    gpa=3.75;
                }
                else if(grd[i]>=69.5)
                {
                    grade[i][0]="A-";
                    grade[i][1]="3.50";
                    gpa=3.5;
                }
                else if(grd[i]>=64.5)
                {
                    grade[i][0]="B+";
                    grade[i][1]="3.25";
                    gpa=3.25;
                }
                else if(grd[i]>=59.5)
                {
                    grade[i][0]="B";
                    grade[i][1]="3.00";
                    gpa=3.00;
                }
                else if(grd[i]>=54.5)
                {
                    grade[i][0]="B-";
                    grade[i][1]="2.75";
                    gpa=2.75;
                }
                else if(grd[i]>=49.5)
                {
                    grade[i][0]="C+";
                    grade[i][1]="2.50";
                    gpa=2.5;
                }
                else if(grd[i]>=44.5)
                {
                    grade[i][0]="C";
                    grade[i][1]="2.25";
                    gpa=2.25;
                }
                else if(grd[i]>=39.5)
                {
                    grade[i][0]="D";
                    grade[i][1]="2.00";
                    gpa=2.00;
                }
                else
                {
                    grade[i][0]="F";
                    grade[i][1]="0.00";
                    gpa=0.00;
                }
                
        try{    
              ResultSet rs=st.executeQuery("SELECT credit FROM `course` WHERE course_code='"+course[i]+"'");
              rs.next();
              credit+=1.0*rs.getFloat(1);
              Tcredit+=gpa*(1.0*rs.getFloat(1));
            } catch (SQLException ex) {
                Logger.getLogger(cgpa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        finalgpa=Tcredit/credit;
        //finalgpa=1.00;
        NumberFormat formatter = new DecimalFormat("#0.00");
        grade[l][0]=" ";
        grade[l][1]=formatter.format(finalgpa).toString();
                //Double.toString(formatter.format(finalgpa));
                //formatter.format(finalgpa).toString();
        
        return grade;
    }
}