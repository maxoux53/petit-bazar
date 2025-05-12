package view;


import controller.*;

import exceptions.*;
import model.Category;
import model.Product;
import model.Vat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class EditProduct extends JPanel {
    // Attributes
    private JPanel titlePanel, formPanel, barcodePanel, namePanel, descriptionPanel, pricePanel, amountPanel, vatTypePanel, categoryPanel, brandPanel, startDatePanel, startDateLabelSubPanel, startDateFieldsSubPanel, availablePanel, AvailablelabelSubPanel, AvailableRadioButtonSubPanel, buttonPanel;
    private JLabel titleLabel, barcodeLabel, nameLabel, descriptionLabel, priceLabel, amountLabel, vatTypeLabel, categoryLabel, brandLabel, startDateLabel, availableLabel;
    private JTextField barcodeField, nameField, descriptionField, priceField, brandField, startDateDayField, startDateMonthField, startDateYearField;
    private JButton barcodeButton, addButton;
    private JSpinner amountSpinner;
    private JComboBox<String> vatTypeComboBox, categoryComboBox;
    private ButtonGroup availabilityGroup;
    private JRadioButton availableRadioButtonYes, availableRadioButtonNo;
    private boolean fieldsIsVisible;
    private ProductController productController;

    // Constructors
    public EditProduct() {
        productController = new ProductController();

        setLayout(new BorderLayout(0, 100));
        setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        setBackground(Color.white);

        // Title
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.white);
        
        titleLabel = new JLabel("Modifier un article");
        titleLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.BOLD, 60));

        titlePanel.add(titleLabel);

        // Form
        formPanel = new JPanel(new GridLayout(5, 2, 50, 100));
        formPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 250));
        formPanel.setBackground(Color.white);
        
        // Barcode
        barcodePanel = new JPanel(new GridLayout(1, 3, 20, 0));
        barcodePanel.setBackground(Color.white);
        
        barcodeLabel = new JLabel("Code-barres", SwingConstants.RIGHT);
        barcodeLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.MID_SIZE));
        
        barcodeField = new JTextField();
        barcodeField.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.NORMAL_SIZE));
        barcodeField.setBackground(Color.white);
        barcodeField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        
        barcodeButton = new JButton("Charger");
        barcodeButton.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.BOLD, FontPreferences.MID_SIZE));
        barcodeButton.setBackground(Color.white);
        barcodeButton.setFocusPainted(false);
        
        fieldsIsVisible = false;
        barcodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!fieldsIsVisible) {
                    try {
                        fillAllFields(productController.getByBarcode(barcodeField.getText()));
                        setVisibleAll(true);
                        barcodeButton.setText("Décharger");
                        addButton.setEnabled(true);
                        barcodeField.setEnabled(false);
                    } catch (WrongTypeException | DAORetrievalFailedException | NotFoundException |
                             FieldIsEmptyException ex) {
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
        nameLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.MID_SIZE));

        nameField = new JTextField();
        nameField.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.NORMAL_SIZE));
        nameField.setBackground(Color.white);
        nameField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        // Description
        descriptionPanel = new JPanel(new GridLayout(1, 2, 50, 0));
        descriptionPanel.setBackground(Color.white);
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,0));
        
        descriptionLabel = new JLabel("Description", SwingConstants.RIGHT);
        descriptionLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.MID_SIZE));

        descriptionField = new JTextField();
        descriptionField.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.NORMAL_SIZE));
        descriptionField.setBackground(Color.white);
        descriptionField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        descriptionPanel.add(descriptionLabel);
        descriptionPanel.add(descriptionField);
        
        // Price
        pricePanel = new JPanel(new GridLayout(1, 2, 50, 0));
        pricePanel.setBackground(Color.white);
        pricePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,0));
        
        priceLabel = new JLabel("Prix", SwingConstants.RIGHT);
        priceLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.MID_SIZE));

        priceField = new JTextField();
        priceField.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.NORMAL_SIZE));
        priceField.setBackground(Color.white);
        priceField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        
        pricePanel.add(priceLabel);
        pricePanel.add(priceField);
        
        // Amount
        amountPanel = new JPanel(new GridLayout(1, 2, 50, 0));
        amountPanel.setBackground(Color.white);
        amountPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,0));
        
        amountLabel = new JLabel("Quantité", SwingConstants.RIGHT);
        amountLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.MID_SIZE));

        amountSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
        amountSpinner.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.NORMAL_SIZE));
        amountSpinner.setBackground(Color.white);
        
        amountPanel.add(amountLabel);
        amountPanel.add(amountSpinner);
        
        // Vat Type
        vatTypePanel = new JPanel(new GridLayout(1, 2, 50, 0));
        vatTypePanel.setBackground(Color.white);
        vatTypePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,0));
        
        vatTypeLabel = new JLabel("Type de TVA", SwingConstants.RIGHT);
        vatTypeLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.MID_SIZE));
        
        vatTypeComboBox = new JComboBox<String>();
        vatTypeComboBox.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.NORMAL_SIZE));
        vatTypeComboBox.setBackground(Color.white);

        final ArrayList<Vat> vats;
        try {
            vats = productController.getAllVats();

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
        categoryLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.MID_SIZE));

        categoryComboBox = new JComboBox<String>();
        categoryComboBox.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.NORMAL_SIZE));
        categoryComboBox.setBackground(Color.white);

        final ArrayList<Category> categories = new ArrayList<>();
        try {
            categories.addAll(productController.getAllCategories());

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
        brandLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.MID_SIZE));

        brandField = new JTextField();
        brandField.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.NORMAL_SIZE));
        brandField.setBackground(Color.white);
        brandField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        
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
        startDateLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.MID_SIZE));
        
        startDateDayField = new JTextField();
        startDateDayField.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.NORMAL_SIZE));
        startDateDayField.setBackground(Color.white);
        startDateDayField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        startDateDayField.setText("Jour");
        startDateDayField.setForeground(Color.GRAY);

        backgroundText(startDateDayField, "Jour");
        
        startDateMonthField = new JTextField();
        startDateMonthField.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.NORMAL_SIZE));
        startDateMonthField.setBackground(Color.white);
        startDateMonthField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        startDateMonthField.setText("Mois");
        startDateMonthField.setForeground(Color.GRAY);
        
        backgroundText(startDateMonthField, "Mois");

        startDateYearField = new JTextField();
        startDateYearField.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.NORMAL_SIZE));
        startDateYearField.setBackground(Color.white);
        startDateYearField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        startDateYearField.setText("Année");
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
        availableLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.MID_SIZE));

        availableRadioButtonYes = new JRadioButton("oui");
        availableRadioButtonYes.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.NORMAL_SIZE));
        availableRadioButtonYes.setSelected(true);
        availableRadioButtonNo = new JRadioButton("non");
        availableRadioButtonNo.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.NORMAL_SIZE));

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
        
        addButton = new JButton("Modifier");
        addButton.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.BOLD, FontPreferences.MID_SIZE));
        addButton.setBackground(Color.white);
        addButton.setFocusPainted(false);
        addButton.setEnabled(false);
        
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    productController.create(new Product(
                            stringToBarcode(barcodeField.getText()),
                            nameInputValidation(nameField.getText()),
                            descriptionField.getText(),
                            stringToPrice(priceField.getText()),
                            (Integer)amountSpinner.getValue(),
                            availableRadioButtonYes.isSelected(),
                            ((String)vatTypeComboBox.getSelectedItem()).charAt(0),
                            categories.get(categoryComboBox.getSelectedIndex()).getId(),
                            productController.getOrCreateBrand(brandField.getText()),
                            startDateField.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate()
                    ));

                    removeAllField();
                } catch (WrongTypeException | ProhibitedValueException | InsertionFailedException | DAORetrievalFailedException | NullPointerException | FieldIsEmptyException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
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
    private void removeAllField() {
        nameField.setText("");
        descriptionField.setText("");
        priceField.setText("");
        amountSpinner.setValue(0);
        vatTypeComboBox.setSelectedIndex(0);
        categoryComboBox.setSelectedIndex(0);
        brandField.setText("");
        startDateDayField.setText("Jour");
        startDateDayField.setForeground(Color.GRAY);
        startDateMonthField.setText("Mois");
        startDateMonthField.setForeground(Color.GRAY);
        startDateYearField.setText("Année");
        startDateYearField.setForeground(Color.GRAY);
        availableRadioButtonYes.setSelected(true);
        
        repaint();
        revalidate();
    }
    
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
    
    private void fillAllFields(Product product) {
        nameField.setText(product.getName());
        descriptionField.setText(product.getDescription());
        priceField.setText(String.valueOf(product.getExclVatPrice()));
        amountSpinner.setValue(product.getAmount());
        try {
            vatTypeComboBox.setSelectedIndex(productController.indexOfVatType(product.getVatType()));
            categoryComboBox.setSelectedIndex(productController.indexOfCategoryName(product.getCategoryId()));
        } catch (DAORetrievalFailedException e) {
            System.out.println("test");
        }
        // brandField.setText(product.getBrandId());
    }

    public Integer indexOfVatType(char targetVatType) throws DAORetrievalFailedException {
        ArrayList<Vat> vats = getAllVats();

        int size = vats.size();
        for (int i = 0; i < size; i++) {
            if (vats.get(i).getType() == targetVatType) {
                return i;
            }
        }
        return null;
    }

    public Integer indexOfCategoryName(int targetCategoryId) throws DAORetrievalFailedException {
        ArrayList<Category> categories = getAllCategories();

        int size = categories.size();
        for (int i = 0; i < size; i++) {
            if (categories.get(i).getId() == targetCategoryId) {
                return i;
            }
        }
        return null;
    }

    private String nameInputValidation(String name) {
        if (!name.isEmpty()) {
            return name;
        }
        return null;
    }

    private BigDecimal stringToPrice(String priceAsString) throws WrongTypeException, ProhibitedValueException {
        if (!priceAsString.isEmpty()) {
            BigDecimal price;

            try {
                price = new BigDecimal(priceAsString);

                if (price.compareTo(BigDecimal.ZERO) < 0) {
                    throw new ProhibitedValueException("Prix");
                }

                return price;
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Prix");
            }
        }
        return null;
    }

    private Long stringToBarcode(String barcodeAsString) throws WrongTypeException, FieldIsEmptyException {
        if (!barcodeAsString.isEmpty()) {
            try {
                return Long.parseLong(barcodeAsString);
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Code-barres");
            }
        } else {
            throw new FieldIsEmptyException("Code-barres");
        }
    }
}

