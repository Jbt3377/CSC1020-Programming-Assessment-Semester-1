package part03;

import java.util.ArrayList;

public class Borrower {
	private String name;
	private String address;
	private String id;
	private ArrayList<Book> booksOnLoan;
	
	public Borrower(String id, String name, String address) {
		this.name = name;
		this.address = address;
		this.id = id;
		booksOnLoan = new ArrayList<Book>();
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getId() {
		return id;
	}
	
	public String getDetails() {
		String res = "";
		res+="ID:"+id+" Name:"+name+" Address:"+address;
		return res;
	}
	
	public boolean borrowBook(Book bk) {
		if ( bk != null && bk.isAvailable() ) {
			booksOnLoan.add(bk);
			bk.setAvailable(false);
			return true;
		}
		return false;
	}
	
	public ArrayList<Book> getAllBooks() {
		return booksOnLoan;
	}
	
	
	public boolean hasBook(String searchISBN) {
		boolean hasBookOnLoan = false;
		
		// Search booksOnLoan for book object with passed in ISBN code
		for(Book eachBook: booksOnLoan) {
			if(eachBook.getIsbn().equals(searchISBN)) {
				// If book with an ISBN code matching the searched for ISBN, found variable set to TRUE
				hasBookOnLoan = true;
			}
		}
		return hasBookOnLoan;
	}
	
	/**
	 * Method takes in a BookID and searches the Array List of books on loan of this borrower instance
	 * If a book with a matching ID is found, the index of the book in booksOnLoan is returned
	 * @param bookID is the ID of the Book being searched for
	 * @return returns the index of the book in booksOnLoan if its found. If not in booksOnLoan, -1 is returned
	 */
	private int locate(int bookID) {
		int indexOfBook = -1;
		
		for(int i=0; i<booksOnLoan.size(); i++) {
			Book eachBook = booksOnLoan.get(i);
			if(eachBook.getId() == bookID) {
				indexOfBook = i;
				return i;
			}
		}
		return indexOfBook;
		
	}
	
	/**
	 * Method returns book on loan by taking in a bookID, searching booksOnLoan array list for a book with that id,
	 * then removes it from the array list and finally changes the state of the Book's availability to avaiable
	 * @param bookId takes in the ID of the Book being returned
	 * @return returns true if return process was successful, false if no book could be found with the ID provided
	 */
	public boolean returnBook(int bookID) {
		
		// Gets the location of the Book in Books on Loan Array List
		int indexOfBookInBOL = locate(bookID);
		
		// Checks book exists in array list
		if(!(indexOfBookInBOL == -1)) {
			// If it exists, sets state of availability of the book object back to "Available"
			Book bookBeingReturned = booksOnLoan.get(indexOfBookInBOL);
			bookBeingReturned.setAvailable(true);
			// Remove Book from Books on Loan Array List
			booksOnLoan.remove(indexOfBookInBOL);
			// Confirms Process is Successful
			return true;
		}
		return false;
		
	}
	
}











