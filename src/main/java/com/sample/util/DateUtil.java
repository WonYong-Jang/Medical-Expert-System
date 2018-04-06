package com.sample.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * 날짜 타입 변환 유틸
 */
public class DateUtil {

   
    private static final String DATE_PATTERN = "yyyy.MM.dd";
    
   
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern(DATE_PATTERN);

    
    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }
    
    /**
     * 
     */
    public static String getNowDateTime() {
    	LocalDateTime now = LocalDateTime.now();
    	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
    	return now.format(dateTimeFormatter); 
    }
    /**
     * 
     */
    public static String getNowDate() {
    	LocalDateTime now = LocalDateTime.now();
    	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd ss");
    	return now.format(dateTimeFormatter); 
    }
    
    /**
    
     *
     */
    public static LocalDate parse(String dateString) {
        try {
        	LocalDate localdate = LocalDate.parse(dateString, DATE_FORMATTER);
        	return localdate;
           // return DATE_FORMATTER.parse(dateString,LocalDate.);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     *
     * @param dateString
     * @return true if the String is a valid date
     */
    public static boolean validDate(String dateString) {
        // Try to parse the String.
        return DateUtil.parse(dateString) != null;
    }
}