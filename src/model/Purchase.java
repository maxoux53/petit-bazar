package model;

import exceptions.ProhibitedValueException;

import java.time.LocalDate;

public class Purchase {
    private Long id;
    private LocalDate date;
    private Integer employeeId;
    private Integer customerCardNumber;

    public Purchase(Long id, LocalDate date, Integer employeeId, Integer customerCardNumber) throws ProhibitedValueException {
        this.id = id;
        setDate(date);
        this.employeeId = employeeId;
        this.customerCardNumber = customerCardNumber;
    }

    // Setters
    public void setDate(LocalDate date) throws ProhibitedValueException {
        if (date.isAfter(LocalDate.now())) {
            throw new ProhibitedValueException("La date d'achat ne peut pas être dans le futur");
        }

        this.date = date;
    }
}
