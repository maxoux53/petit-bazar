package view;

import model.Product;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class ListingProduct extends JPanel {
    // Attributes
    JPanel titlePanel;
    JLabel titleLabel;
    JPanel listingPanel;
    ArrayList<String> listingNameColumn;
    ArrayList<Product> listingValue;
    JTable listingTable;
    JScrollPane scrollPane;
    
    // Constructors
    public ListingProduct() {
        setLayout(new BorderLayout(0, 100));
        setBorder(BorderFactory.createEmptyBorder(20, 100, 100, 100));
        new GridLayout(2, 1, 0, 0);
        setBackground(Color.white);
        
        // Title
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.white);
        
        titleLabel = new JLabel("Liste des articles", SwingConstants.CENTER);
        titleLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.BOLD, FontPreferences.TITLE_SIZE.getSize()));
        
        titlePanel.add(titleLabel);
        
        // Listing
        listingPanel = new JPanel();
        listingPanel.setBackground(Color.red);
        
        listingNameColumn = new ArrayList<>();
        listingNameColumn.add("Code-barres");
        listingNameColumn.add("Nom");
        listingNameColumn.add("description");
        listingNameColumn.add("Quantité");
        listingNameColumn.add("Disponible");
        listingNameColumn.add("TVA");
        listingNameColumn.add("Catégorie");
        listingNameColumn.add("Marque");
        listingNameColumn.add("Prix HTVA");
        listingNameColumn.add("Date de mise en rayon");
        

        // Produit 1
        Product product1 = new Product(
                (long)100001,                           // barcode
                "Ordinateur portable",             // name
                "Ordinateur léger et rapide",       // description
                50,                                // amount
                true,                              // isAvailable
                'A',                               // vatType
                1,                                 // categoryId
                2,                                 // brandId
                BigDecimal.valueOf(999.99),                            // exclVatPrice
                LocalDate.of(2025, 5, 1)            // startDate
        );

        // Produit 2
        Product product2 = new Product(
                (long)100002,
                "Casque audio",
                "Casque sans fil avec réduction de bruit",
                30,
                true,
                'B',
                2,
                3,
                BigDecimal.valueOf(199.99),
                LocalDate.of(2025, 6, 10)
        );

        // Produit 3
        Product product3 = new Product(
                (long)100003,
                "Clavier mécanique",
                "Clavier RGB pour gamers",
                80,
                false,
                'A',
                3,
                4,
                BigDecimal.valueOf(89.99),
                LocalDate.of(2025, 7, 5)
        );

        // Produit 4
        Product product4 = new Product(
                (long)100004,
                "Souris ergonomique",
                "Souris confortable pour le bureau",
                100,
                true,
                'C',
                4,
                5,
                BigDecimal.valueOf(49.99),
                LocalDate.of(2025, 8, 20)
        );

        listingValue = new ArrayList<>();
        listingValue.add(product1);
        listingValue.add(product2);
        listingValue.add(product3);
        listingValue.add(product4);
        
        listingTable = new JTable((TableModel) listingNameColumn, (TableColumnModel) listingValue);
        
        scrollPane = new JScrollPane(listingTable);
        
        listingPanel.add(scrollPane);
        
        // Add Main
        add(titlePanel, BorderLayout.NORTH);
        add(listingPanel, BorderLayout.CENTER);
    }
}
