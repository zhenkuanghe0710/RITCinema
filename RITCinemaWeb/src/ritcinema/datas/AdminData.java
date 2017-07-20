package ritcinema.datas;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AdminData implements Serializable{

	private String adminname;
	private String password;
	private int ssn;
	
	
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
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
