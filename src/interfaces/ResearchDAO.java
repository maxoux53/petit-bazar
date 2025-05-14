package interfaces;

import exceptions.DAORetrievalFailedException;
import exceptions.NotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;

public interface ResearchDAO {
    public ArrayList<Object[]> getPurchaseInformations(LocalDate date) throws DAORetrievalFailedException, NotFoundException;

    public ArrayList<Object> getEmployeePlace(int id) throws DAORetrievalFailedException, NotFoundException;
    
    public ArrayList<Object[]> getProductInformations(int brandId) throws DAORetrievalFailedException, NotFoundException;
}
