package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JPanel {
    // Attributes
    private Window window;
    private JMenuBar menuBar;
    private JMenu edit;
    private JMenuItem signOut;


    // Constructors
    public Menu(Window window) {
        this.window = window;
        menuBar = new JMenuBar();

        setBackground(Color.WHITE);

        // Menu
        JMenu application = new JMenu("Application");
        edit = new JMenu("Édition d'articles");

        // Application
        signOut = new JMenuItem("Se déconnecter");

        signOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                grayOut();
                window.showLogin();
            }
        });
        window.showLogin();

        JMenuItem leave = new JMenuItem("Quitter");

        leave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
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

    // Methods
    public void toggleMenu(boolean status) {
        edit.setEnabled(status);

        signOut.setEnabled(status);

        menuBar.repaint();
    }

    public void grayOut() {
        toggleMenu(false);
    }

    public void activate() {
        toggleMenu(true);
    }

    // Getters
    public JMenuBar getMenuBar() {
        return menuBar;
    }
}    
