package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

public class Window extends JFrame {
    // Attributes
    private Container container;
    private JPanel currentPanel;
    private Menu menu;
    private Login login;
    private Home home;

    static {
        applyPlatformSpecificSettings();
    }
    
    
    // Constructors
    public Window() {
        super("Le p'tit bazar");
        setBounds(0, 0, 1920, 1080);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                System.exit(0);
            }
        });

        // Login
        login = new Login(this);
        
        container = getContentPane();
        container.add(login);
        currentPanel = login;
        
        // Visible
        setVisible(true);
    }
    
    public void showHome() {
        if (currentPanel != home) {
            container.remove(currentPanel);

            menu = new Menu(this);
            setJMenuBar(menu.getMenuBar());
            home = new Home();
            
            container.add(menu);
            container.add(home);
            
            currentPanel = home;
            
            container.revalidate();
            container.repaint();
        }
    }

    public void showLogin() {
        if (currentPanel != login) {
            container.remove(currentPanel);
            setJMenuBar(null);

            container.add(login);
            currentPanel = login;

            container.revalidate();
            container.repaint();
        }
    }

    private static void applyPlatformSpecificSettings() { // migration to final main

        // Apple macOS
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("apple.awt.application.name", "Le p'tit bazar");
        }

    }
}
