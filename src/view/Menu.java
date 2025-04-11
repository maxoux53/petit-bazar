package view;

import javax.swing.*;
import java.awt.*;
import java.rmi.dgc.Lease;

public class Menu extends JPanel {
    // Attributes
    private Window window;
    private JMenuBar menuBar;


    // Constructors
    public Menu(Window window) {
        this.window = window;
        menuBar = new JMenuBar();

        setBackground(Color.WHITE);

        // Menu
        JMenu application = new JMenu("Application");
        JMenu edit = new JMenu("Édition d'article");

        // Application
        JMenuItem signOut = new JMenuItem("Se déconnecter");
        signOut.addActionListener(e -> {
            window.showLogin();
        });
        window.showLogin();

        JMenuItem leave = new JMenuItem("Quitter");
        leave.addActionListener(e -> {
            System.exit(0);
        });
        application.add(signOut);
        application.add(leave);

        // Edit
        JMenuItem add = new JMenuItem("Ajouter un article");
        edit.add(add);

        // Add
        menuBar.add(application);
        menuBar.add(edit);
    }

    // Getters
    public JMenuBar getMenuBar() {
        return menuBar;
    }
}    
