package view;


import controller.FieldIsEmptyException;
import controller.ProductController;
import controller.ProhibitedValueException;
import controller.WrongTypeException;
import dataAccess.DAORetrievalFailedException;
import dataAccess.InsertionFailedException;
import dataAccess.NotFoundException;
import model.Category;
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
        setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        setBackground(Color.white);

        // Title
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.white);
        
        titleLabel = new JLabel("Supprimer un article");
        titleLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.BOLD, 60));

        titlePanel.add(titleLabel);

        // Form
        formPanel = new JPanel(new GridLayout(5, 2, 50, 100));
        formPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 250));
        formPanel.setBackground(Color.white);
        
        // Barcode
        barcodePanel = new JPanel(new GridLayout(1, 3, 20, 0));
        barcodePanel.setBackground(Color.white);
        
        barcodeLabel = new JLabel("Code barre", SwingConstants.RIGHT);
        barcodeLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.MID_SIZE.getSize()));
        
        barcodeField = new JTextField();
        barcodeField.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.NORMAL_SIZE.getSize()));
        barcodeField.setBackground(Color.white);
        barcodeField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        
        barcodeButton = new JButton("Charger");
        barcodeButton.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.BOLD, FontPreferences.MID_SIZE.getSize()));
        barcodeButton.setBackground(Color.white);
        barcodeButton.setFocusPainted(false);
        
        fieldsIsVisible = false;
        barcodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!fieldsIsVisible) {
                    try {
                        ProductController.getProductByBarcode(barcodeField.getText()); // AFFICHER LE PRODUIT RETOURNÉ
                        setVisibleAll(true);
                        barcodeButton.setText("Décharger");
                        addButton.setEnabled(true);
                        barcodeField.setEnabled(false);
                    } catch (WrongTypeException | DAORetrievalFailedException | NotFoundException | FieldIsEmptyException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    setVisibleAll(false);
                    barcodeButton.setText("Charger");
                    addButton.setEnabled(false);
                    barcodeField.setEnabled(true);
                }
                fieldsIsVisible = !fieldsIsVisible;
            }
        });
        
        barcodePanel.add(barcodeLabel);
        barcodePanel.add(barcodeField);
        barcodePanel.add(barcodeButton);
        
        // Name
        namePanel = new JPanel(new GridLayout(1, 2, 50, 0));
        namePanel.setBackground(Color.white);
        namePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,0));
        
        nameLabel = new JLabel("Nom", SwingConstants.RIGHT);
        nameLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.MID_SIZE.getSize()));

        nameField = new JTextField();
        nameField.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.NORMAL_SIZE.getSize()));
        nameField.setBackground(Color.white);
        nameField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        nameField.setEnabled(false);
        nameField.setForeground(Color.GRAY);
        
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        // Description
        descriptionPanel = new JPanel(new GridLayout(1, 2, 50, 0));
        descriptionPanel.setBackground(Color.white);
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,0));
        
        descriptionLabel = new JLabel("Description", SwingConstants.RIGHT);
        descriptionLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.MID_SIZE.getSize()));

        descriptionField = new JTextField();
        descriptionField.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.NORMAL_SIZE.getSize()));
        descriptionField.setBackground(Color.white);
        descriptionField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        descriptionField.setEnabled(false);
        descriptionField.setForeground(Color.GRAY);
        
        descriptionPanel.add(descriptionLabel);
        descriptionPanel.add(descriptionField);
        
        // Price
        pricePanel = new JPanel(new GridLayout(1, 2, 50, 0));
        pricePanel.setBackground(Color.white);
        pricePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,0));
        
        priceLabel = new JLabel("Prix", SwingConstants.RIGHT);
        priceLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.MID_SIZE.getSize()));

        priceField = new JTextField();
        priceField.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.NORMAL_SIZE.getSize()));
        priceField.setBackground(Color.white);
        priceField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        priceField.setEnabled(false);
        priceField.setForeground(Color.GRAY);
        
        pricePanel.add(priceLabel);
        pricePanel.add(priceField);
        
        // Amount
        amountPanel = new JPanel(new GridLayout(1, 2, 50, 0));
        amountPanel.setBackground(Color.white);
        amountPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,0));
        
        amountLabel = new JLabel("Quantité", SwingConstants.RIGHT);
        amountLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.MID_SIZE.getSize()));

        amountSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
        amountSpinner.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.NORMAL_SIZE.getSize()));
        amountSpinner.setBackground(Color.white);
        amountSpinner.setEnabled(false);
        amountSpinner.setForeground(Color.GRAY);
        
        amountPanel.add(amountLabel);
        amountPanel.add(amountSpinner);
        
        // Vat Type
        vatTypePanel = new JPanel(new GridLayout(1, 2, 50, 0));
        vatTypePanel.setBackground(Color.white);
        vatTypePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,0));
        
        vatTypeLabel = new JLabel("Type de TVA", SwingConstants.RIGHT);
        vatTypeLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.MID_SIZE.getSize()));
        
        vatTypeComboBox = new JComboBox<String>();
        vatTypeComboBox.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.NORMAL_SIZE.getSize()));
        vatTypeComboBox.setBackground(Color.white);
        vatTypeComboBox.setEnabled(false);
        vatTypeComboBox.setForeground(Color.GRAY);

        final ArrayList<Vat> vats;
        try {
            vats = ProductController.getVats();

            for (Vat vat : vats) {
                vatTypeComboBox.addItem(vat.getType() + " (" + vat.getRate() + "%)");
            }
        } catch (DAORetrievalFailedException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            vatTypeComboBox.addItem("Veuillez reessayer");
        }
        
        vatTypePanel.add(vatTypeLabel);
        vatTypePanel.add(vatTypeComboBox);
        
        // Category
        categoryPanel = new JPanel(new GridLayout(1, 2, 50, 0));
        categoryPanel.setBackground(Color.white);
        categoryPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,0));
        
        categoryLabel = new JLabel("Catégorie", SwingConstants.RIGHT);
        categoryLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.MID_SIZE.getSize()));

        categoryComboBox = new JComboBox<String>();
        categoryComboBox.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.NORMAL_SIZE.getSize()));
        categoryComboBox.setBackground(Color.white);
        categoryComboBox.setEnabled(false);
        categoryComboBox.setForeground(Color.GRAY);

        final ArrayList<Category> categories = new ArrayList<>();
        try {
            categories.addAll(ProductController.getCategories());

            for (Category category : categories) {
                categoryComboBox.addItem(category.getLabel());
            }
        } catch (DAORetrievalFailedException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        
        categoryPanel.add(categoryLabel);
        categoryPanel.add(categoryComboBox);

        // Brand
        brandPanel = new JPanel(new GridLayout(1, 2, 50, 0));
        brandPanel.setBackground(Color.white);
        brandPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,0));
        
        brandLabel = new JLabel("Marque", SwingConstants.RIGHT);
        brandLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.MID_SIZE.getSize()));

        brandField = new JTextField();
        brandField.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.NORMAL_SIZE.getSize()));
        brandField.setBackground(Color.white);
        brandField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        brandField.setEnabled(false);
        brandField.setForeground(Color.GRAY);
        
        brandPanel.add(brandLabel);
        brandPanel.add(brandField);
        
        // Start date
        startDatePanel = new JPanel(new GridLayout(1, 2, 50, 0));
        startDatePanel.setBackground(Color.white);
        
        startDateLabelSubPanel = new JPanel(new GridLayout(1, 1, 0, 0));
        startDateLabelSubPanel.setBackground(Color.white);
        startDateFieldsSubPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        startDateFieldsSubPanel.setBackground(Color.white);
        
        startDateLabel = new JLabel("Date de mise en rayon", SwingConstants.RIGHT);
        startDateLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.MID_SIZE.getSize()));
        
        startDateDayField = new JTextField();
        startDateDayField.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.NORMAL_SIZE.getSize()));
        startDateDayField.setBackground(Color.white);
        startDateDayField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        startDateDayField.setText("Jour");
        startDateDayField.setForeground(Color.GRAY);
        startDateDayField.setEnabled(false);
        startDateDayField.setForeground(Color.GRAY);

        backgroundText(startDateDayField, "Jour");
        
        startDateMonthField = new JTextField();
        startDateMonthField.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.NORMAL_SIZE.getSize()));
        startDateMonthField.setBackground(Color.white);
        startDateMonthField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        startDateMonthField.setText("Mois");
        startDateMonthField.setForeground(Color.GRAY);
        startDateMonthField.setEnabled(false);
        startDateMonthField.setForeground(Color.GRAY);
        
        backgroundText(startDateMonthField, "Mois");

        startDateYearField = new JTextField();
        startDateYearField.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.NORMAL_SIZE.getSize()));
        startDateYearField.setBackground(Color.white);
        startDateYearField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        startDateYearField.setText("Année");
        startDateYearField.setForeground(Color.GRAY);
        startDateYearField.setEnabled(false);
        startDateYearField.setForeground(Color.GRAY);
        
        backgroundText(startDateYearField, "Année");
        
        startDateLabelSubPanel.add(startDateLabel);

        startDateFieldsSubPanel.add(startDateDayField);
        startDateFieldsSubPanel.add(startDateMonthField);
        startDateFieldsSubPanel.add(startDateYearField);
        
        startDatePanel.add(startDateLabelSubPanel);
        startDatePanel.add(startDateFieldsSubPanel);
        
        // Available
        availablePanel = new JPanel(new GridLayout(1, 2, 50, 0));
        availablePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,0));
        availablePanel.setBackground(Color.white);
        
        AvailablelabelSubPanel = new JPanel(new GridLayout(1, 1, 0, 0));
        AvailablelabelSubPanel.setBackground(Color.white);
        AvailableRadioButtonSubPanel = new JPanel(new GridLayout(1, 2, 0, 0));
        AvailableRadioButtonSubPanel.setBackground(Color.white);
        
        availableLabel = new JLabel("Disponible", SwingConstants.RIGHT);
        availableLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.MID_SIZE.getSize()));

        availableRadioButtonYes = new JRadioButton("oui");
        availableRadioButtonYes.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.NORMAL_SIZE.getSize()));
        availableRadioButtonYes.setSelected(true);
        availableRadioButtonYes.setEnabled(false);
        availableRadioButtonYes.setForeground(Color.GRAY);
        availableRadioButtonNo = new JRadioButton("non");
        availableRadioButtonNo.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.NORMAL_SIZE.getSize()));
        availableRadioButtonNo.setEnabled(false);
        availableRadioButtonNo.setForeground(Color.GRAY);

        availabilityGroup = new ButtonGroup();
        availabilityGroup.add(availableRadioButtonYes);
        availabilityGroup.add(availableRadioButtonNo);

        AvailablelabelSubPanel.add(availableLabel);
        AvailableRadioButtonSubPanel.add(availableRadioButtonYes);
        AvailableRadioButtonSubPanel.add(availableRadioButtonNo);
        
        availablePanel.add(AvailablelabelSubPanel);
        availablePanel.add(AvailableRadioButtonSubPanel);
        
        // Button
        buttonPanel = new JPanel(new GridLayout(1, 2, 0, 0));
        buttonPanel.setBackground(Color.white);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 500, 0, 500));
        
        addButton = new JButton("Supprimer");
        addButton.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.BOLD, FontPreferences.MID_SIZE.getSize()));
        addButton.setBackground(Color.white);
        addButton.setFocusPainted(false);
        addButton.setEnabled(false);
        
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*try {
                    ProductController.create(
                            barcodeField.getText(),
                            nameField.getText(),
                            descriptionField.getText(),
                            priceField.getText(),
                            (Integer)amountSpinner.getValue(),
                            availableRadioButtonYes.isSelected(),
                            ((String)vatTypeComboBox.getSelectedItem()).charAt(0),
                            categories.get(categoryComboBox.getSelectedIndex()).getId(),
                            ProductController.getOrCreateBrand(brandField.getText()),
                            startDateDayField.getText(),
                            startDateMonthField.getText(),
                            startDateYearField.getText()
                    );

                    removeAllField();
                } catch (WrongTypeException | ProhibitedValueException | InsertionFailedException | DAORetrievalFailedException | NullPointerException | FieldIsEmptyException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                 */
            }
        });
        
        buttonPanel.add(addButton);
        
        // Add form
        formPanel.add(barcodePanel);
        
        setVisibleAll(false);
        
        formPanel.add(namePanel);

        formPanel.add(descriptionPanel);
        
        formPanel.add(pricePanel);

        formPanel.add(amountPanel);
        
        formPanel.add(vatTypePanel);

        formPanel.add(categoryPanel);

        formPanel.add(brandPanel);
        
        formPanel.add(startDatePanel);

        formPanel.add(availablePanel);
        
        // Main add
        add(titlePanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    // Methods
    private void backgroundText(JTextField field, String text) {
        field.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(text)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setForeground(Color.GRAY);
                    field.setText(text);
                }
            }
        });
    }
    
    private void setVisibleAll(boolean status) {
        namePanel.setVisible(status);
        descriptionPanel.setVisible(status);
        pricePanel.setVisible(status);
        amountPanel.setVisible(status);
        brandPanel.setVisible(status);
        vatTypePanel.setVisible(status);
        categoryPanel.setVisible(status);
        startDatePanel.setVisible(status);
        availablePanel.setVisible(status);
    }
}
