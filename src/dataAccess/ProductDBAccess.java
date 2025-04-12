package dataAccess;

import model.Product;
import java.sql.*;
import java.util.ArrayList;

public class ProductDBAccess implements IProductDAO {
    private String sqlInstruction;
    private PreparedStatement preparedStatement;
    private ResultSet data;

    public int create(Product product) throws InsertionFailedException, DAORetrievalFailedException {
        sqlInstruction = "INSERT INTO product (name, description, amount, is_available, vat_type, category_id, brand_id, supplier_vat_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setBoolean(4, product.getAvailable());
            preparedStatement.setString(5, String.valueOf(product.getVatType()));
            preparedStatement.setInt(6, product.getCategoryId());
            preparedStatement.setInt(7, product.getBrandId());
            preparedStatement.setInt(8, product.getSupplierVatNumber());

            try {
                return preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new InsertionFailedException("product", product.getBarcode(), e.getMessage());
            }
        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException("Database query timed out!", e.getMessage());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException("SQL data access failed!", e.getMessage());
        }
    }

    public void deleteByBarcode(int barcode) throws DeleteFailedException, DAORetrievalFailedException {
        sqlInstruction = "DELETE FROM product WHERE barcode = ?;";
        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, barcode);

            try {
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new DeleteFailedException("product", barcode, e.getMessage());
            }
        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException("Database query timed out!", e.getMessage());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException("SQL data access failed!", e.getMessage());
        }
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

    public int edit(Product product) throws UpdateFailedException, DAORetrievalFailedException {
        sqlInstruction = "UPDATE product SET name = ?, description = ?, amount = ?, is_available = ?, vat_type = ?, category_id = ?, brand_id = ?, supplier_vat_number = ? WHERE barcode = ?;";
        int barcode = product.getBarcode();

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setBoolean(4, product.getAvailable());
            preparedStatement.setString(5, String.valueOf(product.getVatType()));
            preparedStatement.setInt(6, product.getCategoryId());
            preparedStatement.setInt(7, product.getBrandId());
            preparedStatement.setInt(8, product.getSupplierVatNumber());
            preparedStatement.setInt(9, barcode);

            try {
                return preparedStatement.executeUpdate();
            } catch (SQLTimeoutException e) {
                throw new DAORetrievalFailedException("Database query timed out!", e.getMessage());
            } catch (SQLException e) {
                throw new UpdateFailedException("product", barcode, e.getMessage());
            }

        } catch (SQLException e) {
            throw new DAORetrievalFailedException("SQL data access failed!", e.getMessage());
        }
    }

    public void price(int barcode, double price, int discountPercentageIncluded) throws InsertionFailedException, DAORetrievalFailedException {
        sqlInstruction = "INSERT INTO price_history (excl_vat_price, discount, start_date) VALUES (?,?,CURRENT_DATE) WHERE product_barcode = ?;";

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            preparedStatement.setDouble(1, price);
            preparedStatement.setInt(2, discountPercentageIncluded);
            preparedStatement.setInt(3, barcode);


            try {
                preparedStatement.executeUpdate();
            } catch (SQLTimeoutException e) {
                throw new DAORetrievalFailedException("Database query timed out!", e.getMessage());
            } catch (SQLException e) {
                throw new InsertionFailedException("price", barcode, e.getMessage());
            }

        } catch (SQLException e) {
            throw new DAORetrievalFailedException("SQL data access failed!", e.getMessage());
        }
    }

}
