package schema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class db_connect {
    
    private volatile static db_connect db;
    public Statement statement;
    public Connection con;
    private db_connect() 
   {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/versity?user=root");
            statement=con.createStatement();
            //ResultSet rs;
        } catch (Exception ex) {
            Logger.getLogger(db_connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static db_connect get_connection()
    {
        if(db==null)
        {
            synchronized(db_connect.class){
                if(db==null)
                    db =new db_connect();
            }
        }
        return db;
    }
}