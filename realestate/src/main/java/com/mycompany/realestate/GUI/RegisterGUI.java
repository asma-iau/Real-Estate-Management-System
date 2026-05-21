// screan for creating new accounts
package com.mycompany.realestate.GUI;
import com.mycompany.realestate.models.User;
import com.mycompany.realestate.service.UserService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RegisterGUI extends JFrame {
    //input fields
    JTextField nameField =new JTextField();
    JTextField emailField =new JTextField();
    // passwoard fields
    JPasswordField passwordField = new JPasswordField();
    // button register
    JButton register =new JButton("Register");
    // service object
    UserService service =new UserService();

    public RegisterGUI() {
        setTitle("Create Account"); // title window
        setSize(500,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //  title style  
        JLabel title = new JLabel("CREATE ACCOUNT",SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(44,62,80));
        title.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        add(title, BorderLayout.NORTH);
        
        // main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,2,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        panel.setBackground(new Color(240,248,255));

        // name field
        panel.add(new JLabel("Name"));
        panel.add(nameField);
        //email field
        panel.add(new JLabel("Email"));
        panel.add(emailField);
        // password field
        panel.add(new JLabel("Password"));
        panel.add(passwordField);

        // button style
        register.setBackground(new Color(52,152,219));
        register.setForeground(Color.WHITE);
        panel.add(register);
        add(panel,BorderLayout.CENTER);

        // action listener for enter register
        register.addActionListener(e -> {
            try {
                String name =nameField.getText();
                String email =emailField.getText();
                String password =passwordField.getText();
                // validate empty fields
                if(
                        name.isEmpty() ||
                        email.isEmpty() ||
                        password.isEmpty()
                ) {
                    JOptionPane.showMessageDialog(null,"Please fill all fields");
                    return;
                }
                // validate email format
                if(!email.contains("@")) {
                    JOptionPane.showMessageDialog(null,"Invalid Email");
                    return;
                }
                //  validate passwords length
                if(password.length() < 8) {
                    JOptionPane.showMessageDialog( null, "Password must be at least 8 characters");
                    return;
                }
                //create user object
                User u = new User( 0,name,email,password);
                // save user
                service.addUser(u);
                JOptionPane.showMessageDialog(null, "Account Created");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        });

        setVisible(true);
    }
    
}
