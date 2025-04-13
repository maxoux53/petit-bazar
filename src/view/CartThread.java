package view;

import javax.swing.*;

public class CartThread extends Thread {
    // Attributes
    private Home homePage;
    private boolean running; // needs a better name
    
    // Constructors
    public CartThread(Home homePage) {
        this.homePage = homePage;
    }

    public void setRunning(boolean isHomePageActive) {
        this.running = isHomePageActive;
    }

    @Override
    public void run() {
        Cart cart = homePage.getCart();

        while (running) {
            cart.move();
            homePage.repaint();
            System.out.println("test"); // DEBUG

            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Le temps d'attente de l'animation du chariot a échoué.\nErreur : " + e.getMessage(), "Critical Thread Error", JOptionPane.ERROR_MESSAGE); // should have a parent component?
                System.exit(1); // DEBUG ONLY, SHOULD BE REMOVED IN THE NEAR FUTURE!! ⚠️
            }
        }
    }
}
