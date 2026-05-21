package com.mycompany.realestate.service;
import com.mycompany.realestate.databaseconnect.DatabaseConnect;
import com.mycompany.realestate.models.User;
import java.sql.*;
import javax.swing.JOptionPane;

public class UserService {
  Connection con; 
   public UserService(){
        con = DatabaseConnect.getConnection();
   }
    public void addUser(User u) {
        try {
            String sql ="INSERT INTO USERS(Name,Email,Password) VALUES(?,?,?)";
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setString(1,u.getName());
            ps.setString(2,u.getEmail());
            ps.setString(3,u.getPassword());
            ps.executeUpdate();
            System.out.println("User Saved ");
            
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    public boolean checkLogin(String Name,String password ) {
        try {
            String sql ="SELECT * FROM USERS " +"WHERE Name=? AND Password=?";
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setString(1,Name);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return false;
    }
}
