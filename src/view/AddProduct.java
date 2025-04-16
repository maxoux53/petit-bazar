package view;

import javax.swing.*;
import java.awt.*;

public class AddProduct extends JPanel {
    // Attributes
    JPanel titlePanel;
    JLabel titleLabel;
    JPanel formPanel;
    JLabel nameLabel;
    JTextField nameField;
    JLabel descriptionLabel;
    JTextField descriptionField;
    JLabel amountLabel;
    JSpinner amountSpinner;
    JLabel availableLabel;
    JCheckBox availableCheckBox;
    JLabel categoryLabel;
    JTextField categoryField;
    JLabel brandLabel;
    JTextField brandField;
    JLabel supplierVatNumberLabel;
    JTextField supplierVatNumberField;


    // Constructors
    public AddProduct() {
        setLayout(new BorderLayout(200, 0));
        setBackground(Color.white);

        // TitlePanel
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.white);

        // Title
        titleLabel = new JLabel("Ajouter un article", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 60));

        titlePanel.add(titleLabel, BorderLayout.CENTER);

        // Form
        formPanel = new JPanel(new GridLayout(8, 4, 100, 50));
        formPanel.setBackground(Color.white);


        // Name
        nameLabel = new JLabel("Nom", SwingConstants.LEFT);
        nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));

        nameField = new JTextField();
        nameField.setFont(new Font("SansSerif", Font.PLAIN, 25));
        nameField.setBackground(new Color(238, 238, 238));
        nameField.setPreferredSize(new Dimension(20, 25));

        // Description
        descriptionLabel = new JLabel("Description");
        descriptionLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));

        descriptionField = new JTextField();
        descriptionField.setFont(new Font("SansSerif", Font.PLAIN, 25));
        descriptionField.setBackground(new Color(238, 238, 238));
        descriptionField.setPreferredSize(new Dimension(20, 50));

        // Amount
        amountLabel = new JLabel("Quantité");
        amountLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));

        amountSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
        amountSpinner.setFont(new Font("SansSerif", Font.PLAIN, 25));
        amountSpinner.setBackground(new Color(238, 238, 238));

        // Available
        availableLabel = new JLabel("Disponible ?");
        availableLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));

        availableCheckBox = new JCheckBox();
        amountSpinner.setBackground(new Color(238, 238, 238));

        // Category
        categoryLabel = new JLabel("Catégorie");
        categoryLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));

        categoryField = new JTextField();
        categoryField.setFont(new Font("SansSerif", Font.PLAIN, 25));
        categoryField.setBackground(new Color(238, 238, 238));
        categoryField.setPreferredSize(new Dimension(20, 25));

        // Brand
        brandLabel = new JLabel("Marque");
        brandLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));

        brandField = new JTextField();
        brandField.setFont(new Font("SansSerif", Font.PLAIN, 25));
        brandField.setBackground(new Color(238, 238, 238));
        brandField.setPreferredSize(new Dimension(20, 25));

        // SupplierVatNumber
        supplierVatNumberLabel = new JLabel("Numéro de TVA du fournisseur");
        supplierVatNumberLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));

        supplierVatNumberField = new JTextField();
        supplierVatNumberField.setFont(new Font("SansSerif", Font.PLAIN, 25));
        supplierVatNumberField.setBackground(new Color(238, 238, 238));
        supplierVatNumberField.setPreferredSize(new Dimension(20, 25));

        // Blank
        JLabel blankLabel = new JLabel(" ", SwingConstants.CENTER);
        for (int i = 0; i < 8 ; i++) {
            formPanel.add(blankLabel);
        }

        // Add
        formPanel.add(nameLabel);
        formPanel.add(nameField);

        formPanel.add(descriptionLabel);
        formPanel.add(descriptionField);

        formPanel.add(amountLabel);
        formPanel.add(amountSpinner);

        formPanel.add(availableLabel);
        formPanel.add(availableCheckBox);

        formPanel.add(categoryLabel);
        formPanel.add(categoryField);

        formPanel.add(brandLabel);
        formPanel.add(brandField);

        formPanel.add(supplierVatNumberLabel);
        formPanel.add(supplierVatNumberField);

        // Blank
        for (int i = 0; i < 8 ; i++) {
            formPanel.add(blankLabel);
        }

        // Main add
        add(titlePanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
    }
}
