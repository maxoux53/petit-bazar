package view;

import javax.swing.*;
import java.awt.*;

public class Home extends JPanel {
    // Attributes
    private Cart cart;
    private CartThread cartThread;
    
    // Constructors
    public Home() {
        setLayout(new GridLayout(5, 1, 0, 0));
        setBackground(Color.white);
        
        // Title
        JLabel text = new JLabel("Gestion du magasin", SwingConstants.CENTER);
        text.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.BOLD, FontPreferences.TITLE_SIZE));
        JLabel storeName = new JLabel(ViewCore.NAME, SwingConstants.CENTER);
        storeName.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.BOLD, FontPreferences.TITLE_SIZE));
        add(text);
        add(storeName);
        
        // Cart
        cart = new Cart();
        
        // Cart Thread
        setCartThread(new CartThread(this));
        cartThread.start();
    }

    // Getters
    public Cart getCart() {
        return cart;
    }

    public CartThread getCartThread() {
        return cartThread;
    }
    
    // Setters
    public void setCartThread(CartThread cartThread) {
        this.cartThread = cartThread;
    }

    // Methods
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        cart.draw(g);
    }
}
