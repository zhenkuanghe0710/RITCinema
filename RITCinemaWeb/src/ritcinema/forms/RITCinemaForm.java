package ritcinema.forms;
 
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.apache.struts.action.ActionForm;

import ritcinema.datas.AdminData;
import ritcinema.datas.BooksData;
import ritcinema.datas.BuyData;
import ritcinema.datas.CinemaData;
import ritcinema.datas.CompanyData;
import ritcinema.datas.ContractData;
import ritcinema.datas.DiscountData;
import ritcinema.datas.EmployeeData;
import ritcinema.datas.FoodData;
import ritcinema.datas.FullContractData;
import ritcinema.datas.FullShowsData;
import ritcinema.datas.FullStaffData;
import ritcinema.datas.MailData;
import ritcinema.datas.Movie_infoData;
import ritcinema.datas.OfferingData;
import ritcinema.datas.OffersData;
import ritcinema.datas.PersonData;
import ritcinema.datas.PersonphoneData;
import ritcinema.datas.ProduceData;
import ritcinema.datas.ProductionData;
import ritcinema.datas.ShowsData;
import ritcinema.datas.StaffData;
import ritcinema.datas.UsersData;

@SuppressWarnings("serial")
public class RITCinemaForm extends ActionForm{

	//Administration
	private String adminname;
	//private String password;
	//private int ssn;
	private List<AdminData> adminList;
	
	//Books
	private String ticket_id;
	private int seatnumber;
	//private String show_id;
	//private String username;
	//private String discount_id;
	private List<BooksData> booksList;
	
	//Buy
	private String order_id;
	//private String username;
	//private String food_id;
	private Date delivery_date;
	private int quantity;
	private int total_price;
	private List<BuyData> buyList;
	
	//Cinema
	private String cinema_id;
	private String cinema_name;
	private String address_street;
	private String address_city;
	private String address_state;
	private List<CinemaData> cinemaList;
	
	//Company
	private String company_id;
	private String company_name;
	private Date establish_date;
	private String country;
	private List<CompanyData> companyList;
	
	//Contract
	//private String cinema_id;
	//private String company_id;
	private String contract_date;
	private int duration_time;
	private List<ContractData> contractList;
	
	//Discount
	private String discount_id;
	private String works_for;
	private String off_rate;
	private List<DiscountData> discountList;
	
	//Employee
	private String emp_id;
	private int salary;
	//private int ssn;
	private List<EmployeeData> employeeList;
	
	//Food
	private String food_id;
	private String food_name;
	private float price;
	private String type;
	private String description;
	private List<FoodData> foodList;
	
	//Mail
	private String contact_date;
	//private String username;
	//private String adminname;
	private String mail_id;
	private String subject;
	private String content;
	private List<MailData> mailList;
	
	//Movie_info
	private String movie_id;
	private String movie_name;
	private String actor;
	private List<Movie_infoData> movieList;
	
	//Offers
	//private String cinema_id;
	//private String discount_id;
	private List<OffersData> offersList;
	
	//Person
	private int ssn;
	private String person_name;
	private String email;
	private List<PersonData> personList;
	
	//Personphone
	private String phone;
	//private int ssn;
	private List<PersonphoneData> personphoneList;
	
	//Produce
	//private String movie_id;
	//private String company_id;
	private List<ProduceData> produceList;
	
	//Shows
	private String show_id;
	//private String movie_id;
	//private String cinema_id;
	private int screen;
	private int seats;
	private Date show_date;
	private Time show_time;
	private List<ShowsData> showsList;
	private List<FullShowsData> fullshowsList;
	
	//Staff
	//private int ssn;
	private String staff_id;
	private String department;
	private Time working_time;
	private String position;
	private List<StaffData> staffList;
	
	//Users
	private String username;
	private String password;
	//private int ssn;
	private List<UsersData> usersList;
	
	//Overall
	private String result;
	
	//View
	private List<FullContractData> fullcontractList;
	private List<ProductionData> productionList;
	private List<OfferingData> offeringList;
	private List<BuyData> orderList;
	private List<FullStaffData> fullstaffList;
	
	
	public List<FullStaffData> getFullstaffList() {
		return fullstaffList;
	}
	public void setFullstaffList(List<FullStaffData> fullstaffList) {
		this.fullstaffList = fullstaffList;
	}
	public List<BuyData> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<BuyData> orderList) {
		this.orderList = orderList;
	}
	public List<OfferingData> getOfferingList() {
		return offeringList;
	}
	public void setOfferingList(List<OfferingData> offeringList) {
		this.offeringList = offeringList;
	}
	public List<ProductionData> getProductionList() {
		return productionList;
	}
	public void setProductionList(List<ProductionData> productionList) {
		this.productionList = productionList;
	}
	public List<FullContractData> getFullcontractList() {
		return fullcontractList;
	}
	public void setFullcontractList(List<FullContractData> fullcontractList) {
		this.fullcontractList = fullcontractList;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}
	public int getSeatnumber() {
		return seatnumber;
	}
	public void setSeatnumber(int seatnumber) {
		this.seatnumber = seatnumber;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public Date getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public String getCinema_id() {
		return cinema_id;
	}
	public void setCinema_id(String cinema_id) {
		this.cinema_id = cinema_id;
	}
	public String getCinema_name() {
		return cinema_name;
	}
	public void setCinema_name(String cinema_name) {
		this.cinema_name = cinema_name;
	}
	public String getAddress_street() {
		return address_street;
	}
	public void setAddress_street(String address_street) {
		this.address_street = address_street;
	}
	public String getAddress_city() {
		return address_city;
	}
	public void setAddress_city(String address_city) {
		this.address_city = address_city;
	}
	public String getAddress_state() {
		return address_state;
	}
	public void setAddress_state(String address_state) {
		this.address_state = address_state;
	}
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public Date getEstablish_date() {
		return establish_date;
	}
	public void setEstablish_date(Date establish_date) {
		this.establish_date = establish_date;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getContract_date() {
		return contract_date;
	}
	public void setContract_date(String contract_date) {
		this.contract_date = contract_date;
	}
	public int getDuration_time() {
		return duration_time;
	}
	public void setDuration_time(int duration_time) {
		this.duration_time = duration_time;
	}
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
	public String getOff_rate() {
		return off_rate;
	}
	public void setOff_rate(String off_rate) {
		this.off_rate = off_rate;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getFood_id() {
		return food_id;
	}
	public void setFood_id(String food_id) {
		this.food_id = food_id;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContact_date() {
		return contact_date;
	}
	public void setContact_date(String contact_date) {
		this.contact_date = contact_date;
	}
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getShow_id() {
		return show_id;
	}
	public void setShow_id(String show_id) {
		this.show_id = show_id;
	}
	public int getScreen() {
		return screen;
	}
	public void setScreen(int screen) {
		this.screen = screen;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public Date getShow_date() {
		return show_date;
	}
	public void setShow_date(Date show_date) {
		this.show_date = show_date;
	}
	public Time getShow_time() {
		return show_time;
	}
	public void setShow_time(Time show_time) {
		this.show_time = show_time;
	}
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<AdminData> getAdminList() {
		return adminList;
	}
	public void setAdminList(List<AdminData> adminList) {
		this.adminList = adminList;
	}
	public List<BooksData> getBooksList() {
		return booksList;
	}
	public void setBooksList(List<BooksData> booksList) {
		this.booksList = booksList;
	}
	public List<BuyData> getBuyList() {
		return buyList;
	}
	public void setBuyList(List<BuyData> buyList) {
		this.buyList = buyList;
	}
	public List<CinemaData> getCinemaList() {
		return cinemaList;
	}
	public void setCinemaList(List<CinemaData> cinemaList) {
		this.cinemaList = cinemaList;
	}
	public List<CompanyData> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<CompanyData> companyList) {
		this.companyList = companyList;
	}
	public List<ContractData> getContractList() {
		return contractList;
	}
	public void setContractList(List<ContractData> contractList) {
		this.contractList = contractList;
	}
	public List<DiscountData> getDiscountList() {
		return discountList;
	}
	public void setDiscountList(List<DiscountData> discountList) {
		this.discountList = discountList;
	}
	public List<EmployeeData> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<EmployeeData> employeeList) {
		this.employeeList = employeeList;
	}
	public List<FoodData> getFoodList() {
		return foodList;
	}
	public void setFoodList(List<FoodData> foodList) {
		this.foodList = foodList;
	}
	public List<MailData> getMailList() {
		return mailList;
	}
	public void setMailList(List<MailData> mailList) {
		this.mailList = mailList;
	}
	public List<Movie_infoData> getMovieList() {
		return movieList;
	}
	public void setMovieList(List<Movie_infoData> movieList) {
		this.movieList = movieList;
	}
	public List<OffersData> getOffersList() {
		return offersList;
	}
	public void setOffersList(List<OffersData> offersList) {
		this.offersList = offersList;
	}
	public List<PersonData> getPersonList() {
		return personList;
	}
	public void setPersonList(List<PersonData> personList) {
		this.personList = personList;
	}
	public List<PersonphoneData> getPersonphoneList() {
		return personphoneList;
	}
	public void setPersonphoneList(List<PersonphoneData> personphoneList) {
		this.personphoneList = personphoneList;
	}
	public List<ProduceData> getProduceList() {
		return produceList;
	}
	public void setProduceList(List<ProduceData> produceList) {
		this.produceList = produceList;
	}
	public List<ShowsData> getShowsList() {
		return showsList;
	}
	public void setShowsList(List<ShowsData> showsList) {
		this.showsList = showsList;
	}
	public List<StaffData> getStaffList() {
		return staffList;
	}
	public void setStaffList(List<StaffData> staffList) {
		this.staffList = staffList;
	}
	public List<UsersData> getUsersList() {
		return usersList;
	}
	public void setUsersList(List<UsersData> usersList) {
		this.usersList = usersList;
	}
	public List<FullShowsData> getFullshowsList() {
		return fullshowsList;
	}
	public void setFullshowsList(List<FullShowsData> fullshowsList) {
		this.fullshowsList = fullshowsList;
	}
	
	
	
}
