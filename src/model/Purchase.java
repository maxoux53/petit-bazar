package model;

import java.time.LocalDate;

public class Purchase {
    private Integer id;
    private LocalDate date;
    private Integer employeeId;
    private Integer customerCardNumber;

    public Purchase(Integer id, LocalDate date, Integer employeeId, Integer customerCardNumber) {
        this.id = id;
        this.date = date;
        this.employeeId = employeeId;
        this.customerCardNumber = customerCardNumber;
    }
}
