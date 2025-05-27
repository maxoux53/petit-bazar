package view.employee;

import controller.EmployeeController;
import exceptions.*;
import model.City;
import model.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddEmployee extends EmployeePanel {
    public AddEmployee() {
        super("Ajouter un employé", "Ajouter");
        setController(new EmployeeController());

        getButton().addActionListener((ActionEvent e) -> {
            try {
                fieldsAreFilled();
                
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
                        ((java.util.Date)getHireDateSpinner().getValue()).toInstant()
                                .atZone(java.time.ZoneId.systemDefault())
                                .toLocalDate(),
                        stringToId(getManagerIdField().getText().trim()),
                        zipCode,
                        cityName
                ));

                clearFields();
            } catch (WrongTypeException | ProhibitedValueException | InsertionFailedException | DAORetrievalFailedException | NumberFormatException | HashFailedException | FieldIsEmptyException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
