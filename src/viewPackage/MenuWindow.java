package viewPackage;

import controllerPackage.CustomerController;
import viewPackage.customer.CustomerFormPanel;

import javax.swing.*;
import java.awt.event.*;

public class MenuWindow extends JFrame {
    private JMenuBar menuBar;

    private JMenu exitMenu;
    private JMenu customerMenu;

    private JMenuItem addCustomer;

    private CustomerController customerController;

    public MenuWindow() {
        super("Petit Bazar");

        this.setBounds(100, 100, 500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        customerController = new CustomerController();

        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        exitMenu = new JMenu("Quitter");
        menuBar.add(exitMenu);

        customerMenu = new JMenu("Client");
        menuBar.add(customerMenu);

        JMenuItem exitItem = new JMenuItem("Quitter");
        exitMenu.add(exitItem);
        exitItem.addActionListener(e -> System.exit(0));

        addCustomer = new JMenuItem("Ajouter un client");
        customerMenu.add(addCustomer);

        addCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CustomerFormPanel customerFormPanel = new CustomerFormPanel();
                setContentPane(customerFormPanel);
                revalidate();
                repaint();
            }
        });
    }
}
