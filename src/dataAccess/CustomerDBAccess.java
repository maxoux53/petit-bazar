package dataAccess;

import exceptions.DAORetrievalFailedException;
import exceptions.NotFoundException;
import exceptions.ProhibitedValueException;
import interfaces.CustomerDAO;
import model.Customer;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDBAccess extends DBAccess implements CustomerDAO {
    private static final String objectClassName;

    static {
        objectClassName = Customer.class.getSimpleName().toLowerCase();
    }

    public Customer getByLoyaltyCardNumber(int loyaltyCardNumber) throws NotFoundException, DAORetrievalFailedException, ProhibitedValueException {
        sqlInstruction = "SELECT * FROM customer WHERE loyalty_card_number = ?;";
        
        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, loyaltyCardNumber);
            
            ResultSet data = preparedStatement.executeQuery();

            if (data.next()) {
                Customer customer = new Customer(
                        data.getInt("loyalty_card_number"),
                        data.getString("first_name"),
                        data.getString("last_name"),
                        data.getDate("birth_date").toLocalDate(),
                        data.getString("email"),
                        data.getInt("loyalty_points")
                );

                int phone = data.getInt("phone");
                if (!data.wasNull()) {
                    customer.setPhone(phone);
                }
                
                long vatNumber = data.getLong("vat_number");
                if (!data.wasNull()) {
                    customer.setVatNumber(vatNumber);
                }

                return customer;
            } else {
                throw new NotFoundException(objectClassName, loyaltyCardNumber, DBRetrievalFailure.NO_ROW);
            }
            
        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT, e.getMessage());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR, e.getMessage());
        }
    }

    public ArrayList<Customer> getAll() throws DAORetrievalFailedException, ProhibitedValueException {
        sqlInstruction = "SELECT * FROM customer;";
        
        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            
            ResultSet data = preparedStatement.executeQuery();
            
            ArrayList<Customer> customers = new ArrayList<>();
            Customer customer;
            int phone;
            long vatNumber;

            while (data.next()) {
                customer = new Customer(
                        data.getInt("loyalty_card_number"),
                        data.getString("first_name"),
                        data.getString("last_name"),
                        data.getDate("birth_date").toLocalDate(),
                        data.getString("email"),
                        data.getInt("loyalty_points")
                );

                phone = data.getInt("phone");
                if (!data.wasNull()) {
                    customer.setPhone(phone);
                }

                vatNumber = data.getLong("vat_number");
                if (!data.wasNull()) {
                    customer.setVatNumber(vatNumber);
                }
                
                customers.add(customer);
            }
            
            return customers;
        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT, e.getMessage());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR, e.getMessage());
        }
    }
}

