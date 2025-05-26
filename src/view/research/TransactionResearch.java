package view.research;

import controller.PurchaseController;
import exceptions.*;
import model.PurchaseInformation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class TransactionResearch extends JPanel {
    private JSpinner dateSpinner; // Entrée - Date (dd-MM-yyyy)
    private JButton searchButton; // Entrée - Bouton "Rechercher"
    private JTable resultTable; // Sortie - Tableau des transactions
    private DefaultTableModel tableModel; // Modèle du tableau des transactions

    private PurchaseController controller;

    public TransactionResearch() {
        setController(new PurchaseController());
        setLayout(new BorderLayout());

        // Initialisation du JSpinner (dateSpinner)
        dateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd-MM-yyyy");
        dateSpinner.setEditor(dateEditor);

        // Initialisation du JButton (searchButton)
        searchButton = new JButton("Rechercher");

        // Initialisation du modèle du tableau des transactions
        tableModel = new DefaultTableModel(new Object[]{
                "Identifiant de la transaction",
                "Prénom du client",
                "Nom du client",
                "Prénom de l'employé",
                "Nom de l'employé"},
                0
        );

        resultTable = new JTable(tableModel);

        // Initialisation du JPanel (dateSpinner + searchButton)
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Date :"));
        topPanel.add(dateSpinner);
        topPanel.add(searchButton);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultTable), BorderLayout.CENTER);

        // Mise en fonction du JButton (searchButton)
        searchButton.addActionListener(e -> searchTransaction());
    }

    private void searchTransaction() {
        Date selectedDate = (Date) dateSpinner.getValue(); // Récupération de la date
        LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // Transformation de la date (Date -> LocalDate)

        try {
            ArrayList<PurchaseInformation> results = controller.getPurchaseInformationByDate(localDate); // Récupération des données
            fillTable(results);
        } catch (DAORetrievalFailedException e) {
            JOptionPane.showMessageDialog(this, "Erreur lors de la récupération des données : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fillTable(ArrayList<PurchaseInformation> results) {
        tableModel.setRowCount(0); // Réinitialisation du tableau

        for (PurchaseInformation pi : results) { // Remplissage du tableau avec les données
            tableModel.addRow(new Object[]{
                    pi.getPurchaseId(),
                    pi.getCustomerFirstName(),
                    pi.getCustomerLastName(),
                    pi.getEmployeeFirstName(),
                    pi.getEmployeeLastName()
            });
        }
    }

    public void setController(PurchaseController controller) {
        this.controller = controller; // Setter du Controller
    }
}
