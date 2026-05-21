package com.mycompany.realestate.service;
import com.mycompany.realestate.models.Transaction;
import com.mycompany.realestate.databaseconnect.DatabaseConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TransactionService {
     Connection con = DatabaseConnect.getConnection();
    public void addTransaction(Transaction t) {
        try {

            String sql ="INSERT INTO TRANSACTION " + "(Date, FinalPrice, ClientID, AgentID, PropertyID) " +
            "VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getDate());
            ps.setDouble(2, t.getFinalPrice());
            ps.setInt(3, t.getClientId());
            ps.setInt(4, t.getAgentId());
            ps.setInt(5, t.getPropertyId());
            int rows = ps.executeUpdate();
            
            System.out.println("Inserted Sueccssfuly");
            System.out.println(rows);

        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }

     public List<Transaction> getAll() {
        List<Transaction> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM TRANSACTION";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Transaction t = new Transaction(
                        rs.getInt("TransactionID"),
                        rs.getString("Date"),
                        rs.getDouble("FinalPrice"),
                        rs.getInt("ClientID"),
                        rs.getInt("AgentID"),
                        rs.getInt("PropertyID"));
                list.add(t);
            }
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null,e.getMessage());

        }
        return list;
    }
}
