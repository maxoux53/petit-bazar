package view.employee;

import controller.EmployeeController;
import exceptions.*;
import model.City;
import model.Employee;
import view.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.util.Date;

public class EditEmployee extends EmployeePanel {
    private int lastLoadedEmployeeId;

    public EditEmployee(Window window) {
        super("Modifier un employé", "Modifier");
        setController(new EmployeeController());

        getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    checkFields();
                    
                    Integer zipCode = stringToZipCode(getCityZipCodeField().getText().trim());
                    String cityName = getCityNameField().getText();

                    controller.setCity(new City(zipCode, cityName, (String) getCountryComboBox().getSelectedItem()));

                    controller.update(new Employee(
                            lastLoadedEmployeeId,
                            getFirstNameField().getText().trim(),
                            getLastNameField().getText(),
                            stringToPassword(getPasswordField().getPassword()),
                            getActiveYes().isSelected(),
                            getStreetField().getText(),
                            getStreetNumberField().getText().trim(),
                            stringToUnitNumber(getUnitNumberField().getText().trim()),
                            (String) getRoleComboBox().getSelectedItem(),
                            ((java.util.Date) getHireDateSpinner().getValue()).toInstant()
                                    .atZone(java.time.ZoneId.systemDefault())
                                    .toLocalDate(),
                            stringToId(getManagerIdField().getText().trim()),
                            zipCode,
                            cityName
                    ));

                    clearFields();
                    window.showEmployeeManagement();
                } catch (WrongTypeException | ProhibitedValueException | UpdateFailedException | DAORetrievalFailedException | HashFailedException | NullPointerException | FieldIsEmptyException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Methods
    public void fillAllFields(Employee employee) throws DAORetrievalFailedException, NotFoundException, ProhibitedValueException {
        Integer cityZipCode = employee.getCityZipCode();
        String cityName = employee.getCityName();

        lastLoadedEmployeeId = employee.getId();
        getFirstNameField().setText(employee.getFirstName());
        getLastNameField().setText(employee.getLastName());
        getPasswordField().setText("");
        getActiveYes().setSelected(employee.getActive());
        getActiveNo().setSelected(!employee.getActive());
        getStreetField().setText(employee.getStreet());
        getStreetNumberField().setText(employee.getStreetNumber());
        getUnitNumberField().setText(employee.getUnitNumber() == null ? "" : employee.getUnitNumber().toString());
        getRoleComboBox().setSelectedItem(employee.getRoleLabel());
        getHireDateSpinner().setValue(Date.from(employee.getHireDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        getManagerIdField().setText(employee.getManagerId() == null ? "" : employee.getManagerId().toString());
        getCityZipCodeField().setText(cityZipCode.toString());
        getCityNameField().setText(cityName);
        getCountryComboBox().setSelectedItem(controller.getCity(cityZipCode, cityName).getCountry());
    }
}
