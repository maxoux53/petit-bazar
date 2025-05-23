package view.employee;

import controller.EmployeeController;
import exceptions.*;
import model.City;
import model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class EditEmployee extends EmployeePanel {
    private int lastLoadedEmployeeId;

    public EditEmployee() {
        setController(new EmployeeController());
        new EmployeePanel("Modifier un employé", "Modifier");

        getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer zipCode = stringToZipCode(getCityZipCodeField().getText().trim());
                    String cityName = getCityNameField().getText();

                    controller.setCity(new City(zipCode, cityName, (String)getCountryComboBox().getSelectedItem()));

                    controller.update(new Employee(
                            lastLoadedEmployeeId,
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
                } catch (WrongTypeException | ProhibitedValueException | UpdateFailedException | DAORetrievalFailedException | HashFailedException | NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setLayout(new BorderLayout());
        setBackground(Color.white);
        add(this, BorderLayout.CENTER);
    }

    // Methods
    public void fillAllFields(Employee employee) {
        Integer cityZipCode = employee.getCityZipCode();
        String cityName = employee.getCityName();

        lastLoadedEmployeeId = employee.getId();
        getFirstNameField().setText(employee.getFirstName());
        getLastNameField().setText(employee.getLastName());
        getPasswordField().setText("");
        getActiveYes().setSelected(employee.getActive());
        getStreetField().setText(employee.getStreet());
        getStreetNumberField().setText(employee.getStreetNumber());
        getUnitNumberField().setText(employee.getUnitNumber() == null ? "" : employee.getUnitNumber().toString());
        getRoleComboBox().setSelectedItem(employee.getRoleLabel());
        getHireDateSpinner().setValue(employee.getHireDate());
        getManagerIdField().setText(employee.getManagerId() == null ? "" : employee.getManagerId().toString());
        getCityZipCodeField().setText(cityZipCode.toString());
        getCityNameField().setText(cityName);
        getCountryComboBox().setSelectedItem(controller.getCountry(cityZipCode, cityName));
    }
}
