/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accomate360;

import emergency.connection.CallTheConnection;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class UserRegister {
    
    public static void registerUser(){
        try{
            String name = JOptionPane.showInputDialog("Enter First Name: ");
            String lastName = JOptionPane.showInputDialog("Enter Last Name: ");
            String userId = JOptionPane.showInputDialog("Enter User ID : ");
            String password = JOptionPane.showInputDialog("Enter the password: ");
            String phoneNo = JOptionPane.showInputDialog("Enter phone number: ");
            String email = JOptionPane.showInputDialog("Enter email: ");
            String address = JOptionPane.showInputDialog("Enter address: ");
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = CallTheConnection.connectionCode();
            PreparedStatement st = con.prepareStatement("insert into usertable values(?,?,?,?,?,?,?)");
            st.setString(1,userId);
            st.setString(2,password);
            st.setString(3,name);
            st.setString(4,lastName);
            st.setString(5,phoneNo);
            st.setString(6,email);
            st.setString(7,address);
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
            PreparedStatement st = con.prepareStatement("Select * from usertable");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String userId = rs.getString(1);
                String password = rs.getString(2);
                String name = rs.getString(3);
                String lastname = rs.getString(4);
                String phoneNo = rs.getString(5);
                String email = rs.getString(6);
                String address = rs.getString(7);
                out.println(userId+" "+password+" "+name+" "+lastname+" "+phoneNo+" "+email+" "+address);
            }
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void showUser(){
        try{
            String userID = JOptionPane.showInputDialog("Enter user ID to search: ");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = CallTheConnection.connectionCode();
            PreparedStatement st = con.prepareStatement("select * from usertable where userId=?");
            st.setString(1,userID);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                String userId = rs.getString(1);
                String password = rs.getString(2);
                String name = rs.getString(3);
                String lastName = rs.getString(4);
                String phoneNo = rs.getString(5);
                String email = rs.getString(6);
                String address  = rs.getString(7);
                JOptionPane.showMessageDialog(null,userId+" "+password+" "+name+" "+lastName+" "+phoneNo+" "+email+" "+address);
            }
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }
}
