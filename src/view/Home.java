package view;

import javax.swing.*;
import java.awt.*;

public class Home extends JPanel {
    // Attributes
    private Window window;
    private Cart cart;
    
    // Constructors
    public Home() {
        setLayout(new GridLayout(2, 1, 0, 0));
        setBackground(Color.white);
        
        // Title
        JLabel welcome = new JLabel("Gestion du magasin Le P'tit Bazar", SwingConstants.CENTER);
        welcome.setFont(new Font("SansSerif", Font.PLAIN, 50));
        add(welcome);
        
        // Cart
        cart = new Cart();
        
        // Cart Thread
        CartThread cartThread = new CartThread(this);
        cartThread.start();
    }

    // Getters
    public Cart getCart() {
        return cart;
    }

    // Methods
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        cart.draw(g);
    }
}
