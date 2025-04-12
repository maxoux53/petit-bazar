package view;

public class CartThread extends Thread{
    // Attributes
    private Home homePage;
    
    // Constructors
    public CartThread(Home homePage) {
        this.homePage = homePage;
    }
    
    @Override
    public void run() {
        Cart cart = homePage.getCart();
        while (true) {
            cart.move();
            homePage.repaint();
            try {
                Thread.sleep(5);
            }catch (InterruptedException interruptedException) {
                throw new RuntimeException(interruptedException);
            }
        }
    }
}
