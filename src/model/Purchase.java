package model;

import java.time.LocalDate;

public class Purchase {
    private Long id;
    private LocalDate date;
    private Integer employeeId;
    private Integer customerCardNumber;

    public Purchase(Long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setCustomerCardNumber(Integer customerCardNumber) {
        this.customerCardNumber = customerCardNumber;
    }
}
