package view;

import java.awt.*;

public class Cart {
    // Attributes
    Rectangle cart;
    int stepX = -2;
    
    // Constructors
    public Cart() {
        cart = new Rectangle(1774, 670, 300, 10);
    }
    
    // Methods
    public void draw(Graphics g) {
        g.setColor(Color.black);
        
        // Cart body
        g.fillRect(cart.x, cart.y, 300, 10);
        g.fillOval(cart.x - 5, cart.y, 10, 10);
        g.fillRect(cart.x + 290, cart.y - 140, 10, 150);
        g.fillRect(cart.x + 290, cart.y - 140, 50, 10);
        
        // Wheels
        g.fillOval(cart.x, cart.y + 10, 60, 60);
        g.fillOval(cart.x + 250, cart.y + 10, 60, 60);
        
        // Box
        g.setColor(new Color(255, 155, 68));
        g.fillRect(cart.x + 40, cart.y - 80, 100, 80);
        g.setColor(Color.DARK_GRAY);
        g.drawRect(cart.x + 40, cart.y - 80, 100, 80);
        
        g.setColor(new Color(255, 155, 68));
        g.fillRect(cart.x + 160, cart.y - 80, 100, 80);
        g.setColor(Color.DARK_GRAY);
        g.drawRect(cart.x + 160, cart.y - 80, 100, 80);
        
        g.setColor(new Color(255, 155, 68));
        g.fillRect(cart.x + 120, cart.y - 160, 100, 80);
        g.setColor(Color.DARK_GRAY);
        g.drawRect(cart.x + 120, cart.y - 160, 100, 80);
    }
    
    public void move() {
        cart.x += stepX;
        if (cart.x == -340) {
            cart.x = 1774;
        }
    }
}
