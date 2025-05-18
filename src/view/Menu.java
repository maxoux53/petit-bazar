package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JPanel {
    /* Attribut */
    private Window window;
    private JMenuBar menuBar;
    private JMenu application, product, employee;
    private JMenuItem home, leave, signOut;
    private JMenuItem addProduct, editProduct, deleteProduct, listingProduct;
    private JMenuItem addEmployee, editEmployee, deleteEmployee, listingEmployee;
    
    /* Constructeur */
    public Menu(Window window) {
        this.window = window;
        menuBar = new JMenuBar();
        application = new JMenu("Application");
        product = new JMenu("Article");
        employee = new JMenu("Employé");

        setBackground(Color.WHITE);

        /* Application */ /* Accueil */
        home = new JMenuItem("Accueil");
        
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.showHome();
            }
        });

        /* Application */ /* Se déconnecter */
        signOut = new JMenuItem("Se déconnecter");

        signOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                grayOut();
                window.showLogin();
            }
        });

        /* Application */ /* Quitter */
        leave = new JMenuItem("Quitter");

        leave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewCore.quit();
            }
        });

        application.add(home);
        application.add(signOut);
        application.add(leave);

        /* Article */ /* Ajouter un article */
        addProduct = new JMenuItem("Ajouter un article");

        addProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.showAddProduct();
            }
        });

        /* Article */ /* Modifier un article */
        editProduct = new JMenuItem("Modifier un article");

        editProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.showProductManagement();
            }
        });

        /* Article */ /* Supprimer un article */
        deleteProduct = new JMenuItem("Supprimer un article");
        
        deleteProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.showProductManagement();
            }
        });

        /* Article */ /* Gestion des articles */
        listingProduct = new JMenuItem("Gestion des articles");
        
        listingProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.showProductManagement();
            }
        });

        product.add(addProduct);
        product.add(editProduct);
        product.add(deleteProduct);
        product.add(listingProduct);

        /* Employé */ /* Ajouter un employé */
        addEmployee = new JMenuItem("Ajouter un employé");

        addEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.showAddEmployee();
            }
        });

        /*

        /* Employé */ /* Modifier un employé */
        editEmployee = new JMenuItem("Modifier un employé");

        editEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.showEmployeeManagement();
            }
        });

        /* Employé */ /* Supprimer un employé */
        deleteEmployee = new JMenuItem("Supprimer un employé");

        deleteEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.showEmployeeManagement();
            }
        });

        /* Employé */ /* Gestion des employés */
        listingEmployee = new JMenuItem("Gestion des employés");

        listingEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.showEmployeeManagement();
            }
        });

        employee.add(addEmployee);
        employee.add(editEmployee);
        employee.add(deleteEmployee);
        employee.add(listingEmployee);

        menuBar.add(application);
        menuBar.add(product);
        menuBar.add(employee);
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
