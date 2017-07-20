package ritcinema.datas;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UsersData implements Serializable{

	private String username;
	private String password;
	private int ssn;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
	
}
