package view;


import exceptions.*;
import controller.ProductController;
import model.Category;
import model.Product;
import model.Vat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

public class DeleteProduct extends JPanel {
    // Attributes
    /*private JPanel titlePanel;
    private JLabel titleLabel;
    private JPanel formPanel;
    private JPanel barcodePanel;
    private JLabel barcodeLabel;
    private JTextField barcodeField;
    private JButton barcodeButton;
    private boolean fieldsIsVisible;
    private JPanel namePanel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JPanel descriptionPanel;
    private JLabel descriptionLabel;
    private JTextField descriptionField;
    private JPanel pricePanel;
    private JLabel priceLabel;
    private JTextField priceField;
    private JPanel amountPanel;
    private JLabel amountLabel;
    private JSpinner amountSpinner;
    private JPanel vatTypePanel;
    private JLabel vatTypeLabel;
    private JComboBox<String> vatTypeComboBox;
    private JPanel categoryPanel;
    private JLabel categoryLabel;
    private JComboBox<String> categoryComboBox;
    private JPanel brandPanel;
    private JLabel brandLabel;
    private JTextField brandField;
    private JPanel startDatePanel;
    private JPanel startDateLabelSubPanel;
    private JLabel startDateLabel;
    private JPanel startDateFieldsSubPanel;
    private JTextField startDateDayField;
    private JTextField startDateMonthField;
    private JTextField startDateYearField;
    private JPanel availablePanel;
    private JPanel AvailablelabelSubPanel;
    private JLabel availableLabel;
    private JPanel AvailableRadioButtonSubPanel;
    private ButtonGroup availabilityGroup;
    private JRadioButton availableRadioButtonYes;
    private JRadioButton availableRadioButtonNo;
    private JPanel buttonPanel;
    private JButton addButton;*/

    private JPanel titlePanel, formPanel, barcodePanel, namePanel, descriptionPanel, pricePanel, amountPanel, vatTypePanel, categoryPanel, brandPanel, startDatePanel, startDateLabelSubPanel, startDateFieldsSubPanel, availablePanel, AvailablelabelSubPanel, AvailableRadioButtonSubPanel, buttonPanel;
    private JLabel titleLabel, barcodeLabel, nameLabel, descriptionLabel, priceLabel, amountLabel, vatTypeLabel, categoryLabel, brandLabel, startDateLabel, availableLabel;
    private JTextField barcodeField, nameField, descriptionField, priceField, brandField, startDateDayField, startDateMonthField, startDateYearField;
    private JButton barcodeButton, addButton;
    private JSpinner amountSpinner;
    private JComboBox<String> vatTypeComboBox, categoryComboBox;
    private ButtonGroup availabilityGroup;
    private JRadioButton availableRadioButtonYes, availableRadioButtonNo;
    private boolean fieldsIsVisible;

    // Constructors
    public DeleteProduct() {
        setLayout(new BorderLayout(0, 100));
        new GridLayout(3,1, 0, 0);
        setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        setBackground(Color.white);

        // Title
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.white);
        
        titleLabel = new JLabel("Supprimer un article");
        titleLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.BOLD, 60));

        titlePanel.add(titleLabel);
        
        // Barcode
        barcodePanel = new JPanel(new GridLayout(1, 2, 20, 0));
        barcodePanel.setBorder(BorderFactory.createEmptyBorder(280, 300, 280, 300));
        barcodePanel.setBackground(Color.white);
        
        barcodeLabel = new JLabel("Code-barres", SwingConstants.CENTER);
        barcodeLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.MID_SIZE.getSize()));
        
        barcodeField = new JTextField();
        barcodeField.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.NORMAL_SIZE.getSize()));
        barcodeField.setBackground(Color.white);
        barcodeField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        
        barcodePanel.add(barcodeLabel);
        barcodePanel.add(barcodeField);
        
        
        // Button
        buttonPanel = new JPanel(new GridLayout(1, 2, 0, 0));
        buttonPanel.setBackground(Color.white);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 500, 0, 500));
        
        addButton = new JButton("Supprimer");
        addButton.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.BOLD, FontPreferences.MID_SIZE.getSize()));
        addButton.setBackground(Color.white);
        
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Product product = ProductController.getByBarcode(barcodeField.getText());
                    
                    int answer =  JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer l'aticle : " + product.getName() + " ?");
                    
                    if (answer == 0) {
                        try {

                            if (ProductController.remove(barcodeField.getText()) == 0) {
                                System.out.println("TEST");
                            }


                        } catch (WrongTypeException | DeleteFailedException | DAORetrievalFailedException | NullPointerException | FieldIsEmptyException exception) {
                            JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    
                } catch (DAORetrievalFailedException | WrongTypeException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (NotFoundException | FieldIsEmptyException exception) {
                    JOptionPane.showMessageDialog(null, "Article inconnu !", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        
        buttonPanel.add(addButton);
        
        
        // Main add
        add(titlePanel, BorderLayout.NORTH);
        add(barcodePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
