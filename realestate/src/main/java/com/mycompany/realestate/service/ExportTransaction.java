// exports Transaction records into txt file
package com.mycompany.realestate.service;
import com.mycompany.realestate.databaseconnect.DatabaseConnect;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ExportTransaction {
    Connection con;
    public ExportTransaction(){
    con = DatabaseConnect.getConnection(); }
    
    // exports all transaction into transaction.txt file
 public void exportTransactions() {
    try {
        FileWriter writer =new FileWriter("transactions.txt");
        String sql ="SELECT * FROM TRANSACTION";
        PreparedStatement ps =con.prepareStatement(sql);
        ResultSet rs =ps.executeQuery();

        while(rs.next()) {
            writer.write( "Transaction ID: " +rs.getInt("TransactionID") + " | Date: " +rs.getString("Date")
            + " | Final Price: " +rs.getDouble("FinalPrice")+ "\n"
            );
        }
        writer.close();

    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }
}
