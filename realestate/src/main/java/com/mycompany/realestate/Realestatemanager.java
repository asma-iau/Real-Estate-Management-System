
package com.mycompany.realestate;
import com.mycompany.realestate.GUI.LoginGUI;
import javax.swing.SwingUtilities;

public class Realestatemanager {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()  -> {
            new LoginGUI().setVisible(true);
        });
    }
}
