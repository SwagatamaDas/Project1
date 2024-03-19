package com.dao;
 
import java.util.ArrayList;
import java.util.List;
import com.model.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class BookDAO {
    private static Connection connection=null;
	public int insertBookList(List<Book> booklist) {
		int recordsInserted = 0;
 
        try {
            // Get the database connection
            connection = DBConnectionManager.getConnection();
 
            // SQL query to insert a book record in PostgreSQL
            String insertQuery = "INSERT INTO book (bookid, bookname, bookauthor, price, publisher, dateofpurchase) " +
                                 "VALUES (?, ?, ?, ?, ?, ?)";
 
            // Create a PreparedStatement
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Loop through the list of books and insert each record into the database
                for (Book book : booklist) {
                    preparedStatement.setString(1, book.getBookId());
                    preparedStatement.setString(2, book.getBookName());
                    preparedStatement.setString(3, book.getBookAuthor());
                    preparedStatement.setDouble(4, book.getPrice());
                    preparedStatement.setString(5, book.getPublisher());
                    preparedStatement.setDate(6, new java.sql.Date(book.getDateOfPurchase().getTime()));
 
                    // Execute the insert query
                    preparedStatement.executeUpdate();
 
                    // Increment the count of records inserted
                    recordsInserted++;
                }
            }
        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace();
        } finally {
            // Close the database connection
            DBConnectionManager.closeConnection(connection);
        }
 
        return recordsInserted;
	}
	public List<Book> retrieveBookList(String publisher) {
		List<Book> bookList = new ArrayList<>();
 
        try {
            // Get the database connection
            connection = DBConnectionManager.getConnection();
 
            // SQL query to retrieve book records based on publisher in PostgreSQL
            String retrieveQuery = "SELECT * FROM book WHERE publisher = ?";
 
            // Create a PreparedStatement
            try (PreparedStatement preparedStatement = connection.prepareStatement(retrieveQuery)) {
                preparedStatement.setString(1, publisher);
 
                // Execute the retrieve query
                ResultSet resultSet = preparedStatement.executeQuery();
 
                // Loop through the result set and create Book objects
                while (resultSet.next()) {
                    Book book = new Book(
                            resultSet.getString("bookid"),
                            resultSet.getString("bookname"),
                            resultSet.getString("bookauthor"),
                            resultSet.getDouble("price"),
                            resultSet.getString("publisher"),
                            resultSet.getDate("dateofpurchase")
                    );
                    bookList.add(book);
                }
            }
        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace();
        } finally {
            // Close the database connection
            DBConnectionManager.closeConnection(connection);
        }
 
        return bookList;
	}
}