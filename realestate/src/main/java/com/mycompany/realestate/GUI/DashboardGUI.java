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
        setTitle("Real Estate Dashboard");
        setSize(900,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel title = new JLabel( "REAL ESTATE MANAGEMENT SYSTEM",SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(new Color(44,62,80));
        title.setBorder(BorderFactory.createEmptyBorder(20,0,20,0) );
        add(title,BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2,3,20,20));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30) );
        centerPanel.setBackground(new Color(240,248,255));
        

        JButton property = new JButton("Properties");
        JButton client = new JButton("Clients");
        JButton agent = new JButton("Agents");
        JButton owner = new JButton("Owners");
        JButton transaction = new JButton("Transactions");
        JButton exit = new JButton("Exit");

        JButton[] buttons = {property,client,agent,owner,transaction,exit};
        for(JButton btn : buttons) {
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.setBackground(new Color(52,152,219));
            btn.setForeground(Color.WHITE);
            centerPanel.add(btn);
        }
        add(centerPanel, BorderLayout.CENTER);

        property.addActionListener(e -> new PropertyView().setVisible(true));
        owner.addActionListener(e -> new OwnerView().setVisible(true));
        client.addActionListener(e -> new ClientView().setVisible(true));
        agent.addActionListener(e -> new AgentView().setVisible(true));
        transaction.addActionListener(e ->new TransactionView().setVisible(true));
        exit.addActionListener(e ->System.exit(0));

        setVisible(true);
    }
}




