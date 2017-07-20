package ritcinema.datas;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OffersData implements Serializable{

	private String cinema_id;
	private String discount_id;
	
	public String getCinema_id() {
		return cinema_id;
	}
	public void setCinema_id(String cinema_id) {
		this.cinema_id = cinema_id;
	}
	public String getDiscount_id() {
		return discount_id;
	}
	public void setDiscount_id(String discount_id) {
		this.discount_id = discount_id;
	}

}
