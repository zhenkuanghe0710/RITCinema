package ritcinema.datas;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class ContractData implements Serializable{
	
	private String cinema_id;
	private String company_id;
	private Date contract_date;
	private int duration_time;
	
	public String getCinema_id() {
		return cinema_id;
	}
	public void setCinema_id(String cinema_id) {
		this.cinema_id = cinema_id;
	}
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public Date getContract_date() {
		return contract_date;
	}
	public void setContract_date(Date contract_date) {
		this.contract_date = contract_date;
	}
	public int getDuration_time() {
		return duration_time;
	}
	public void setDuration_time(int duration_time) {
		this.duration_time = duration_time;
	}
	
	

}
