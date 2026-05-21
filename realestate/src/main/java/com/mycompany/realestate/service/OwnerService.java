package com.mycompany.realestate.service;
import com.mycompany.realestate.databaseconnect.DatabaseConnect;
import com.mycompany.realestate.models.Owner;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class OwnerService {
     Connection con;

    public OwnerService() {

        con = DatabaseConnect.getConnection();
    }
    public void addOwner(Owner o) {
        try {
            String sql ="INSERT INTO OWNER " +"(Email, Fname, Lname, PhoneNumber, Oname) " +"VALUES (?,?,?,?,?)";
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setString(1, o.getEmail());
            ps.setString(2, o.getFirstName());
            ps.setString(3, o.getLastName());
            ps.setString(4, o.getPhoneNumber());
            ps.setString(5, o.getOwnerName());
            int rows = ps.executeUpdate();
            System.out.println("Inserted Rows = " + rows );
        } catch (SQLException e) {
            e.printStackTrace();
              JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public List<Owner> getOwners() {
        List<Owner> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM OWNER";
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while (rs.next()) {
                Owner o = new Owner(
                        rs.getInt("OwnerID"), 
                        rs.getString("Email"),
                        rs.getString("Fname"),
                        rs.getString("Lname"),
                        rs.getString("PhoneNumber"),
                        rs.getString("Oname") );
                list.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
              JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return list;
}
}

