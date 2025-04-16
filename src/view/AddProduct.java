package view;

import controller.ApplicationController;
import model.Category;
import model.Vat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddProduct extends JPanel {
    // Attributes
    private JPanel titlePanel;
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
    private JPanel availablePanel;
    private JPanel AvailablelabelSubPanel;
    private JLabel availableLabel;
    private JPanel AvailableRadioButtonSubPanel;
    private ButtonGroup availabilityGroup;
    private JRadioButton availableRadioButtonYes;
    private JRadioButton availableRadioButtonNo;
    private JPanel buttonPanel;
    private JButton addButton;
    
    // Constructors
    public AddProduct() {
        setLayout(new BorderLayout(20, 100));
        setBorder(BorderFactory.createEmptyBorder(30, 450, 30, 0));
        setBackground(Color.white);

        // Title
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.white);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,450));
        
        titleLabel = new JLabel("Ajouter un article", SwingConstants.TRAILING);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 60));

        titlePanel.add(titleLabel, BorderLayout.WEST);

        // Form
        formPanel = new JPanel(new GridLayout(8, 1, 0, 50));
        formPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 100));
        formPanel.setBackground(Color.white);
        
        // Name
        namePanel = new JPanel(new GridLayout(1, 2, 150, 0));
        namePanel.setBackground(Color.white);
        namePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,450));
        
        nameLabel = new JLabel("Nom", SwingConstants.RIGHT);
        nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));

        nameField = new JTextField();
        nameField.setFont(new Font("SansSerif", Font.PLAIN, 20));
        nameField.setBackground(Color.white);
        nameField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        nameField.setPreferredSize(new Dimension(20, 25));
        
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        // Description
        descriptionPanel = new JPanel(new GridLayout(1, 2, 150, 0));
        descriptionPanel.setBackground(Color.white);
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,450));
        
        descriptionLabel = new JLabel("Description", SwingConstants.RIGHT);
        descriptionLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));

        descriptionField = new JTextField();
        descriptionField.setFont(new Font("SansSerif", Font.PLAIN, 20));
        descriptionField.setBackground(Color.white);
        descriptionField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        descriptionField.setPreferredSize(new Dimension(20, 50));

        descriptionPanel.add(descriptionLabel);
        descriptionPanel.add(descriptionField);
        
        // Price
        pricePanel = new JPanel(new GridLayout(1, 2, 150, 0));
        pricePanel.setBackground(Color.white);
        pricePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,450));
        
        priceLabel = new JLabel("Prix", SwingConstants.RIGHT);
        priceLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));

        priceField = new JTextField();
        priceField.setFont(new Font("SansSerif", Font.PLAIN, 20));
        priceField.setBackground(Color.white);
        priceField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        priceField.setPreferredSize(new Dimension(20, 50));
        
        pricePanel.add(priceLabel);
        pricePanel.add(priceField);
        
        // Amount
        amountPanel = new JPanel(new GridLayout(1, 2, 150, 0));
        amountPanel.setBackground(Color.white);
        amountPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,450));
        
        amountLabel = new JLabel("Quantité", SwingConstants.RIGHT);
        amountLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));

        amountSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
        amountSpinner.setFont(new Font("SansSerif", Font.PLAIN, 20));
        amountSpinner.setBackground(Color.white);
        
        amountPanel.add(amountLabel);
        amountPanel.add(amountSpinner);
        
        // Vat Type
        vatTypePanel = new JPanel(new GridLayout(1, 2, 150, 0));
        vatTypePanel.setBackground(Color.white);
        vatTypePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,450));
        
        vatTypeLabel = new JLabel("Type de TVA", SwingConstants.RIGHT);
        vatTypeLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));
        
        vatTypeComboBox = new JComboBox<String>();
        vatTypeComboBox.setFont(new Font("SansSerif", Font.PLAIN, 20));
        vatTypeComboBox.setBackground(Color.white);
        vatTypeComboBox.setPreferredSize(new Dimension(20, 25));
        
        ArrayList<Vat> vats = ApplicationController.getVats();
        for (Vat vat : vats) {
            vatTypeComboBox.addItem(vat.getType() + " (" + vat.getRate() + "%)");
        }
        
        vatTypePanel.add(vatTypeLabel);
        vatTypePanel.add(vatTypeComboBox);
        
        // Category
        categoryPanel = new JPanel(new GridLayout(1, 2, 150, 0));
        categoryPanel.setBackground(Color.white);
        categoryPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,450));
        
        categoryLabel = new JLabel("Catégorie", SwingConstants.RIGHT);
        categoryLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));

        categoryComboBox = new JComboBox<String>();
        categoryComboBox.setFont(new Font("SansSerif", Font.PLAIN, 20));
        categoryComboBox.setBackground(Color.white);
        categoryComboBox.setPreferredSize(new Dimension(20, 25));
        
        ArrayList<Category> categories = ApplicationController.getCategories();
        for (Category category : categories) {
            categoryComboBox.addItem(category.getName());
        }
        
        categoryPanel.add(categoryLabel);
        categoryPanel.add(categoryComboBox);

        // Brand
        brandPanel = new JPanel(new GridLayout(1, 2, 150, 0));
        brandPanel.setBackground(Color.white);
        brandPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,450));
        
        brandLabel = new JLabel("Marque", SwingConstants.RIGHT);
        brandLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));

        brandField = new JTextField();
        brandField.setFont(new Font("SansSerif", Font.PLAIN, 20));
        brandField.setBackground(Color.white);
        brandField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        brandField.setPreferredSize(new Dimension(20, 25));
        
        brandPanel.add(brandLabel);
        brandPanel.add(brandField);

        // Available
        availablePanel = new JPanel(new GridLayout(1, 2, 0, 0));
        availablePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,310));
        availablePanel.setBackground(Color.white);
        
        AvailablelabelSubPanel = new JPanel(new GridLayout(1, 1, 0, 0));
        AvailablelabelSubPanel.setBackground(Color.white);
        AvailableRadioButtonSubPanel = new JPanel(new GridLayout(1, 2, 0, 0));
        AvailableRadioButtonSubPanel.setBackground(Color.white);

        AvailablelabelSubPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 ,140));
        
        availableLabel = new JLabel("Disponible", SwingConstants.RIGHT);
        availableLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));

        availableRadioButtonYes = new JRadioButton("oui");
        availableRadioButtonYes.setFont(new Font("SansSerif", Font.PLAIN, 20));
        availableRadioButtonYes.setSelected(true);
        availableRadioButtonNo = new JRadioButton("non");
        availableRadioButtonNo.setFont(new Font("SansSerif", Font.PLAIN, 20));

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
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 200, 0, 625));
        
        addButton = new JButton("Ajouter");
        addButton.setFont(new Font("SansSerif", Font.BOLD, 25));
        addButton.setBackground(Color.white);
        addButton.setFocusPainted(false);
        
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Le produit a été ajouté avec succès", "Ajout effectué", JOptionPane.PLAIN_MESSAGE);
                
                removeAllField();
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
        availableRadioButtonYes.setSelected(true);
        
        repaint();
        revalidate();
    }
}
