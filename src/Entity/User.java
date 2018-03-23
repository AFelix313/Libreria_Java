package Entity;
public class User {

	private int Userld;
	private String Role;
	private String Username;
	private String Password;
	
	// Username, UserId, Role, Password
	public User(String username, String password, String role  ) {
		
		
		//this.setUserld(userld);
		
		this.setUsername(username);
		this.setPassword(password);
		this.setRole(role);
	}

		public User() {
		
	}
	
		
	public User( int Userld, String username, String password, String role  ) {
			
			
			this.setUserld(Userld);
			
			this.setUsername(username);
			this.setPassword(password);
			this.setRole(role);
	}

	
	
	public int getUserld() {
		return Userld;
	}


	public void setUserld(int userld) {
		this.Userld = userld;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		this.Role = role;
	}
	

	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		this.Username = username;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		this.Password = password;
	}
	
	// METODI:
	
	public String toString() {
        return "Userld:" + this.Userld + ",, " + "Role:" + this.Role
                + "Username:" + this.Username + " " + "Password:"
                + this.Password ;
    }


	
	
	
}
