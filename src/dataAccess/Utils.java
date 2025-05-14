package dataAccess;

import model.Product;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utils {
    // Methods
    public static Product dataToProductObject(ResultSet data) throws SQLException {
        Product product;
        
        String name;
        String description;
        int amount;
        boolean isAvailable;
        char vatType;
        int categoryId;
        int brandId;
        BigDecimal exclVatPrice;
        Date startDate;
        
        product = new Product(data.getLong("barcode"));

        name = data.getString("name");
        if (!data.wasNull()) {
            product.setName(name);
        }

        description = data.getString("description");
        if (!data.wasNull()) {
            product.setDescription(description);
        }

        amount = data.getInt("amount");
        if (!data.wasNull()) {
            product.setAmount(amount);
        }

        isAvailable = data.getBoolean("is_available");
        if (!data.wasNull()) {
            product.setAvailable(isAvailable);
        }

        vatType = data.getString("vat_type").charAt(0);
        if (!data.wasNull()) {
            product.setVatType(vatType);
        }

        categoryId = data.getInt("category_id");
        if (!data.wasNull()) {
            product.setCategoryId(categoryId);
        }

        brandId = data.getInt("brand_id");
        if (!data.wasNull()) {
            product.setBrandId(brandId);
        }

        exclVatPrice = data.getBigDecimal("excl_vat_price");
        if (!data.wasNull()) {
            product.setExclVatPrice(exclVatPrice);
        }

        startDate = data.getDate("start_date");
        if (!data.wasNull()) {
            product.setStartDate(startDate.toLocalDate());
        }
        
        return product;
    }
}
