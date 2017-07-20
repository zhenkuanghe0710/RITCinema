package ritcinema.dao;

import java.util.List;

import ritcinema.datas.AdminData;
import ritcinema.datas.BooksData;
import ritcinema.datas.BuyData;
import ritcinema.datas.CinemaData;
import ritcinema.datas.DiscountData;
import ritcinema.datas.FoodData;
import ritcinema.datas.FullContractData;
import ritcinema.datas.FullShowsData;
import ritcinema.datas.FullStaffData;
import ritcinema.datas.MailData;
import ritcinema.datas.Movie_infoData;
import ritcinema.datas.OfferingData;
import ritcinema.datas.PersonData;
import ritcinema.datas.PersonphoneData;
import ritcinema.datas.ProductionData;
import ritcinema.datas.ShowsData;
import ritcinema.datas.UsersData;

public interface ritcinemaDAO {

	//(about food)
	FoodData retrieveFood(FoodData data) throws Exception;
	List<FoodData> getFoodList(FoodData data) throws Exception;
	
	//(about buy)
	void createOrder(BuyData data) throws Exception;
	List<BuyData> getOrderList(BuyData data) throws Exception;
	
	//(about mail)
	void createMail(MailData data) throws Exception;
	List<MailData> getMailList(MailData data) throws Exception;
	
	//(about login)
	void createUser(UsersData data) throws Exception;
	UsersData retrieveUser(UsersData data) throws Exception;
	AdminData retrieveAdmin(AdminData data) throws Exception;
    
    //(about discount)
    DiscountData retrieveDiscount(DiscountData data) throws Exception;
    List<DiscountData> getDiscountList(DiscountData data) throws Exception;

    //(about cinema)
    CinemaData retrieveCinema(CinemaData data) throws Exception;
    List<CinemaData> getCinemaList(CinemaData data) throws Exception;

    //(about person)
    void createPerson(PersonData data) throws Exception;
    PersonData retrievePerson(PersonData data) throws Exception;
    
    //(about personphone)
    void createPersonphone(PersonphoneData data) throws Exception;
    
    //(about offers)
    List<OfferingData> getOfferingList(OfferingData data) throws Exception;
    
    //(about shows)
	void createShows(ShowsData data) throws Exception;
	void deleteShows(ShowsData data) throws Exception;
	ShowsData retrieveShows(ShowsData data) throws Exception;
	void updateShows(ShowsData data) throws Exception;
	List<FullShowsData> getFullShowsList(FullShowsData data) throws Exception;

	//(about ticket)
	void createTicket(BooksData data) throws Exception;
	List<BooksData> getTicketList(BooksData data) throws Exception;

	//(about movie)
	Movie_infoData retrieveMovie(Movie_infoData data) throws Exception;
	List<Movie_infoData> getMovieList(Movie_infoData data) throws Exception;
	
	//(about view)
	List<FullContractData> getFullContractList(FullContractData data) throws Exception;
	List<ProductionData> getProductionList(ProductionData data) throws Exception;
	List<FullStaffData> getFullStaffList(FullStaffData data) throws Exception;
}
