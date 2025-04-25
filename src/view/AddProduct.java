package view;

import controller.ApplicationController;
import controller.FieldIsEmpty;
import controller.ProhibitedValue;
import controller.WrongType;
import model.Category;
import model.Vat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddProduct extends JPanel {
    // Attributes
    /*private JPanel titlePanel;
    private JLabel titleLabel;
    private JPanel formPanel;
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
    
    private JPanel titlePanel, formPanel, namePanel, descriptionPanel, pricePanel, amountPanel, vatTypePanel, categoryPanel, brandPanel, startDatePanel, availablePanel, buttonPanel;
    private JLabel titleLabel, nameLabel, descriptionLabel, priceLabel, amountLabel, vatTypeLabel, categoryLabel, brandLabel, startDateLabel, availableLabel;
    private JTextField nameField, descriptionField, priceField, brandField, startDateDayField, startDateMonthField, startDateYearField;
    private JComboBox<String> vatTypeComboBox, categoryComboBox;
    private JSpinner amountSpinner;
    private JPanel startDateLabelSubPanel, startDateFieldsSubPanel, AvailablelabelSubPanel, AvailableRadioButtonSubPanel;
    private JRadioButton availableRadioButtonYes, availableRadioButtonNo;
    private ButtonGroup availabilityGroup;
    private JButton addButton;

    // Constructors
    public AddProduct() {
        setLayout(new BorderLayout(0, 100));
        setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        setBackground(Color.white);

        // Title
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.white);
        
        titleLabel = new JLabel("Ajouter un article");
        titleLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.BOLD, FontPreferences.TITLE_SIZE.getSize()));

        titlePanel.add(titleLabel);

        // Form
        formPanel = new JPanel(new GridLayout(5, 2, 50, 100));
        formPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 250));
        formPanel.setBackground(Color.white);
        
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
        nameField.setPreferredSize(new Dimension(20, 25));
        
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
        priceField.setPreferredSize(new Dimension(20, 50));
        
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
        vatTypeComboBox.setPreferredSize(new Dimension(20, 25));
        
        ArrayList<Vat> vats = ApplicationController.getVats();
        for (Vat vat : vats) {
            vatTypeComboBox.addItem(vat.getType() + " (" + vat.getRate() + "%)");
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
        categoryComboBox.setPreferredSize(new Dimension(20, 25));
        
        ArrayList<Category> categories = ApplicationController.getCategories();
        for (Category category : categories) {
            categoryComboBox.addItem(category.getName());
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
        brandField.setPreferredSize(new Dimension(20, 25));
        
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

        backgroundText(startDateDayField, "Jour");
        
        startDateMonthField = new JTextField();
        startDateMonthField.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.NORMAL_SIZE.getSize()));
        startDateMonthField.setBackground(Color.white);
        startDateMonthField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        startDateMonthField.setText("Mois");
        startDateMonthField.setForeground(Color.GRAY);
        
        backgroundText(startDateMonthField, "Mois");

        startDateYearField = new JTextField();
        startDateYearField.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.NORMAL_SIZE.getSize()));
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
        availableLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.MID_SIZE.getSize()));

        availableRadioButtonYes = new JRadioButton("OUI");
        availableRadioButtonYes.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.NORMAL_SIZE.getSize()));
        availableRadioButtonYes.setSelected(true);
        availableRadioButtonNo = new JRadioButton("NON");
        availableRadioButtonNo.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, FontPreferences.NORMAL_SIZE.getSize()));

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
        addButton.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.BOLD, FontPreferences.MID_SIZE.getSize()));
        addButton.setBackground(Color.white);
        addButton.setFocusPainted(false);
        
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ApplicationController.createProduct(
                            nameField.getText(),
                            descriptionField.getText(),
                            priceField.getText(),
                            (Integer)amountSpinner.getValue(),
                            availableRadioButtonYes.isSelected(),
                            ((String)vatTypeComboBox.getSelectedItem()).charAt(0), // MUST BE CHANGED TO A BETTER WAY OF GETTING THE VAT CHAR
                            1,                                             // }
                            //(String)categoryComboBox.getSelectedItem(),  // } FOR TESTING PURPOSES ONLY,
                            1,                                             // } MUST PROVIDES DIRECT IDs
                            //brandField.getText(),                        // }
                            startDateDayField.getText(),
                            startDateMonthField.getText(),
                            startDateYearField.getText()
                    );

                    removeAllField();
                } catch (FieldIsEmpty | WrongType | ProhibitedValue ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        buttonPanel.add(addButton);
        
        // Add
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
