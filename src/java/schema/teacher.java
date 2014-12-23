/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package schema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author tonmoy
 */

public class teacher extends user{
    private String id;
    private String name;
    private String username;
    private String password;
    private String designation;
    private String email;
    private String mobile_no;
    private String dept_name;
    private String gender;
    
    public teacher(){}
    public teacher(String id,String name,String username,String password,String designation,String email,String mobile_no,String dept_name,String gender)
    {
        this.id=id;
        this.name=name;
        this.username=username;
        this.password=password;
        this.designation=designation;
        this.email=email;
        this.mobile_no=mobile_no;
        this.dept_name=dept_name;
        this.gender=gender;
    }        

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
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

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
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
    public int store() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/tonmoy?zeroDateTimeBehavior=convertToNull";
        Connection con=DriverManager.getConnection(url,"root","");
        PreparedStatement ps=con.prepareStatement("insert into result.teacher(ID,Name,Username,Password,Designation,Email,Mobile_No,Department_Name,Gender)values(?,?,?,?,?,?,?,?,?)");
        ps.setString(1,id);
        ps.setString(2,name);
        ps.setString(3,username);
        ps.setString(4,password);
        ps.setString(5,designation);
        ps.setString(6,email);
        ps.setString(7,mobile_no);
        ps.setString(8,dept_name);
        ps.setString(9,gender);
         int a=ps.executeUpdate();
        if(a>0)
            return a;
        else
            return 0;
    }
    
}