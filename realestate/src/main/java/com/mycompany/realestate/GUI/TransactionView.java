package com.mycompany.realestate.GUI;
import com.mycompany.realestate.models.Transaction;
import com.mycompany.realestate.service.TransactionService;
import com.mycompany.realestate.service.ExportTransaction;
import javax.swing.*;
import java.awt.*;

public class TransactionView extends JFrame {
    JTextField dateField = new JTextField();
    JTextField finalPriceField = new JTextField();
    JTextField clientField = new JTextField();
    JTextField agentField = new JTextField();
    JTextField propertyField = new JTextField();
    JTextArea area = new JTextArea();

    JButton save = new JButton("Save");
    JButton show = new JButton("Show Transactions");
    JButton Export = new JButton("Export");

    TransactionService service = new TransactionService();
    ExportTransaction seervice = new ExportTransaction();

    public TransactionView() {
        setTitle("Transaction Management");
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titel = new JLabel("Transaction Mangmaent",SwingConstants.CENTER);
        titel.setFont(new Font("Arial",Font.BOLD,24));
        titel.setForeground(new Color (44,62,80));
        titel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titel,BorderLayout.NORTH);

       
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9,2,15,15));
        panel.setBorder( BorderFactory.createEmptyBorder(15,15,15,15));
        
        panel.add(new JLabel("Date"));
        panel.add(dateField);

        panel.add(new JLabel("Final Price"));
        panel.add(finalPriceField);

        panel.add(new JLabel("Client ID"));
        panel.add(clientField);

        panel.add(new JLabel("Agent ID"));
        panel.add(agentField);

        panel.add(new JLabel("Property ID"));
        panel.add(propertyField);
        
        save.setBackground(new Color(52,152,219));
        save.setForeground(Color.WHITE);
        show.setBackground(new Color(46,204,113));
        show.setForeground(Color.WHITE);
        Export.setBackground(new Color(52,152,219));
        Export.setForeground(Color.WHITE);
       
        panel.add(save);
        panel.add(show);
        panel.add(Export);

        add(panel, BorderLayout.CENTER);
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        add(scroll, BorderLayout.SOUTH);

        save.addActionListener(e -> {
            try {
                Transaction t = new Transaction( 0,
                dateField.getText(),
                Double.parseDouble( finalPriceField.getText() ),
                Integer.parseInt(clientField.getText()),
                Integer.parseInt( agentField.getText()),
                Integer.parseInt( propertyField.getText()));
                service.addTransaction(t);
                JOptionPane.showMessageDialog( null, "Transaction Saved" );
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        });
        show.addActionListener(e -> {
            area.setText("");
            for (Transaction t : service.getAll()) {
                area.append(
                        t.getId() + " | " +
                        t.getDate() + " | " +
                        t.getFinalPrice() + " | " +
                        t.getClientId() + " | " +
                        t.getAgentId() + " | " +
                        t.getPropertyId() + "\n"  );
  }
        });
        Export.addActionListener(e -> {
        seervice.exportTransactions();
        JOptionPane.showMessageDialog(null,"Export Successful " );
});
 
        setVisible(true);

    }

}

    

