package view.employee;

import controller.EmployeeController;
import exceptions.*;
import model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class EditEmployee extends JPanel {
    private final EmployeePanel employeePanel;
    private EmployeeController controller;
    private int lastLoadedEmployeeId;

    public EditEmployee() {
        setController(new EmployeeController());

        employeePanel = new EmployeePanel("Modifier un employé", "Modifier");

        employeePanel.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.update(
                            lastLoadedEmployeeId,
                            employeePanel.getFirstNameField().getText().trim(),
                            employeePanel.getLastNameField().getText(),
                            employeePanel.getPasswordField().getPassword(),
                            employeePanel.getActiveYes().isSelected(),
                            employeePanel.getStreetField().getText(),
                            employeePanel.getStreetNumberField().getText().trim(),
                            employeePanel.getUnitNumberField().getText().trim(),
                            (String) employeePanel.getRoleComboBox().getSelectedItem(),
                            (Date) employeePanel.getHireDateSpinner().getValue(),
                            employeePanel.getManagerIdField().getText().trim(),
                            employeePanel.getCityZipCodeField().getText().trim(),
                            employeePanel.getCityNameField().getText().trim(),
                            "Belgique"
                    );

                    employeePanel.clearFields();
                } catch (WrongTypeException | ProhibitedValueException | UpdateFailedException |
                         DAORetrievalFailedException | HashFailedException | NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setLayout(new BorderLayout());
        setBackground(Color.white);
        add(employeePanel, BorderLayout.CENTER);
    }

    // Methods
    public void setController(EmployeeController controller) {
        this.controller = controller;
    }

    public void fillAllFields(Employee employee) {
        lastLoadedEmployeeId = employee.getId();
        employeePanel.getFirstNameField().setText(employee.getFirstName());
        employeePanel.getLastNameField().setText(employee.getLastName());
        employeePanel.getPasswordField().setText("");
        employeePanel.getActiveYes().setSelected(employee.getActive());
        employeePanel.getStreetField().setText(employee.getStreet());
        employeePanel.getStreetNumberField().setText(employee.getStreetNumber());
        employeePanel.getUnitNumberField().setText(employee.getUnitNumber() == null ? "" : employee.getUnitNumber().toString());
        employeePanel.getRoleComboBox().setSelectedItem(employee.getRoleLabel());
        employeePanel.getHireDateSpinner().setValue(java.sql.Date.valueOf(employee.getHireDate()));
        employeePanel.getManagerIdField().setText(employee.getManagerId() == null ? "" : employee.getManagerId().toString());
        employeePanel.getCityZipCodeField().setText(employee.getCityZipCode().toString());
        employeePanel.getCityNameField().setText(employee.getCityName());
    }
}
