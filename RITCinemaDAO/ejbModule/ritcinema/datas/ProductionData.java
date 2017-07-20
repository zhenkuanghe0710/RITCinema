package ritcinema.datas;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductionData implements Serializable{

	private String company_name;
	private String movie_name;
	
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	
	
}
