package view.employee;

import controller.EmployeeController;
import exceptions.*;
import model.City;
import model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class AddEmployee extends EmployeePanel {
    public AddEmployee() {
        super("Ajouter un employé", "Ajouter");
        setController(new EmployeeController());

        getButton().addActionListener((ActionEvent e) -> {
            try {
                Integer zipCode = stringToZipCode(getCityZipCodeField().getText().trim());
                String cityName = getCityNameField().getText();

                controller.setCity(new City(zipCode, cityName, (String)getCountryComboBox().getSelectedItem()));

                controller.create(new Employee(
                        getFirstNameField().getText().trim(),
                        getLastNameField().getText(),
                        stringToPassword(getPasswordField().getPassword()),
                        getActiveYes().isSelected(),
                        getStreetField().getText(),
                        getStreetNumberField().getText().trim(),
                        stringToUnitNumber(getUnitNumberField().getText().trim()),
                        (String)getRoleComboBox().getSelectedItem(),
                        (LocalDate)getHireDateSpinner().getValue(),
                        stringToId(getManagerIdField().getText().trim()),
                        zipCode,
                        cityName
                ));

                clearFields();
            } catch (WrongTypeException | ProhibitedValueException | InsertionFailedException | DAORetrievalFailedException | NumberFormatException | HashFailedException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
