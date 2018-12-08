package part03;

import java.util.Scanner;

public class LibrarySystem {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		String options[] = { "1. Create Borrower", "2. Display Borrower", "3. Borrow Book", "4. Return Book", "5. Quit"};
		Borrower b = null;
		boolean finished = false;
		Book[] library = addBooks();
		
		do {
			displayMenu(options);
			int choice = getUserChoice();
			switch(choice) {
			case 1	:	b = createBorrower();
						break;
			case 2	:	displayBorrower(b);
						break;
			case 3	:	if(!(b==null)) {
							Book bk = chooseBook(library);
							b.borrowBook(bk);
						}else {
							System.out.println("\nError: No Borrower on the system! Create a borrower first\n");
						}
						break;
			case 4	: 	returnBook(b);
						break;
			case 5	:	finished = true;
						break;
			default	:	System.out.println("Error - Invalid Choice");
			}
		}
		while( !finished );
		System.out.println("Goodbye!");
	}
	
	static void displayBorrower(Borrower b) {
		// Checks if b Object is null. If so, error message output
		if(!(b==null)) {
			System.out.println("\nLibrary Member Details");
			System.out.println("======================");
			
			System.out.println("\t"+b.getDetails()+"\n");
			
			System.out.println("Books on Loan");
			System.out.println("=============");
			System.out.println( "\t"+b.getAllBooks() );
			System.out.println();
		}else {
			System.out.println("\nERROR: No Borrower on the system! Create a borrower first\n");
		}
	}
	
	static void displayMenu(String data[]) {
		System.out.println("Main Menu");
		System.out.println("=========\n");
		
		for(String option: data) {
			System.out.println(option);
		}
		System.out.println();
	}

	static int getUserChoice() {
		System.out.print("Enter choice:");
		int choice = input.nextInt();
		input.nextLine();
		return choice;
	}
	
	static Borrower createBorrower() {	
		System.out.print("Enter Id:");
		String id = input.nextLine();
		System.out.print("Enter Name:");
		String name = input.nextLine();
		System.out.print("Enter Address:");
		String add = input.nextLine();
		System.out.println();
		Borrower b = new Borrower(id,name,add);
		return b;
	}
	
	static Book[] addBooks() {
		Book theBooks[] = new Book[2];
		theBooks[0] = new Book(23, "12-12-12", "The Cosmos", "Sagan");
		theBooks[1] = new Book(24, "45-12-14", "The Sky at Night", "Moore");
		return theBooks;
	}
	
	static Book chooseBook(Book[] data) {
		Book pick = null;
		boolean notValidOption = true;
		int choice;
		System.out.println("Book List");
		System.out.println("=========\n");
		
		// Do while asks user for book until a valid option is selected
		// Do while only terminates when the notValidOption variable is set to true
		do {
			for(int index=0;index<data.length;index++) {
				Book bk1 = data[index];
				System.out.println((index+1) +". "+ bk1);
			}
			System.out.println();
			choice = getUserChoice();

			// Validates that the option exists (i.e. >0 <= how many options exist)
			if(choice > 0 && choice <= data.length) {
				notValidOption = false;
			}else {
				System.out.println("\nERROR: Invalid option! Please pick again\n");
			}
				
		}while(notValidOption);

		pick = data[choice-1];
		return pick;
	}
	
	/**
	 * Method kicks off process of returning book. Asks user for a Book ID to return and outputs a message,
	 * informing the user if the process was successful 
	 * @param b takes in Borrower object
	 */
	static void returnBook(Borrower b) {
		System.out.println("ID for book to return?");
		int bookID = getUserChoice();
		boolean successful = b.returnBook(bookID);
		
		if(successful) {
			System.out.println("Book with ID: " + bookID + " successfully returned");
		}else {
			System.out.println(b.getName() + " has not borrowed book with ID: " + bookID);
		}
	}

}
