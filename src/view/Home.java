package view;

import javax.swing.*;
import java.awt.*;

public class Home extends JPanel {
    // Attributes
    private Window window;
    
    // Constructors
    public Home() {
        setLayout(new BorderLayout(20, 20));
        setBackground(Color.white);
        
        // Title
        JLabel welcome = new JLabel("Gestion du magasin\nLe p'tit bazar", SwingConstants.CENTER);
        welcome.setFont(new Font("SansSerif", Font.PLAIN, 50));
        add(welcome, BorderLayout.CENTER);
    }
}
