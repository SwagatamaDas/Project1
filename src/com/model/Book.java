//DO NOT EDIT OR ADD ANY CODE HERE

package com.model;

import java.util.Date;

public class Book {

	private String bookId;
	private String bookName;
	private String bookAuthor;
	private double price;
	private String publisher;
	private Date dateOfPurchase;
	
	public Book() {
		super();
	}

	public Book(String bookId, String bookName, String bookAuthor, double price, String publisher,
			Date dateOfPurchase) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.price = price;
		this.publisher = publisher;
		this.dateOfPurchase = dateOfPurchase;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", price=" + price
				+ ", publisher=" + publisher + ", dateOfPurchase=" + dateOfPurchase + "]";
	}

	
	
}
