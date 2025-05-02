package dataAccess;

import model.Purchase;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PurchaseDBAccess extends DBAccess implements IPurchaseDAO {
    private static final String objectClassName;

    static {
        objectClassName = Purchase.class.getSimpleName().toLowerCase();
    }

    public ArrayList<Purchase> findAll() throws DAORetrievalFailedException {
        sqlInstruction = "SELECT * FROM purchase;";
        ArrayList<Purchase> purchases = new ArrayList<>();
        Purchase purchase;
        LocalDate date;
        int employeeId;
        int customerCardNumber;

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            data = preparedStatement.executeQuery();

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
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT.toString(), e.getMessage());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR.toString(), e.getMessage());
        }
    }
}
