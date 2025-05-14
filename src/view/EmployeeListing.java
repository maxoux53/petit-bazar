package view;

import controller.EmployeeController;
import exceptions.DAORetrievalFailedException;

import javax.swing.*;
import java.awt.*;

public class EmployeeListing extends JPanel {
    // Attributes
    JPanel titlePanel, listingPanel;
    JLabel titleLabel;
    JTable listingTable;
    JScrollPane listingScroll;
    EmployeeController employeeController;

    // Constructor
    public EmployeeListing() {
        setLayout(new BorderLayout(0, 100));
        setBorder(BorderFactory.createEmptyBorder(20, 100, 100, 100));
        new GridLayout(2, 1, 0, 0);
        setBackground(Color.white);
        
        employeeController = new EmployeeController();

        // Titles
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.white);

        titleLabel = new JLabel("Liste des employés", SwingConstants.CENTER);
        titleLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE, Font.BOLD, FontPreferences.TITLE_SIZE));

        titlePanel.add(titleLabel);

        // Listing
        listingPanel = new JPanel();
        listingPanel.setBackground(Color.red);

        try {
            listingTable = new JTable(employeeController.infoTableModel());

            // Scroll
            listingScroll = new JScrollPane(listingTable);
            add(listingScroll, BorderLayout.CENTER);
        } catch (DAORetrievalFailedException e) {
            JOptionPane.showMessageDialog(null, "Erreur de récupération des données", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
