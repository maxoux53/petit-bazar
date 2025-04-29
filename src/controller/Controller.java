package controller;

import java.time.DateTimeException;
import java.time.LocalDate;

public abstract class Controller {

    /*package-private*/ static LocalDate stringToDate(String stringDay, String stringMonth, String stringYear) throws WrongTypeException, ProhibitedValueException {
        int day;
        try {
            day = Integer.parseInt(stringDay);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeException("Jour");
        }

        int month;
        try {
            month = Integer.parseInt(stringMonth);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeException("Mois");
        }

        int year;
        try {
            year = Integer.parseInt(stringYear);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeException("Année");
        }

        try {
            return LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            throw new ProhibitedValueException("Date");
        }
    }
}
