package viewPackage.customer;

import modelPackage.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerFormPanel extends JPanel {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField loyaltyCardNumberField;
    private JTextField loyaltyPointsField;
    private JTextField birthDateField;
    private JButton submitButton;
    private JButton cancelButton;

    public CustomerFormPanel() {
        setLayout(new GridLayout(9, 2, 10, 10));

        add(new JLabel("Prénom:"));
        firstNameField = new JTextField();
        add(firstNameField);

        add(new JLabel("Nom de famille:"));
        lastNameField = new JTextField();
        add(lastNameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Téléphone:"));
        phoneField = new JTextField();
        add(phoneField);

        add(new JLabel("Numéro de carte de fidélité:"));
        loyaltyCardNumberField = new JTextField();
        add(loyaltyCardNumberField);

        add(new JLabel("Points de fidélité:"));
        loyaltyPointsField = new JTextField();
        add(loyaltyPointsField);

        add(new JLabel("Date de naissance (YYYY-MM-DD):"));
        birthDateField = new JTextField();
        add(birthDateField);

        submitButton = new JButton("Ajouter un client");
        add(submitButton);

        cancelButton = new JButton("Annuler");
        add(cancelButton);

        cancelButton.addActionListener(e -> {
            clearFields();
        });

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                int loyaltyCardNumber = Integer.parseInt(loyaltyCardNumberField.getText());
                int loyaltyPoints = Integer.parseInt(loyaltyPointsField.getText());
                String birthDateStr = birthDateField.getText();
                Date birthDate = parseDate(birthDateStr);

                Customer customer = new Customer();
                customer.setFirstName(firstName);
                customer.setLastName(lastName);
                customer.setEmail(email);
                customer.setPhone(phone);
                customer.setLoyaltyCardNumber(loyaltyCardNumber);
                customer.setLoyaltyPoints(loyaltyPoints);
                customer.setBirthDate(birthDate);

                JOptionPane.showMessageDialog(CustomerFormPanel.this, "Client créé avec succès");
                clearFields();
            }
        });
    }

    private void clearFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
        phoneField.setText("");
        loyaltyCardNumberField.setText("");
        loyaltyPointsField.setText("");
        birthDateField.setText("");
    }

    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Format de date invalide. Veuillez entrer la date au format YYYY-MM-DD");
            return null;
        }
    }
}
