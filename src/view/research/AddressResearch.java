package view.research;

import controller.EmployeeController;
import exceptions.*;
import model.EmployeePlace;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class AddressResearch extends JPanel {
    private JTextField idField; // Entrée - Id
    private JButton searchButton; // Entrée - Bouton "Rechercher"
    private JTable resultTable; // Sortie - Tableau de l'adresse
    private DefaultTableModel tableModel; // Modèle du tableau de l'adresse

    private EmployeeController controller;

    public AddressResearch() {
        setController(new EmployeeController());
        setLayout(new BorderLayout());

        // Initialisation du JPanel (idField)
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Identifiant de l'employé :"));
        idField = new JTextField(10);
        topPanel.add(idField);

        // Initialisation du JButton (searchButton)
        searchButton = new JButton("Rechercher");
        topPanel.add(searchButton);

        add(topPanel, BorderLayout.NORTH);

        // Initialisation du modèle du tableau de l'adresse
        tableModel = new DefaultTableModel(new Object[]{
                "Prénom",
                "Nom",
                "Adresse"},
                0
        );

        resultTable = new JTable(tableModel);

        add(new JScrollPane(resultTable), BorderLayout.CENTER);

        // Mise en fonction du JButton (searchButton)
        searchButton.addActionListener(e -> searchAddress());
    }

    private void searchAddress() {
        String idText = idField.getText().trim();

        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un ID employé", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Integer employeeId; // Récupération de l'id
        try {
            employeeId = Integer.parseInt(idText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "L'ID doit être un nombre entier", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            ArrayList<EmployeePlace> places = controller.getEmployeePlaceByEmployee(employeeId); // Récupération des données
            fillTable(places);
        } catch (DAORetrievalFailedException | ProhibitedValueException ex) {
            JOptionPane.showMessageDialog(this, "Erreur lors de la récupération des données : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fillTable(ArrayList<EmployeePlace> places) {
        tableModel.setRowCount(0); // Réinitialisation du tableau

        for (EmployeePlace place : places) { // Remplissage du tableau avec les données
            String fullAddress = place.getCity().getZipCode() + ", " +
                    place.getCity().getName() + ", " +
                    place.getCity().getCountry();

            tableModel.addRow(new Object[]{
                    place.getEmployeeFirstName(),
                    place.getEmployeeLastName(),
                    fullAddress
            });
        }

        if (places.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aucune donnée trouvée pour cet ID", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void setController(EmployeeController controller) {
        this.controller = controller; // Setter du Controller
    }
}
