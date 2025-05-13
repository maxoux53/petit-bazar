package dataAccess.customer;

import dataAccess.DBAccess;
import dataAccess.DBRetrievalFailure;
import dataAccess.SingletonConnection;
import exceptions.DAORetrievalFailedException;
import exceptions.NotFoundException;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDBAccess extends DBAccess implements ICustomerDAO {
    private static final String objectClassName;

    static {
        objectClassName = Customer.class.getSimpleName().toLowerCase();
    }

    public Customer getByLoyaltyCardNumber(int loyaltyCardNumber) throws NotFoundException, DAORetrievalFailedException {
        sqlInstruction = "SELECT * FROM customer WHERE loyalty_card_number = ?;";

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, loyaltyCardNumber);

            data = preparedStatement.executeQuery();

            if (data.next()) {
                return mapResultSetToCustomer(data);
            } else {
                throw new NotFoundException(objectClassName, (long)loyaltyCardNumber, DBRetrievalFailure.NO_ROW.toString());
            }

        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT.toString(), e.getMessage());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR.toString(), e.getMessage());
        }
    }

    public ArrayList<Customer> getAll() throws DAORetrievalFailedException {
        sqlInstruction = "SELECT * FROM customer;";

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            data = preparedStatement.executeQuery();

            ArrayList<Customer> customers = new ArrayList<>();

            while (data.next()) {
                customers.add(mapResultSetToCustomer(data));
            }

            return customers;

        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT.toString(), e.getMessage());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR.toString(), e.getMessage());
        }
    }

    public Customer mapResultSetToCustomer(ResultSet data) throws SQLException {
        Customer customer = new Customer(data.getInt("loyalty_card_number"));

        String firstName = data.getString("first_name");
        if (!data.wasNull()) customer.setFirstName(firstName);

        String lastName = data.getString("last_name");
        if (!data.wasNull()) customer.setLastName(lastName);

        Date birthDate = data.getDate("birth_date");
        if (!data.wasNull()) customer.setBirthDate(birthDate.toLocalDate());

        String email = data.getString("email");
        if (!data.wasNull()) customer.setEmail(email);

        int phone = data.getInt("phone");
        if (!data.wasNull()) customer.setPhone(phone);

        long vatNumber = data.getLong("vat_number");
        if (!data.wasNull()) customer.setVatNumber(vatNumber);

        int loyaltyPoints = data.getInt("loyalty_points");
        if (!data.wasNull()) customer.setLoyaltyPoints(loyaltyPoints);

        return customer;
    }
}
