package com.imdbcatalogo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private SimpleDateFormat dateFormat;

    public DateUtils() {
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.dateFormat.setLenient(false);
    }

    public Date parseDate(String dateStr) throws ParseException {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            throw new ParseException("Data não pode ser nula ou vazia", 0);
        }
        return dateFormat.parse(dateStr.trim());
    }

    public String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        return dateFormat.format(date);
    }
}