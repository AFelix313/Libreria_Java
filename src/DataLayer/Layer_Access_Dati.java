package DataLayer;

import java.util.ArrayList;

import Entity.*;


// Questa interfaccia permette di gestire i comandi:
// Questi comandi vengono IMPLEMENTATI dal modo particolare metodo per memorizzare i dati che di volta in volta
// viene utilizzato ese. XML o DB (JDBC):

// é bene che questi metodo siano implementati così dalla Classe GestioneDB:
// Perciè bene che COINCIDANO:

public interface Layer_Access_Dati {

	public User LoginUtente(String username, String password );
	
	
	public boolean insertNewUser(String username, String password, String role );
	
	public ArrayList <Book> avableBook(Book book);
	public void insertBook(String[] param, String[] value);
	public ArrayList <Book> searchBook(Book book);
	public ArrayList<Book> getBooks();
	public boolean delateBook(Book book, User user);
	
	public void newReservation(User u);
	public void delateReservatio(User u);
	public ArrayList<Reservation> getReservations();

	boolean insertBook(Book book, User user);

}
