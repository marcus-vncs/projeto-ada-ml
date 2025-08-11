package com.imdbcatalogo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private SimpleDateFormat dateFormat;

    public DateUtils() {
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }

    public Date parseDate(String dateStr) throws ParseException {
        return dateFormat.parse(dateStr);
    }

    public String formatDate(Date date) {
        return dateFormat.format(date);
    }
}