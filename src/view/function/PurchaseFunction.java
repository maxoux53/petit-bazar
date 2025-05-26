package view.function;

import controller.PurchaseController;
import exceptions.DAORetrievalFailedException;
import model.SalesInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PurchaseFunction extends JPanel {
    private JTextField categoryField;
    private JButton searchButton;
    private JTable resultTable;
    private DefaultTableModel tableModel;

    private PurchaseController controller;

    public PurchaseFunction() {
        setController(new PurchaseController());
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Catégorie :"));
        categoryField = new JTextField(15);
        topPanel.add(categoryField);

        searchButton = new JButton("Rechercher");
        topPanel.add(searchButton);

        add(topPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{
                "Code-barres",
                "Nom",
                "Quantité vendue"
        }, 0);

        resultTable = new JTable(tableModel);
        add(new JScrollPane(resultTable), BorderLayout.CENTER);

        searchButton.addActionListener(e -> functionPurchase());
    }

    private void functionPurchase() {
        String categoryLabel = categoryField.getText().trim();

        if (categoryLabel.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Veuillez entrer un nom de catégorie",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            ArrayList<SalesInfo> results = controller.salesRanking(categoryLabel);
            fillTable(results);
        } catch (DAORetrievalFailedException e) {
            JOptionPane.showMessageDialog(this,
                    "Erreur lors de la récupération des données : " + e.getMessage(),
                    "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fillTable(ArrayList<SalesInfo> results) {
        tableModel.setRowCount(0);

        for (SalesInfo info : results) {
            tableModel.addRow(new Object[]{
                    info.getProductBarcode(),
                    info.getProductName(),
                    info.getSumQuantity()
            });
        }

        if (results.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Aucun résultat trouvé pour cette catégorie",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void setController(PurchaseController controller) {
        this.controller = controller;
    }
}
