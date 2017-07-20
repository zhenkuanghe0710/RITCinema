package ritcinema.datas;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PersonphoneData implements Serializable{
	
	private String phone;
	private int ssn;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
}
