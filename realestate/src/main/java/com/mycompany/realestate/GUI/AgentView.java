package com.mycompany.realestate.GUI;
import com.mycompany.realestate.service.AgentService;
import com.mycompany.realestate.models.Agent;
import javax.swing.*;
import java.awt.*;

public class AgentView  extends JFrame {
    
    JTextField agentNameField = new JTextField();
    JTextField firstNameField =  new JTextField();
    JTextField lastNameField = new JTextField();
    JTextField supervisesField = new JTextField();
    JTextArea area = new JTextArea();

    JButton save =new JButton("Save Agent");
    JButton show =new JButton("Show Agents");

    AgentService service = new AgentService();

    public AgentView() {
        setTitle("Agent Management");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JLabel titel = new JLabel("Agent Mangmaent",SwingConstants.CENTER);
        titel.setFont(new Font("Arial",Font.BOLD,24));
        titel.setForeground(new Color (44,62,80));
        titel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titel,BorderLayout.NORTH);
       
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,2,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
       

        panel.add(new JLabel("Agent Name"));
        panel.add(agentNameField);

        panel.add(new JLabel("First Name"));
        panel.add(firstNameField);

        panel.add(new JLabel("Last Name"));
        panel.add(lastNameField);

        panel.add(new JLabel("Supervises ID"));
        panel.add(supervisesField);

        save.setBackground(new Color(52,152,219));
        save.setForeground(Color.WHITE);
        show.setBackground(new Color(46,204,113));
        show.setForeground(Color.WHITE);
        
        panel.add(save);
        panel.add(show);
        add(panel, BorderLayout.CENTER);
        add(new JScrollPane(area), BorderLayout.SOUTH);
        
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


