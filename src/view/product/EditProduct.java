package view.product;


import controller.*;

import exceptions.*;
import model.Product;
import view.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditProduct extends JPanel {
    // Attributes
    private final ProductPanel productPanel;
    private static ProductController productController;

    static {
        new ProductController();
    }

    // Constructors
    public EditProduct(Window window) {
        productPanel = new ProductPanel("Modifier un article", "Modfier");

        productPanel.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*try {
                    ProductController.update(
                            productPanel.getBarcodeField().getText(),
                            productPanel.getNameField().getText(),
                            productPanel.getDescriptionField().getText(),
                            productPanel.getPriceField().getText(),
                            (Integer) productPanel.getAmountSpinner().getValue(),
                            productPanel.getAvailableRadioButtonYes().isSelected(),
                            ((String) productPanel.getVatTypeComboBox().getSelectedItem()).charAt(0),
                            ProductController.getAllCategories().get(productPanel.getCategoryComboBox().getSelectedIndex()).getId(),
                            ProductController.getOrCreateBrand(productPanel.getBrandField().getText()),
                    );

                    productPanel.removeAllField();
                    window.showProductManagement();
                } catch (WrongTypeException | ProhibitedValueException | UpdateFailedException | DAORetrievalFailedException | NullPointerException |
                         FieldIsEmptyException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }*/
            }
        });

        setLayout(new BorderLayout(0, 0));
        setBackground(Color.red);
        add(productPanel);
    }
    
    // Methods
    
    public void fillAllFields(Product product) {
        productPanel.getBarcodeField().setText(String.valueOf(product.getBarcode()));
        productPanel.getNameField().setText(product.getName());
        productPanel.getDescriptionField().setText(product.getDescription());
        productPanel.getPriceField().setText(String.valueOf(product.getExclVatPrice()));
        productPanel.getAmountSpinner().setValue(product.getAmount());

        try {
            productPanel.getVatTypeComboBox().setSelectedIndex(productController.indexOfVatType(product.getVatType()));
            productPanel.getCategoryComboBox().setSelectedIndex(productController.indexOfCategoryName(product.getCategoryId()));
            productPanel.getBrandField().setText(productController.getBrandLabelById(product.getBrandId()));
        } catch (DAORetrievalFailedException | NotFoundException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        
        productPanel.getAvailableRadioButtonNo().setSelected(!product.getAvailable());
    }
}
