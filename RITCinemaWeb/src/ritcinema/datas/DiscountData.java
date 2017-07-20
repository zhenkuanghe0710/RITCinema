package ritcinema.datas;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DiscountData implements Serializable{

	private String discount_id;
	private String works_for;
	private int off_rate;
	
	public String getDiscount_id() {
		return discount_id;
	}
	public void setDiscount_id(String discount_id) {
		this.discount_id = discount_id;
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
