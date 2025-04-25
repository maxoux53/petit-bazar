package view;

import javax.swing.*;

public class CartThread extends Thread {
    // Attributes
    private Home homePage;
    private boolean running;
    private Cart cart;
    
    // Constructors
    public CartThread(Home homePage) {
        this.homePage = homePage;
        cart = homePage.getCart();
    }

    public synchronized void setRunning(boolean isHomePageActive) {
        this.running = isHomePageActive;
        if (running) {
            notify();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (this) {
                    if (!running) {
                        wait();
                    }
                }

                cart.move();
                homePage.repaint();

                Thread.sleep(15);
            }
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(null, "L'animation du chariot a échoué !\nErreur : " + e.getMessage(), "Critical Thread Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
