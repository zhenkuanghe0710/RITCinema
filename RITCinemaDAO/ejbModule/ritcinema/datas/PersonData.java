package ritcinema.datas;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PersonData implements Serializable{
	
	private int ssn;
	private String person_name;
	private String email;
	
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
