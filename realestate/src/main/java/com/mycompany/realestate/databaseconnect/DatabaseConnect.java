package com.mycompany.realestate.databaseconnect;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;
public class DatabaseConnect {
    public static Connection getConnection(){
    Connection con = null;
    try {
           con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/realestatemangmentsystem"
                  ,"root","Ghala123.4");
          System.out.println("connected");
    }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, "connection failed"+ e.getMessage());
    }
     return con;
    }
}
    




