// GUI screan used for property mangment
package com.mycompany.realestate.GUI;
import com.mycompany.realestate.models.Apartment;
import com.mycompany.realestate.models.Land;
import com.mycompany.realestate.models.Property;
import com.mycompany.realestate.models.Villa;
import com.mycompany.realestate.service.PropertyService;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

   public class PropertyView extends JFrame {
    // input fields
    JTextField locationField =new JTextField();
    JTextField statusField =new JTextField();
    JTextField ownerIDField = new JTextField();
    JTextField agentIDField =new JTextField();
    JTextField priceField =new JTextField();
    JTextField idField = new JTextField();
    
    // property type selection
    JComboBox<String> typeBox = new JComboBox<>(new String[]{ "Villa","Apartment","Land" } );
    // property used to sisplay properties
    JTextArea area =new JTextArea();

    //buttons
    JButton save = new JButton("Save Property");
    JButton show = new JButton("Show Properties");
    JButton update = new JButton("Update Property");
    JButton delete = new JButton("Delete Property");
    
    // object service
    PropertyService service = new PropertyService();

    public PropertyView() {
        setTitle("Property Management"); // title  window
        setSize(900,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
         // screan title style
        JLabel titel = new JLabel("Property Management",SwingConstants.CENTER); 
        titel.setFont(new Font ("Arial",Font.BOLD,24));
        titel.setForeground(new Color(44,62,80));
        titel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titel,BorderLayout.NORTH);
        
        // main panel
        JPanel panel =new JPanel();
        panel.setLayout(new GridLayout(9,2,15,15));
        panel.setBorder(
        BorderFactory.createEmptyBorder(20,20,20,20));
        panel.setBackground(new Color(240,248,255));
        
        // property fields
        panel.add(new JLabel("Location"));
        panel.add(locationField);
        panel.add(new JLabel("Status"));
        panel.add(statusField);
        panel.add(new JLabel("Property Type"));
        panel.add(typeBox);
        panel.add(new JLabel("Owner ID"));
        panel.add(ownerIDField);
        panel.add(new JLabel("Agent ID"));
        panel.add(agentIDField);
        panel.add(new JLabel("Price"));
        panel.add(priceField);
        panel.add(new JLabel("propertyid"));
        panel.add(idField);
        
        // buttons style
        save.setBackground(new Color(52,152,219));
        save.setForeground(Color.WHITE);
        show.setBackground(new Color(46,204,113));
        show.setForeground(Color.WHITE);
        update.setBackground(new Color(52,152,219));
        update.setForeground(Color.WHITE);
        delete.setBackground(new Color(52,152,219));
        delete.setForeground(Color.WHITE);
        
        panel.add(save);
        panel.add(show);
        panel.add(update);
        panel.add(delete);
        
        add(panel, BorderLayout.CENTER);
        area.setEditable(false);
        add(new JScrollPane(area),BorderLayout.SOUTH);
        
         // action listener for enter save
        save.addActionListener(e -> {
            try {
                String type =typeBox.getSelectedItem().toString();
                Property p;
                // create villa type
                if (type.equals("Villa")) {
                    p = new Villa(0,
                            locationField.getText(),
                            statusField.getText(),
                            Integer.parseInt(ownerIDField.getText()),
                            Integer.parseInt(agentIDField.getText()),
                            Double.parseDouble(priceField.getText())
                    );
                    // create apartment type
                } else if (type.equals("Apartment")) {
                    p = new Apartment(0,
                           locationField.getText(),
                            statusField.getText(),
                            Integer.parseInt(ownerIDField.getText()),
                            Integer.parseInt(agentIDField.getText()),
                            Double.parseDouble(priceField.getText())         
                    );
                     // create land type
                } else {
                    p = new Land( 0,
                            locationField.getText(),
                            statusField.getText(),
                            Integer.parseInt(ownerIDField.getText()),
                            Integer.parseInt(agentIDField.getText()),
                            Double.parseDouble(priceField.getText())
                    );
                }
                // save property
                service.addProperty(p);
                JOptionPane.showMessageDialog(null,"Property Saved ️");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        });
          // action listener for enter show
        show.addActionListener(e -> {
            area.setText("");
            for (Property p :service.getProperties()) {
               area.append(
                        p.getPropertyID() + " | " +
                        p.getLocation() + " | " +
                        p.getStatus() + " | " +
                        p.getPropertyType() + " | " +
                        p.getOwnerID() + " | " +
                        p.getAgentID() + " | " +
                        p.getPrice() + "\n" );}
        });
        
         // action listener for enter update
        update.addActionListener(e -> {
         try {
        String type = typeBox.getSelectedItem().toString();
        Property p;
        int id = Integer.parseInt(idField.getText());
        if (type.equals("Villa")) {
            //update villa
            p = new Villa(
                    id,
                    locationField.getText(),
                    statusField.getText(),
                    Integer.parseInt(ownerIDField.getText()),
                    Integer.parseInt(agentIDField.getText()),
                    Double.parseDouble(priceField.getText())
            );
        } 
        //update apartment
        else if (type.equals("Apartment")) {
            p = new Apartment(
                    id,
                    locationField.getText(),
                    statusField.getText(),
                    Integer.parseInt(ownerIDField.getText()),
                    Integer.parseInt(agentIDField.getText()),
                    Double.parseDouble(priceField.getText())
            );
        } else {
            //update land
            p = new Land(
                    id,
                    locationField.getText(),
                    statusField.getText(),
                    Integer.parseInt(ownerIDField.getText()),
                    Integer.parseInt(agentIDField.getText()),
                    Double.parseDouble(priceField.getText())
            );
        }
        service.updateProperty(p); //update property
        JOptionPane.showMessageDialog(null, "Property Updated");
    } 
         catch (Exception ex) {
         JOptionPane.showMessageDialog(null,ex.getMessage());
    }
    });
         // action listener for enter delete
        delete.addActionListener(e -> {
       try {
        int id = Integer.parseInt(idField.getText());
        boolean deleted = service.deleteProperty(id);
        if (deleted){
            JOptionPane.showMessageDialog(null, "property deleted");
        } else {
            JOptionPane.showMessageDialog(null, "property id not found");
        }
    } catch (Exception ex){
        JOptionPane.showMessageDialog(null, "invalid id");
    }
});
   setVisible(true);
    }

}
