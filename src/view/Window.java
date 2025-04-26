package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {
    // Attributes
    private Container container;
    private JPanel currentPanel;
    private Menu menu;
    private Login login;
    private Home home;
    private AddProduct addProduct;
    private EditProduct editProduct;

    // Constructors
    public Window(String title) {
        super(title);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                ViewCore.quit();
            }
        });

        // Menu bar
        menu = new Menu(this);
        setJMenuBar(menu.getMenuBar());
        menu.grayOut();

        // Create panel
        login = new Login(this);
        home = new Home();
        addProduct = new AddProduct();
        editProduct = new EditProduct();
        
        container = getContentPane();
        container.add(login);
        setCurrentPanel(login);
        
        // Visible
        setVisible(true);
    }
    
    public void showHome() {
        if (currentPanel != home) {
            container.remove(currentPanel);

            if (currentPanel == login) {
                menu.activate();
            }
            
            container.add(home);
            home.getCartThread().setRunning(true);
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
    
    public void showAddProduct() {
        if (currentPanel != addProduct) {
            container.remove(currentPanel);
            
            container.add(addProduct);
            setCurrentPanel(addProduct);

            container.revalidate();
            container.repaint();
        }
    }
    
    public void showEditProduct() {
        if (currentPanel != editProduct) {
            container.remove(currentPanel);
            
            container.add(editProduct);
            setCurrentPanel(editProduct);
            
            container.repaint();
            container.revalidate();
        }
    }

    private void setCurrentPanel(JPanel currentPanel) {
        if (home != null && currentPanel != home) {
            home.getCartThread().setRunning(false);
        }

        this.currentPanel = currentPanel;
    }
}
