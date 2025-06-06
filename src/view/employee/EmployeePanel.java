package view.employee;

import controller.EmployeeController;
import exceptions.*;
import view.FontPreferences;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class EmployeePanel extends JPanel {
    private JPanel titlePanel, formPanel, firstNamePanel, lastNamePanel, passwordPanel, isActivePanel, streetPanel, streetNumberPanel, unitNumberPanel, rolePanel, hireDatePanel, managerIdPanel, cityZipCodePanel, cityNamePanel, countryPanel, buttonPanel;
    private JLabel titleLabel, isActiveLabel, hireDateLabel;
    private JTextField firstNameField, lastNameField, streetField, streetNumberField, unitNumberField, managerIdField, cityZipCodeField, cityNameField;
    private JPasswordField passwordField;
    private JSpinner hireDateSpinner;
    private JRadioButton activeYes, activeNo;
    private ButtonGroup activeGroup;
    private JButton button;
    private JComboBox<String> roleComboBox, countryComboBox;
    private ArrayList<String> countriesList;
    public EmployeeController controller;

    public EmployeePanel(String title, String buttonString) {
        setController(new EmployeeController());

        setLayout(new BorderLayout(0, 100));
        setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        setBackground(Color.white);

        titlePanel = new JPanel();
        titlePanel.setBackground(Color.white);
        titleLabel = new JLabel(title);
        titleLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.BOLD, FontPreferences.TITLE_SIZE));
        titlePanel.add(titleLabel);

        formPanel = new JPanel(new GridLayout(8, 2, 50, 40));
        formPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 250));
        formPanel.setBackground(Color.white);

        firstNamePanel = buildInputPanel("Prénom", firstNameField = new JTextField());
        lastNamePanel = buildInputPanel("Nom", lastNameField = new JTextField());
        passwordPanel = buildInputPanel("Mot de passe", passwordField = new JPasswordField());
        streetPanel = buildInputPanel("Rue", streetField = new JTextField());
        streetNumberPanel = buildInputPanel("Numéro de rue", streetNumberField = new JTextField());
        unitNumberPanel = buildInputPanel("Boîte postale", unitNumberField = new JTextField());
        managerIdPanel = buildInputPanel("Matricule du Manager", managerIdField = new JTextField());
        cityZipCodePanel = buildInputPanel("Code postal", cityZipCodeField = new JTextField());
        cityNamePanel = buildInputPanel("Ville", cityNameField = new JTextField());

        rolePanel = new JPanel(new GridLayout(1, 2, 50, 0));
        rolePanel.setBackground(Color.white);
        JLabel roleLabel = new JLabel("Rôle", SwingConstants.RIGHT);
        roleLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.MID_SIZE));
        try {
            roleComboBox = new JComboBox<>(controller.getAllRoles().toArray(new String[0]));
        } catch (DAORetrievalFailedException e) {
            roleComboBox = new JComboBox<>();
            JOptionPane.showMessageDialog(this, "Erreur lors du chargement des rôles.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        roleComboBox.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.NORMAL_SIZE));
        rolePanel.add(roleLabel);
        rolePanel.add(roleComboBox);

        countryPanel = new JPanel(new GridLayout(1, 2, 50, 0));
        countryPanel.setBackground(Color.white);
        JLabel countryLabel = new JLabel("Pays", SwingConstants.RIGHT);
        countryLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.MID_SIZE));
        try {
            countriesList = controller.getAllCountries();
            countryComboBox = new JComboBox<>(countriesList.toArray(new String[0]));
            countryComboBox.setSelectedItem("Belgique");
        } catch (DAORetrievalFailedException e) {
            countryComboBox = new JComboBox<>();
            JOptionPane.showMessageDialog(this, "Erreur lors du chargement des pays.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        countryComboBox.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.NORMAL_SIZE));
        countryPanel.add(countryLabel);
        countryPanel.add(countryComboBox);

        hireDatePanel = new JPanel(new GridLayout(1, 2, 50, 0));
        hireDatePanel.setBackground(Color.white);
        hireDateLabel = new JLabel("Date d'embauche", SwingConstants.RIGHT);
        hireDateLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.MID_SIZE));
        hireDateSpinner = new JSpinner(new SpinnerDateModel());
        hireDateSpinner.setEditor(new JSpinner.DateEditor(hireDateSpinner, "dd/MM/yyyy"));
        hireDateSpinner.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.PLAIN, FontPreferences.NORMAL_SIZE));
        hireDatePanel.add(hireDateLabel);
        hireDatePanel.add(hireDateSpinner);

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

        buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(Color.white);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 450, 0, 450));
        button = new JButton(buttonString);
        button.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.BOLD, FontPreferences.MID_SIZE));
        button.setBackground(Color.white);
        button.setFocusPainted(false);
        buttonPanel.add(button);

        formPanel.add(firstNamePanel);
        formPanel.add(streetPanel);
        formPanel.add(lastNamePanel);
        formPanel.add(streetNumberPanel);
        formPanel.add(passwordPanel);
        formPanel.add(unitNumberPanel);
        formPanel.add(rolePanel);
        formPanel.add(cityZipCodePanel);
        formPanel.add(managerIdPanel);
        formPanel.add(cityNamePanel);
        formPanel.add(hireDatePanel);
        formPanel.add(countryPanel);
        formPanel.add(isActivePanel);

        add(titlePanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void setController(EmployeeController controller) {
        this.controller = controller;
    }
    
    public JTextField getFirstNameField() { return firstNameField; }
    public JTextField getLastNameField() { return lastNameField; }
    public JPasswordField getPasswordField() { return passwordField; }
    public JTextField getStreetField() { return streetField; }
    public JTextField getStreetNumberField() { return streetNumberField; }
    public JTextField getUnitNumberField() { return unitNumberField; }
    public JTextField getManagerIdField() { return managerIdField; }
    public JTextField getCityZipCodeField() { return cityZipCodeField; }
    public JTextField getCityNameField() { return cityNameField; }
    public JSpinner getHireDateSpinner() { return hireDateSpinner; }
    public JRadioButton getActiveYes() { return activeYes; }
    public JRadioButton getActiveNo() {
        return activeNo;
    }
    public JButton getButton() { return button; }
    public JComboBox<String> getRoleComboBox() { return roleComboBox; }
    public JComboBox<String> getCountryComboBox() { return countryComboBox; }
    public ArrayList<String> getCountriesList() {
        return countriesList;
    }

    // Public methods
    public void clearFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        passwordField.setText("");
        streetField.setText("");
        streetNumberField.setText("");
        unitNumberField.setText("");
        managerIdField.setText("");
        cityZipCodeField.setText("");
        cityNameField.setText("");
        hireDateSpinner.setValue(new Date());
        activeYes.setSelected(true);
        if (roleComboBox.getItemCount() > 0) roleComboBox.setSelectedIndex(0);
        if (countryComboBox.getItemCount() > 0) countryComboBox.setSelectedIndex(0);
    }
    
    public void checkFields() throws FieldIsEmptyException{
        if (nullIfEmptyName(firstNameField.getText()) == null) {
            throw new FieldIsEmptyException("Prénom");
        } else {
            if (nullIfEmptyName(lastNameField.getText()) == null) {
                throw new FieldIsEmptyException("Nom");
            }
            else {
                if (nullIfEmptyName(passwordField.getText()) == null) {
                    throw new FieldIsEmptyException("Mot de passe");
                }
                else {
                    if (nullIfEmptyName(streetField.getText()) == null) {
                        throw new FieldIsEmptyException("Rue");
                    } 
                    else {
                        if (nullIfEmptyName(streetNumberField.getText()) == null) {
                            throw new FieldIsEmptyException("Numéro de rue");
                        }
                        else {
                            if (nullIfEmptyName(cityZipCodeField.getText()) == null) {
                                throw new FieldIsEmptyException("Code postal");
                            } 
                            else {
                                if (nullIfEmptyName(cityNameField.getText()) == null) {
                                    throw new FieldIsEmptyException("Ville");
                                } 
                            }
                        }
                    }
                }
            }
        }
    }
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

    public Integer stringToUnitNumber(String unitNumberAsString) throws ProhibitedValueException, WrongTypeException {
        if (!unitNumberAsString.isEmpty()) {
            int unitNumber;

            try {
                unitNumber = Integer.parseInt(unitNumberAsString);

                if (unitNumber < 0) {
                    throw new ProhibitedValueException("Numéro d'unité");
                }
                return unitNumber;
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Numéro d'unité");
            }
        }
        return null;
    }

    public byte[] stringToPassword(char[] password) throws HashFailedException {
        if (password != null) {
            return controller.hashPassword(new String(password));
        }
        return null;
    }

    public Integer stringToId(String idAsString) throws ProhibitedValueException, WrongTypeException {
        if (!idAsString.isEmpty()) {
            try {
                return Integer.parseInt(idAsString);
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Identifiant");
            }
        }
        return null;
    }

    public Integer stringToZipCode(String zipCodeAsString) throws ProhibitedValueException, WrongTypeException {
        if (!zipCodeAsString.isEmpty()) {
            int zipCode;

            try {
                zipCode = Integer.parseInt(zipCodeAsString);

                if (zipCode < 0) {
                    throw new ProhibitedValueException("Code postal");
                }
                return zipCode;
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Code postal");
            }
        }
        return null;
    }
    
    // Private methods

    private String nullIfEmptyName(String field) {
        return (field.isEmpty() ? null : field);
    }
}
