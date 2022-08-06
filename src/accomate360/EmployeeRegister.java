package accomate360;

import emergency.connection.CallTheConnection;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EmployeeRegister {
    
    public static void registerEmployee(){
        try{
            String name = JOptionPane.showInputDialog("Enter First Name: ");
            String userId = JOptionPane.showInputDialog("Enter Employee ID : ");
            String password = JOptionPane.showInputDialog("Enter the password: ");
            String email = JOptionPane.showInputDialog("Enter email: ");
            String phoneNo = JOptionPane.showInputDialog("Enter phone number: ");
            String address = JOptionPane.showInputDialog("Enter address: ");
            String salary = "100000";
            String IFSCcode = JOptionPane.showInputDialog("Enter your IFSC Code: ");
            String accountNo = JOptionPane.showInputDialog("Enter your account number: ");
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = CallTheConnection.connectionCode();
            PreparedStatement st = con.prepareStatement("insert into emptable values(?,?,?,?,?,?,?,?,?)");
            st.setString(1,userId);
            st.setString(2,name);
            st.setString(3,password);
            st.setString(4,email);
            st.setString(5,phoneNo);
            st.setString(6,address);
            st.setString(7,salary);
            st.setString(8, IFSCcode);
            st.setString(9,accountNo);
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
            PreparedStatement st = con.prepareStatement("Select * from emptable");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String userId = rs.getString(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                String email = rs.getString(4);
                String phoneNo = rs.getString(5);
                String address = rs.getString(6);
                String salary = rs.getString(7);
                String IFSCcode = rs.getString(8);
                String accountNo = rs.getString(9);
                out.println(userId+" "+password+" "+name+" "+email+" "+phoneNo+" "+address+" "+salary+" "+IFSCcode+" "+accountNo);
            }
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }
}
