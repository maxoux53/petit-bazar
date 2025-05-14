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
                "AND purchase.date = ?;";
        
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
    
    
    
}
