package DBConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Entity.Book;

public class GestioneDb {

	
	// Prova
	
	// Prova COMMIT 3
	
	// METODI CREA LE TABELLE:
	public void  CreateTableBooks(Statement s) throws SQLException {
			
		String newBook = "CREATE TABLE BOOKS ("
				+ "ID_B NUMBER  GENERATED ALWAYS as IDENTITY (START with 1 INCREMENT by 1) NOT NULL PRIMARY KEY,"
				+ "TITLE_B VARCHAR(255),"
				+ "AUTHOR_B VARCHAR(255),"
				+ "PUBLISHINGHOUSE_B VARCHAR(255)," 
				+ "QUANTITY_B NUMBER "
				+")";
		System.out.println("Tabella BOOKS Creata");
		s.execute(newBook);
	
	}
	
	public void  CreateTableUsers(Statement s) throws SQLException {
		
		String newUser = "CREATE TABLE USERS ("
				+ "ID_U NUMBER  GENERATED ALWAYS as IDENTITY (START with 1 INCREMENT by 1) NOT NULL PRIMARY KEY,"
				+ "USERNAME_U VARCHAR(255) NOT NULL,"
				+ "PASSWORD_U VARCHAR(255),"
				+ "ROLE_U VARCHAR(255)" 
				+")";
		System.out.println("Tabella USERS Creata");
		s.execute(newUser);
	
	}
		
	public void  CreateTableReservations(Statement s) throws SQLException {
			
			String newReservation = "CREATE TABLE RESERVATIONS ("
					+ "RESERV_ID_R NUMBER GENERATED ALWAYS as IDENTITY (START with 1 INCREMENT by 1) NOT NULL PRIMARY KEY,"
					+ "RESERV_ID_U NUMBER NOT NULL,"
					+ "RESERV_ID_B NUMBER NOT NULL,"
					+ "RESERV_START_DATE DATE," 
					+ "RESERV_END_DATE DATE,"
					+ "CONSTRAINT rv_Book FOREIGN KEY (RESERV_ID_B ) REFERENCES BOOKS(ID_B),"
					+ "CONSTRAINT rv_User FOREIGN KEY (RESERV_ID_U ) REFERENCES USERS(ID_U)"
					+")";
			System.out.println("Tabella RESERVATIONS Creata");
			s.execute(newReservation);
		
		}
	
	/*
	// METODI DI POPOLAMENTO:	
	*/
	
	// s.executeUpdate(sql) per aggiornare i records di alcune tabelle
	// s.executeQuery(sql) per  aggiungere i records di alcune tabelle
	
	// SELECT BOOK FROM ( "%" 'b.getID().toLowerCase()')
	
	public Statement populateTableBooks(Statement s) throws SQLException {
		
		// Non gli metto il campo ID_B perchè tanto lo genera sempre automaticamente!!!
		
		String BookInsert  = " INSERT INTO BOOKS "  
							  +	"( TITLE_B, AUTHOR_B, PUBLISHINGHOUSE_B, QUANTITY_B) VALUES "
							  + "('I tre Moschettieri', 'Dumas', 'Mondadori', 1)";
		

		// Inserisci nel Record:
		s.executeQuery(BookInsert);
		System.out.println("Inserted records into the table!");
		
		return s;
	}
	
	// PROVAAAA
	public String insertTableBook() {
		
		// Non gli metto il campo ID_B perchè tanto lo genera sempre automaticamente!!!
		
		String BookInsert  = " INSERT INTO BOOKS "  
							  +	"( TITLE_B, AUTHOR_B, PUBLISHINGHOUSE_B, QUANTITY_B) VALUES "
							  + "('Divina Commedia', 'Dante', 'Mondadori', 3)";
		

		// Inserisci nel Record:
		//s.executeQuery(BookInsert);
		System.out.println("Stinga nuovo BOOK!");
		
		return BookInsert;
	}
	
	// Inserisce il libro creato con l'oggetto:
	public Statement insertNewBook(Book b,Statement s) throws SQLException {
		
		
		String BookNew  = " INSERT INTO BOOKS "  
				  +	"( TITLE_B, AUTHOR_B, PUBLISHINGHOUSE_B, QUANTITY_B) VALUES "
				  + "('"+ b.getTitle()+ "','" + b.getAuthor() + "','" + b.getPublischingHouse()+ "', 1)";
		
		s.executeQuery(BookNew);
		System.out.println("Stinga nuovo BOOK!");
		
		return s;
	}
	
	

	// Ricerca un libro ben definito:
	public String searchBook(Statement s,Book b) throws SQLException {
		
		//String querySQL = "SELECT * FROM BOOKS_PROVA"; // Ricerca tutti i libri!
		// Mi ricerca i libri che hanno queste determinate caratteristiche e gli orsina per ID 
		// che è progressivamente crescente!
		String Bookresearch  = " SELECT * FROM BOOKS WHERE TITLE_B = '" + b.getTitle() + 
									"' AND AUTHOR_B = '" + b.getAuthor() + "' ORDER BY ID_B";  
				 
		
		System.out.println("Libri ricercati:");
		
		return Bookresearch;
	}
	
	

	// Ricerca un libro passato in ingrasso alla riga di ricerca:
	public void deletBook(Statement s,Book b) throws SQLException {
		
		
		// Elimino dalla Tabella il libro che passo in ingresso al metodo:
		String Bookresearch  = " DELETE FROM BOOKS WHERE TITLE_B = '" + b.getTitle() + 
									"' AND AUTHOR_B = '" + b.getAuthor() + "'";  
				 
		
		int x =s.executeUpdate(Bookresearch);  // Elimino i libri 
		
		if (x>0)
			System.out.println("Il libro " + b.getTitle() + " scritto da " + b.getAuthor() + " è stato eliminato!");
		else 
			System.out.println("ERRORE: nessun libro eliminato!");
	
	}
	
	
	
	public ResultSet stampBooks(Statement s, String Bookresearch) throws SQLException {
		
		//System.out.println("\n I BOOK dentro la Tabella BOOKS sono: ");
		//System.out.println("\n I BOOK ricercati sono: ");
		
		//String querySQL = "SELECT * FROM BOOKS_PROVA";
		
		ResultSet rs = s.executeQuery(Bookresearch);
		
		while(rs.next()) {
			
			// Ritrova il valore dal nome della colonna della tabella:
			int     id_b =rs.getInt("ID_B");
			String title  = rs.getString("TITLE_B");
			String author = rs.getString("AUTHOR_B");
			String publishinghouse = rs.getString("PUBLISHINGHOUSE_B");
			int quantity =rs.getInt("QUANTITY_B");
		
			// Mostro i risultati:
			System.out.println("\t:ID_BOOK: "  + id_b +
	        ", TITLE_B: " + title + ", AUTHOR_B: " + author +
	        ", PUBLISHINGHOUSE_B: " + publishinghouse +
	        ", QUANTITY_B: " + quantity);		
		
			/*
			// Mostra i valori in Maniera alternativa:
			 System.out.print("ID_BOOK: " + id_b);
	         System.out.print(", TITLE_B: " + title);
	         System.out.print(", AUTHOR_B: " + author);
	         System.out.println(", PUBLISHINGHOUSE_B: " + publishinghouse);
	         System.out.println(", QUANTITY_B: " + quantity);		
             */		
		}
		
		
		return rs;
	}
	
	
	

	
}
