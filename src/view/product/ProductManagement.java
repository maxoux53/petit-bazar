package view.product;

import controller.ProductController;
import exceptions.*;
import model.Product;
import view.FontPreferences;
import view.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductManagement extends JPanel {
    // Attributes
    JPanel titlePanel;
    JLabel titleLabel;
    JPanel listingPanel;
    JTable listingTable;
    JScrollPane scrollPane;
    JPanel buttonsPanel;
    JButton editButton;
    JButton deleteButton;
    Product selectedProduct;
    
    // Constructors
    public ProductManagement(Window window) {
        setLayout(new BorderLayout(0, 50));
        setBorder(BorderFactory.createEmptyBorder(20, 100, 50, 100));
        new GridLayout(3, 1, 0, 0);
        setBackground(Color.white);
        
        // Title
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.white);
        
        titleLabel = new JLabel("Gestion des articles", SwingConstants.CENTER);
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
        
        // Buttons
        buttonsPanel = new JPanel(new GridLayout(1, 2, 50,  0));
        buttonsPanel.setBackground(Color.white);
        
        editButton = new JButton("Modifier");
        editButton.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.BOLD, FontPreferences.MID_SIZE.getSize()));
        editButton.setBackground(Color.white);
        
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getSelectedProduct()) {
                    window.getEditProduct().fillAllFields(selectedProduct);
                    window.showEditProduct();
                }
            }
        });

        deleteButton = new JButton("Supprimer");
        deleteButton.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.BOLD, FontPreferences.MID_SIZE.getSize()));
        deleteButton.setBackground(Color.white);
        
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getSelectedProduct()) {
                    int answer =  JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer l'aticle : " + selectedProduct.getName() + " ?");

                    if (answer == 0) {
                        try {

                            if (ProductController.remove(String.valueOf(selectedProduct.getBarcode())) == 0) {
                                JOptionPane.showMessageDialog(null, "L'article a été supprimé avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
                            }


                        } catch (WrongTypeException | DeleteFailedException | DAORetrievalFailedException | NullPointerException | FieldIsEmptyException exception) {
                            JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
        
        buttonsPanel.add(editButton);
        buttonsPanel.add(deleteButton);
        
        // Add Main
        add(titlePanel, BorderLayout.NORTH);
        add(listingPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }
    
    // Methods
    private boolean getSelectedProduct() {
        if (listingTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Aucune donnée séléctionnée !", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else {
            try {
                selectedProduct = ProductController.getByBarcode(String.valueOf(listingTable.getValueAt(listingTable.getSelectedRow(), 0)));
            } catch (DAORetrievalFailedException | WrongTypeException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (NotFoundException | FieldIsEmptyException exception) {
                JOptionPane.showMessageDialog(null, "Article inconnu !", "Erreur", JOptionPane.ERROR_MESSAGE);
            } 
        }
        return true;
    }
}
