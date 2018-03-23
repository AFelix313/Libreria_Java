package DBConnect;

import java.math.BigDecimal;
import java.security.AccessControlException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import BusinessLayer.Menu_Library;
import DataLayer.Layer_Access_Dati;

import java.sql.SQLException;
import java.sql.Statement;

import Entity.Book;
import Entity.Reservation;
import Entity.User;

public class GestioneDb implements Layer_Access_Dati {

	
	static String USER = "tester";
	static String PASSWORD = "firenze";
	

	
	public Statement connectDB(String user, String password) throws SQLException, ClassNotFoundException
		{
	
	   String host =  "localhost";
	   int port = 1521;
	   String URL = "jdbc:oracle:thin:@ " + host + ":" + port + "/"  + "orcl";
	   Connection conn = DriverManager.getConnection( URL, user, password);
       Statement stat = conn.createStatement();
	   
       //System.out.println(" Connesso al DB");
       Class.forName("oracle.jdbc.driver.OracleDriver"); // Carico i driver class
       
	   	return stat;
		
		}
	
	
	public void queryDB_update(String query) throws ClassNotFoundException {
		

		ResultSet r = null;
		Statement s = null;
		DB_MAIN stat = new DB_MAIN();
		//LinkedList<HashMap<String, Object>> list = new LinkedList<HashMap<String, Object>>();
		
		
		try {
			s = connectDB(USER, PASSWORD);
			
			if (s != null) {
		          System.out.println("Connessione UPDATE realizzata!");
		       } else {
		           System.out.println("Connessione Fallita!");
		       }
			
			s.executeUpdate(query);
		
			//ResultSetMetaData md = r.getMetaData(); // Permette di ottenere il nome e il tipo delle colonne
			//int columns =md.getColumnCount();
			
			//ArrayList<Map<String, Object>> rows = new ArrayList<Map<String,Object>>();
		    //System.out.println(columns);
		
		    
			//System.out.println("-- --- --");
			//System.out.println("Query  riuscita!");
			//return list;
			
			//return true;
		
			}		 
			catch (SQLException e) {
				
				 e.printStackTrace();
				 System.out.println("Query non riuscita!");}
			     //return false;
			finally { 
				 try {
					 if (s != null) {s.close();}}
					 catch(SQLException e) {
		
						 e.printStackTrace();
					 }
				 }
		
	}
		
	
	    // Questo metodo prende in ingresso le Query fatte dai vari metodi e permette di gestire 
		// la connessione al DB, con i vari try/catch:
		public LinkedList<Map<String, Object>> queryDBLinked(String query) throws ClassNotFoundException {
			
			
			ResultSet r = null;
			Statement s = null;
			DB_MAIN stat = new DB_MAIN();
			LinkedList<Map<String, Object>> lista = new LinkedList<Map<String, Object>>();
			
			try {
				s = connectDB(USER, PASSWORD);
				
				if (s != null) {
			          System.out.println("Connessione DB realizzata!");
			       } else {
			           System.out.println("Connessione DB Fallita!");
			       }
				
				r = s.executeQuery(query);    // Restituisce un ResultSet
				
				lista = resultSetToList (r);  // Restituisce una lista
		
	             		
				}		 
				catch (SQLException e) {
					
					 e.printStackTrace();
					 System.out.println("Query non riuscita!");}
				
			
				finally { 
					 try {
						 if (s != null) {s.close();}}
						 catch(SQLException e) {
			
							 e.printStackTrace();
						 }
					 }
			
			return lista;
			
				 }
			
		 
	
	
	
	
	
	
	
		    
	// Questo metodo prende in ingresso le Query fatte dai vari metodi e permette di gestire 
	// la connessione al DB, con i vari try/catch:
	public LinkedList queryDB(String query) throws ClassNotFoundException {
		
		
		ResultSet r = null;
		Statement s = null;
		DB_MAIN stat = new DB_MAIN();
		LinkedList<HashMap<String, Object>> list = new LinkedList<HashMap<String, Object>>();
		
		try {
			s = connectDB(USER, PASSWORD);
			
			if (s != null) {
		          System.out.println("Connessione DB realizzata!");
		       } else {
		           System.out.println("Connessione DB Fallita!");
		       }
			
			r = s.executeQuery(query);
			
			/*  Ecco come convertire in Lista un ResultSet:
			1)Iterate over the ResultSet
			2)Create a new Object for each row, to store the fields you need
			3)Add this new object to ArrayList or Hashmap or whatever you fancy
			4)Close the ResultSet, Statement and the DB connection
			*/
			
			ResultSetMetaData md = r.getMetaData(); // Permette di ottenere il nome e il tipo delle colonne
			int columns =md.getColumnCount();
			
			//ArrayList<Map<String, Object>> rows = new ArrayList<Map<String,Object>>();
		    //System.out.println(columns);
			
			/*
			ArrayList<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		    while (r.next()){
		        Map<String, Object> row = new HashMap<String, Object>(columns);
		        for(int i = 1; i <= columns; ++i){
		            row.put(md.getColumnName(i), r.getObject(i));
		        }
		        rows.add(row);
		    }
		    return rows;
			*/
			
			HashMap<String, Object> row = new HashMap<String, Object>(columns);
			
			while (r.next()){
			     HashMap<String, Object> row1 = new HashMap<String, Object>(columns);
			     
			     for(int i=1; i<=columns; i++){           
			      row1.put(md.getColumnName(i), r.getObject(i));  // Crea una mappa dove nel primo campo inserisce il nome delle colonne
			                                                    // e nella seconda il suo valore
			     }
			     list.add(row1);
			  }
             
             
			
			//s.executeUpdate(query);
			
			
			System.out.println("-- LISTA QUERY_DB --");
			//System.out.println("Query  riuscita!");
			return list;
			
			
		
			
		
			}		 
			catch (SQLException e) {
				
				 e.printStackTrace();
				 System.out.println("Query non riuscita!");}
			
		
			finally { 
				 try {
					 if (s != null) {s.close();}}
					 catch(SQLException e) {
		
						 e.printStackTrace();
					 }
				 }
		
		return list;
		
			 }
	
	
	// ConnectDB_Main gdb = new ConnectDB_Main();
	
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
	public Statement insertNewBook(Book b,User u, Statement s) throws SQLException {
		
		
		if (u.getRole() != "Admin")
			throw new AccessControlException("Accesso negato!"); 
		
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
	
	

	

	
	
	
public void insert_Book( String[] param, String[] value, User u, Statement s ) throws SQLException  {
	/*
	 * Insert new book inside table BOOKS
	 * @return true / false
	 */
	
	if ( ! u.getRole().equals("Admin")) {
		throw new AccessControlException("Permission denided. You're not Admin!");
	}

	//LinkedList<Book> result = searchBook(param, value);
	
	
	// Dovrei fare un controllo sulla lista dei libri presenti per vedere se vi è già nella libreria!
	
	
	
		// Sempre devo inizializzare le Stringhe:
		String query_param = "";
		String query_value ="";
		for ( int i = 0; i < param.length ; i++ ) {
			//query_param += ( i == 0)? param[i] : " , " + param[i]; // Operatore Terziario
			if (i == 0) {
			query_param += param[i]  ;        
			query_value += "'" + value[i].toLowerCase() + "'";}
			else 
			{query_param += "," + param[i];
			query_value += ", '" + value[i].toLowerCase()+ "'";}
			}
		
		// Stampa i valori:
		System.out.println(query_param);
		System.out.println(query_value);
		
		String query_book = "INSERT INTO BOOKS (" + query_param +", QUANTITY_B) VALUES (" + query_value + ", 1)";
		
		System.out.println(query_book);
		
		s.executeQuery(query_book);
		
		
		System.out.println("Libro Inserito!");
		//Book b_found = result.getFirst();
		//String query_update = "UPDATE BOOKS SET QUANTITY = QUANTITY + 1 WHERE BOOK_ID = "+ b_found.getBookId();
		//boolean res_update = db_query_update( query_update );
	
	
	
	
	}






@Override
public ArrayList<Book> avableBook(Book book) {
	// TODO Auto-generated method stub
	return null;
}



// Metodo che salva le informazioni del ResulSet nella Mappa:
// Poi questo sarà utile per convertire tutti i riusltati delle QUERY che saranno salvati nella Map:
public LinkedList<Map<String,Object>> resultSetToList (ResultSet r){

LinkedList<Map<String,Object>> list = new LinkedList<Map<String,Object>>(); // Inizializzo la lista


try {
	
	
	while (r.next()){
		
		
			ResultSetMetaData md = r.getMetaData(); // Permette di ottenere il nome e il tipo delle colonne
			int columns =md.getColumnCount();
	     HashMap<String, Object> row = new HashMap<String, Object>();
	     
	     for(int i=1; i<=columns; i++){           
	      row.put(md.getColumnName(i), r.getObject(i));  // Crea una mappa dove nel primo campo inserisce il nome delle colonne
	                                                    // e nella seconda il suo valore
	     }
	     list.add(row);
	  }
    
}  catch (SQLException e) {
	System.out.println("ERRORE!");
	e.printStackTrace();
	
}
	return list;
	

}







/*
//
// METODO ESPERIMENTO:
//
*/

@Override
public void insertBook(String[] param, String[] value) {

	Statement s = null;

	try {
		s= connectDB(USER, PASSWORD);
		
		// Sempre devo inizializzare le Stringhe:
				String query_param = "";
				String query_value ="";
				for ( int i = 0; i < param.length ; i++ ) {
					//query_param += ( i == 0)? param[i] : " , " + param[i]; // Operatore Terziario
					if (i == 0) {
					query_param += param[i]  ;        
					query_value += "'" + value[i].toLowerCase() + "'";}
					else 
					{query_param += "," + param[i];
					query_value += ", '" + value[i].toLowerCase()+ "'";}
					}
				
				// Stampa i valori:
				//System.out.println(query_param);
				//System.out.println(query_value);
				
				String query_book = "INSERT INTO BOOKS (" + query_param +", QUANTITY_B) VALUES (" + query_value + ", 1)";
				
				//System.out.println(query_book);
				
				s.executeQuery(query_book);
				
				
				System.out.println("Il BOOK " +value[0]+" scritto da "+ value[1]+ " è STATO INSERITO NEL DB!");
				
				//System.out.println("Libro Inserito!");
				//Book b_found = result.getFirst();
				//String query_update = "UPDATE BOOKS SET QUANTITY = QUANTITY + 1 WHERE BOOK_ID = "+ b_found.getBookId();
				//boolean res_update = db_query_update( query_update );
			
			
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
}

@Override
public ArrayList<Book> searchBook(Book book) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ArrayList<Book> getBooks() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean delateBook(Book book, User user) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public void newReservation(User u) {
	// TODO Auto-generated method stub
	
}

@Override
public void delateReservatio(User u) {
	// TODO Auto-generated method stub
	
}

@Override
public ArrayList<Reservation> getReservations() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean insertBook(Book book, User user) {
	// TODO Auto-generated method stub
	return false;
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                        METODI OK:                                                              //
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


@Override
public User LoginUtente(String username, String password) {
	
LinkedList<Map<String, Object>> utente = new LinkedList<Map<String, Object>>();
	
	User userlogged = null;
	
	String  check_utente = " SELECT * FROM USERS WHERE USERNAME_U = '" + username + "' AND PASSWORD_U = '" + password + "'";  // Devi concatenare le stringhe
	
	try {
		 utente = queryDBLinked(check_utente); // Mi estrae l'utente presente
		 
         Map<String,Object> utente1 = utente.getFirst();
		 
		userlogged = makeUser(utente1);
		 
		 
		 // for ( )
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return userlogged;
}


public User makeUser( Map<String, Object> oggetto) {
	
	User user = null;
	
	int use_id = ((BigDecimal) oggetto.get("ID_U")).intValue();
	String username = (String)  oggetto.get("USERNAME_U");   // Utilizzo il cast
	String password = (String) oggetto.get("PASSWORD_U");
	String role     = (String) oggetto.get("ROLE_U");
	
	user = new User(use_id, username, password, role); 
	
	return user;
}

public Book makeBook( Map<String, Object> oggetto) {
		
	
	Book book = null;
	
	int use_id = ((BigDecimal) oggetto.get("ID_B")).intValue();
	String username = (String)  oggetto.get("TITLE_B");   // Utilizzo il cast
	String password = (String) oggetto.get("AUTHOR_B");
	String role     = (String) oggetto.get("PUBLISHINGHOUSE_B");
	int quantity = ((BigDecimal) oggetto.get("QUANTITY_B")).intValue();
	
	book = new Book(use_id,username, password, role, quantity ); 
	
	return book;
}



//Come faccio a sapere se  è un nuovo utente? 
//Faccio la query che controlla nel DB se vi è un utente presente con questi dati

@Override
public boolean insertNewUser(String username, String password, String role) {
	
	LinkedList<Map<String, Object>> control = new LinkedList<Map<String, Object>>();
	
	
	String  control_new_user = " SELECT * FROM USERS WHERE USERNAME_U = '" + username + "' AND PASSWORD_U = '" + password +
			"' AND ROLE_U = '" + role + "'";  // Devi concatenare le stringhe
	
	
	try {
		control = queryDBLinked(control_new_user);
		System.out.println (control);
		
		
		if (control.isEmpty()){
			
			String inserimento_user = " INSERT INTO USERS "
					+ "(USERNAME_U, PASSWORD_U, ROLE_U) VALUES" 
					 + "('"+ username + "','" + password + "','" + role + "')";
			
			queryDBLinked(inserimento_user);
			return true;
			
		} else {
			     System.out.println("ERRORE: Utente già presente!");
			     System.out.println(" --- --- --- ");

			}
		}  catch (ClassNotFoundException e) {
		
		e.printStackTrace();
		}
	return false;
	
}


//Metodo che inserisce un nuovo User dentro la tabella Users:
	public boolean insertNewUser(Statement s, User user) throws SQLException {
		
		String  control_user = " SELECT * FROM USERS WHERE USERNAME_U = '" + user.getUsername()+ "'";  // Devi concatenare le stringhe
		DB_MAIN stat = new DB_MAIN();                                                                                            // inserendo il +
		
		LinkedList<Map<String,Object>> controllo; 
		
		
		try {		
			controllo = queryDB(control_user);
			
			if (controllo.isEmpty()) // Se il risultato della query mi da come risultato una lista vuota allora l'utente è nuovo 
				                     // e lo posso aggiungere
			{
				String inserimento_user = " INSERT INTO USERS "
						+ "(USERNAME_U, PASSWORD_U, ROLE_U) VALUES" 
						 + "('"+ user.getUsername()+ "','" + user.getPassword() + "','" + user.getRole()+ "')";
				
					//s.executeUpdate(inserimento_user);
					queryDB_update(inserimento_user);
					//stat.queryDB(inserimento_user);
					System.out.println("Utente Inserito!");
					return true;
			
			} else {
				System.out.println("ATTENZIONE: Utente già presente!!!");
			   
			}}  catch (ClassNotFoundException e ) {
			
				e.printStackTrace();
			}
			return false;
		}


}