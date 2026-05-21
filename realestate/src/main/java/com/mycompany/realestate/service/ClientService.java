package com.mycompany.realestate.service;
import com.mycompany.realestate.models.Client;
import com.mycompany.realestate.databaseconnect.DatabaseConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClientService {
       Connection con;

    public ClientService() {
        con = DatabaseConnect.getConnection();
    }
    public void addClient(Client c) {
        try {

            String sql ="INSERT INTO CLIENT " +"(CName, PhoneNumber, Email) " +"VALUES (?,?,?)";
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2, c.getPhoneNumber());
            ps.setString(3, c.getEmail());
            int rows = ps.executeUpdate();
            System.out.println( "Inserted Successfuly" );
            System.out.println(rows);

        } catch (SQLException e) {
          e.printStackTrace();
          JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public List<Client> getClients() {
        List<Client> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM CLIENT";
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while (rs.next()) {
                Client c = new Client(
                        rs.getInt("ClientID"),
                        rs.getString("CName"),
                        rs.getString("PhoneNumber"),
                        rs.getString("Email")
                );
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return list;
    }
}
