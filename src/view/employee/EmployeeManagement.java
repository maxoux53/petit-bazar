package view.employee;

import controller.EmployeeController;
import exceptions.*;
import model.Employee;
import view.FontPreferences;
import view.Window;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EmployeeManagement extends JPanel {
    // Attributes
    private JPanel titlePanel, listingPanel, buttonsPanel;
    private JLabel titleLabel;
    private JTable listingTable;
    private JScrollPane scrollPane;
    private JButton editButton, deleteButton;
    private Employee selectedEmployee;
    private EmployeeController controller;

    // Constructors
    public EmployeeManagement(Window window) {
        setController(new EmployeeController());

        setLayout(new BorderLayout(0, 50));
        setBorder(BorderFactory.createEmptyBorder(20, 100, 50, 100));
        setBackground(Color.white);

        // Title
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.white);

        titleLabel = new JLabel("Gestion des employés", SwingConstants.CENTER);
        titleLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.BOLD, FontPreferences.TITLE_SIZE));

        titlePanel.add(titleLabel);

        // Listing
        listingPanel = new JPanel(new BorderLayout());
        listingPanel.setBackground(Color.white);

        try {
            listingTable = new JTable(infoTableModel());
            listingTable.setDefaultEditor(Object.class, null);
        } catch (DAORetrievalFailedException | ProhibitedValueException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        scrollPane = new JScrollPane(listingTable);

        listingPanel.add(scrollPane);

        // Buttons
        buttonsPanel = new JPanel(new GridLayout(1, 2, 50, 0));
        buttonsPanel.setBackground(Color.white);

        editButton = new JButton("Modifier");
        editButton.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.BOLD, FontPreferences.MID_SIZE));
        editButton.setBackground(Color.white);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSelectedEmployeeLoaded()) {
                    window.getEditEmployee().fillAllFields(selectedEmployee);
                    window.showEditEmployee();
                }
            }
        });

        deleteButton = new JButton("Supprimer");
        deleteButton.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.BOLD, FontPreferences.MID_SIZE));
        deleteButton.setBackground(Color.white);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSelectedEmployeeLoaded()) {
                    if (JOptionPane.showConfirmDialog(null,
                            "Êtes-vous sûr de vouloir supprimer l'employé : " + selectedEmployee.getFirstName() + " " + selectedEmployee.getLastName() + " ?",
                            "Confirmation",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                        try {
                            if (controller.remove(selectedEmployee.getId()) > 0) {
                                JOptionPane.showMessageDialog(null, "L'employé a été supprimé avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
                                refreshTable();
                            } else {
                                JOptionPane.showMessageDialog(null, "L'employé n'a pas pu être supprimé !", "Échec", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (WrongTypeException | DeleteFailedException | DAORetrievalFailedException | NullPointerException | ProhibitedValueException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

        buttonsPanel.add(editButton);
        buttonsPanel.add(deleteButton);

        // Add Main
        add(titlePanel, BorderLayout.NORTH);
        add(listingPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    // Methods
    private boolean isSelectedEmployeeLoaded() {
        if (listingTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Aucune donnée sélectionnée !", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            selectedEmployee = controller.getEmployeeById((Integer) listingTable.getValueAt(listingTable.getSelectedRow(), 0));
            return true;
        } catch (DAORetrievalFailedException | WrongTypeException | NullPointerException | ProhibitedValueException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (NotFoundException exception) {
            JOptionPane.showMessageDialog(null, "Employé inconnu !", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

    public DefaultTableModel infoTableModel() throws DAORetrievalFailedException, ProhibitedValueException {
        String[] columnNames = {
                "Matricule",
                "Prénom",
                "Nom",
                "est actif",
                "Rue",
                "Numéro de rue",
                "Numéro de boîte",
                "Rôle",
                "Date d'embauche",
                "Matricule du manager",
                "Code postal de la ville",
                "Nom de la ville",
                "Pays"
        };

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        ArrayList<Employee> employees = controller.getAllEmployees();
        Object[] employeeInfos = new Object[columnNames.length];

        for (Employee employee : employees) {

            employeeInfos[0] = employee.getId();
            employeeInfos[1] = employee.getFirstName();
            employeeInfos[2] = employee.getLastName();
            employeeInfos[3] = employee.getActive();
            employeeInfos[4] = employee.getStreet();
            employeeInfos[5] = employee.getStreetNumber();
            employeeInfos[6] = employee.getUnitNumber();
            employeeInfos[7] = employee.getRoleLabel();
            employeeInfos[8] = employee.getHireDate();
            employeeInfos[9] = employee.getManagerId();
            employeeInfos[10] = employee.getCityZipCode();
            employeeInfos[11] = employee.getCityName();

            model.addRow(employeeInfos);
        }

        return model;
    }

    private void refreshTable() {
        try {
            listingTable.setModel(infoTableModel());
        } catch (DAORetrievalFailedException | ProhibitedValueException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setController(EmployeeController controller) {
        this.controller = controller;
    }
}
