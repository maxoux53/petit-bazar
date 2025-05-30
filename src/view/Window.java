package view;

import view.features.CustomerFeature;
import view.features.PurchaseFeature;
import view.product.AddProduct;
import view.product.EditProduct;
import view.product.ProductManagement;
import view.employee.AddEmployee;
import view.employee.EditEmployee;
import view.employee.EmployeeManagement;
import view.research.LocalityResearch;
import view.research.ProductResearch;
import view.research.TransactionResearch;

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
    private ProductManagement productManagement;
    private AddEmployee addEmployee; // Attribut - Ajout d'un employé
    private EditEmployee editEmployee; // Attribut - Modification d'un employé
    private EmployeeManagement employeeManagement; // Attribut - Gestion d'un employé
    private LocalityResearch localityResearch; // Attribut - Recherche 1
    private ProductResearch productResearch; // Attribut - Recherche 2
    private TransactionResearch transactionResearch; // Attribut - Recherche 3
    private CustomerFeature customerFeature; // Attribut - Fonctionnalité métier 1
    private PurchaseFeature purchaseFeature; // Attribut - Fonctionnalité métier 2

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
        editProduct = new EditProduct(this);
        productManagement = new ProductManagement(this);
        addEmployee = new AddEmployee(); // Panel - Ajout d'un employé
        editEmployee = new EditEmployee(this); // Panel - Modification d'un employé
        employeeManagement = new EmployeeManagement(this); // Panel - Gestion d'un employé
        localityResearch = new LocalityResearch(); // Panel - Recherche 1
        productResearch = new ProductResearch(); // Panel - Recherche 2
        transactionResearch = new TransactionResearch(); // Panel - Recherche 3
        customerFeature = new CustomerFeature(); // Panel - Fonctionnalité métier 1
        purchaseFeature = new PurchaseFeature(); // Panel - Fonctionnalité métier 2
        
        container = getContentPane();
        container.add(login);
        setCurrentPanel(login);
        
        // Visible
        setVisible(true);
    }
    
    // Getters

    public EditProduct getEditProduct() {
        return editProduct;
    }

    public EditEmployee getEditEmployee() { // Getter - Modification d'un employé
        return editEmployee;
    }

    // Methods
    
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

            container.revalidate();
            container.repaint();
        }
    }
    
    public void showProductManagement() {
        if (currentPanel != productManagement) {
            container.remove(currentPanel);
            
            productManagement.refreshTable();
            container.add(productManagement);
            setCurrentPanel(productManagement);

            container.revalidate();
            container.repaint();
        }
    }

    public void showAddEmployee() { // Show - Ajout d'un employé
        if (currentPanel != addEmployee) {
            container.remove(currentPanel);

            container.add(addEmployee);
            setCurrentPanel(addEmployee);

            container.revalidate();
            container.repaint();
        }
    }

    public void showEditEmployee() { // Show - Modification d'un employé
        if (currentPanel != editEmployee) {
            container.remove(currentPanel);

            container.add(editEmployee);
            setCurrentPanel(editEmployee);

            container.revalidate();
            container.repaint();
        }
    }

    public void showEmployeeManagement() { // Show - Gestion d'un employé
        if (currentPanel != employeeManagement) {
            container.remove(currentPanel);

            employeeManagement.refreshTable();
            container.add(employeeManagement);
            setCurrentPanel(employeeManagement);

            container.revalidate();
            container.repaint();
        }
    }

    public void showAddressResearch() { // Show - Recherche 1
        if (currentPanel != localityResearch) {
            container.remove(currentPanel);

            container.add(localityResearch);
            setCurrentPanel(localityResearch);

            container.revalidate();
            container.repaint();
        }
    }

    public void showProductResearch() { // Show - Recherche 2
        if (currentPanel != productResearch) {
            container.remove(currentPanel);

            container.add(productResearch);
            setCurrentPanel(productResearch);

            container.revalidate();
            container.repaint();
        }
    }

    public void showTransactionResearch() { // Show - Recherche 3
        if (currentPanel != transactionResearch) {
            container.remove(currentPanel);

            container.add(transactionResearch);
            setCurrentPanel(transactionResearch);

            container.revalidate();
            container.repaint();
        }
    }

    public void showCustomerFunction() { // Show - Fonctionnalité Métier 1
        if (currentPanel != customerFeature) {
            container.remove(currentPanel);

            container.add(customerFeature);
            setCurrentPanel(customerFeature);

            container.revalidate();
            container.repaint();
        }
    }

    public void showPurchaseFunction() { // Show - Fonctionnalité Métier 2
        if (currentPanel != purchaseFeature) {
            container.remove(currentPanel);

            container.add(purchaseFeature);
            setCurrentPanel(purchaseFeature);

            container.revalidate();
            container.repaint();
        }
    }

    private void setCurrentPanel(JPanel currentPanel) {
        if (home != null && currentPanel != home) {
            home.getCartThread().setRunning(false);
        }

        this.currentPanel = currentPanel;
    }
}
