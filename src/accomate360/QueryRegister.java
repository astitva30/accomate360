package accomate360;

import emergency.connection.CallTheConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import static java.lang.System.out;

public class QueryRegister {
    
    public static void registerQuery(){
        
        try{
            
            String userId = JOptionPane.showInputDialog("Enter USER ID : ");
            String propertyId = JOptionPane.showInputDialog("Enter Property ID: ");
            String problem = JOptionPane.showInputDialog("Enter problem description: ");
            String status = "unsolved";
            
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = CallTheConnection.connectionCode();
            PreparedStatement st = con.prepareStatement("insert into querytable values(?,?,?,?,?)");
            
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
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = CallTheConnection.connectionCode();
            PreparedStatement st = con.prepareStatement("Select * from querytable");
            ResultSet rs = st.executeQuery();
        
            while(rs.next()){
                int queryID = rs.getInt(1);
                String userId = rs.getString(2);
                String propertyId = rs.getString(3);
                String problem = rs.getString(4);
                String status = rs.getString(5);
                out.println(queryID + " " + userId + " " + propertyId + " " + problem + " " + status);
            }
        }catch(SQLException | ClassNotFoundException ex){}
    }
    public static void showQuery(){
        try{
            String queryID = JOptionPane.showInputDialog("Enter Query ID to search: ");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = CallTheConnection.connectionCode();
            PreparedStatement st = con.prepareStatement("select * from querytable where queryId=?");
            st.setString(1,queryID);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                String queryId = rs.getString(1);
                String userId = rs.getString(2);
                String propertyId = rs.getString(3);
                String problem = rs.getString(4);
                String status = rs.getString(5);
                JOptionPane.showMessageDialog(null,queryId+" "+userId+" "+propertyId+" "+problem+" "+status);
            }
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }
}
