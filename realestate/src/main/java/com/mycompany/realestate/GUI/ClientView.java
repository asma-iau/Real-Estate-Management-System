package com.mycompany.realestate.GUI;
import com.mycompany.realestate.models.Client;
import com.mycompany.realestate.service.ClientService;
import javax.swing.*;
import java.awt.*;

public class ClientView extends JFrame {
 
    JTextField nameField = new JTextField();
    JTextField phoneField = new JTextField();
    JTextField emailField = new JTextField();
    JTextArea area = new JTextArea();

    JButton save =new JButton("Save Client");
    JButton show =new JButton("Show Clients");

    ClientService service = new ClientService();

    public ClientView() {
        setTitle("Client Management");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JLabel titel = new JLabel("Client Mangmaent",SwingConstants.CENTER);
        titel.setFont(new Font("Arial",Font.BOLD,24));
        titel.setForeground(new Color (44,62,80));
        titel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titel,BorderLayout.NORTH);

        
        JPanel panel =new JPanel();
        panel.setLayout(new GridLayout(4,2,10,10));
        panel.setBorder(
        BorderFactory.createEmptyBorder(20,20,20,20) );
        panel.setBackground(new Color(240,248,255));

        panel.add(new JLabel("Client Name"));
        panel.add(nameField);

        panel.add(new JLabel("Phone Number"));
        panel.add(phoneField);

        panel.add(new JLabel("Email"));
        panel.add(emailField);
        
        save.setBackground(new Color(52,152,219));
        save.setForeground(Color.WHITE);
        
        show.setBackground(new Color(46,204,113));
        show.setForeground(Color.WHITE);

        panel.add(save);
        panel.add(show);

        add(panel, BorderLayout.CENTER);
        area.setEditable(false);

        add(new JScrollPane(area),BorderLayout.SOUTH);
        
        save.addActionListener(e -> {
            try {
                Client c = new Client(0,
                        nameField.getText(),
                        phoneField.getText(),
                        emailField.getText()
                );
                service.addClient(c);
                JOptionPane.showMessageDialog(null,"Client Saved");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });
        show.addActionListener(e -> {
           area.setText("");
            for (Client c : service.getClients()) {
                area.append(
                        c.getClientID() + " | " +
                        c.getName() + " | " +
                        c.getPhoneNumber() + " | " +
                        c.getEmail() + "\n"
                );
            }
        });
        setVisible(true);
    }

    }

