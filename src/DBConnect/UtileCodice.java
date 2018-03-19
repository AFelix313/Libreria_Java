package DBConnect;

import java.sql.SQLException;

public class UtileCodice {

	
	/*
	
	  // Create a Statement
      Statement stmt = conn.createStatement();
      
      String sql_create   = "CREATE TABLE T1(col1 int)";
      String sql_insert1  = "INSERT INTO T1 VALUES(110)";
      String sql_select   = "SELECT * FROM T1";
      String sql_drop     = "drop table T1";
      
      // Create a table
      stmt.execute(sql_create);
      
      // Insert a record
      int insert = stmt.executeUpdate(sql_insert1);
      System.out.println("Records updated: " + insert);
      
      // Select records
      ResultSet rs = stmt.executeQuery(sql_select);
      while(rs.next()) {
        rs.getInt(1);
        System.out.println("Value for getInt(int columnIndex): " + rs.getInt(1));
        
        System.out.println("Value for getInt(String columnLabel): " + rs.getString("col1")); 
      }
      
      // Drop the table
      stmt.execute(sql_drop);
	



   
	public static void main(String[] args) throws ClassNotFoundException {
		   
		//Connection conn = null;
		  
		
		
		ConnectDB_Main stat = new ConnectDB_Main(); // Creo la classe principale che contiene il main 
		GestioneDb g = new GestioneDb();            // Classe che gestisce i Metodi del DB
		Statement s;

		//static String USER = "tester";
		//static String PASSWORD = "firenze";
		
		
		
		try {
			
			
			// Creo la connessione con il DB:
			s = stat.connectDB(USER, PASSWORD);
			
			
			// Creo le 3 tabelle vuote:
			g.CreateTableBooks(s);
			g.CreateTableUsers(s);
			g.CreateTableReservations(s);
			
			
			// Passo ad inserirvi i dati all'interno delle tabelle:
			
			//g.populateTableBooks(s);
			
			//g.CreateTableBooks_Prova(s);
			//g.populateTableBooks(s);
			
			g.queryAllBooks(s);
			
			
			   if (s != null) {
		           System.out.println("Connessione realizzata!");
		       } else {
		           System.out.println("onnessione Fallita!");
		       }
			   
			   
			 s.close();
				
			   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Mi sono creato la classe connection che possiede il metodo 
		
	  }
	  */	
	
}
