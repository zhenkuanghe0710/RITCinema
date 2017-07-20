package ritcinema.datas;

import java.io.Serializable;
import java.sql.Time;

@SuppressWarnings("serial")
public class StaffData implements Serializable{

	private int ssn;
	private String staff_id;
	private String department;
	private Time working_time;
	private String position;
	
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Time getWorking_time() {
		return working_time;
	}
	public void setWorking_time(Time working_time) {
		this.working_time = working_time;
	}

	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
