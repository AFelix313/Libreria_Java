package Entity;

// Rappresenta la prenotazione di un libro:

import java.util.Date;

public class Reservation {

	private int Id;
	private int Useldr;
	private int Bookld;
	private Date StartDate;
	private Date EndDate;
	
	
	
	public Reservation(int id, int useldr, int bookld, Date startDate, Date endDate) {
		
		this.Id = id;
	    this.Useldr = useldr;
		this.Bookld = bookld;
		this.StartDate = startDate;
		this.EndDate = endDate;
		
	}


	public Reservation() {
		
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		this.Id = id;
	}


	public int getUseldr() {
		return Useldr;
	}


	public void setUseldr(int useldr) {
		this.Useldr = useldr;
	}
	
	
	public int getBookld() {
		return Bookld;
	}


	public void setBookld(int bookld) {
		this.Bookld = bookld;
	}

	public Date getStartDate() {
		return StartDate;
	}


	public void setStartDate(Date startDate) {
		this.StartDate = startDate ;
	}
	
	

	public Date getEndDate( ) {
		return EndDate ;
	}


	public void setEndDate(Date endDate) {
		this.EndDate = endDate;
	}
	
	
	// Metodi: 
	
	
	
	
	
}
