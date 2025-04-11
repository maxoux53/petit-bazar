package dataAccess;

import model.Product;
import java.sql.*;
import java.util.ArrayList;

public class ProductDBAccess implements IProductDAO {
    private String sqlInstruction;
    private PreparedStatement preparedStatement;
    private ResultSet data;

    public void create(Product product) throws InsertionFailedException {

    }

    public void delete(Product product) throws DeleteFailedException {

    }

    public Product findByBarcode(int barcode) throws NotFoundException, DAORetrievalFailedException {
        sqlInstruction = "SELECT * FROM product WHERE barcode = ?;";

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, barcode);

            data = preparedStatement.executeQuery();

            if (data.next()) {
                String name;
                String description;
                int amount;
                boolean isAvailable;
                char vatType;
                int categoryId;
                int brandId;
                int supplierVatNumber;

                Product product = new Product(barcode);

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

                supplierVatNumber = data.getInt("supplier_vat_number");
                if (!data.wasNull()) {
                    product.setSupplierVatNumber(supplierVatNumber);
                }

                return product;
            } else {
                throw new NotFoundException("product", barcode, "There are no more rows."); // e.getMessage()
            }
        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException("Database query timed out!", e.getMessage());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException("SQL data access failed!", e.getMessage());
        }
    }

    public ArrayList<Product> findAll() throws DAORetrievalFailedException {
        sqlInstruction = "SELECT * FROM product;";

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            preparedStatement.executeQuery();

            ArrayList<Product> products = new ArrayList<>();

            Product product;
            int barcode;
            String name;
            String description;
            int amount;
            boolean isAvailable;
            char vatType;
            int categoryId;
            int brandId;
            int supplierVatNumber;

            while (data.next()) {
                product = new Product(data.getInt("barcode")); // what if barcode is null?

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

                supplierVatNumber = data.getInt("supplier_vat_number");
                if (!data.wasNull()) {
                    product.setSupplierVatNumber(supplierVatNumber);
                }

                products.add(product);
            }

            return products;
        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException("Database query timed out!", e.getMessage());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException("SQL data access failed!", e.getMessage());
        }
    }

    public void edit(Product product) throws UpdateFailedException {

    }
}
