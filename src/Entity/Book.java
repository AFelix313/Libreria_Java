package Entity;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;


public class Book implements Serializable {

	private static final long serialVersionUID = 6110690276685962829L;
	private int Bookld;
	private String Title;
	//private Book[] copie;
	private String author;
	private List<String> authors;
	private String PublishingHouse;
	private int quantity;
	
	public Book (int bookld, String title, String author,
			String publishingHouse, int quantity) {
		
		this.setBookld(bookld);
		this.setTitle(title);
		this.setAuthor(author);
		this.setPublishingHouse(publishingHouse);
		this.setQuantity(quantity);
	}
	
	

	public Book(String Title,String Author, String PublishingHouse) {
		
		this.Title = Title;
		this.author = Author;
		this.PublishingHouse = PublishingHouse;
	}
	
	
	public Book() {
		authors=new ArrayList<String>();
		
	}

	
	public boolean isAvable() {
		
		if (quantity >0)
			return true;
		return false;
	}
	

	public int getBookld() {
		return Bookld;
	}

	public void setBookld(int bookld) {
		this.Bookld = bookld;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		this.Title = title;
	}
	
	
	
	public String getAuthor() {
		return author;
	}

	public String getAuthor2() {
		String app="";
		for(int i = 0; i<authors.size();i++)
			app=app+authors.get(i)+" ";      // Così lascio lo spazio per concatenare le Stringhe
		                                       	
		return app;
	}
	
	public void setAuthor(String a) {
		authors.add(a);
	}

	public String getPublishingHouse() {
		return PublishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.PublishingHouse = publishingHouse;
	}

	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public void incQuantity() {
		quantity += 1;
	}
	// METODI:



	public String getPublischingHouse() {
		// TODO Auto-generated method stub
		return PublishingHouse;
	}
	
	
	
	
	
	
}
