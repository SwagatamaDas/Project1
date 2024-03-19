package com.client;
 
import com.exception.InvalidBookException;
import com.service.BookService;
import java.util.*;
 
public class UserInterface {
 
	public static void main(String[] args) throws InvalidBookException
	{
			Scanner s=new Scanner(System.in);
			BookService bs = new BookService();
			// The below code gets the details of books
			// Give input in the format as specified in the problem statement

			System.out.println("Enter the number of books");
			int num=s.nextInt();
			String b[]=new String[num];
			System.out.println("Enter the book details");
			s.nextLine();
			for(int i=0;i<num;i++)
			{
				b[i]=s.nextLine();
			}
		    // The below code passes the book details to the addBookList method in the BookService class
			boolean recordsAdded=bs.addBookList(b);
			if (recordsAdded)
				System.out.println("Valid book details are added successfully");
			else
				System.out.println("Failed to add records");
		    // The below code calls the retrievePublisherCount method in the BookService class	
			// It will display the count of books for a particular publisher's name
			System.out.println("Enter the publisher's name");
			String publisher=s.nextLine();
			int count=bs.retrievePublisherCount(publisher);
			System.out.println("There is "+count+" "+ publisher + " publisher book available");
	}
}