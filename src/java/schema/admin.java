/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package schema;

/**
 *
 * @author tonmoy
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *
 * @author User
 */
public class admin extends user {
     private String username;
     private String password;
    
    public admin(){}
    public admin(String username,String password)
    {
        this.username=username;
        this.password=password;
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
     public boolean Check() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/tonmoy?zeroDateTimeBehavior=convertToNull";
        Connection con=DriverManager.getConnection(url,"root","");
        Statement st=con.createStatement();
        ResultSet rs;
        rs=st.executeQuery("select * from result.admin where Username='"+username+"'and Password='"+password+"'");
        return rs.next();
    }
    
}
