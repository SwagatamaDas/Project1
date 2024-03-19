package com.util;
 
import com.exception.InvalidBookException;
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
 
public class ApplicationUtil {
	public static List<String> extractDetails(String[] books)
	{
		 List<String> bList = new ArrayList<>();
 
	        for (String book : books) {
	            try {
	                String[] bookDetails = book.split(":");
	                // Validate and filter based on bookId
	                if (validateBookId(bookDetails[0])) {
	                    bList.add(book);
	                }
	            } catch (InvalidBookException e) {
	                // Handle invalid book exception (optional)
	                System.err.println(e.getMessage());
	            }
	        }
 
	        return bList;
	    }
 
	    public static boolean validateBookId(String bookId) throws InvalidBookException {
	        boolean flag = false;
 
	        // Validation Criteria: Assume that the first four characters should be "BOOK" followed by / and four digits.
	        // Digits can take any value from 0 to 9. Otherwise, throw InvalidBookException.
 
	        if (bookId.matches("BOOK/\\d{4}")) {
	            flag = true;
	        } else {
	            throw new InvalidBookException("Invalid book ID format: " + bookId);
	        }
 
	        return flag;
	    }
 
	    public static java.util.Date stringToDateConverter(String date) {
	        try {
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            return dateFormat.parse(date);
	        } catch (ParseException e) {
	            // Handle parsing exception (optional)
	            e.printStackTrace();
	            return null;
	        }
	    }
 
	    public static java.sql.Date utilToSqlDateConverter(java.util.Date utDate) {
	        return new java.sql.Date(utDate.getTime());
	    }
 
	    public static java.util.Date sqlToUtilDateConverter(java.sql.Date sDate) {
	        return new java.util.Date(sDate.getTime());
	}
 
	
}