package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays; // DEBUG ONLY, REMOVE LATER

public class Login extends JPanel {
    // Attributes
    /*private Window window;
    private JPanel titlePanel;
    private JLabel title;
    private JPanel formPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel buttonPanel;
    private JButton button;*/

    private Window window;
    private JPanel titlePanel, formPanel, buttonPanel;
    private JLabel title, usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton button;

    private String username;
    private char[] password;
    
    // Constructors
    public Login(Window window) {
        this.window = window;
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 500, 30, 500));
        setBackground(Color.WHITE);
        
        // Title of login view
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.WHITE);
        title = new JLabel("Connexion");
        title.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.BOLD, 60));
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);
        
        // Form
        formPanel = new JPanel(new GridLayout(6, 1, 150, 100));
        formPanel.setBackground(Color.WHITE);
        
        // Blank
        JLabel blankLabel = new JLabel(" ", SwingConstants.CENTER);
        formPanel.add(blankLabel);
        
        // User
        JLabel usernameLabel = new JLabel("👤 Nom d'utilisateur", SwingConstants.LEFT);
      
        usernameLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, 35));
        formPanel.add(usernameLabel);
        usernameField = new JTextField();
        usernameField.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, 25));
        usernameField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        usernameField.setPreferredSize(new Dimension(20, 25));
        formPanel.add(usernameField);
        
        // Password
        JLabel passwordLabel = new JLabel("🔑 Mot de passe", SwingConstants.LEFT);

        passwordLabel.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, 35));
        formPanel.add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.PLAIN, 25));
        passwordField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        passwordField.setPreferredSize(new Dimension(passwordField.getPreferredSize().width, 10));
        formPanel.add(passwordField, BorderLayout.CENTER);
        
        add(formPanel, BorderLayout.CENTER);
        
        // Button
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        button = new JButton("Se connecter");
        button.setFont(new Font(FontPreferences.DEFAULT_STYLE.getStyle(), Font.BOLD, 25));
        button.setBackground(Color.white);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(300, 50));
        buttonPanel.add(button);
        add(buttonPanel, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                username = usernameField.getText();
                password = passwordField.getPassword();

                // Exemple : afficher dans la console
                System.out.println("Nom d'utilisateur : " + username);
                System.out.println("Mot de passe : " + Arrays.toString(password)); // DEBUG ONLY!! REMOVE LATER (+ import) ⚠️

                window.showHome();
            }
        });
    }
}
