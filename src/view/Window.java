package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

        // Menu bar
        menu = new Menu(this);
        setJMenuBar(menu.getMenuBar());
        menu.grayOut();

        // Login
        login = new Login(this);
        
        container = getContentPane();
        container.add(login);
        setCurrentPanel(login);
        
        // Visible
        setVisible(true);
    }
    
    public void showHome() {
        if (currentPanel != home) {
            container.remove(currentPanel);

            menu.activate();
            home = new Home();
            
            container.add(menu);
            container.add(home);

            setCurrentPanel(home);
            
            container.revalidate();
            container.repaint();
        }
    }

    public void showLogin() {
        if (currentPanel != login) {
            container.remove(currentPanel);
            menu.grayOut();

            container.add(login);
            setCurrentPanel(login);

            container.revalidate();
            container.repaint();
        }
    }

    private void setCurrentPanel(JPanel currentPanel) {
        if (home != null && currentPanel != home) {
            home.getCartThread().setRunning(false);
        }

        this.currentPanel = currentPanel;
    }

    private static void applyPlatformSpecificSettings() { // migration to final main

        // Apple macOS
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("apple.awt.application.name", "Le p'tit bazar");
        }
    }
}
