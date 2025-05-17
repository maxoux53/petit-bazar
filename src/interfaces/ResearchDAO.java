package interfaces;

import exceptions.DAORetrievalFailedException;
import exceptions.ProhibitedValueException;
import model.EmployeePlace;
import model.ProductInformation;
import model.PurchaseInformation;

import java.time.LocalDate;
import java.util.ArrayList;

public interface ResearchDAO {
    public ArrayList<PurchaseInformation> getPurchaseInformationByDate(LocalDate date) throws DAORetrievalFailedException;

    public ArrayList<EmployeePlace> getEmployeePlaceByEmployee(int employeeId) throws ProhibitedValueException, DAORetrievalFailedException;
    
    public ArrayList<ProductInformation> getProductInformationByBrand(int brandId) throws DAORetrievalFailedException;
}
