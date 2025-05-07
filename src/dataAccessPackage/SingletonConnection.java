package dataAccessPackage;

import exceptionPackage.*;

import javax.swing.*;
import java.sql.*;

public class SingletonConnection {
    private static Connection connection;

    private SingletonConnection() {}

    public static Connection getInstance() throws ConnectionException {
        try {
            if (connection == null) {
                JTextField usernameField = new JTextField();
                JPasswordField passwordField = new JPasswordField();

                Object[] message = {
                        "Username:", usernameField,
                        "Password:", passwordField
                };

                int option = JOptionPane.showOptionDialog(null, message, "Veuillez renseigner vos identifiants", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                if (option == JOptionPane.OK_OPTION) {
                    String username = usernameField.getText();
                    char[] passwordChars = passwordField.getPassword();
                    String password = new String(passwordChars);

                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pb", username, password);
                } else {
                    throw new ConnectionException("La connexion à la base de données a été annulée");
                }
            }

            return connection;
        } catch (SQLException sqlException) {
            throw new ConnectionException("Erreur lors de la connexion à la base de données");
        }
    }
}
