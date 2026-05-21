package com.mycompany.realestate.GUI;
import com.mycompany.realestate.service.UserService;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;

public class LoginGUI extends JFrame {
     public LoginGUI(){
        setTitle("Real Estate Login");
        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(240,248,255));

        JLabel title = new JLabel("REAL ESTATE SYSTEM");
        title.setBounds(90,40,350,40);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(44,62,80));
        panel.add(title);


        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(70,120,100,30);
        userLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(userLabel);
        JTextField user = new JTextField();
        user.setBounds(170,120,220,35);
        user.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(user);


        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(70,180,100,30);
        passLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(passLabel);
        JPasswordField pass = new JPasswordField();
        pass.setBounds(170,180,220,35);
        pass.setFont(new Font("Arial", Font.PLAIN,14));
        panel.add(pass);


        JButton login = new JButton("LOGIN");
        login.setBounds(150,250,200,40);
        login.setFont(new Font("Arial", Font.BOLD, 16));
        login.setBackground(new Color(52,152,219));
        login.setForeground(Color.WHITE);
        panel.add(login);
        
        JButton Create = new JButton("CREATE ACCOUNT");
        Create.setBounds(150,310,200,40);
        Create.setFont(new Font("Arial", Font.BOLD, 16));
        Create.setBackground(new Color(52,152,219));
        Create.setForeground(Color.WHITE);
        panel.add(Create);

        login.addActionListener(e -> {
          try {
            UserService service = new UserService();
            boolean valid = service.checkLogin(user.getText(),pass.getText());
        if(valid) {
            dispose();
            new DashboardGUI().setVisible(true); }
        else {
            JOptionPane.showMessageDialog(null,"Wrong Email or Password");
        }

    } catch (Exception ex) {
          JOptionPane.showMessageDialog(null,ex.getMessage());
    }
     });
        Create.addActionListener(e -> {
            new RegisterGUI().setVisible(true);
        });
        add(panel);
        setVisible(true);

    }
     
}