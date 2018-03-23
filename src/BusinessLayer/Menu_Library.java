package BusinessLayer;

import java.io.File;
import java.util.Scanner;

// Per importare il package 
import Entity.*;

public class Menu_Library {

	
	// Restituisce in uscita l'oggetto User e per questo motivo mettò return
	// l'oggetto user appena creato:
	// Inizializzo lo scanner e la biblioteca:
	Library lib = new Library();
	Scanner input = new Scanner (System.in);
	Library lazzerini=new Library();
	
	// 
	
	
	/*
	 *  STRUTTURA APPLICATIVO BIBBLIOTECA:
	 * Nel MAIN_Biblioteca richiamo per mezzo dello Switch i diversi metodi di questo menù e provvedo una volta fatto l'inserimento a 
	 *  memorizzare i dati inseriti dall'utente all'interno dell'oggetto creato, o meglio in ingresso ai metodi della Library che implementa
	 *  quelli della interfaccia Layer_Access_Dati che a sua volta richiamano quelli della classe GestioneDB per accesso al DB (JDRC)
	 *
	 */
	

	// METODO OK: 
	public void insertNewLibro() {
		
		System.out.println("Creo un nuovo libro:");
		
		String [] param = {"TITLE_B", "AUTHOR_B", "PUBLISHINGHOUSE_B"};
		String [] value = new String[3];
		
		System.out.println("Inserisci il Titolo:");
		//String title = input.next();
		//value[0] = title;  // Assegno il valore al primo elemento della lista
		value[0] = input.nextLine().replace("\n", "");   // Comandi tutti in una medesima riga!
		
		//System.out.println(value[0]);
		
		while (value[0] == null || value[0].isEmpty())
		{
			System.out.println("Campo non può essere vuoto:");
			System.out.println("Inserisci il Titolo:");
			value[0] = input.nextLine().replace("\n", "");
		}
	
		
		System.out.println("Inserisci l'Autore:");
		value[1] = input.nextLine().replace("\n", "");
		while (value[1] == null || value[1].isEmpty())
		{
			System.out.println("Campo non può essere vuoto:");
			System.out.println("Inserisci l'Autore:");
			value[1] = input.nextLine().replace("\n", "");
		}
		
		System.out.println("Inserisci la Casa Editrice:");
		value[2] = input.nextLine().replace("\n", "");
		while (value[2] == null || value[2].isEmpty())
		{
			System.out.println("Campo non può essere vuoto:");
			System.out.println("Inserisci la Casa Editrice:");
			value[2] = input.nextLine().replace("\n", "");
		}
		
		// System.out.println(value[0]);
		// System.out.println(value[1]);
		
		System.out.println("Il Book " +value[0]+" scritto da "+ value[1]+ " è stato creato!");
		
		 lib.insertBook (param, value);
		
		// é un metodo che da si o no: 
		/*
		if (createBook) {System.out.println("Libro" +value[0]+ value[1]+ "creato!");}
		else {System.out.println("Libro NON creato!");}
		*/
		
	}
	
	
	

	
	
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
		
		System.out.println("--- MENU USER: ---");
		System.out.println("Create booking: select 1");
		System.out.println("Delete booking: select 2");
		System.out.println("Exit: select 3");
		System.out.print("Cosa desideri fare:");
		System.out.print("\n");
		
		userChoice = input.nextInt();
	
		
		switch(userChoice) {
		
		case 1: 
			insertNewLibro();
			break;
		case 2: 
			deleteBook();
			break;     // Interrompo il programma ed esco!
		case 3:
			exit();
			return userChoice;
		default: 
			System.out.println("------------------\n");
			System.out.println("Scelta non ammissibile!"); 
			System.out.println("------------------\n");
			menuStarter();
		}
		
		return userChoice;
	}
	
		
// Importanteeeeee:::	
public int menuAdmin() {
		
		int adminChoice;
		
		System.out.println("--- MENU ADMIN: ---");
		System.out.println("Insert new book: select 1");
		System.out.println("Edit book: select 2"); 
		System.out.println("Delete book: select 3");
		System.out.println("Exit: select 4");
		System.out.print("Choose what do you want to do:");
		System.out.print("\n");
		
		adminChoice = input.nextInt();
	
		switch(adminChoice) {
		
		case 1: 
			insertNewLibro();
			break;
		case 2:
			editBook();
			break;
		case 3: 
			deleteBook();
			break;     // Interrompo il programma ed esco!
		case 4:
			exit();
			return adminChoice;
		default: 
			System.out.println("------------------\n");
			System.out.println("Scelta non ammissibile!"); 
			System.out.println("------------------\n");
			menuStarter();
		}
		
	
		return adminChoice;
	}
	

	
	public void deleteBook() {


		// Elimina un Libro!
	
}




	public void editBook() {

		// Modifica un libro esistente!
	
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
		
		System.out.println("--- INSERISCI DATI LOGIN ---");
		System.out.print("Username: ");
		String username = input.next().replace("\n", "");
		System.out.print("Password: ");
		String pass = input.next().replace("\n", "");
		
		 
		
		User login = lib.LoginUtente(username, pass );
		
		
		
		
		
		
		if ( login != null ) {
			System.out.println("Logged in! Benvenuto " + login.getUsername() + ".");
			
			String loginRole = login.getRole();
			
			//System.out.println(loginRole);
			
			switch (loginRole) {
			
			case "Admin":
				menuAdmin();
				break;
			case "User":
				menuUser();
			default:
				throw new IllegalArgumentException("Ruolo Invalido!");
			}
			
		} else {
			System.out.println("Login fallito! ");
			menuStarter();
		}
			 
		
	}
	

	// Devo controllare che non abbia già un utente con le medesime credenziali registrato nella lista degli utenti!
	public User firstLogin() {
		
		// Primo login con la creazione del nuovo utente!
		
		
		System.out.print("Username: ");
		String username = input.next().replace("\n", "");
		System.out.print("Password: ");
		String pass = input.next().replace("\n", "");

		System.out.print("Role: ");
		String role = input.next().replace("\n", "");
		User user1 = new User(username, pass, role);
		System.out.println(role);
		
		
		if (user1.getRole().equals( "Admin"))      // Per confrontare due stringhe devo usare il metodo equals e non ==
		{ 
		
		// System.out.println("Nuovo Admin " + user1.getUsername() + " Memorizzato!");
		
		boolean controllo_admin =lib.insertNewUser (username, pass, role);
		
		if (controllo_admin == false ) 
		{
			System.out.println("USER "+  user1.getUsername() +" già presente!!!");
			System.out.println("---");
			firstLogin(); 
		}
		
		System.out.println("Nuovo Admin " + user1.getUsername() + " Memorizzato!");
		System.out.println("---");
		
		menuAdmin();
		
		} 
		else 
		{
		
		
		boolean controllo_utente =lib.insertNewUser (username, pass, role);
		
		if (controllo_utente == false ) 
		{
			System.out.println("USER "+  user1.getUsername() +" già presente!!!");
			System.out.println("---");
			firstLogin(); 
		}
		
		System.out.println("Nuovo Utente " + user1.getUsername() + " Memorizzato!");
		System.out.println("---");
		
		
		
		lib.insertNewUser(username, pass, role);
		menuUser();
		}
		
		return user1;
	}

	
	public void secondLogin(User u){
		
		
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
