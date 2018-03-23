package Entity;
// Rappresenta l'intera Biblioteca ed è caratterizzato da :


import java.util.ArrayList;

import DBConnect.GestioneDb;
import DataLayer.Layer_Access_Dati;
import Entity.Book; // Per importare il package 



public class Library {

	 private ArrayList <Book> books;
	 private ArrayList <User> users;
	 private ArrayList <Reservation> prenotazioni;
	
	 
	 
	 public Layer_Access_Dati dati; // Non può essere istanziata perchè è un interfaccia!
	 
	 
	 
	 
	 public Library()
	   {
	      this.books = new ArrayList<Book>();
	      this.users = new ArrayList<User>();
	      this.prenotazioni = new ArrayList<Reservation>();
	      this.dati= new GestioneDb();     // Nel costruttore specifico il tipo di Gestione di Dati e lo istanzio!
	      
	   }
	
	 
	// Metodo Aggiungi Libro alla Biblioteca:
	 
	public void addBook(Book book) {
		books.add(book);
		
	}
	
	
	public boolean checkBook(int codice) {
		boolean trovato=false;
		for(int i = 0; i<books.size();i++) {
			if(codice == books.get(i).getBookld())
			{
				trovato = true;
				break;
			}	
		}
		return trovato;
		
	}


	// Questo metodo accede alla quantità di libri contenuti nella libreria e vi aggiunge un elemento:
	public void addBook2(int bookId) {
		
		for(int i = 0; i<books.size();i++) {
			if(bookId == books.get(i).getBookld())
			{
				books.get(i).setQuantity(books.get(i).getQuantity() + 1);  // Ho un array con un insieme di libri Books e get mi accede al
				                                                           // singolo libro contenuto
			}
		
		}
	
	}
	 
	// Metodo che permette di ottenere la lista dei titoli dei Libri:
	public String toTitolo() {
		
		String booksTitle = "";
		
		for(Book books:getBook()) {
			booksTitle += books.getTitle() + ","; 
		}
		
		return booksTitle;
	}
	
	
	public ArrayList <Book> getBook() {
		return books;
	}


	public void insertUser(String[] param, String[] value) {
		
		dati.insertBook(param, value);
	}

	public boolean insertNewUser (String username, String pass, String role) {
		
		return dati.insertNewUser(username,  pass, role);
		
	}
	

	public void insertBook(String[] param, String[] value) {
		
		dati.insertBook(param, value);
	}


    public User LoginUtente (String username, String password ) {
    	
    	
    	return dati.LoginUtente(username, password);
    
    }

}