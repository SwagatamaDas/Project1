package com.service;
 
import com.dao.BookDAO;
import com.exception.InvalidBookException;
import com.model.Book;
import com.util.ApplicationUtil;
 
import java.util.*;
 
public class BookService {
	public static List <Book> buildBookList(List <String> BookRecords) 
	{
		List <Book> bList = new ArrayList<Book>();
 
		// Write code	
		for (String bookRecord : BookRecords) {
            String[] bookDetails = bookRecord.split(":");
 
            // Extract individual details from the record
            String bookId = bookDetails[0];
            String bookName = bookDetails[1];
            String bookAuthor = bookDetails[2];
            double price = Double.parseDouble(bookDetails[3]);
            String publisher = bookDetails[4];
            java.util.Date dateOfPurchase = ApplicationUtil.stringToDateConverter(bookDetails[5]);
 
            // Create a Book object and add it to the list
            Book book = new Book(bookId, bookName, bookAuthor, price, publisher, dateOfPurchase);
            bList.add(book);
        }
 
        return bList;
    }
 
    public boolean addBookList(String[] books) throws InvalidBookException {
        // Extract valid book records
		List<String> validBookRecords = ApplicationUtil.extractDetails(books);
 
		// Build a list of Book objects
		List<Book> bookList = buildBookList(validBookRecords);
 
		// Insert validated records into the database
		BookDAO bookDAO = new BookDAO();
		return bookDAO.insertBookList(bookList) > 0;
    }
 
    public int retrievePublisherCount(String publisher) {
        // Retrieve book records from the database based on the publisher
        BookDAO bookDAO = new BookDAO();
        List<Book> bookList = bookDAO.retrieveBookList(publisher);
 
        // Return the count of records for the specified publisher
        return bookList.size();
	}
}