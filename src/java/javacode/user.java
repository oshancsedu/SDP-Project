package javacode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Oshan
 */
public abstract class user {
    public static user u;
    public abstract void getMark(HttpSession session,String Rnum,String course);
    public abstract void setmark(HttpSession session,String s,HttpServletRequest req);
    public abstract void deleteReg(HttpSession se,String reg_num,String type);
    public abstract void profile(HttpSession se);
    public abstract String[][] viewresult(double [] num,double tnum[],String[] course,String type,int l);
    public abstract void reg();
}
