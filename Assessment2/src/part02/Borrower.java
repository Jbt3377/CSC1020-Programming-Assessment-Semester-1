package part02;

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
	
}
