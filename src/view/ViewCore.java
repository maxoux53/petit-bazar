package view;

import Utils.Env;
import business.DataInteractionManager;
import exceptions.DAORetrievalFailedException;

import javax.swing.*;
import java.util.zip.DataFormatException;

public class ViewCore {
    public static final String NAME;
    private static Window window;
    private static DataInteractionManager dataInteractionManager;

    static {
        NAME = Env.getDotenv().get("STORE_NAME");
        dataInteractionManager = new DataInteractionManager();
    }

    public static void init() {
        applyPlatformSpecificSettings();
        window = new Window(NAME);
    }

    public static void quit() {
        try {
            dataInteractionManager.close();
            System.exit(0);
        } catch (DAORetrievalFailedException e) {
            JOptionPane.showMessageDialog(null, "Une erreur est survenue lors de la fermeture ! Veuillez reessayer.\n" + e.getMessage(), "⛔️", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void applyPlatformSpecificSettings() {
        // Apple macOS
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("apple.awt.application.name", NAME);
            System.setProperty("apple.awt.application.appearance", "system");
        }
    }
}
