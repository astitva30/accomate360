package accomate360;

import emergency.connection.CallTheConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class QueryRegister {
    
    public static void registerQuery(){
        
        try{
            String userId = JOptionPane.showInputDialog("Enter USER ID : ");
            String propertyId = JOptionPane.showInputDialog("Enter Property ID: ");
            String problem = JOptionPane.showInputDialog("Enter problem description: ");
            String status = "unsolved";
            
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = CallTheConnection.connectionCode();
//            PreparedStatement st1= con.prepareStatement("select * from querytable where queryId in (select MAX(queryId) queryId from querytable)");
            PreparedStatement st = con.prepareStatement("insert into querytable values(?,?,?,?,?)");
//            ResultSet rs = st1.executeQuery();
//            int queryID = rs.getInt(1);
            int queryID=0;
            st.setInt(1, queryID);
            st.setString(2, userId);
            st.setString(3, propertyId);
            st.setString(4, problem);
            st.setString(5, status);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Record Entered Successfully!");
        }
        catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void showAll(){
        
    }
}
