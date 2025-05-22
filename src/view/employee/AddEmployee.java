package view.employee;

import controller.EmployeeController;
import exceptions.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AddEmployee extends JPanel {
    // Attributes
    private final EmployeePanel employeePanel;
    private EmployeeController controller;

    // Constructors
    public AddEmployee() {
        setController(new EmployeeController());
        employeePanel = new EmployeePanel("Ajouter un employé", "Ajouter");

        employeePanel.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String countryName = "Belgique"; // PAR DEFAUT ATTENTION !!!

                    controller.create(
                            employeePanel.getFirstNameField().getText(),
                            employeePanel.getLastNameField().getText(),
                            employeePanel.getPasswordField().getPassword(),
                            employeePanel.getActiveYes().isSelected(),
                            employeePanel.getStreetField().getText(),
                            employeePanel.getStreetNumberField().getText(),
                            employeePanel.getUnitNumberField().getText(),
                            employeePanel.getRoleField().getText(),
                            (Date) employeePanel.getHireDateSpinner().getValue(),
                            employeePanel.getManagerIdField().getText(),
                            employeePanel.getCityZipCodeField().getText(),
                            employeePanel.getCityNameField().getText(),
                            countryName
                    );

                    employeePanel.clearFields();
                    JOptionPane.showMessageDialog(null, "Employé ajouté avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
                } catch (WrongTypeException | ProhibitedValueException | InsertionFailedException | DAORetrievalFailedException | NumberFormatException | HashFailedException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
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
