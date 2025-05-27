package view.product;

import controller.*;

import exceptions.*;
import model.Category;
import model.Product;
import model.Vat;
import view.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class EditProduct extends JPanel {
    // Attributes
    private final ProductPanel productPanel;
    private ProductController controller;
    private long lastLoadedProductBarcode;

    // Constructors
    public EditProduct(Window window) {
        setController(new ProductController());

        productPanel = new ProductPanel("Modifier un article", "Modifier");

        productPanel.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.update(new Product(
                            lastLoadedProductBarcode,
                            productPanel.nullIfEmptyName(productPanel.getNameField().getText()),
                            productPanel.getDescriptionField().getText(),
                            (int)productPanel.getAmountSpinner().getValue(),
                            productPanel.getAvailableRadioButtonYes().isSelected(),
                            ((String)productPanel.getVatTypeComboBox().getSelectedItem()).charAt(0),
                            controller.getAllCategories().get(productPanel.getCategoryComboBox().getSelectedIndex()).getId(),
                            controller.getOrCreateBrand(productPanel.getBrandField().getText()),
                            productPanel.stringToPrice(productPanel.getPriceField().getText()),
                            ((java.util.Date)productPanel.getStartDateSpinner().getValue()).toInstant()
                                    .atZone(java.time.ZoneId.systemDefault())
                                    .toLocalDate()
                    ));

                    productPanel.removeAllField();
                    window.showProductManagement();
                } catch (WrongTypeException | ProhibitedValueException | UpdateFailedException | DAORetrievalFailedException | NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setLayout(new BorderLayout(0, 0));
        setBackground(Color.red);
        add(productPanel);
    }
    
    // Methods
    public void setController(ProductController productController) {
        controller = productController;
    }
    
    public void fillAllFields(Product product) {
        productPanel.getBarcodeField().setText(String.valueOf(product.getBarcode()));
        productPanel.getNameField().setText(product.getName());
        productPanel.getDescriptionField().setText(product.getDescription());
        productPanel.getPriceField().setText(String.valueOf(product.getExclVatPrice()));
        productPanel.getAmountSpinner().setValue(product.getAmount());

        try {
            productPanel.getVatTypeComboBox().setSelectedIndex(indexOfVatType(product.getVatType()));
            productPanel.getCategoryComboBox().setSelectedItem(controller.getCategoryById(product.getCategoryId()).getLabel());
            productPanel.getBrandField().setText(controller.getBrandById(product.getBrandId()).getName());
        } catch (DAORetrievalFailedException | NotFoundException | ProhibitedValueException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        
        productPanel.getStartDateSpinner().setValue(Date.from(product.getStartDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));

        productPanel.getAvailableRadioButtonYes().setSelected(product.getAvailable());
        productPanel.getAvailableRadioButtonNo().setSelected(!product.getAvailable());
        lastLoadedProductBarcode = product.getBarcode();
    }

    private Integer indexOfVatType(Character targetVatType) throws NotFoundException {
        ArrayList<Vat> vats = productPanel.getVats();
        int size = vats.size();

        int i = 0;
        while (i < size && !vats.get(i).getType().equals(targetVatType)) {
            i++;
        }

        if (i < size) {
            return i;
        }
        throw new NotFoundException("TVA", targetVatType, "Type de TVA inconnu");
    }
}
