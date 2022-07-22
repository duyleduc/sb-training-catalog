package com.example.DemoSpringBoot.validationz;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTimeValidation {

    public static boolean isDatePast(final String date, final String dateFormat) {
        LocalDate localDate = LocalDate.now(ZoneId.systemDefault());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
        LocalDate inputDate = LocalDate.parse(date, dtf);

        return inputDate.isBefore(localDate);
    }

    public static boolean isDateToday(final String date, final String dateFormat) {
        LocalDate localDate = LocalDate.now(ZoneId.systemDefault());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
        LocalDate inputDate = LocalDate.parse(date, dtf);

        return inputDate.isEqual(localDate);
    }

    public static boolean isDateFuture(final String date, final String dateFormat) {
        LocalDate localDate = LocalDate.now(ZoneId.systemDefault());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
        LocalDate inputDate = LocalDate.parse(date, dtf);

        return inputDate.isAfter(localDate);
    }

    public static boolean isBeforeorNow(final Date date) {
        Calendar now = Calendar.getInstance();
        now.set(Calendar.HOUR_OF_DAY, 12);
        now.set(Calendar.MINUTE, 30);
        Calendar givenDate = Calendar.getInstance();
        givenDate.setTime(date);

        boolean isBefore = now.before(givenDate);
        

        return isBefore;
    }
}
