package view.function;

import controller.PurchaseController;
import exceptions.*;
import model.LoyalCustomerPurchases;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class CustomerFunction extends JPanel {
    private JTextField idEmployeeField;
    private JButton searchButton;
    private JTable resultTable;
    private DefaultTableModel tableModel;

    private PurchaseController controller;

    public CustomerFunction() {
        setController(new PurchaseController());
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Identifiant de l'employé :"));
        idEmployeeField = new JTextField(10);
        topPanel.add(idEmployeeField);

        searchButton = new JButton("Rechercher");
        topPanel.add(searchButton);

        add(topPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{
                "Prénom du client",
                "Nom du client",
                "Nombre d'achats"},
                0);

        resultTable = new JTable(tableModel);

        add(new JScrollPane(resultTable), BorderLayout.CENTER);

        searchButton.addActionListener(e -> functionCustomer());
    }

    private void functionCustomer() {
        String idText = idEmployeeField.getText().trim();

        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un ID employé", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Integer employeeId;
        try {
            employeeId = Integer.parseInt(idText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "L'ID doit être un nombre entier", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            ArrayList<LoyalCustomerPurchases> results = controller.loyalCustomerPurchasesRankingByEmployee(employeeId);
            fillTable(results);
        } catch (DAORetrievalFailedException e) {
            JOptionPane.showMessageDialog(this, "Erreur lors de la récupération des données : " + e.getMessage(),
                    "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fillTable(ArrayList<LoyalCustomerPurchases> results) {
        tableModel.setRowCount(0);

        for (LoyalCustomerPurchases c : results) {
            tableModel.addRow(new Object[]{
                    c.getCustomerFirstName(),
                    c.getCustomerLastName(),
                    c.getPurchaseNb()
            });
        }

        if (results.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aucune transaction trouvée pour cet employé", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void setController(PurchaseController controller) {
        this.controller = controller;
    }
}
