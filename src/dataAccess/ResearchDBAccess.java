package dataAccess;

import exceptions.DAORetrievalFailedException;
import exceptions.NotFoundException;
import interfaces.ResearchDAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ResearchDBAccess extends DBAccess implements ResearchDAO {

    public ArrayList<Object[]> getPurchaseInformations(LocalDate date) throws DAORetrievalFailedException {
        sqlInstruction = "SELECT purchase.id ,customer.first_name, customer.last_name, employee.first_name, employee.last_name " +
                "FROM purchase " +
                "JOIN customer ON purchase.customer_card_number = customer.loyalty_card_number " +
                "JOIN employee ON purchase.employee_id = employee.id " +
                "WHERE purchase.date = ?;";
        
        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            preparedStatement.setDate(1, Date.valueOf(date));

            ResultSet data = preparedStatement.executeQuery();
            
            ArrayList<Object[]> purchaseInformations = new ArrayList<>();
            Object[] infoWrapper = new Object[5];
            
            while (data.next()) {
                infoWrapper[0] = data.getInt(1);
                for (int i = 1; i < 5; i++) {
                    infoWrapper[i] = data.getString(i + 1);
                } 
                purchaseInformations.add(infoWrapper.clone());
            }
            
            if (purchaseInformations.isEmpty()) {
                //throw new NotFoundException(DBRetrievalFailure.NO_ROW, Long.valueOf(date.toString(), ));
            }
            
            return purchaseInformations;
            
        } catch (SQLTimeoutException exception) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT, exception.getMessage());
        } catch (SQLException exception) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR, exception.getMessage());
        }
    }
    
    
    public ArrayList<Object> getEmployeeLocation(int id) throws DAORetrievalFailedException{
        sqlInstruction = "SELECT employee.first_name, employee.last_name, city.name, city.zip_code, country.name " +
                "FROM employee " +
                "JOIN city ON employee.city_name = city.name AND employee.city_zip_code = city.zip_code " +
                "JOIN country ON city.country = country.name " +
                "WHERE employee.id = ?;";

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, id);

            ResultSet data = preparedStatement.executeQuery();

            ArrayList<Object> employeeInformations = new ArrayList<>();

            if (data.next()) {
                employeeInformations.add(data.getString(1));
                employeeInformations.add(data.getString(2));
                employeeInformations.add(data.getString(3));
                employeeInformations.add(data.getInt(4));
                employeeInformations.add(data.getString(5));
            }

            if (employeeInformations.isEmpty()) {
                //throw new NotFoundException(DBRetrievalFailure.NO_ROW, Long.valueOf(date.toString(), ));
            }

            return employeeInformations;

        } catch (SQLTimeoutException exception) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT, exception.getMessage());
        } catch (SQLException exception) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR, exception.getMessage());
        }
    }
    
    
}
