package view;

import controller.ProductController;
import exceptions.DAORetrievalFailedException;
import exceptions.NotFoundException;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProductListing extends JPanel {
    // Attributes
    JPanel titlePanel;
    JLabel titleLabel;
    JPanel listingPanel;
    ArrayList<String> listingNameColumn;
    ArrayList<Product> listingValue;
    JTable listingTable;
    JScrollPane scrollPane;
    
    // Constructors
    public ProductListing() {
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
        listingPanel = new JPanel(new BorderLayout());
        listingPanel.setBackground(Color.white);
        
        try {
            listingTable = new JTable(ProductController.infoTableModel());
        } catch (DAORetrievalFailedException | NotFoundException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        
        scrollPane = new JScrollPane(listingTable);
        
        listingPanel.add(scrollPane);
        
        // Add Main
        add(titlePanel, BorderLayout.NORTH);
        add(listingPanel, BorderLayout.CENTER);
    }
}
