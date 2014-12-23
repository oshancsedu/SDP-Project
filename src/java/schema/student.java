package schema;

import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author User
 */
public class student extends user{
    private String name;
    private String username;
    private String password;
    private String reg_num;
    private String email;
    private String mobile_no;
    private String gender;
    private String dept_name;
    private String faculty;
    private String session;
    public student(){}
    public student(String name,String reg_num,String email,String mobile_no,String gender,String dept_name,String faculty,String session)
    {
        this.name=name;
        this.reg_num=reg_num;
        this.email=email;
        this.mobile_no=mobile_no;
        this.gender=gender;
        this.dept_name=dept_name;
        this.faculty=faculty;
        this.session=session;
    }   

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the reg_num
     */
    public String getReg_num() {
        return reg_num;
    }

    /**
     * @param reg_num the reg_num to set
     */
    public void setReg_num(String reg_num) {
        this.reg_num = reg_num;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the mobile_no
     */
    public String getMobile_no() {
        return mobile_no;
    }

    /**
     * @param mobile_no the mobile_no to set
     */
    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the dept_name
     */
    public String getDept_name() {
        return dept_name;
    }

    /**
     * @param dept_name the dept_name to set
     */
    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    /**
     * @return the faculty
     */
    public String getFaculty() {
        return faculty;
    }

    /**
     * @param faculty the faculty to set
     */
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    /**
     * @return the session
     */
    public String getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(String session) {
        this.session = session;
    }
    
    public int store() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/tonmoy?zeroDateTimeBehavior=convertToNull";
        Connection con=DriverManager.getConnection(url,"root","");
        PreparedStatement ps1=con.prepareStatement("insert into result.studentlogin(Username,Password,reg_num)values(?,?,?)");
        ps1.setString(1,username);
        ps1.setString(2,password);
        ps1.setString(3,reg_num);
        int b=ps1.executeUpdate();
        PreparedStatement ps=con.prepareStatement("insert into result.student(name,reg_num,email,mobile_no,gender,dept_name,faculty,session)values(?,?,?,?,?,?,?,?)");
        ps.setString(1,name);
        ps.setString(2,reg_num);
        ps.setString(3,email);
        ps.setString(4,mobile_no);
        ps.setString(5,gender);
        ps.setString(6,dept_name);
        ps.setString(7,faculty);
        ps.setString(8,session);
        
        int a=ps.executeUpdate();
        if(a>0 && b>0)
            return a;
        else
            return 0;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}