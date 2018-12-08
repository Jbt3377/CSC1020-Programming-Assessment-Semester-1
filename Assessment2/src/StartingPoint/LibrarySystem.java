package StartingPoint;

import java.util.Scanner;

public class LibrarySystem {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		String options[] = { "1. Create Borrower", "2. Display Borrower", "3. Borrow Book", "4. Quit"};
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
			case 3	:	Book bk = chooseBook(library);
						b.borrowBook(bk);
						break;
			case 4	:	finished = true;
						break;
			default	:	System.out.println("Error - Invalid Choice");
			}
		}
		while( !finished );
		System.out.println("Goodbye!");
	}
	
	static void displayBorrower(Borrower b) {
		System.out.println("\nLibrary Member Details");
		System.out.println("======================");
		
		System.out.println("\t"+b.getDetails()+"\n");
		
		System.out.println("Books on Loan");
		System.out.println("=============");
		System.out.println( "\t"+b.getAllBooks() );
		System.out.println();
	}
	
	static void displayMenu(String data[]) {
		System.out.println("Main Menu");
		System.out.println("=========\n");
		
		System.out.println(data[0]);
		System.out.println(data[1]);
		System.out.println(data[2]);
		System.out.println(data[3]);
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
		System.out.println("Book List");
		System.out.println("=========\n");
		
		for(int index=0;index<data.length;index++) {
			Book bk1 = data[index];
			System.out.println((index+1) +". "+ bk1);
		}
		System.out.println();
		int choice = getUserChoice();
		pick = data[choice-1];
		return pick;
	}
	
}
