package view.employee;

import controller.EmployeeController;
import exceptions.*;
import model.City;
import model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class AddEmployee extends JPanel {
    private final EmployeePanel employeePanel;
    private EmployeeController controller;

    public AddEmployee() {
        setController(new EmployeeController());
        employeePanel = new EmployeePanel("Ajouter un employé", "Ajouter");

        employeePanel.getButton().addActionListener((ActionEvent e) -> {
            try {
                String firstName = employeePanel.getFirstNameField().getText().trim();
                String lastName = employeePanel.getLastNameField().getText();
                char[] passwordChars = employeePanel.getPasswordField().getPassword();
                boolean isActive = employeePanel.getActiveYes().isSelected();
                String street = employeePanel.getStreetField().getText();
                String streetNumber = employeePanel.getStreetNumberField().getText().trim();
                String unitText = employeePanel.getUnitNumberField().getText().trim();
                Integer unitNumber = unitText.isEmpty() ? null : Integer.parseInt(unitText);
                String role = (String) employeePanel.getRoleComboBox().getSelectedItem();
                LocalDate hireDate = ((Date) employeePanel.getHireDateSpinner().getValue()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                String managerText = employeePanel.getManagerIdField().getText().trim();
                Integer managerId = managerText.isEmpty() ? null : Integer.parseInt(managerText);
                String zipCodeText = employeePanel.getCityZipCodeField().getText().trim();
                Integer zipCode = zipCodeText.isEmpty() ? null : Integer.parseInt(zipCodeText);
                String cityName = employeePanel.getCityNameField().getText().trim();
                City selectedCity = (City) employeePanel.getCountryComboBox().getSelectedItem();
                String country = selectedCity != null ? selectedCity.getCountry() : "🇧🇪 Belgique";

                byte[] passwordBytes = new String(passwordChars).getBytes(StandardCharsets.UTF_8);

                Employee employee = new Employee(
                        firstName,
                        lastName,
                        passwordBytes,
                        isActive,
                        street,
                        streetNumber,
                        unitNumber,
                        role,
                        hireDate,
                        managerId,
                        zipCode,
                        cityName
                );

                controller.create(
                        employee.getFirstName(),
                        employee.getLastName(),
                        passwordChars,
                        employee.getActive(),
                        employee.getStreet(),
                        employee.getStreetNumber(),
                        employee.getUnitNumber() != null ? employee.getUnitNumber().toString() : "",
                        employee.getRoleLabel(),
                        Date.from(employee.getHireDate().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                        employee.getManagerId() != null ? employee.getManagerId().toString() : "",
                        employee.getCityZipCode() != null ? employee.getCityZipCode().toString() : "",
                        employee.getCityName(),
                        country
                );

                employeePanel.clearFields();

            } catch (WrongTypeException | ProhibitedValueException | InsertionFailedException |
                     DAORetrievalFailedException | NumberFormatException | HashFailedException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        setLayout(new BorderLayout());
        setBackground(Color.white);
        add(employeePanel, BorderLayout.CENTER);
    }

    public void setController(EmployeeController employeeController) {
        this.controller = employeeController;
    }
}
