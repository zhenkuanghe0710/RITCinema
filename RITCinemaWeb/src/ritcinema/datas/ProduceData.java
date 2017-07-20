package ritcinema.datas;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProduceData implements Serializable{
	
	private String movie_id;
	private String company_id;
	
	public String getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}

	
}
