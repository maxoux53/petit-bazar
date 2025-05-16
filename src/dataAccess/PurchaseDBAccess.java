package dataAccess;

import exceptions.DAORetrievalFailedException;
import interfaces.PurchaseDAO;
import model.Purchase;
import model.SalesInfo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PurchaseDBAccess extends DBAccess implements PurchaseDAO {
    private static final String objectClassName;

    static {
        objectClassName = Purchase.class.getSimpleName().toLowerCase();
    }

    public ArrayList<Purchase> getAll() throws DAORetrievalFailedException {
        sqlInstruction = "SELECT * FROM purchase;";
        ArrayList<Purchase> purchases = new ArrayList<>();
        Purchase purchase;
        LocalDate date;
        int employeeId;
        int customerCardNumber;

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            ResultSet data = preparedStatement.executeQuery();

            while (data.next()) {
                purchase = new Purchase(data.getLong("purchase_id"));

                date = data.getDate("date").toLocalDate();
                if (!data.wasNull()) {
                    purchase.setDate(date);
                }

                employeeId = data.getInt("employee_id");
                if (!data.wasNull()) {
                    purchase.setEmployeeId(employeeId);
                }

                customerCardNumber = data.getInt("customer_card_number");
                if (!data.wasNull()) {
                    purchase.setCustomerCardNumber(customerCardNumber);
                }

                purchases.add(purchase);
            }

            return purchases;
        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT, e.getMessage());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR, e.getMessage());
        }
    }

    public ArrayList<SalesInfo> salesRanking(String categoryLabel) throws DAORetrievalFailedException {
        sqlInstruction = "SELECT p.barcode, p.name, SUM(a.quantity) AS total_sales_volume FROM product p INNER JOIN order_line a ON a.product_barcode = p.barcode WHERE p.category_id = (SELECT id FROM category WHERE label = ?) GROUP BY p.barcode, p.name ORDER BY SUM(a.quantity) DESC;";
        ArrayList<SalesInfo> ranking = new ArrayList<>();

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            preparedStatement.setString(1, categoryLabel);
            ResultSet data = preparedStatement.executeQuery();

            while (data.next()) {
                ranking.add(new SalesInfo(
                        data.getLong("barcode"),
                        data.getString("name"),
                        data.getInt("total_sales_volume")
                ));
            }

            return ranking;
        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT, e.getMessage());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR, e.getMessage());
        }
    }
}
