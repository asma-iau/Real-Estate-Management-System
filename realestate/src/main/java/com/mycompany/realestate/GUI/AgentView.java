// GUI agent used for agent mangment 
package com.mycompany.realestate.GUI;
import com.mycompany.realestate.service.AgentService;
import com.mycompany.realestate.models.Agent;
import javax.swing.*;
import java.awt.*;

public class AgentView  extends JFrame {
     // input fields
    JTextField agentNameField = new JTextField();
    JTextField firstNameField =  new JTextField();
    JTextField lastNameField = new JTextField();
    JTextField supervisesField = new JTextField();
    JTextArea area = new JTextArea(); // area used for display agent

    // buttons
    JButton save =new JButton("Save Agent");
    JButton show =new JButton("Show Agents");

     // service object 
    AgentService service = new AgentService();

    public AgentView() {
        setTitle("Agent Management"); // title window
        setSize(700, 500); // size
        setLocationRelativeTo(null); //open in cnter
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // screan title and style 
        JLabel titel = new JLabel("Agent Mangmaent",SwingConstants.CENTER);
        titel.setFont(new Font("Arial",Font.BOLD,24));
        titel.setForeground(new Color (44,62,80));
        titel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titel,BorderLayout.NORTH);
       
         // main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,2,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
       
        // agent name field
        panel.add(new JLabel("Agent Name"));
        panel.add(agentNameField);
        // agent first name field
        panel.add(new JLabel("First Name"));
        panel.add(firstNameField);
         // agent last name field
        panel.add(new JLabel("Last Name"));
        panel.add(lastNameField);
         // agent supeevisse id field
        panel.add(new JLabel("Supervises ID"));
        panel.add(supervisesField);

         // button style
        save.setBackground(new Color(52,152,219));
        save.setForeground(Color.WHITE);
        show.setBackground(new Color(46,204,113));
        show.setForeground(Color.WHITE);
        
        panel.add(save);
        panel.add(show);
        add(panel, BorderLayout.CENTER);
        add(new JScrollPane(area), BorderLayout.SOUTH);
        
        // action listener for enter save
        save.addActionListener(e -> {
            try {
                int supID = 0;
                if (!supervisesField.getText().isEmpty()) {
                    supID = Integer.parseInt( supervisesField.getText()
                    );
                }
                Agent a = new Agent(0,
                        agentNameField.getText(),
                        firstNameField.getText(),
                        lastNameField.getText(),
                        supID
                );
                service.addAgent(a);
                JOptionPane.showMessageDialog( null, "Agent Saved ️" );

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        });

       // action listener for enter show
        show.addActionListener(e -> {
            area.setText("");
            for (Agent a :service.getAgents()) {
                area.append(
                        a.getAgentID() + " | " +
                        a.getName() + " | " +
                        a.getfirstName() + " | " +
                        a.getlasttName() + " | " +
                        a.getSupervises() + "\n"
                );
            }
        });
        setVisible(true);
    }
    }


