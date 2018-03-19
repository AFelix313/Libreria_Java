package BusinessLayer;

import java.io.File;
import java.util.Scanner;

// Per importare il package 
import Entity.*;

public class Menu_Library {

	
	// Restituisce in uscita l'oggetto User e per questo motivo mettò return
	// l'oggetto user appena creato:
	
	public User writeUsers() {
		
	
	User user = new User();
	Scanner scanner = new Scanner(System.in);
		
	System.out.print("Inserisci ID: ");
	int id = scanner.nextInt();		
	user.setUserld(id);
	
	
	System.out.print("Inserisci Role: ");
	String name = scanner.next();
	user.setUsername(name);
	
	System.out.print("Inserisci Username: ");
	String eta = scanner.next();
	user.setUsername(eta);
	
	System.out.print("Inserisci Password: ");
	int password = scanner.nextInt();
	user.setPassword(password);
	
	
	return user;
	
	}
	
	public void writeBooks() {
		
		
		Book book = new Book();
		Scanner scanner1 = new Scanner(System.in);
			
		
		System.out.print("BookId: ");
		int bookId = scanner1.nextInt();		
		book.setBookld(bookId);
		
		
		System.out.print("Inserisci autore: ");
		String titolo = scanner1.next();
		book.setTitle(titolo);
		
		System.out.print("Inserisci editore: ");
		String editore = scanner1.next();
		book.setPublishingHouse(editore);
		
		
		}
		
	
	public void Login() {
		
		Scanner scanner1 = new Scanner(System.in);
		
		String userld;
		String Password;
		String Username;
		
		System.out.println("LOGIN");
		System.out.println("Username:");
		
		Username = scanner1.next();
		
		System.out.println("Password:");
		
		Password = scanner1.next();
		
		if(Username.equals(Username) && Password.equals(Password)) 
		System.out.println("You are Login!");
	
		else if (Password.equals(Password)) {
			System.out.println("Invalid Password");
		} else {
			System.out.println("User name and Password");
		}
		
		
		
	}
	
	
	/*
	String path_xml = System.getProperty("user.dir");
	String name_file_xml = "Library.xml";
	String file_xml = path_xml + File.separator + name_file_xml;
	Scanner scanner;
	Library my_libr;
	private User logged_user;
	*/
	
	// Inizializzo lo scanner e la biblioteca:
	Scanner input = new Scanner (System.in);
	Library lazzerini=new Library();

	
	public int menuStarter() {
		
		int starterChoice;
		
		System.out.println("Welcome to Lazzerini! ");
		System.out.println("If a New User: select 1");
		System.out.println("Login: select 2");
		System.out.println("Exit: select 3");
		System.out.print("Choose what do you want to do:");
		
		starterChoice = input.nextInt();
	
		return starterChoice;
	}
	
	
	public int menuUser() {
		
		int userChoice;
		
		System.out.println("Hello User" + "Andrea");
		System.out.println("Create booking: select 1");
		System.out.println("Delete booking: select 2");
		System.out.println("Exit: select 3");
		System.out.print("Choose what do you want to do:");
		
		userChoice = input.nextInt();
	
		return userChoice;
	}
	
		
	
public int adminUser() {
		
		int adminChoice;
		
		System.out.println("Insert new book: select 1");
		System.out.println("Edit book: select 2");
		System.out.println("Delete book: select 3");
		System.out.println("Exit: select 4");
		System.out.print("Choose what do you want to do:");
		System.out.print("\n");
		
		adminChoice = input.nextInt();
	
		return adminChoice;
	}
	

	
	public void insertBook() {
		
		
		Book book = new Book();
		
		
		System.out.println("Inserisci BookId:");
		book.setBookld(input.nextInt());
		System.out.println(book.getBookld());
		if(lazzerini.checkBook(book.getBookld())==false) {
		
			System.out.println("Inserisci Title:");
			book.setTitle(input.next());
			System.out.println("Inserisci Casa di Pubblicazione:");
			book.setPublishingHouse(input.next());

			do {
				System.out.println("Inserisci Autore:");
				book.setAuthor(input.next());
				System.out.println("Ci sono altri autori (1 SI 2 NO):");	
			} while (input.nextInt()!=2);

			lazzerini.addBook(book);
		}	
		else 
		{ 
			lazzerini.addBook2(book.getBookld());
		}
		
	}
	


	public void login() {
		System.out.print("Username: ");
		String username = input.next().replace("\n", "");
		System.out.print("Password: ");
		String pass = input.next().replace("\n", "");
		
		// Faccio inserire nome e password, se vi sono presenti accedo altrimenti
		// da errore! 
		
		User user1 = new User();
		
		
		//User logged_in = my_libr.login(username, pass);
		//if ( logged_in!= null || logged_in instanceof User ) {
		//	System.out.println("Logged in! Welcome "+ logged_in.getUsername() + "!");
		//}else {
		//	System.out.println("Login failed! User of password incorrect.");
		//
		}


	public void firstLogin() {
		
		// Primo login con la creazione del nuovo utente!
		
		System.out.print("Username: ");
		String username = input.next().replace("\n", "");
		System.out.print("Password: ");
		String pass = input.next().replace("\n", "");
		System.out.print("userId: ");
		System.out.print("role: ");
	
		
	}


	public void exit() {
		
		System.out.println("\n");
		System.out.println("Have a Nice Day!");
		
	}
	
	

		
		/* COMANDI JACOPO:
		
		public command_line_view() {
			scanner = new Scanner( System.in );
			my_libr = new Library();
			my_libr.connectToData( file_xml );
			my_libr.loadData();
		}
		
		public void setCurrentUser( User u ) {
			logged_user = u;
		}
		
		public User getCurrentUser() {
			return logged_user;
		}
		
		public int command_choice_admin () {
			
			System.out.println("1) Insert new book");
			System.out.println("2) Edit book");
			System.out.println("3) Delete book");
			System.out.println("4) Create booking");
			System.out.println("5) Delete booking");
			System.out.println("6) Exit");
			System.out.print("Choose what you wanna do: ");
			int command_to_execute = scanner.nextInt();
			scanner.nextLine(); // To ignore newline after int choice
			return command_to_execute;
		}
		
		public int command_choice_user () {
			
			System.out.println("1) Create booking");
			System.out.println("2) Book restitution");
			System.out.println("3) Exit");
			System.out.print("Choose what you wanna do: ");
			int command_to_execute = scanner.nextInt();
			
			return command_to_execute;
		}
		public void login() {
			System.out.println("Insert data to log in");
			System.out.print("Username: ");
			String username = scanner.next().replace("\n", "");
			System.out.print("Password: ");
			String pass = scanner.next().replace("\n", "");
			
			User logged_in = my_libr.login(username, pass);
			if ( logged_in!= null || logged_in instanceof User ) {
				logged_user = logged_in;
				System.out.println("Logged in! Welcome "+ logged_user.getUsername() + "!");
				System.out.print("");
			}else {
				System.out.println("Login failed! User or password incorrect.");
				System.out.println("");
				System.out.println("  !--------------------------------------------!");
				System.out.println("");
				login();
			}
		}
		
		public void insertNewBook() {
			System.out.println("Create a new book!");
			String [] param = {"Title", "Author", "Publisher"};
			String [] value = new String[3];
			
			System.out.print("Insert book's title: ");
			value[0] = scanner.nextLine().replace("\n", "");
			while ( value[0]== null || value[0].isEmpty()) {	
				System.out.println("Book's title can not be empty!");
				System.out.print("Insert book's title: ");
				value[0] = scanner.nextLine().replace("\n", "");			
			}

			System.out.print("Insert book's author: ");
			value[1] = scanner.nextLine().replace("\n", "");
			while ( value[1]== null || value[1].isEmpty()) {	
				System.out.println("Book's author can not be empty!");
				System.out.print("Insert author's title: ");
				value[1] = scanner.nextLine().replace("\n", "");			
			}

			System.out.print("Insert book's publisher: ");
			value[2] = scanner.nextLine().replace("\n", "");
			while ( value[2]== null || value[2].isEmpty()) {	
				System.out.println("Book's publisher can not be empty!");
				System.out.print("Insert book's publisher: ");
				value[2] = scanner.nextLine().replace("\n", "");			
			}
			
			boolean result = my_libr.insertNewBook(param, value, logged_user);
			
			if ( result ) {
				System.out.println("New book '" + value[0] + "' by "+ value[1] +" saved!");
			} else {
				System.out.println("Ooops! Something goes wrong!");
			}
		}
		
		public void deleteBook() {
			
		}

		public static void main(String[] args) {

			command_line_view cmd_library = new command_line_view();
			int command = 0;
			boolean work = true;
			
			System.out.println("  !-- WELCOME TO LIBRARY CONSOLE APPLICATION --!");
			
			cmd_library.login();	// Login before all
			
			while ( work ) {
				if ( cmd_library.getCurrentUser().getRole().equals("Admin") ) {
						
						command = cmd_library.command_choice_admin ();			
						
						switch (command) {
						case 1: cmd_library.insertNewBook();
							break;
						case 6: work = false; 
							break;
						}
						
					}
				
				if ( cmd_library.getCurrentUser().getRole().equals("User") ) {
					
						command = cmd_library.command_choice_user ();			
						
						switch (command) {
						case 1: return;
							//break;
						case 3: work = false;
							break;
							
						}
				}
			}
			System.out.println("  !- LIBRARY CONSOLE APPLICATION LOGGING OUT -!");
		}

	}

	
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
