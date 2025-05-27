package view.research;

import controller.ProductController;
import exceptions.*;
import model.Brand;
import model.ProductInformation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ProductResearch extends JPanel {
    private JComboBox<String> brandComboBox; // Choix du nom de la marque
    private ArrayList<Brand> brands; // Liste des marques
    private JButton searchButton; // Entrée - Bouton "Rechercher"
    private JTable resultTable; // Sortie - Tableau des produits
    private DefaultTableModel tableModel; // Modèle du tableau des produits

    private ProductController controller;

    public ProductResearch() {
        setController(new ProductController());
        setLayout(new BorderLayout());

        // Initialisation du JPanel (brandIdField)
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Identifiant de la marque :"));
        brandComboBox = new JComboBox<>();
        
        try {
            brands = controller.getAllBrands();
            
            for (Brand brand : brands) {
                brandComboBox.addItem(brand.getName());
            }
        } catch (DAORetrievalFailedException | ProhibitedValueException e) {
            JOptionPane.showMessageDialog(this, "Erreur lors de la récupération des données : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }


        topPanel.add(brandComboBox);

        // Initialisation du JButton (searchButton)
        searchButton = new JButton("Rechercher");
        topPanel.add(searchButton);

        add(topPanel, BorderLayout.NORTH);

        // Initialisation du modèle du tableau des produits
        tableModel = new DefaultTableModel(new Object[]{
                "Nom",
                "Catégorie",
                "TVA (%)"},
                0
        );

        resultTable = new JTable(tableModel);

        add(new JScrollPane(resultTable), BorderLayout.CENTER);

        // Mise en fonction du JButton (searchButton)
        searchButton.addActionListener(e -> searchProduct());
    }

    private void searchProduct() {
        Brand brandSelectd = brands.get(brandComboBox.getSelectedIndex());
        
        try {
            ArrayList<ProductInformation> results = controller.getProductInformationByBrand(brandSelectd.getId()); // Récupération des données
            fillTable(results);
        } catch (DAORetrievalFailedException ex) {
            JOptionPane.showMessageDialog(this, "Erreur lors de la récupération des données : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fillTable(ArrayList<ProductInformation> products) {
        tableModel.setRowCount(0); // Réinitialisation du tableau

        for (ProductInformation pi : products) { // Remplissage du tableau avec les données
            tableModel.addRow(new Object[]{
                    pi.getProductName(),
                    pi.getCategoryName(),
                    pi.getVatRate()
            });
        }

        if (products.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aucun produit trouvé pour cette marque", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void setController(ProductController controller) {
        this.controller = controller; // Setter du Controller
    }
}
