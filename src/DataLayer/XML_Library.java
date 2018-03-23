package DataLayer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.w3c.dom.*;


import Entity.*;


public class XML_Library  {
	
	
	static String pathFile = "C:\\Users\\andrea.felici\\Desktop\\Libreria.xml";
	
	
	
	
public Document createNewNode(User user1) throws ParserConfigurationException, TransformerException, SAXException, IOException {
	
	//Element e = null; // Inizializzo l'oggetto 
	
	Document doc = null;
	
	String pathFile = "C:\\Users\\andrea.felici\\Desktop\\Libreria1.xml";
	
	// Carico un file XML:
	DocumentBuilderFactory xmlFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder xmlBuilder;
	
	xmlBuilder = xmlFactory.newDocumentBuilder();
	doc = xmlBuilder.parse( pathFile );
			
	/*
	DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	doc = docBuilder.parse(pathFile);
	*/
		        
	// Document doc = dBuilder.parse(xmlFile);
	// doc.getDocumentElement().normalize();
	        
	//Element library = doc.createElement("Library");
	//Element users = doc.createElement("Users");
			        
	//Element users = doc.createElement("Users");
	//Element books = doc.createElement("Books");
	//Element reservations = doc.createElement("Reservations");
			
	//library.appendChild(users);
			
	NodeList list = doc.getElementsByTagName( "Users" );
	
	Element elementoCapo = (Element) list.item(0); // Accedo al primo elemento della lista
			                                        // ve lo colloco, appendo
	Element el = doc.createElement("User");
			
	String[] v = new String[4]; // Inizializzo l'array
	v[0] = user1.getUsername();
	v[1] = user1.getRole();
	v[2] = String.valueOf(user1.getUserld());
	v[3] = String.valueOf(user1.getPassword());
			
			
	String[] s = new String[4];
	s[0] = "Username";
	s[1] = "Role";
	s[2] = "UserId";
	s[3] = "Password";
			
	for (int i = 0; i < v.length; i++  ) {
				
		el.setAttribute(s[i], v[i]);
				
		}
			
			
	elementoCapo.appendChild(el); // appendo user ad Users
			
	//library.appendChild(users);
			
	//library.appendChild(books);
	//library.appendChild(reservations);
			
	//users.appendChild(el);  // Appendo l'elemento el all'Users
			
			
	//doc.appendChild(library); 
			
			
	// create the xml file:
	TransformerFactory transformerFactory = TransformerFactory.newInstance();
	Transformer transformer = transformerFactory.newTransformer();
	//transform the DOM Object to an XML File:
	DOMSource source = new DOMSource(doc);
	StreamResult result = new StreamResult(new File(pathFile));


	transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	transformer.transform(source, result);
	System.out.println("XML file updated successfully");
			
			
	//transformer.transform(domSource, streamResult);

	System.out.println("Created newUser !");

			
					
					
	return doc;
			
		
	}
		
	
public Document delateNode(User user1) throws Exception {
	
	//Element e = null; // Inizializzo l'oggetto 
	
	Document doc = null;
	
	String pathFile = "C:\\Users\\andrea.felici\\Desktop\\Libreria1.xml";
	
	// Carico un file XML:
	DocumentBuilderFactory xmlFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder xmlBuilder;
	
	xmlBuilder = xmlFactory.newDocumentBuilder();
	doc = xmlBuilder.parse( pathFile );
			
	/*
	DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	doc = docBuilder.parse(pathFile);
	*/
		        
	// Document doc = dBuilder.parse(xmlFile);
	// doc.getDocumentElement().normalize();
	        
	//Element library = doc.createElement("Library");
	//Element users = doc.createElement("Users");
			        
	//Element users = doc.createElement("Users");
	//Element books = doc.createElement("Books");
	//Element reservations = doc.createElement("Reservations");
			
	//library.appendChild(users);
			
	NodeList list = doc.getElementsByTagName( "Users" );
	
	int b = list.getLength();
	
	Element element = (Element) doc.getElementsByTagName( "User" ).item(0); // Accedo al primo elemento della lista
			                                        // ve lo colloco, appendo
	element.getParentNode().removeChild(element);
	
	doc.normalize();
	
	System.out.println("Delate a User !");
	
	printXML(doc,pathFile);
	
	return doc;
	
	}
	
    public static final void printXML(Document doc, String parhFile) throws Exception{
    	
    //String pathFile = "C:\\Users\\andrea.felici\\Desktop\\Libreria1.xml";
    	
	// create the xml file:
	TransformerFactory transformerFactory = TransformerFactory.newInstance();
	Transformer transformer = transformerFactory.newTransformer();
	//transform the DOM Object to an XML File:
	DOMSource source = new DOMSource(doc);
	StreamResult result = new StreamResult(new File(pathFile));


	transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	transformer.transform(source, result);
	System.out.println("XML file updated successfully");
			
			
	//transformer.transform(domSource, streamResult);

	

			
					
					

			
		
	}





	
	
	
	
	public Document createXML() throws ParserConfigurationException {
	
	// Mi creo il File XML:	
	
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		
		
		
		return doc;	
	}
	
	
	public Document createXMLEmpty(Document doc) throws ParserConfigurationException, TransformerException {
		
	// Mi creo la struttura vuota del XML con gli elmenti Users, Books,Reservations:
		
		
		// Roots:
		Element library = doc.createElement("Library");
		
		Element users = doc.createElement("Users");
		Element books = doc.createElement("Books");
		Element reservations = doc.createElement("Reservations");
		
		
		// Nuovi elementi :
		Element user = doc.createElement("User"); 
		// Imposto l'attributo di user, impostando l'attributo:
		user.setAttribute("UserId", ""); // Accetta solo attributi
		                                                                 //e perciò uso il metodo di String
		user.setAttribute("Role", "");
		user.setAttribute("Username", "");
		user.setAttribute("Password", "");
		
		users.appendChild(user); // appendo user ad Users
		
		library.appendChild(users);
	
		
		Element book = doc.createElement("Book"); 
		book.setAttribute("BookId", ""); // Accetta solo attributi
        //e perciò uso il metodo di String
		book.setAttribute("Title", "");
		book.setAttribute("Author", "");
		book.setAttribute("Publisher", "");
		book.setAttribute("Quantity", "");
		
		books.appendChild(book);
		library.appendChild(books);
		
		
		Element reservation = doc.createElement("Reservation"); 
		reservation.setAttribute("BookId", "");
    
		reservation.setAttribute("Title", "");
		reservation.setAttribute("Author", "");
		reservation.setAttribute("Publisher", "");
		reservation.setAttribute("Quantity", "");
		
		reservations.appendChild(reservation);
		library.appendChild(reservations);
		
		doc.appendChild(library);  // Appendo al documento XML la Libreria
		
		
		/*
		// Nuovi elementi :
		Element book = doc.createElement("User"); 
		// Imposto l'attributo di user, impostando l'attributo:
		book.setAttribute("BookId", String.valueOf(utente.getUserld())); // Accetta solo attributi
				                                                                 //e perciò uso il metodo di String
		book.setAttribute("Title", String.valueOf(utente.getRole()));
		book.setAttribute("Publisher"", utente.getUsername());
		book.setAttribute("Quantity", String.valueOf(utente.getPassword()));
				
		users.appendChild(user); // appendo user ad Users
	
		// Vecchio codice:
		library.appendChild(users);     // Appendo alla libreria l'elemento Users          
		library.appendChild(books);
		library.appendChild(reservations);
		doc.appendChild(library);  // Appendo al documento XML la Libreria
		*/
		
			
		
		// create the xml file:
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		//transform the DOM Object to an XML File:
		DOMSource domSource = new DOMSource(doc);
		StreamResult streamResult = new StreamResult(new File(pathFile));


		transformer.transform(domSource, streamResult);

		System.out.println("Created XML-File empty !");

		//System.out.println(doc.getDocumentElement().getNodeName()); // Mi scrive il nome della radice del file XML
		
		//NodeList nodeList = doc.getElementsByTagName("User");
		//System.out.println(doc.getElementsByTagName("Users"));
		
		
		return doc;
	}
	
	
	public Document createNewUser(User user1) throws ParserConfigurationException, TransformerException, SAXException, IOException {
		
		//Element e = null; // Inizializzo l'oggetto 
		
		
		String pathFile = "C:\\Users\\andrea.felici\\Desktop\\Libreria1.xml";
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		
		
		
		/*
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		doc = docBuilder.parse(pathFile);
        */
        
        //Document doc = dBuilder.parse(xmlFile);
        //doc.getDocumentElement().normalize();
        
	
		Element library = doc.createElement("Library");
		Element users = doc.createElement("Users");
		
        
		//Element users = doc.createElement("Users");
		Element books = doc.createElement("Books");
		Element reservations = doc.createElement("Reservations");
		
		//library.appendChild(users);
		
		
		
		Element el = doc.createElement("User");
		
		String[] v = new String[4]; // Inizializzo l'array
		v[0] = user1.getUsername();
		v[1] = user1.getRole();
		v[2] = String.valueOf(user1.getUserld());
		v[3] = String.valueOf(user1.getPassword());
		
		
		String[] s = new String[4];
		s[0] = "Username";
		s[1] = "Role";
		s[2] = "UserId";
		s[3] = "Password";
		
		for (int i = 0; i < v.length; i++  ) {
			
			el.setAttribute(s[i], v[i]);
			
		}
		
		
		users.appendChild(el); // appendo user ad Users
		
		library.appendChild(users);
		
		library.appendChild(books);
		library.appendChild(reservations);
		
		users.appendChild(el);  // Appendo l'elemento el all'Users
		
		
		doc.appendChild(library); 
		
		
		// create the xml file:
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		//transform the DOM Object to an XML File:
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(pathFile));


		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
        System.out.println("XML file updated successfully");
		
		
		//transformer.transform(domSource, streamResult);

		System.out.println("Created newUser !");

		
				
				
		return doc;
		
	}
	

	public Document createNewUser(Document doc,User user1) throws ParserConfigurationException, TransformerException, SAXException, IOException {
		
		//Element e = null; // Inizializzo l'oggetto 
		
		
		String pathFile = "C:\\Users\\andrea.felici\\Desktop\\Libreria.xml";
		
		/* PARTE DEL METODO DA ZERO:
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		*/
		
		
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		//doc = docBuilder.parse(pathFile);
       
        
        //Document doc = dBuilder.parse(xmlFile);
        //doc.getDocumentElement().normalize();
        
	
		//Element library = doc.createElement("Library");
		
		
		
		//Element users = doc.createElement("Users");
		
		
        
        //Element users = doc.createElement("Users");
		
		//Element books = doc.createElement("Books");
		//Element reservations = doc.createElement("Reservations");
		
		//library.appendChild(users);
		
		
		
		Element el = doc.createElement("User");
		
		String[] v = new String[4]; // Inizializzo l'array
		v[0] = user1.getUsername();
		v[1] = user1.getRole();
		v[2] = String.valueOf(user1.getUserld());
		v[3] = String.valueOf(user1.getPassword());
		
		
		String[] s = new String[4];
		s[0] = "Username";
		s[1] = "Role";
		s[2] = "UserId";
		s[3] = "Password";
		
		for (int i = 0; i < v.length; i++  ) {
			
			el.setAttribute(s[i], v[i]);
			
		}
		
		
		//users.appendChild(el); // appendo user ad Users
		
		//library.appendChild(users);
		
		//doc.appendChild(library);	
		
		//library.appendChild(books);
		//library.appendChild(reservations);
		
		//users.appendChild(el);  // Appendo l'elemento el all'Users
		
		
		 
		
		
		// create the xml file:
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		//transform the DOM Object to an XML File:
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(pathFile));


		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
        System.out.println("XML file updated successfully");
		
		
		//transformer.transform(domSource, streamResult);

		System.out.println("Created newUser !");

		
				
				
		return doc;
		
	}
	
	
	
	
	
	public Document createNewBook(Document d,Book book) throws ParserConfigurationException {
		
		Element e = null; // Inizializzo l'oggetto 
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		Element library = doc.createElement("Library");
		
		Element users = doc.createElement("Users");
		Element books = doc.createElement("Books");
		Element reservations = doc.createElement("Reservations");
		
		library.appendChild(users);
		library.appendChild(books);
		library.appendChild(reservations);
		
		Element el = doc.createElement("User");
		
		// Bookld, Title, PublishingHouse,Quantity
		String[] b = new String[5]; // Inizializzo l'array
		b[0] = String.valueOf(book.getBookld());
		b[1] = book.getTitle();
		b[2] = book.getAuthor();
		b[3] = book.getPublishingHouse();
		b[4] = String.valueOf(book.getQuantity());
		
		
		String[] k = new String[4];
		k[0] = "Username";
		k[1] = "Role";
		k[2] = "UserId";
		k[3] = "Password";
		k[4] = "Quantity";
		
		for (int i = 0; i < b.length; i++  ) {
			
			el.setAttribute(b[i], k[i]);
			
		}
		//return el;
		users.appendChild(el);  // Appendo l'elemento el all'Users
		
		
		library.appendChild(users); 
		
		
		
		
		
		return doc;
	}
	
	
	

	
	

	public Element insertElement(Document d, String[] v) {
	
		// Mi creo un elemento e di tipo User
		Element el = d.createElement("User");
		
		for (int i = 0; i < v.length; i++  ) {
			
			el.setAttribute("Ciao ", v[i]);
		}
		return el;
		
	}
		
	
	
	
	public static void XML_Read() {
	
	}
	
	
	
	
	public Document readXML() throws SAXException, IOException, ParserConfigurationException {
		
		

		// Leggo un file XML presente nel Desktop:
		File file = new File(pathFile);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		
		return doc;
		
	}
	
	public NodeList flowXMLNode(Document doc)	{
		
		
		
		
		// Update attribute Value:
		upDateAttributeValue(doc);
		
		
		
		doc.getDocumentElement().normalize(); // 
		
		
		
		
		
		
		System.out.println("Root element:"  + doc.getDocumentElement().getNodeName() );
		
		NodeList nList = doc.getElementsByTagName("User");
		
		
		for(int i= 0; i<nList.getLength(); i++) {
			
			
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			
			System.out.println("\n Current Element :" + nNode.getNodeValue());
			
			//System.out.println("\n Users ID :" + eElement.getElementsByTagName("Role=").getTextContent());
			
			
;		}
		
		
		
		return nList;
		
	}
	
	
	
	public void upDateAttributeValue(Document doc) {
		
		NodeList users = doc.getElementsByTagName("Users");
		Element elem = null; // Gli oggetti vanno inizializzati SEMPRE!
		
		// Scorre su ciascun Users
		
	}


	
	


	public  void createXML(User utente) {
	
		
		
		
		
		
		try {

			
			
			DocumentBuilderFactory document_new = DocumentBuilderFactory.newInstance();

			DocumentBuilder documentBuilder = document_new.newDocumentBuilder();

			// Creo un Oggetto di tipo Document:
			
			Document document = documentBuilder.newDocument();
			
			//Document document =  documentBuilder.parse(new File("employees.xml"));
			
			

			Element library = document.createElement("Library");
			document.appendChild(library);
			
			Element users = document.createElement("Users");
			library.appendChild(users);
			
			Element user = document.createElement("User"); 
			
			// Imposto l'attributo di user, impostando l'attributo:
			user.setAttribute("UserId", String.valueOf(utente.getUserld())); // Accetta solo attributi
			                                                                 //e perciò uso il metodo di String
			user.setAttribute("Role", String.valueOf(utente.getRole()));
			user.setAttribute("Username", utente.getUsername());
			user.setAttribute("Password", String.valueOf(utente.getPassword()));
			
			users.appendChild(user); // appendo user
			
			
			Element books = document.createElement("Books");
			library.appendChild(books);
			Element book = document.createElement("User"); 
			book.setAttribute("BookId", String.valueOf(utente.getUserld()));
			books.appendChild(book);
			
			
			Element reservations = document.createElement("Reservations");
			library.appendChild(reservations);
			Element reservation = document.createElement("User"); 
			reservation.setAttribute("ReservationId", String.valueOf(utente.getUserld()));
			reservations.appendChild(reservation);
			
			
			
			
			// Decido io dove salvare il file XML:
			
			String xmlFilePath = "C:\\Users\\andrea.felici\\Desktop\\Libreria2.xml";
			
			// create the xml file:
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			//transform the DOM Object to an XML File:
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(xmlFilePath));

	
			transformer.transform(domSource, streamResult);

			System.out.println("Done creating XML File");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}

}

