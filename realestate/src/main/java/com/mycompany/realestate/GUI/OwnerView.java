// GUI owner used for Owner mangment
package com.mycompany.realestate.GUI;
import com.mycompany.realestate.models.Owner;
import com.mycompany.realestate.service.OwnerService;
import javax.swing.*;
import java.awt.*;

public class OwnerView extends JFrame {
    // inpout JtextField
    JTextField emailField = new JTextField();
    JTextField firstNameField = new JTextField();
    JTextField lastNameField = new JTextField();
    JTextField phoneField = new JTextField();
    JTextField ownerNameField =  new JTextField();
    JTextArea area =  new JTextArea();
    
    // buttons
    JButton save =new JButton("Save Owner");
    JButton show = new JButton("Show Owners");

    // object service
    OwnerService service = new OwnerService();

    public OwnerView() {
        setTitle("Owner Management"); // title window
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        //  title style  
        JLabel titel = new JLabel("Owner Mangmaent",SwingConstants.CENTER);
        titel.setFont(new Font("Arial",Font.BOLD,24));
        titel.setForeground(new Color (44,62,80));
        titel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titel,BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,2,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        // owner email field
        panel.add(new JLabel("Email"));
        panel.add(emailField);
         // owner Fname field
        panel.add(new JLabel("First Name"));
        panel.add(firstNameField);
         // owner Lname field
        panel.add(new JLabel("Last Name"));
        panel.add(lastNameField);
         // owner phonenumber field
        panel.add(new JLabel("Phone Number"));
        panel.add(phoneField);
         // owner name field
        panel.add(new JLabel("Owner Name"));
        panel.add(ownerNameField);
        
        // button style
        save.setBackground(new Color(52,152,219));
        save.setForeground(Color.WHITE);
        show.setBackground(new Color(46,204,113));
        show.setForeground(Color.WHITE);

        panel.add(save);
        panel.add(show);
        
        add(panel, BorderLayout.CENTER);
        area.setEditable(false);
        add(new JScrollPane(area),BorderLayout.SOUTH);
        
         // action listener for enter save
        save.addActionListener(e -> {
            try {
                Owner o = new Owner( 0,
                        emailField.getText(),
                        firstNameField.getText(),
                        lastNameField.getText(),
                        phoneField.getText(),
                        ownerNameField.getText()
                );
                service.addOwner(o);
                JOptionPane.showMessageDialog(null, "Owner Saved " );         
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        });

       // action listener for enter show
        show.addActionListener(e -> {
            area.setText("");
            for (Owner o : service.getOwners()) {
                area.append(
                        o.getOwnerId() + " | " +
                        o.getEmail() + " | " +
                        o.getFirstName() + " | " +
                        o.getLastName() + " | " +
                        o.getPhoneNumber() + " | " +
                        o.getOwnerName() + "\n"
                );
            }
        });

        setVisible(true);
    }
    }

