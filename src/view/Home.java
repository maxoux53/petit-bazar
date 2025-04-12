package view;

import javax.swing.*;
import java.awt.*;

public class Home extends JPanel {
    // Attributes
    private Window window;
    private Cart cart;
    
    // Constructors
    public Home() {
        setLayout(new GridLayout(5, 1, 0, 0));
        setBackground(Color.white);
        
        // Title
        JLabel text = new JLabel("<html>Gestion du magasin<html>", SwingConstants.CENTER);
        text.setFont(new Font("SansSerif", Font.PLAIN, 50));
        JLabel shopName = new JLabel("Le P'tit Bazar", SwingConstants.CENTER);
        shopName.setFont(new Font("SansSerif", Font.PLAIN, 50));
        add(text);
        add(shopName);
        
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
