package test;

import exceptions.ProhibitedValueException;
import model.Product;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    private Product validProduct;
    private LocalDate testDate;

    @BeforeEach
    public void setUp() {
        try {
            testDate = LocalDate.now();
            validProduct = new Product(
                    (long)123456789,
                    "Produit test",
                    "Description du produit test",
                    10,
                    true,
                    'A',
                    1,
                    2,
                    new BigDecimal("19.99"),
                    testDate
            );
        } catch (ProhibitedValueException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Test
    public void testValidProductCreation() {
        assertNotNull(validProduct);
        assertEquals("Produit test", validProduct.getName());
        assertEquals(new BigDecimal("19.99"), validProduct.getExclVatPrice());
        assertEquals((long)123456789, validProduct.getBarcode());
    }

    @Test
    public void testProductNameTooLong() {
        try {
            String tooLongName = "A".repeat(61); // Crée une chaîne de 61 'A'
            Product invalidProduct = new Product(
                    (long)123456789,
                    tooLongName,
                    "Description",
                    10,
                    true,
                    'A',
                    1,
                    2,
                    new BigDecimal("19.99"),
                    testDate
            );
            fail("Une exception aurait dû être lancée pour un nom trop long");
        } catch (ProhibitedValueException e) {
            assertTrue(e.getMessage().contains("ne peut pas dépasser 60 caractères"));
        }
    }

    @Test
    public void testProductPriceInvalid() {
        try {
            Product invalidProduct = new Product(
                    (long)123456789,
                    "Produit test",
                    "Description",
                    10,
                    true,
                    'A',
                    1,
                    2,
                    new BigDecimal("0"),
                    testDate
            );
            fail("Une exception aurait dû être lancée pour un prix invalide");
        } catch (ProhibitedValueException e) {
            assertTrue(e.getMessage().contains("doit être supérieur à 0"));
        }
    }

    @Test
    public void testAlternativeConstructor() {
        try {
            Product productWithoutBarcode = new Product(
                    "Produit sans code-barre",
                    "Description",
                    10,
                    true,
                    'A',
                    1,
                    2,
                    new BigDecimal("29.99"),
                    testDate
            );
            assertNull(productWithoutBarcode.getBarcode());
            assertEquals("Produit sans code-barre", productWithoutBarcode.getName());
            assertEquals(new BigDecimal("29.99"), productWithoutBarcode.getExclVatPrice());
        } catch (ProhibitedValueException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
