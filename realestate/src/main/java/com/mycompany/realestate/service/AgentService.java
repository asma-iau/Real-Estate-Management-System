package com.mycompany.realestate.service;
import com.mycompany.realestate.models.Agent;
import com.mycompany.realestate.databaseconnect.DatabaseConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AgentService {
          Connection con;
    // estiblish database connection
    public AgentService() {
        con = DatabaseConnect.getConnection();
    }
    // add a new agent into db
    public void addAgent(Agent a) {
        try {
            // sql query for insearting
            String sql ="INSERT INTO AGENT " + "(AName, Fname, Lname, Supervises) " +"VALUES (?,?,?,?)";
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setString(1, a.getName());
            ps.setString(2, a.getfirstName());
            ps.setString(3, a.getlasttName());
            if (a.getSupervises() == 0) {
               ps.setNull(4,Types.INTEGER);
            } else {
                ps.setInt(4, a.getSupervises());
            }
            int rows = ps.executeUpdate();
            System.out.println( "Inserted Successfuly" + rows );
            
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
      // retreves all agents from db
    public List<Agent> getAgents() {
        List<Agent> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM AGENT";
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while (rs.next()) {
                Agent a = new Agent(
                        rs.getInt("AgentID"),
                        rs.getString("AName"),
                        rs.getString("Fname"),
                        rs.getString("Lname"),
                        rs.getInt("Supervises")
                );
                list.add(a);
            }

        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return list;
    }
    }


