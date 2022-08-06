
package emergency.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallTheConnection {
    
    static Connection con = null;
    
    static{
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accomate360","root","root");
        }catch(SQLException ex){}
    }
    
    static public Connection connectionCode(){
        try{
            if(con.isClosed()){
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accomate360","root","root");
            } 
        }catch(SQLException ex){}
        return con;
    }
}

