package ritcinema.datas;

import java.io.Serializable;
import java.sql.Time;

@SuppressWarnings("serial")
public class FullStaffData implements Serializable{

	private int salary;
	private String person_name;
	private String department;
	private Time working_time;
	private String position;
	
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
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

	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
