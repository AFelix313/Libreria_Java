package BusinessLayer;
import DataLayer.XML_Library;
import Entity.*;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class MAIN_Biblioteca {

		
		public static void main(String[] args) throws Exception  {
					
		
			
			System.out.println(" --- BENVENUTO IN BIBLIOTECA! ---");
			
			Scanner scanner = new Scanner(System.in);
			
			Menu_Library menu = new Menu_Library();
			
			
			int starter = menu.menuStarter();
			
			
			//menu.insertNewLibro();
			
			
			// Prove sul Menù : 
			
			switch(starter) {
			
			case 1: 
				menu.firstLogin();
				break;
			case 2:
				menu.login();
				break;
			case 3: 
				menu.exit();
				return;     // Interrompo il programma ed esco!
			default: 
				System.out.println("------------------\n");
				System.out.println("Scelta non ammissibile!"); 
				System.out.println("------------------\n");
				menu.menuStarter();
			}
			
			
			
	
			/*
			
			User user1 = new User("Andrea", 13,"Administrator",313 ); // Username, UserId, Role, Password
			//Book book1 = new Book(13, "Divina Commedia","Dante", "Einaudi", 2); // Bookld, Title, PublishingHouse,Quantity
			
			//Reservation reservation = new Reservation(13, 23, 332, 13/12/2001,13/12/2001);
			
			String[] v = {};
			v[0] = user1.getUsername();
			v[1] = String.valueOf(user1.getUserld());
			v[2] = user1.getRole();
			v[3] = String.valueOf(user1.getPassword());
			
			
			XML_Library a = new XML_Library(); // Inizializzo la Library
			
			//String pathFile = "C:\\Users\\andrea.felici\\Desktop\\Libreria.xml";
			
			Document d= a.createXML(); // Mi crea l'oggetto d che ha un reference a Document
			d = a.createXMLEmpty(d);
			
			//a.createXMLEmpty(d);
			//d= a.createXML();
			
			
			//a.createNewUser( user1); // Aggiunge un nuovo User 
			
			d = a.readXML();
			//a.createNewBook( d, book1); // Aggiunge un nuovo User 
			//a.createNewReservation( d, book1); // Aggiunge un nuovo User
			
			//a.createNewNode(user1);
			
			d = a.delateNode(user1);
			
			
			
			
			//a.createNewUser( d, user1);
			
			
			//int choise;
			// Document d;
			// Creo un ciclo While così da mantenere vera la condizione di funzionamento:
			//while(choise != 4);
			//int starterChoice= l.menuStarter();
			
			// Mi creo il FILE e lo leggo:
			//a.createXML(user1);
			//a.readXML();
			//a.createFileXML(a.readXML());
			
			
			
			
		   
	
		}
			 */			
		
		}			
}
