package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JPanel {
    // Attributes
    /*private Window window;
    private JMenuBar menuBar;
    private JMenu application;
    private JMenuItem home;
    private JMenuItem leave;
    private JMenuItem signOut;
    private JMenu product;
    private JMenuItem addProduct;
    private JMenuItem editProduct;*/

    private Window window;
    private JMenuBar menuBar;
    private JMenu application, product;
    private JMenuItem home, leave, signOut, addProduct, editProduct, deleteProduct, listingProduct;
    
    // Constructors
    public Menu(Window window) {
        this.window = window;
        menuBar = new JMenuBar();
        application = new JMenu("Application");
        product = new JMenu("Article");


        setBackground(Color.WHITE);



        // Application
        // Home
        home = new JMenuItem("Accueil");
        
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.showHome();
            }
        });
        
        // SignOut
        signOut = new JMenuItem("Se déconnecter");

        signOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                grayOut();
                window.showLogin();
            }
        });
        
        // Leave
        leave = new JMenuItem("Quitter");

        leave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewCore.quit();
            }
        });

        // Add items to application submenu
        application.add(home);
        application.add(signOut);
        application.add(leave);



        // Product
        // Add
        addProduct = new JMenuItem("Ajouter un article");

        addProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.showAddProduct();
            }
        });
        
        // Edit
        editProduct = new JMenuItem("Modifier un article");

        editProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.showEditProduct();
            }
        });
        
        // Delete
        deleteProduct = new JMenuItem("Supprimer un article");
        
        deleteProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.showDeleteProduct();
            }
        });
        
        // Listing
        listingProduct = new JMenuItem("Liste des Articles");
        
        listingProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.showListingProduct();
            }
        });

        // Add items to product submenu
        product.add(addProduct);
        product.add(editProduct);
        product.add(deleteProduct);
        product.add(listingProduct);

        // Add submenus to menu bar
        menuBar.add(application);
        menuBar.add(product);
    }

    // Getters
    public JMenuBar getMenuBar() {
        return menuBar;
    }

    // Methods
    public void toggleMenu(boolean status) {
        home.setEnabled(status);
        
        addProduct.setEnabled(status);
        
        editProduct.setEnabled(status);
        
        deleteProduct.setEnabled(status);
        
        listingProduct.setEnabled(status);
        
        signOut.setEnabled(status);

        menuBar.repaint();
    }

    public void grayOut() {
        toggleMenu(false);
    }

    public void activate() {
        toggleMenu(true);
    }
}    
