package ritcinema.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import ritcinema.dao.ritcinemaDAO;
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


@Stateless
@Remote( { ritcinemaDAO.class })
public class RITCinemaServices implements ritcinemaDAO {


	public RITCinemaServices() throws Exception {
	}
	
	@Override
		public List<MailData> getMailList(MailData data) throws Exception {
	
			List<MailData> resultList = new ArrayList<MailData>();
			
			String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
			String ritcinemaDB_Account = "RITCinema";
			String ritcinemaDB_Password = "RITCinema008";
			String sqlCommand = null;
			
			sqlCommand = "SELECT * FROM CONTACT ";
			
			if (data.getUsername() != null)
				sqlCommand = "SELECT * FROM CONTACT AS C WHERE C.USERNAME = '" + data.getUsername() +"'";
			else ;
			
			if (data.getAdminname() != null)
				sqlCommand = "SELECT * FROM CONTACT AS C WHERE C.ADMINNAME = '" + data.getAdminname() +"'";
			else ;
			
			if (data.getContact_date() != null)
				sqlCommand = "SELECT * FROM CONTACT AS C WHERE C.contact_date = '" + data.getContact_date() +"'";
			else ;
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
				
				PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
				ResultSet r = ritcinemaStmt.executeQuery();
			
				int mail_id = 0;
				String contact_date = null;
				String username = null;
				String adminname = null;
				String subject = null;
				String content = null;
				
				while(r.next()){
					MailData mailData = new MailData();
					
					mail_id = r.getInt("MAIL_ID");
					contact_date = r.getString("CONTACT_DATE");
					username = r.getString("USERNAME");
					adminname = r.getString("ADMINNAME");
					subject = r.getString("SUBJECT");
					content = r.getString("CONT");
					
					mailData.setAdminname(adminname);
					mailData.setContact_date(contact_date);
					mailData.setContent(content);
					mailData.setMail_id(mail_id);
					mailData.setSubject(subject);
					mailData.setUsername(username);
					
					resultList.add(mailData);
					}
				ritcinemaStmt.close();
				dbConn.close();
			
			}catch (Exception e){
				throw e;
			}
			
			return resultList;
	}

	@Override
	public List<Movie_infoData> getMovieList(Movie_infoData data)
			throws Exception {
		
		List<Movie_infoData> resultList = new ArrayList<Movie_infoData>();
		
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
		
		sqlCommand = "SELECT * FROM MOVIE_INFO ";
		
		if (data.getActor() != null)
			sqlCommand = "SELECT * FROM MOVIE_INFO AS M WHERE M.ACTOR = '" + data.getActor() +"'";
		else ;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ResultSet r = ritcinemaStmt.executeQuery();
		
			String movie_id = null;
			String movie_name = null;
			String actor = null;
			
			while(r.next()){
				Movie_infoData movie_infoData = new Movie_infoData();
				
				movie_id = r.getString("MOVIE_ID");
				movie_name = r.getString("MOVIE_NAME");
				actor = r.getString("ACTOR");

				movie_infoData.setActor(actor);
				movie_infoData.setMovie_id(movie_id);
				movie_infoData.setMovie_name(movie_name);

				resultList.add(movie_infoData);
				}
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
		
		return resultList;
	}

	@Override
	public List<FullShowsData> getFullShowsList(FullShowsData data) throws Exception {
		
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
		
		sqlCommand = "SELECT * FROM SHOWS AS S, MOVIE_INFO AS M, CINEMA AS C WHERE S.MOVIE_ID = M.MOVIE_ID AND S.CINEMA_ID = C.CINEMA_ID ";
		
		if (data.getCinema_id() != null)
			sqlCommand = "SELECT * FROM SHOWS AS S, MOVIE_INFO AS M, CINEMA AS C WHERE S.MOVIE_ID = M.MOVIE_ID AND S.CINEMA_ID = C.CINEMA_ID AND S.CINEMA_ID = '" + data.getCinema_id() +"'";
		else ;
		if (data.getMovie_id() != null)
			sqlCommand = "SELECT * FROM SHOWS AS S, MOVIE_INFO AS M, CINEMA AS C WHERE S.MOVIE_ID = M.MOVIE_ID AND S.CINEMA_ID = C.CINEMA_ID AND S.MOVIE_ID = '" + data.getMovie_id() +"'";
		else ;
		if (data.getShow_date() != null)
			sqlCommand = "SELECT * FROM SHOWS AS S, MOVIE_INFO AS M, CINEMA AS C WHERE S.MOVIE_ID = M.MOVIE_ID AND S.CINEMA_ID = C.CINEMA_ID AND S.SHOW_DATE = '" + data.getShow_date() +"'";
		else ;
		if (data.getShow_time() != null)
			sqlCommand = "SELECT * FROM SHOWS AS S, MOVIE_INFO AS M, CINEMA AS C WHERE S.MOVIE_ID = M.MOVIE_ID AND S.CINEMA_ID = C.CINEMA_ID AND S.SHOW_TIME = '" + data.getShow_time() +"'";
		else ;
		
		
		List<FullShowsData> resultList = new ArrayList<FullShowsData>();
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ResultSet resultSet = ritcinemaStmt.executeQuery();
			
			String show_id = null;
			String movie_id = null;
			String movie_name = null;
			String actor = null;
			String cinema_id = null;
			String cinema_name = null;
			int screen = 0;
			int seats = 0;
			Date show_date = null;
			Time show_time = null;
			int price = 0;
			
			while(resultSet.next()){
				FullShowsData fullshowsData = new FullShowsData();
				
				 show_id = resultSet.getString("SHOW_ID");
				 movie_id = resultSet.getString("MOVIE_ID");
				 movie_name = resultSet.getString("MOVIE_NAME");
				 actor = resultSet.getString("ACTOR");
				 cinema_id = resultSet.getString("CINEMA_ID");
				 cinema_name = resultSet.getString("CINEMA_NAME");
				 screen = resultSet.getInt("SCREEN");
				 seats = resultSet.getInt("SEATS");
				 show_date = resultSet.getDate("SHOW_DATE");
				 show_time = resultSet.getTime("SHOW_TIME");
				 price = resultSet.getInt("PRICE");
				
				 fullshowsData.setActor(actor);
				 fullshowsData.setCinema_id(cinema_id);
				 fullshowsData.setCinema_name(cinema_name);
				 fullshowsData.setMovie_id(movie_id);
				 fullshowsData.setMovie_name(movie_name);
				 fullshowsData.setScreen(screen);
				 fullshowsData.setSeats(seats);
				 fullshowsData.setShow_date(show_date);
				 fullshowsData.setShow_id(show_id);
				 fullshowsData.setShow_time(show_time);
				 fullshowsData.setPrice(price);
				
				resultList.add(fullshowsData);
			}
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
		
		return resultList;
	}

	@Override
	public List<DiscountData> getDiscountList(DiscountData data) throws Exception {
	
		List<DiscountData> resultList = new ArrayList<DiscountData>();
		
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
		
		sqlCommand = "SELECT * FROM DISCOUNT ";
		
		if (data.getWorks_for() != null)
			sqlCommand = "SELECT * FROM DISCOUNT AS D WHERE D.WORKS_FOR = '" + data.getWorks_for() +"'";
		else ;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ResultSet r = ritcinemaStmt.executeQuery();
		
			String discount_id = null;
			String works_for = null;
			int off_rate = 0;
			
			while(r.next()){
				DiscountData discountData = new DiscountData();
				
				discount_id = r.getString("discount_id");
				works_for = r.getString("works_for");
				off_rate= r.getInt("off_rate");

				discountData.setDiscount_id(discount_id);
				discountData.setOff_rate(off_rate);
				discountData.setWorks_for(works_for);
		
				resultList.add(discountData);
				}
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
		
		return resultList;
	}

	@Override
	public List<CinemaData> getCinemaList(CinemaData data) throws Exception {
	
		List<CinemaData> resultList = new ArrayList<CinemaData>();
		
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
		
		sqlCommand = "SELECT * FROM cinema ";
		
		if (data.getAddress_city() != null)
			sqlCommand = "SELECT * FROM cinema AS c WHERE c.address_city = '" + data.getAddress_city() +"'";
		else ;
		
		if (data.getAddress_state() != null)
		sqlCommand = "SELECT * FROM cinema AS c WHERE c.address_state = '" + data.getAddress_state() +"'";
		else ;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ResultSet r = ritcinemaStmt.executeQuery();
		
			String cinema_id = null;
			String cinema_name = null;
			String address_street = null;
			String address_city = null;
			String address_state = null;
			
			while(r.next()){
				CinemaData cinemaData = new CinemaData();
				
				cinema_id = r.getString("cinema_id");
				cinema_name = r.getString("cinema_name");
				address_street= r.getString("address_street");
				address_city= r.getString("address_city");
				address_state= r.getString("address_state");

				cinemaData.setAddress_city(address_city);
				cinemaData.setAddress_state(address_state);
				cinemaData.setAddress_street(address_street);
				cinemaData.setCinema_id(cinema_id);
				cinemaData.setCinema_name(cinema_name);
		
				resultList.add(cinemaData);
				}
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
		
		return resultList;
	}

	@Override
	public List<FoodData> getFoodList(FoodData data) throws Exception {
	
		List<FoodData> resultList = new ArrayList<FoodData>();
		
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
		
		
		sqlCommand = "SELECT * FROM food ";
		
		if (data.getType() != null)
			sqlCommand = "SELECT * FROM food AS f WHERE f.type = '" + data.getType() +"'";
		else ;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ResultSet r = ritcinemaStmt.executeQuery();
		
			String food_id = null;
			String food_name = null;
			float price = 0;
			String type = null;
			String description = null;
			
			while(r.next()){
				FoodData foodData = new FoodData();
				
				food_id = r.getString("food_id");
				food_name = r.getString("food_name");
				price= r.getFloat("price");
				type= r.getString("type");
				description= r.getString("description");

				foodData.setDescription(description);
				foodData.setFood_id(food_id);
				foodData.setFood_name(food_name);
				foodData.setPrice(price);
				foodData.setType(type);
		
				resultList.add(foodData);
				}
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
		
		return resultList;
	}

	@Override
	public FoodData retrieveFood(FoodData data) throws Exception {
		
		FoodData foodData = new FoodData();
		
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
		
		sqlCommand = "SELECT * FROM food as f where f.food_id = '" + data.getFood_id()+"'";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ResultSet r = ritcinemaStmt.executeQuery();
		
			String food_id = null;
			String food_name = null;
			float price = 0;
			String type = null;
			String description = null;
			
			while(r.next()){
				foodData = new FoodData();
				
				food_id = r.getString("food_id");
				food_name = r.getString("food_name");
				price= r.getFloat("price");
				type= r.getString("type");
				description= r.getString("description");

				foodData.setDescription(description);
				foodData.setFood_id(food_id);
				foodData.setFood_name(food_name);
				foodData.setPrice(price);
				foodData.setType(type);
		
				}
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
		
		return foodData;
	}

	@Override
	public void createOrder(BuyData data) throws Exception {
		
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
		
		sqlCommand = "insert into buy (food_id,username,delivery_date,quantity,total_price) " +
				"values('" + data.getFood_id()+"','"+ data.getUsername() +"','" +data.getDelivery_date() +"'," +
				data.getQuantity()+"," +data.getTotal_price()+")";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ritcinemaStmt.execute();
				
			ritcinemaStmt.close();
			dbConn.close();
		}catch (Exception e){
			throw e;
		}
	}

	@Override
	public ShowsData retrieveShows(ShowsData data) throws Exception {
		ShowsData showsData = new ShowsData();
		
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
		
		sqlCommand = "SELECT * FROM shows as s where s.show_id = '" + data.getShow_id()+"'";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ResultSet r = ritcinemaStmt.executeQuery();
		
			String show_id = null;
			String movie_id = null;
			String cinema_id = null;
			int screen = 0;
			int seats = 0;
			Date show_date = null;
			Time show_time = null;
			int price = 0;
			
			while(r.next()){
				showsData = new ShowsData();
				
				show_id = r.getString("show_id");
				movie_id = r.getString("movie_id");
				cinema_id = r.getString("cinema_id");
				screen= r.getInt("screen");
				seats= r.getInt("seats");
				price= r.getInt("price");
				show_date= r.getDate("show_date");
				show_time= r.getTime("show_time");

				showsData.setCinema_id(cinema_id);
				showsData.setMovie_id(movie_id);
				showsData.setPrice(price);
				showsData.setScreen(screen);
				showsData.setSeats(seats);
				showsData.setShow_date(show_date);
				showsData.setShow_id(show_id);
				showsData.setShow_time(show_time);
		
				}
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
		
		return showsData;
	}

	@Override
	public void createTicket(BooksData data) throws Exception {
		
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
		
		sqlCommand = "insert into books (show_id,username,discount_id,seatnumber,price) " +
				"values('" + data.getShow_id()+"','"+ data.getUsername() +"','" +data.getDiscount_id() +"'," +
				data.getSeatnumber()+"," +data.getPrice()+")";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ritcinemaStmt.execute();
				
			ritcinemaStmt.close();
			dbConn.close();
		}catch (Exception e){
			throw e;
		}
		
	}
	
	@Override
	public DiscountData retrieveDiscount(DiscountData data) throws Exception {
		
		DiscountData discountData = new DiscountData();

		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
		
		sqlCommand = "SELECT * FROM discount as d where d.discount_id = '" + data.getDiscount_id()+"'";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ResultSet r = ritcinemaStmt.executeQuery();
		
			String discount_id = null;
			String works_for = null;
			int off_rate = 0;
			
			while(r.next()){
				discountData = new DiscountData();
				
				discount_id = r.getString("discount_id");
				works_for = r.getString("works_for");
				off_rate= r.getInt("off_rate");

				discountData.setDiscount_id(discount_id);
				discountData.setOff_rate(off_rate);
				discountData.setWorks_for(works_for);
		
				}
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
		
		return discountData;
	}
	
	@Override
	public CinemaData retrieveCinema(CinemaData data) throws Exception {
		CinemaData cinemaData = new CinemaData();

		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
		
		if (data.getCinema_id()!= null)
			sqlCommand = "SELECT * FROM cinema AS c WHERE c.cinema_id = '" + data.getCinema_id() +"'";
		else ;
	
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ResultSet r = ritcinemaStmt.executeQuery();
		
			String cinema_id = null;
			String cinema_name = null;
			String address_street = null;
			String address_city = null;
			String address_state = null;
			
			while(r.next()){
				cinemaData = new CinemaData();
				
				cinema_id = r.getString("cinema_id");
				cinema_name = r.getString("cinema_name");
				address_street= r.getString("address_street");
				address_city= r.getString("address_city");
				address_state= r.getString("address_state");

				cinemaData.setAddress_city(address_city);
				cinemaData.setAddress_state(address_state);
				cinemaData.setAddress_street(address_street);
				cinemaData.setCinema_id(cinema_id);
				cinemaData.setCinema_name(cinema_name);
				}
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
		
		return cinemaData;
	}
	
	@Override
	public Movie_infoData retrieveMovie(Movie_infoData data) throws Exception {
		
		Movie_infoData movie_infoData = new Movie_infoData();

		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
	
		if (data.getMovie_id() != null)
			sqlCommand = "SELECT * FROM MOVIE_INFO AS M WHERE M.movie_id = '" + data.getMovie_id() +"'";
		else ;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ResultSet r = ritcinemaStmt.executeQuery();
		
			String movie_id = null;
			String movie_name = null;
			String actor = null;
			
			while(r.next()){
				movie_infoData = new Movie_infoData();
				
				movie_id = r.getString("MOVIE_ID");
				movie_name = r.getString("MOVIE_NAME");
				actor = r.getString("ACTOR");

				movie_infoData.setActor(actor);
				movie_infoData.setMovie_id(movie_id);
				movie_infoData.setMovie_name(movie_name);

				}
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
		
		return movie_infoData;
	}

	@Override
	public void createMail(MailData data) throws Exception {
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		
		String sqlCommand = "INSERT INTO CONTACT (CONTACT_DATE,USERNAME,ADMINNAME,SUBJECT,CONT) " +
				"VALUES('" + data.getContact_date() +"','" + data.getUsername() +"','" + data.getAdminname() +"','"+
				data.getSubject() + "','" + data.getContent() +"')";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ritcinemaStmt.execute();
			
			dbConn.close();
			ritcinemaStmt.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public UsersData retrieveUser(UsersData data) throws Exception {
		
		UsersData userData = new UsersData();

		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
	
		if (data.getUsername() != null)
			sqlCommand = "SELECT * FROM users AS u WHERE u.username = '" + data.getUsername() +"'";
		else ;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ResultSet r = ritcinemaStmt.executeQuery();
		
			String username = null;
			int ssn = 0;
			String password = null;
			
			while(r.next()){
				userData = new UsersData();
				
				username = r.getString("username");
				ssn = r.getInt("ssn");
				password = r.getString("password");

				userData.setPassword(password);
				userData.setSsn(ssn);
				userData.setUsername(username);

				}
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
		
		return userData;
	}
	
	@Override
	public AdminData retrieveAdmin(AdminData data) throws Exception {
		
		AdminData adminData = new AdminData();

		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
	
		if (data.getAdminname() != null)
			sqlCommand = "SELECT * FROM administrator AS a WHERE a.adminname = '" + data.getAdminname() +"'";
		else ;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ResultSet r = ritcinemaStmt.executeQuery();
		
			String adminname = null;
			int ssn = 0;
			String password = null;
			
			while(r.next()){
				adminData = new AdminData();
				
				adminname = r.getString("adminname");
				ssn = r.getInt("ssn");
				password = r.getString("password");

				adminData.setPassword(password);
				adminData.setSsn(ssn);
				adminData.setAdminname(adminname);

				}
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
		
		return adminData;
	}
	
	@Override
	public void createUser(UsersData data) throws Exception{
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		
		String sqlCommand = "INSERT INTO users (USERNAME,SSN,PASSWORD) " +
				"VALUES('" + data.getUsername() +"'," + data.getSsn() +",'" + data.getPassword() +"')";
		//String sqlCommand = "INSERT INTO users (USERNAME,PASSWORD) " +
					//"VALUES('" + data.getUsername() +"','"  + data.getPassword() +"')";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ritcinemaStmt.execute();
			
			dbConn.close();
			ritcinemaStmt.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public PersonData retrievePerson(PersonData data) throws Exception {
		PersonData personData = new PersonData();

		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
	
		if (data.getSsn() != 0)
			sqlCommand = "SELECT * FROM person AS p WHERE p.ssn = " + data.getSsn();
		else ;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ResultSet r = ritcinemaStmt.executeQuery();
		
			String person_name = null;
			int ssn = 0;
			String email = null;
			
			while(r.next()){
				personData = new PersonData();
				
				person_name = r.getString("person_name");
				ssn = r.getInt("ssn");
				email = r.getString("email");

				personData.setEmail(email);
				personData.setPerson_name(person_name);
				personData.setSsn(ssn);

				}
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
		
		return personData;
	}
	
	public void createPerson(PersonData data) throws Exception{
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		
		String sqlCommand = "INSERT INTO person (ssn,person_name,email) " +
				"VALUES(" + data.getSsn() +",'" + data.getPerson_name() +"','" + data.getEmail() +"')";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ritcinemaStmt.execute();
			
			dbConn.close();
			ritcinemaStmt.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createPersonphone(PersonphoneData data) throws Exception{
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		
		String sqlCommand = "INSERT INTO personphone (ssn,phone) " +
				"VALUES(" + data.getSsn() +",'" + data.getPhone() +"')";
		//String sqlCommand = "INSERT INTO personphone (phone) " +
					//"VALUES('" + data.getPhone() +"')";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ritcinemaStmt.execute();
			
			dbConn.close();
			ritcinemaStmt.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<FullContractData> getFullContractList(FullContractData data)
			throws Exception {
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
		
		sqlCommand = "SELECT * FROM full_contract";
		
		if (data.getAddress_state() != null)
			sqlCommand = "SELECT * FROM full_contract as f where f.address_state = '" + data.getAddress_state() +"'";
		else ;
		
		if (data.getCountry() != null)
			sqlCommand = "SELECT * FROM full_contract as f where f.country = '" + data.getCountry() +"'";
		else ;
		
		List<FullContractData> resultList = new ArrayList<FullContractData>();
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ResultSet resultSet = ritcinemaStmt.executeQuery();
			
			 
			 String cinema_name = null;
			 String address_state = null;
			 String company_name = null;
			 String country = null;
			
			while(resultSet.next()){
				FullContractData fullContractData = new FullContractData();
				
				cinema_name = resultSet.getString("cinema_name");
				address_state = resultSet.getString("address_state");
				company_name = resultSet.getString("company_name");
				country = resultSet.getString("country");
				
				fullContractData.setAddress_state(address_state);
				fullContractData.setCinema_name(cinema_name);
				fullContractData.setCompany_name(company_name);
				fullContractData.setCountry(country);
				
				
				resultList.add(fullContractData);
			}
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
		
		return resultList;
	}
	
	@Override
	public List<ProductionData> getProductionList(ProductionData data)
			throws Exception {
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
		
		sqlCommand = "SELECT * FROM production";
		
		if (data.getCompany_name() != null)
			sqlCommand = "SELECT * FROM production as p where p.company_name = '" + data.getCompany_name() +"'";
		else ;
		
		List<ProductionData> resultList = new ArrayList<ProductionData>();
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ResultSet resultSet = ritcinemaStmt.executeQuery();
			
			 String movie_name = null;
			 String company_name = null;

			
			while(resultSet.next()){
				ProductionData productionData = new ProductionData();
			
				company_name = resultSet.getString("company_name");
				movie_name = resultSet.getString("movie_name");
				
				productionData.setCompany_name(company_name);
				productionData.setMovie_name(movie_name);
				
				resultList.add(productionData);
			}
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
		
		return resultList;
	}
	
	@Override
	public void createShows(ShowsData data) throws Exception {
		
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		
		String sqlCommand = "INSERT INTO shows (show_id,movie_id,cinema_id,screen,seats,show_date,show_time,price) " +
				"VALUES('" + data.getShow_id() +"','" + data.getMovie_id() +"','" + data.getCinema_id() +"',"+
				data.getScreen() + "," + data.getSeats() +",'" 
				+ data.getShow_date()+ "','" + data.getShow_time()+ "'," +data.getPrice()+")";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ritcinemaStmt.execute();
			
			dbConn.close();
			ritcinemaStmt.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateShows(ShowsData data) throws Exception {
		
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
	
		sqlCommand = "UPDATE SHOWS SET screen = " + data.getScreen() + ", seats = " + data.getSeats()
							+ ", show_date = '" + data.getShow_date() +"', show_time = '" + data.getShow_time()
							+ "', price = " + data.getPrice() + " where show_id = '" + data.getShow_id()+ "'";

		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ritcinemaStmt.execute();
		
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
	}
	
	@Override
	public List<BooksData> getTicketList(BooksData data) throws Exception {
	
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
		
		sqlCommand = "SELECT * FROM SHOWS AS S, MOVIE_INFO AS M, CINEMA AS C, BOOKS AS B " +
				"WHERE S.MOVIE_ID = M.MOVIE_ID AND S.CINEMA_ID = C.CINEMA_ID AND B.SHOW_ID = S.SHOW_ID";
		
		if (data.getUsername() != null)
			sqlCommand = "SELECT * FROM SHOWS AS S, MOVIE_INFO AS M, CINEMA AS C, BOOKS AS B " +
					"WHERE S.MOVIE_ID = M.MOVIE_ID AND S.CINEMA_ID = C.CINEMA_ID AND B.SHOW_ID = S.SHOW_ID AND " +
					"B.USERNAME = '" + data.getUsername() +"'";
		else ;
		
		List<BooksData> resultList = new ArrayList<BooksData>();
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ResultSet resultSet = ritcinemaStmt.executeQuery();
			
			 int ticket_id = 0;
			 int seatnumber = 0;
			 String show_id = null;
			 String movie_name = null;
			 String cinema_name = null;
			 Date show_date = null;
			 Time show_time = null;
			 int price = 0;
			
			while(resultSet.next()){
				BooksData booksData = new BooksData();
				
				ticket_id = resultSet.getInt("TICKET_ID");
				seatnumber = resultSet.getInt("SEATNUMBER");
				movie_name = resultSet.getString("MOVIE_NAME");
				show_id = resultSet.getString("SHOW_ID");
				cinema_name = resultSet.getString("CINEMA_NAME");
				show_date = resultSet.getDate("SHOW_DATE");
				show_time = resultSet.getTime("SHOW_TIME");
				price = resultSet.getInt("PRICE");
				
				booksData.setTicket_id(ticket_id);
				booksData.setSeatnumber(seatnumber);
				booksData.setMovie_name(movie_name);
				booksData.setShow_id(show_id);
				booksData.setCinema_name(cinema_name);
				booksData.setShow_date(show_date);
				booksData.setShow_time(show_time);
				booksData.setPrice(price);
				
				resultList.add(booksData);
			}
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
		
		return resultList;
	}

	
	@Override
	public List<OfferingData> getOfferingList(OfferingData data) throws Exception {

		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
		
		sqlCommand = "SELECT * FROM offering";
		
		if (data.getCinema_name() != null)
			sqlCommand = "SELECT * FROM offering as o where o.cinema_name = '" + data.getCinema_name() +"'";
		else ;
		
		if (data.getWorks_for() != null)
			sqlCommand = "SELECT * FROM offering as o where o.works_for = '" + data.getWorks_for() +"'";
		else ;
		
		List<OfferingData> resultList = new ArrayList<OfferingData>();
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ResultSet resultSet = ritcinemaStmt.executeQuery();
			
			 String cinema_name = null;
			 String works_for = null;
			 int off_rate = 0;

			
			while(resultSet.next()){
				OfferingData offeringData = new OfferingData();
			
				cinema_name = resultSet.getString("cinema_name");
				works_for = resultSet.getString("works_for");
				off_rate = resultSet.getInt("off_rate");
				
				offeringData.setCinema_name(cinema_name);
				offeringData.setOff_rate(off_rate);
				offeringData.setWorks_for(works_for);
				
				resultList.add(offeringData);
			}
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
		
		return resultList;
	}
	
	@Override
	public List<BuyData> getOrderList(BuyData data) throws Exception {

		List<BuyData> resultList = new ArrayList<BuyData>();
		
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
		
		sqlCommand = "SELECT * FROM buy";
		
		if (data.getUsername() != null)
			sqlCommand = "SELECT * FROM buy as b where b.username = '" + data.getUsername() +"'";
		else ;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ResultSet resultSet = ritcinemaStmt.executeQuery();
			
			int order_id = 0;
			String food_id = null;
			String username = null;
			Date delivery_date = null;
			int quantity = 0;
			float total_price = 0;

			while(resultSet.next()){
				BuyData buyData = new BuyData();
			
				food_id = resultSet.getString("food_id");
				username = resultSet.getString("username");
				order_id = resultSet.getInt("order_id");
				quantity = resultSet.getInt("quantity");
				delivery_date = resultSet.getDate("delivery_date");
				total_price = resultSet.getFloat("total_price");
				
				buyData.setDelivery_date(delivery_date);
				buyData.setFood_id(food_id);
				buyData.setOrder_id(order_id);
				buyData.setQuantity(quantity);
				buyData.setTotal_price(total_price);
				buyData.setUsername(username);
				
				resultList.add(buyData);
			}
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
		
		return resultList;
	}
	
	@Override
	public List<FullStaffData> getFullStaffList(FullStaffData data) throws Exception{
		
		List<FullStaffData> resultList = new ArrayList<FullStaffData>();
		
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
		
		sqlCommand = "SELECT * FROM full_staff";
		
		if (data.getDepartment() != null)
			sqlCommand = "SELECT * FROM full_staff as f where f.department = '" + data.getDepartment() +"'";
		else ;
		
		if (data.getPosition() != null)
			sqlCommand = "SELECT * FROM full_staff as f where f.position = '" + data.getPosition() +"'";
		else ;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ResultSet resultSet = ritcinemaStmt.executeQuery();
			
			String department = null;
			String position = null;
			Time working_time = null;
			int salary = 0;
			String person_name = null;

			while(resultSet.next()){
				FullStaffData fullStaffData = new FullStaffData();
			
				department = resultSet.getString("department");
				position = resultSet.getString("position");
				working_time = resultSet.getTime("working_time");
				salary = resultSet.getInt("salary");
				person_name = resultSet.getString("person_name");
				
				fullStaffData.setDepartment(department);
				fullStaffData.setPerson_name(person_name);
				fullStaffData.setPosition(position);
				fullStaffData.setSalary(salary);
				fullStaffData.setWorking_time(working_time);
				
				resultList.add(fullStaffData);
			}
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
		
		return resultList;
	}
	
	@Override
	public void deleteShows(ShowsData data) throws Exception {
			
		String ritcinemaDB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RITCinema";
		String ritcinemaDB_Account = "RITCinema";
		String ritcinemaDB_Password = "RITCinema008";
		String sqlCommand = null;
	
		sqlCommand = "DELETE FROM SHOWS WHERE show_id = '" + data.getShow_id() +"'";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection dbConn = DriverManager.getConnection(ritcinemaDB_URL, ritcinemaDB_Account, ritcinemaDB_Password);
			
			PreparedStatement ritcinemaStmt = dbConn.prepareStatement(sqlCommand);
			ritcinemaStmt.execute();
		
			ritcinemaStmt.close();
			dbConn.close();
		
		}catch (Exception e){
			throw e;
		}
	}
}
