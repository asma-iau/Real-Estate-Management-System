// responsible for handling all property db opreations
package com.mycompany.realestate.service;
import com.mycompany.realestate.databaseconnect.DatabaseConnect;
import com.mycompany.realestate.models.Apartment;
import com.mycompany.realestate.models.Land;
import com.mycompany.realestate.models.Villa;
import com.mycompany.realestate.models.Property;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class PropertyService {
    Connection con;
    // estiblish database connection
    public PropertyService() {
        con = DatabaseConnect.getConnection();
    }
    
    // add a new property into db
    public void addProperty(Property p) {
        try {
            // sql query for insearting
            String sql ="INSERT INTO PROPERTY " + "(Location, Status, PropertyType, OwnerID, AgentID, Price) " +
            "VALUES (?,?,?,?,?,?)";
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setString(1, p.getLocation());
            ps.setString(2, p.getStatus());
            ps.setString(3, p.getPropertyType());
            ps.setInt(4, p.getOwnerID());
            ps.setInt(5, p.getAgentID());
            ps.setDouble(6, p.getPrice());
            // execute inseartion
            int rows = ps.executeUpdate();
            System.out.println( "Inserted Successfuly " + rows );

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
     // retreves all property from db
    public List<Property> getProperties() {
        List<Property> list =new ArrayList<>();
        try {
            // sql query for selection
            String sql = "SELECT * FROM PROPERTY";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id =  rs.getInt("PropertyID");
                String location = rs.getString("Location");
                String status =rs.getString("Status");
                String type = rs.getString("PropertyType");
                int ownerID = rs.getInt("OwnerID");
                int agentID =  rs.getInt("AgentID");
                double price = rs.getDouble("Price");
                
                if (type.equalsIgnoreCase("Villa")) {
                    list.add(new Villa( id,location,status,ownerID,agentID, price));

                } else if
                   (type.equalsIgnoreCase("Apartment")) {
                    list.add(new Apartment( id,location,status,ownerID,agentID,price));

                } else {
                    list.add( new Land(id,location,status,ownerID,agentID,price));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return list;
    }
    
    // delete property from db using propertyID
    public boolean deleteProperty(int id) {
    try {
        // sql query for deletion
        String sql = "DELETE FROM PROPERTY WHERE PropertyID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        // excute deleation
        int rows = ps.executeUpdate();
         return rows >0;
    } catch (Exception e){
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    return false;
    }
    
    // update existing property information
    public void updateProperty(Property p) {
    try {
        // sql query for updating
        String sql = "UPDATE PROPERTY SET Location=?, Status=?, PropertyType=?, OwnerID=?, AgentID=?, Price=? WHERE PropertyID=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, p.getLocation());
        ps.setString(2, p.getStatus());
        ps.setString(3, p.getPropertyType());
        ps.setInt(4, p.getOwnerID());
        ps.setInt(5, p.getAgentID());
        ps.setDouble(6, p.getPrice());
        ps.setInt(7, p.getPropertyID());

        // excute updating
        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("Updated Successfully");
        } else {
            System.out.println("No record found");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,e.getMessage());
    }
}
       
}





