package view.employee;

import controller.EmployeeController;
import view.FontPreferences;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class EmployeePanel extends JPanel {
    // Attributes
    private JPanel titlePanel, formPanel, firstNamePanel, lastNamePanel, passwordPanel, isActivePanel, streetPanel, streetNumberPanel, unitNumberPanel, rolePanel, hireDatePanel, managerIdPanel, cityZipCodePanel, cityNamePanel, buttonPanel;
    private JLabel titleLabel, isActiveLabel, hireDateLabel;
    private JTextField firstNameField, lastNameField, streetField, streetNumberField, unitNumberField, roleField, managerIdField, cityZipCodeField, cityNameField;
    private JPasswordField passwordField;
    private JSpinner hireDateSpinner;
    private JRadioButton activeYes, activeNo;
    private ButtonGroup activeGroup;
    private JButton button;
    private EmployeeController controller; // Controlleur non-utilisé !!!

    // Constructors
    public EmployeePanel(String title, String buttonString) {
        setController(new EmployeeController());

        setLayout(new BorderLayout(0, 100));
        setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        setBackground(Color.white);

        // Title
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.white);

        titleLabel = new JLabel(title);
        titleLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.BOLD, FontPreferences.TITLE_SIZE));

        titlePanel.add(titleLabel);

        // Form
        formPanel = new JPanel(new GridLayout(7, 2, 50, 40));
        formPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 250));
        formPanel.setBackground(Color.white);

        // Panels
        firstNamePanel = buildInputPanel("Prénom", firstNameField = new JTextField());
        lastNamePanel = buildInputPanel("Nom", lastNameField = new JTextField());
        passwordPanel = buildInputPanel("Mot de passe", passwordField = new JPasswordField());
        streetPanel = buildInputPanel("Rue", streetField = new JTextField());
        streetNumberPanel = buildInputPanel("Numéro de rue", streetNumberField = new JTextField());
        unitNumberPanel = buildInputPanel("Boîte postale", unitNumberField = new JTextField());
        rolePanel = buildInputPanel("Rôle", roleField = new JTextField());
        managerIdPanel = buildInputPanel("ID du Manager", managerIdField = new JTextField());
        cityZipCodePanel = buildInputPanel("Code postal", cityZipCodeField = new JTextField());
        cityNamePanel = buildInputPanel("Ville", cityNameField = new JTextField());

        // Date d'embauche
        hireDatePanel = new JPanel(new GridLayout(1, 2, 50, 0));
        hireDatePanel.setBackground(Color.white);
        hireDateLabel = new JLabel("Date d'embauche", SwingConstants.RIGHT);
        hireDateLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.MID_SIZE));
        hireDateSpinner = new JSpinner(new SpinnerDateModel());
        hireDateSpinner.setEditor(new JSpinner.DateEditor(hireDateSpinner, "dd/MM/yyyy"));
        hireDateSpinner.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.NORMAL_SIZE));
        hireDatePanel.add(hireDateLabel);
        hireDatePanel.add(hireDateSpinner);

        // Est actif
        isActivePanel = new JPanel(new GridLayout(1, 2, 50, 0));
        isActivePanel.setBackground(Color.white);
        isActiveLabel = new JLabel("Actif", SwingConstants.RIGHT);
        isActiveLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.MID_SIZE));
        JPanel radioPanel = new JPanel(new GridLayout(1, 2));
        radioPanel.setBackground(Color.white);
        activeYes = new JRadioButton("OUI");
        activeNo = new JRadioButton("NON");
        activeGroup = new ButtonGroup();
        activeGroup.add(activeYes);
        activeGroup.add(activeNo);
        activeYes.setSelected(true);
        radioPanel.add(activeYes);
        radioPanel.add(activeNo);
        isActivePanel.add(isActiveLabel);
        isActivePanel.add(radioPanel);

        // Button
        buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(Color.white);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 450, 0, 450));
        button = new JButton(buttonString);
        button.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.BOLD, FontPreferences.MID_SIZE));
        button.setBackground(Color.white);
        button.setFocusPainted(false);
        buttonPanel.add(button);

        // Add
        formPanel.add(firstNamePanel);
        formPanel.add(lastNamePanel);
        formPanel.add(passwordPanel);
        formPanel.add(streetPanel);
        formPanel.add(streetNumberPanel);
        formPanel.add(unitNumberPanel);
        formPanel.add(rolePanel);
        formPanel.add(managerIdPanel);
        formPanel.add(cityZipCodePanel);
        formPanel.add(cityNamePanel);
        formPanel.add(hireDatePanel);
        formPanel.add(isActivePanel);

        // Main add
        add(titlePanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Méthods
    private JPanel buildInputPanel(String labelText, JTextField field) {
        JPanel panel = new JPanel(new GridLayout(1, 2, 50, 0));
        panel.setBackground(Color.white);
        JLabel label = new JLabel(labelText, SwingConstants.RIGHT);
        label.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.MID_SIZE));
        field.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.NORMAL_SIZE));
        field.setBackground(Color.white);
        field.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        panel.add(label);
        panel.add(field);
        return panel;
    }

    public void clearFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        passwordField.setText("");
        streetField.setText("");
        streetNumberField.setText("");
        unitNumberField.setText("");
        roleField.setText("");
        managerIdField.setText("");
        cityZipCodeField.setText("");
        cityNameField.setText("");
        hireDateSpinner.setValue(new Date());
        activeYes.setSelected(true);
    }

    public void setController(EmployeeController controller) {
        this.controller = controller;
    }

    // Getters
    public JTextField getFirstNameField() { return firstNameField; }
    public JTextField getLastNameField() { return lastNameField; }
    public JPasswordField getPasswordField() { return passwordField; }
    public JTextField getStreetField() { return streetField; }
    public JTextField getStreetNumberField() { return streetNumberField; }
    public JTextField getUnitNumberField() { return unitNumberField; }
    public JTextField getRoleField() { return roleField; }
    public JTextField getManagerIdField() { return managerIdField; }
    public JTextField getCityZipCodeField() { return cityZipCodeField; }
    public JTextField getCityNameField() { return cityNameField; }
    public JSpinner getHireDateSpinner() { return hireDateSpinner; }
    public JRadioButton getActiveYes() { return activeYes; }
    public JRadioButton getActiveNo() { return activeNo; }
    public JButton getButton() { return button; }
}
