package DBConnect;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import Entity.Book;
import Entity.User;



public class DB_MAIN {

	static String USER = "tester";
	static String PASSWORD = "firenze";
	
	GestioneDb b = new GestioneDb();
	
		
	 
	// MAIN EVOLUTO:
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		   
				  
		//ConnectDB_Main stat = new ConnectDB_Main(); // Creo la classe principale che contiene il main 
		GestioneDb g = new GestioneDb();            // Classe che gestisce i Metodi del DB
		Statement s = null;
		
		//Book( String Title,String Author, String PublishingHouse)
		Book b = new Book("Siddharta_1","Hermann Hesse","Adelphi");
		
		User u = new User("Andrea","33", "Admin");
		
		
		
		// g.populateTableBooks(s); OK
		//g.insertNewBook( b,u, s); OK
		
		
		/*
		//LIBRO INSERITO CORRETTO:
		s = stat.connectDB(USER, PASSWORD);
		String [] param = {"TITLE_B", "AUTHOR_B", "PUBLISHINGHOUSE_B"};
		String [] value = {"Eineide_1","Virgilio","Mondadori"};
		g.insert_Book(param, value, u,  s ); 
		*/
		
		
		//System.out.println(parr.length);
		
		//g.insertNewUser(s, u12);
		
		//String query = g.insertNewBook(b);
		//String query = g.insertTableBook();
		//stat.queryDB(query);
		
		
		}		
     
    
	
	/*
    // MAIN SEMPLICE:
	public static void main(String[] args) throws ClassNotFoundException {
		   
		//Connection conn = null;
		  
		
		
		ConnectDB_Main stat = new ConnectDB_Main(); // Creo la classe principale che contiene il main 
		GestioneDb g = new GestioneDb();            // Classe che gestisce i Metodi del DB
		Statement s;
		
		try {
			
			
			// Creo la connessione con il DB:
			s = stat.connectDB(USER, PASSWORD);
			
			 if (s != null) {
		           System.out.println("Connessione realizzata!");
		       } else {
		           System.out.println("Connessione Fallita!");
		       }
			
			// Creo le 3 tabelle vuote:
			//g.CreateTableBooks(s);
			//g.CreateTableUsers(s);
			//g.CreateTableReservations(s);
			
		
			// Passo ad inserirvi i dati all'interno delle tabelle:
			
			//g.populateTableBooks(s);
			
			//g.CreateTableBooks_Prova(s);
			//g.populateTableBooks(s);
			
			//Book( String Title,String Author, String PublishingHouse)
			//Book b = new Book("Demian","Hermann Hesse","Adelphi");
			
			// Username,Password, Role:  
			User u = new User("Felix","313", "Admin");
			
			g.insertNewUser(s, u);
			
			//g.insertNewBook(b,s);                          // Inserisco un nuovo libro
			
			//String bookSearched =g.searchBook( s, b);      // 
			//g.stampBooks( s, bookSearched);
			 
			//g.deletBook(s,b);
			   
			s.close();
				
			   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Mi sono creato la classe connection che possiede il metodo 
		
	  }
	
	*/

}
	    
