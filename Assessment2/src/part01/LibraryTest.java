package part01;

import java.util.ArrayList;

public class LibraryTest {

	public static void main(String[] args) {
		// Define bookShelf Array List
		ArrayList<Book> bookShelf = new ArrayList<Book>();
		
		// Create Example Book Objects and Add to bookShelf
		Book Book1 = new Book(1, "12-34-56", "Macbeth", "Shakespeare");
		bookShelf.add(Book1);
		Book Book2 = new Book(2, "56-78-56", "The Hobbit", "Tolkien");
		bookShelf.add(Book2);
		Book Book3 = new Book(3, "78-34-56", "Jaws", "Benchley");
		bookShelf.add(Book3);
		Book Book4 = new Book(4, "78-34-56", "Jaws", "Benchley");
		bookShelf.add(Book4);
		Book Book5 = new Book(5, "56-78-56", "The Hobbit", "Tolkien");
		bookShelf.add(Book5);

		// Test to see Example Books successfully added to bookShelf
		displayBooks(bookShelf);
		
		// Create test borrower object and let him borrow 2 books (1st Book and 3rd Book)
		Borrower newBorrower = new Borrower("101", "Josh", "Belfast");
		newBorrower.borrowBook(Book1);
		newBorrower.borrowBook(Book3);
		
		// Outputs all test borrower's books on loan using displayBooks method
		ArrayList<Book> borrowersBooks = newBorrower.getAllBooks();
		displayBooks(borrowersBooks);
		
		// Test 1 ISBN Search - Should be true
		String searchISBN = "12-34-56";
		checkIfBorrowedBook(searchISBN, newBorrower);
		
		// Test 2 ISBN Search - Should be false
		searchISBN = "56-78-56";
		checkIfBorrowedBook(searchISBN, newBorrower);
	}
	
	
	/**
	 * Method displays all book object details and availability state
	 * @param bookShelf takes an ArrayList of Book Objects to iterate through and display each book details
	 */
	public static void displayBooks(ArrayList<Book> bookShelf) {
		System.out.println("\nLibrary Books");
		System.out.println("=============");
		String isAvailable;
		
		for(Book eachBook: bookShelf) {
			if(eachBook.isAvailable()) {
				isAvailable = "Available";
			}else {
				isAvailable = "On Loan";
			}
			System.out.println("ID: " + eachBook.getId() + " ISBN: " + eachBook.getIsbn() +
					" Title: " + eachBook.getTitle() + " Author: " + eachBook.getAuthor() +
					" (" + isAvailable + ")\n");
		}
	}
	
	/**
	 * Method used to determine if a borrower has loaned a specific book
	 * @param searchISBN	Takes in string of ISBN code. Used to search for book on loan
	 * @param b				Takes in Borrower to search
	 */
	public static void checkIfBorrowedBook(String searchISBN, Borrower b) {
		boolean hasBookOnLoan = b.hasBook(searchISBN);
		if(hasBookOnLoan) {
			System.out.println("Library Member: " + b.getName() + " has borrowed book with ISBN: " + searchISBN);
		}else {
			System.out.println("Library Member: " + b.getName() + " has not borrowed book with ISBN: " + searchISBN);

		}
	}

}
