package view;

import controller.*;
import exceptions.*;
import model.Category;
import model.Vat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddProduct extends JPanel {
    // Attributes
    private JPanel titlePanel, formPanel, barcodePanel, namePanel, descriptionPanel, pricePanel, amountPanel, vatTypePanel, categoryPanel, brandPanel, startDatePanel, availablePanel, buttonPanel;
    private JLabel titleLabel, barcodeLabel, nameLabel, descriptionLabel, priceLabel, amountLabel, vatTypeLabel, categoryLabel, brandLabel, startDateLabel, availableLabel;
    private JTextField nameField, barcodeField, descriptionField, priceField, brandField, startDateDayField, startDateMonthField, startDateYearField;
    private JComboBox<String> vatTypeComboBox, categoryComboBox;
    private JSpinner amountSpinner;
    private JPanel startDateLabelSubPanel, startDateFieldsSubPanel, AvailablelabelSubPanel, AvailableRadioButtonSubPanel;
    private JRadioButton availableRadioButtonYes, availableRadioButtonNo;
    private ButtonGroup availabilityGroup;
    private JButton addButton;
    private ProductController productController;

    // Constructors
    public AddProduct() {
        setLayout(new BorderLayout(0, 100));
        setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        setBackground(Color.white);

        productController = new ProductController();

        // Title
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.white);
        
        titleLabel = new JLabel("Ajouter un article");
        titleLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.BOLD, FontPreferences.TITLE_SIZE));

        titlePanel.add(titleLabel);

        // Form
        formPanel = new JPanel(new GridLayout(5, 2, 50, 100));
        formPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 250));
        formPanel.setBackground(Color.white);
        
        // Barcode
        barcodePanel = new JPanel(new GridLayout(1, 2, 50, 0));
        barcodePanel.setBackground(Color.white);
        
        barcodeLabel = new JLabel("Code-Barres", SwingConstants.RIGHT);
        barcodeLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.MID_SIZE));
        
        barcodeField = new JTextField();
        barcodeField.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.NORMAL_SIZE));
        barcodeField.setBackground(Color.white);
        barcodeField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        
        barcodePanel.add(barcodeLabel);
        barcodePanel.add(barcodeField);
        
        // Name
        namePanel = new JPanel(new GridLayout(1, 2, 50, 0));
        namePanel.setBackground(Color.white);
        
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

        availableRadioButtonYes = new JRadioButton("OUI");
        availableRadioButtonYes.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.NORMAL_SIZE));
        availableRadioButtonYes.setSelected(true);
        availableRadioButtonNo = new JRadioButton("NON");
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
        
        addButton = new JButton("Ajouter");
        addButton.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.BOLD, FontPreferences.MID_SIZE));
        addButton.setBackground(Color.white);
        addButton.setFocusPainted(false);
        
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    productController.create(
                            barcodeField.getText(),
                            nameField.getText(),
                            descriptionField.getText(),
                            priceField.getText(),
                            (Integer)amountSpinner.getValue(),
                            availableRadioButtonYes.isSelected(),
                            ((String)vatTypeComboBox.getSelectedItem()).charAt(0),
                            categories.get(categoryComboBox.getSelectedIndex()).getId(),
                            productController.getOrCreateBrand(brandField.getText()),
                            startDateField.getText()
                    );

                    removeAllField();
                } catch (WrongTypeException | ProhibitedValueException | InsertionFailedException | DAORetrievalFailedException | NullPointerException |
                         FieldIsEmptyException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        buttonPanel.add(addButton);
        
        // Add
        formPanel.add(barcodePanel);
        
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
    
    private void backgroundText(JTextField textField, String text) {
        textField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(text)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(text);
                }
            }
        });
    }
}

