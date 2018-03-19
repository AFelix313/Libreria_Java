package Entity;
public class User {

	private int Userld;
	private String Role;
	private String Username;
	private int Password;
	
	// Username, UserId, Role, Password
	public User(String username,int userld,String role, int password ) {
		
		
		this.setUserld(userld);
		this.setRole(role);
		this.setUsername(username);
		this.setPassword(password);
		
	}

	
	
	public User() {
		
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


	public int getPassword() {
		return Password;
	}


	public void setPassword(int password) {
		this.Password = password;
	}
	
	// METODI:
	
	public String toString() {
        return "Userld:" + this.Userld + ",, " + "Role:" + this.Role
                + "Username:" + this.Username + " " + "Password:"
                + this.Password ;
    }


	
	
	
}
