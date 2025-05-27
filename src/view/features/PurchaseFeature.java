package view.features;

import controller.ProductController;
import controller.PurchaseController;
import exceptions.DAORetrievalFailedException;
import exceptions.ProhibitedValueException;
import model.Category;
import model.SalesInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PurchaseFeature extends JPanel {
    private JComboBox<String> categoryComboBox;
    private ArrayList<Category> categories;
    private JButton searchButton;
    private JTable resultTable;
    private DefaultTableModel tableModel;

    private PurchaseController purchaseController;
    private ProductController productController;

    public PurchaseFeature() {
        setPurchaseController(new PurchaseController());
        setProductController(new ProductController());
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Catégorie :"));
        categoryComboBox = new JComboBox<>();
        
        try {
            categories = productController.getAllCategories();
            
            for (Category category : categories) {
                categoryComboBox.addItem(category.getLabel());
            }
            
        } catch (DAORetrievalFailedException | ProhibitedValueException e) {
            JOptionPane.showMessageDialog(this, "Erreur lors de la récupération des données : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        
        topPanel.add(categoryComboBox);

        searchButton = new JButton("Rechercher");
        topPanel.add(searchButton);

        add(topPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{
                "Code-barres",
                "Nom",
                "Quantité vendue"
        }, 0);

        resultTable = new JTable(tableModel);
        resultTable.setDefaultEditor(Object.class, null);
        add(new JScrollPane(resultTable), BorderLayout.CENTER);

        searchButton.addActionListener(e -> functionPurchase());
    }

    private void functionPurchase() {
        Category categorySelected = categories.get(categoryComboBox.getSelectedIndex());
        
        try {
            ArrayList<SalesInfo> results = purchaseController.salesRanking(categorySelected.getLabel());
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

    // Getters
    public void setPurchaseController(PurchaseController purchaseController) {
        this.purchaseController = purchaseController;
    }

    public void setProductController(ProductController productController) {
        this.productController = productController;
    }
}
