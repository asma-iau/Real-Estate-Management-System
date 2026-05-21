//dashboard screen of the system 
package com.mycompany.realestate.GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DashboardGUI  extends JFrame {
      public DashboardGUI() {
        setTitle("Real Estate Dashboard"); // title window
        setSize(900,600); // size
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // display frame in center
        setLayout(new BorderLayout());

        JLabel title = new JLabel( "REAL ESTATE MANAGEMENT SYSTEM",SwingConstants.CENTER); // dashboard title 
        title.setFont(new Font("Arial", Font.BOLD, 28)); // dashboard title size and font
        title.setForeground(new Color(44,62,80)); // dashboard title color
        title.setBorder(BorderFactory.createEmptyBorder(20,0,20,0) );
        add(title,BorderLayout.NORTH); // dashboard title in the nourth

         // center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2,3,20,20));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30) );
        centerPanel.setBackground(new Color(240,248,255));
       
        
        // dashboard buttons
        JButton property = new JButton("Properties");
        JButton client = new JButton("Clients");
        JButton agent = new JButton("Agents");
        JButton owner = new JButton("Owners");
        JButton transaction = new JButton("Transactions");
        JButton exit = new JButton("Exit");

        // store button inside array
        JButton[] buttons = {property,client,agent,owner,transaction,exit};
        // style all buttons
        for(JButton btn : buttons) {
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.setBackground(new Color(52,152,219));
            btn.setForeground(Color.WHITE);
            centerPanel.add(btn);
        }
        add(centerPanel, BorderLayout.CENTER);

        property.addActionListener(e -> new PropertyView().setVisible(true)); // open property screan
        owner.addActionListener(e -> new OwnerView().setVisible(true)); // open owner screan
        client.addActionListener(e -> new ClientView().setVisible(true)); // open client screan
        agent.addActionListener(e -> new AgentView().setVisible(true)); // open agent screan
        transaction.addActionListener(e ->new TransactionView().setVisible(true)); // open transaction screan
        exit.addActionListener(e ->System.exit(0)); // exsit system

        setVisible(true);
    }
}




