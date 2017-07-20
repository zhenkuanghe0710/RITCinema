package ritcinema.datas;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OfferingData implements Serializable{

	private String cinema_name;
	private String works_for;
	private int off_rate;
	
	public String getCinema_name() {
		return cinema_name;
	}
	public void setCinema_name(String cinema_name) {
		this.cinema_name = cinema_name;
	}
	public String getWorks_for() {
		return works_for;
	}
	public void setWorks_for(String works_for) {
		this.works_for = works_for;
	}
	public int getOff_rate() {
		return off_rate;
	}
	public void setOff_rate(int off_rate) {
		this.off_rate = off_rate;
	}
	
	

}
