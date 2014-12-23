package javacode;

public class division implements CalculateResult{

    String grade[][]=new String[15][2];
    boolean fail=false;
    @Override
    public String[][] cal_res(double grd[],String[] course,int l) {
        int i;
        double n,tn,num=0.0; 
        for(i=0;i<=l;i++)
        {
            if(i==l){
                if(fail==false)
                grd[i]=num/(1.0*l);
                else
                grd[i]=00;
            }
            
            num+=grd[i];
            if(grd[i]>=60)
            {
                grade[i][0]="Frist Division";
                grade[i][1]="A";
            }
            else if(grd[i]>=55)
            {
                 grade[i][1]="Second Division";
                 grade[i][0]="B+";
            }
            else if(grd[i]>=50)
            {
                 grade[i][1]="Second Division";
                 grade[i][0]="B";
            }
            else if(grd[i]>=43)
            {
                grade[i][1]="Third Division";
                grade[i][0]="C+";
            }
            else if(grd[i]>=35)
            {
                grade[i][1]="Third Division";
                grade[i][0]="C";
            }
            else
            {
                 grade[i][0]="Fail";
                 grade[i][1]="F";
                 fail=true;
            }
        }
        
        
        
        return grade;
    
    }
    
}
