package accomate360;

import emergency.connection.CallTheConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class QueryRegister {
    private static int queryID;
    public static void registerQuery(){
        
        try{
            queryID++;
            String userId = JOptionPane.showInputDialog("Enter USER ID : ");
            String propertyId = JOptionPane.showInputDialog("Enter Property ID: ");
            String problem = JOptionPane.showInputDialog("Enter problem description: ");
            String status = "unsolved";
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = CallTheConnection.connectionCode();
            PreparedStatement st = con.prepareStatement("insert into querytable values(?,?,?,?,?)");
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
}
