package interfaces;

import exceptions.DAORetrievalFailedException;

import java.time.LocalDate;
import java.util.ArrayList;

public interface ResearchDAO {
    public ArrayList<Object[]> getPurchaseInformations(LocalDate date) throws DAORetrievalFailedException;

    public ArrayList<Object> getEmployeeLocation(int id) throws DAORetrievalFailedException;
}
