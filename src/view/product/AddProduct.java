package view.product;

import controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddProduct extends JPanel {
    // Attributes
    private final ProductPanel productPanel;
    private static ProductController productController;
    
    static {
        new ProductController();
    }
    
    // Constructors
    public AddProduct() {
        productPanel = new ProductPanel("Ajouter un article", "Ajouter");
        
        productPanel.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*try {
                    ProductController.create(
                            productPanel.getBarcodeField().getText(),
                            productPanel.getNameField().getText(),
                            productPanel.getDescriptionField().getText(),
                            productPanel.getPriceField().getText(),
                            (Integer) productPanel.getAmountSpinner().getValue(),
                            productPanel.getAvailableRadioButtonYes().isSelected(),
                            ((String) productPanel.getVatTypeComboBox().getSelectedItem()).charAt(0),
                            ProductController.getAllCategories().get(productPanel.getCategoryComboBox().getSelectedIndex()).getId(),
                            ProductController.getOrCreateBrand(productPanel.getBrandField().getText()),
                            productPanel.getStartDateDayField().getText(),
                            productPanel.getStartDateMonthField().getText(),
                            productPanel.getStartDateYearField().getText()
                    );

                    productPanel.removeAllField();
                } catch (WrongTypeException | ProhibitedValueException | InsertionFailedException | DAORetrievalFailedException | NullPointerException |
                         FieldIsEmptyException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }*/
            }
        });
        
        setLayout(new BorderLayout(0, 0));
        setBackground(Color.red);
        add(productPanel);
    }
}
