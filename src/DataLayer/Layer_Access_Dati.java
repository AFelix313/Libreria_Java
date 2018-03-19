package DataLayer;

import java.util.ArrayList;

import Entity.*;


// Questa interfaccia permette di gestire i comandi:

public interface Layer_Access_Dati {

	public void Login(String username, String password );
	
	public ArrayList <Book> avableBook(Book book);
	public boolean insertBook(Book book, User user);
	public ArrayList <Book> searchBook(Book book);
	public ArrayList<Book> getBooks();
	public boolean delateBook(Book book, User user);
	
	public void newReservation(User u);
	public void delateReservatio(User u);
	public ArrayList<Reservation> getReservations();

}
