package modelPackage;

import java.time.LocalDate;

public class Purchase {
    private String id;
    private LocalDate date;
    private String idEmployee;
    private String idCustomer;

    // CONSTRUCTOR

    public Purchase() {}

    // GETTER

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public String getIdCustomer() {
        return idCustomer;
    }
}
