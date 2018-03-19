package DBConnect;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Entity.Book;



public class ConnectDB_Main {


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
	
	// Questo metodo prende in ingresso le Query fatte dai vari metodi e permette di gestire 
	// la connessione al DB, con i vari try/catch:
	public ResultSet queryDB(String query) throws ClassNotFoundException {
		
		
		ResultSet r = null;
		Statement s = null;
		ConnectDB_Main stat = new ConnectDB_Main();
		 
		try {
			s = stat.connectDB(USER, PASSWORD);
			
			if (s != null) {
		          System.out.println("Connessione realizzata!");
		       } else {
		           System.out.println("onnessione Fallita!");
		       }
			
			r = s.executeQuery(query);
			System.out.println("Query  riuscita!");
			}		 
			catch (SQLException e) {
				
				 e.printStackTrace();
				 System.out.println("Query non riuscita!");}
			 
			finally { 
				 try {
					 if (s != null) {s.close(); System.out.println("Connessione chiusa!");}}
					 catch(SQLException e) {
		
						 e.printStackTrace();
					 }
				 }
		return r;
			 }
		
	/*	   
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		   
				  
		ConnectDB_Main stat = new ConnectDB_Main(); // Creo la classe principale che contiene il main 
		GestioneDb g = new GestioneDb();            // Classe che gestisce i Metodi del DB
		
		
		//Book( String Title,String Author, String PublishingHouse)
		Book b = new Book("Siddharta","Hermann Hesse","Adelphi");
		
		String query = g.insertNewBook(b);
		
		//String query = g.insertTableBook();
		stat.queryDB(query);
		
		
		}		
     */

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
		           System.out.println("onnessione Fallita!");
		       }
			
			// Creo le 3 tabelle vuote:
			g.CreateTableBooks(s);
			g.CreateTableUsers(s);
			g.CreateTableReservations(s);
			
		
			// Passo ad inserirvi i dati all'interno delle tabelle:
			
			//g.populateTableBooks(s);
			
			//g.CreateTableBooks_Prova(s);
			//g.populateTableBooks(s);
			
			//Book( String Title,String Author, String PublishingHouse)
			Book b = new Book("Demian","Hermann Hesse","Adelphi");
			
			g.insertNewBook(b,s);                          // Inserisco un nuovo libro
			
			//String bookSearched =g.searchBook( s, b);      // 
			//g.stampBooks( s, bookSearched);
			 
			//g.deletBook(s,b);
			   
			s.close();
				
			   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Mi sono creato la classe connection che possiede il metodo 
		
	  }
		

}
	    
