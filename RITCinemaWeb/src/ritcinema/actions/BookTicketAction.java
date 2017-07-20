package ritcinema.actions;


import java.sql.Date;
import java.sql.Time;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import ritcinema.dao.ritcinemaDAO;
import ritcinema.datas.BooksData;
import ritcinema.datas.CinemaData;
import ritcinema.datas.DiscountData;
import ritcinema.datas.MailData;
import ritcinema.datas.Movie_infoData;
import ritcinema.datas.ShowsData;
import ritcinema.forms.RITCinemaForm;

public class BookTicketAction extends Action{
	
	private ActionErrors errors = null;
	
	public ShowsData retrieveShows(ShowsData data) throws Exception{
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://localhost";
        String ejbObject = "ejb/RITCinema";
        
        ShowsData showsData = new ShowsData();
        try{
			
            Properties mailProperties = new Properties();
            mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
            mailProperties.put(Context.PROVIDER_URL, jndiServer);             
            Context context = new InitialContext( mailProperties );
           
            ritcinemaDAO mailProxy = (ritcinemaDAO) context.lookup( ejbObject );
           
            showsData = mailProxy.retrieveShows(data);
   	     }
         catch (Exception e){
        	throw e;
         }	
         return showsData;
    }
	
	public void createTicket(BooksData data) throws Exception {
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://localhost";
        String ejbObject = "ejb/RITCinema";
        try{
			
            Properties mailProperties = new Properties();
            mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
            mailProperties.put(Context.PROVIDER_URL, jndiServer);             
            Context context = new InitialContext( mailProperties );
           
            ritcinemaDAO mailProxy = (ritcinemaDAO) context.lookup( ejbObject );
           
            mailProxy.createTicket(data);
   	     }
         catch (Exception e){
        	throw e;
         }
    }
	
	public DiscountData retrieveDiscount(DiscountData data) throws Exception{
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://localhost";
        String ejbObject = "ejb/RITCinema";
        
        DiscountData discountData = new DiscountData();
        try{
			
            Properties mailProperties = new Properties();
            mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
            mailProperties.put(Context.PROVIDER_URL, jndiServer);             
            Context context = new InitialContext( mailProperties );
           
            ritcinemaDAO mailProxy = (ritcinemaDAO) context.lookup( ejbObject );
           
            discountData = mailProxy.retrieveDiscount(data);
   	     }
         catch (Exception e){
        	throw e;
         }	
         return discountData;
    }
	
	public CinemaData retrieveCinema(CinemaData data) throws Exception {
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://localhost";
        String ejbObject = "ejb/RITCinema";
        
        CinemaData cinemaData = new CinemaData();
        try{
			
            Properties mailProperties = new Properties();
            mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
            mailProperties.put(Context.PROVIDER_URL, jndiServer);             
            Context context = new InitialContext( mailProperties );
           
            ritcinemaDAO mailProxy = (ritcinemaDAO) context.lookup( ejbObject );
           
            cinemaData = mailProxy.retrieveCinema(data);
   	     }
         catch (Exception e){
        	throw e;
         }	
         return cinemaData;
    }
	
	public Movie_infoData retrieveMovie(Movie_infoData data) throws Exception{
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://localhost";
        String ejbObject = "ejb/RITCinema";
        
        Movie_infoData movie_infoData = new Movie_infoData();
        try{
			
            Properties mailProperties = new Properties();
            mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
            mailProperties.put(Context.PROVIDER_URL, jndiServer);             
            Context context = new InitialContext( mailProperties );
           
            ritcinemaDAO mailProxy = (ritcinemaDAO) context.lookup( ejbObject );
           
            movie_infoData = mailProxy.retrieveMovie(data);
   	     }
         catch (Exception e){
        	throw e;
         }	
         return movie_infoData;
    }
	
	public void createMail(MailData data) throws Exception {
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://localhost";
        String ejbObject = "ejb/RITCinema";
        try{
			
            Properties mailProperties = new Properties();
            mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
            mailProperties.put(Context.PROVIDER_URL, jndiServer);             
            Context context = new InitialContext( mailProperties );
           
            ritcinemaDAO mailProxy = (ritcinemaDAO) context.lookup( ejbObject );
           
            mailProxy.createMail(data);
   	     }
         catch (Exception e){
        	throw e;
         }
    }
	
	public ActionForward execute (	ActionMapping mapping,
														 ActionForm form,
														 HttpServletRequest request, 
														 HttpServletResponse response ) throws Exception {

				RITCinemaForm rcForm = (RITCinemaForm) form;
				ActionForward forward = new ActionForward();
				errors = new ActionErrors();
				
				String show_id = rcForm.getShow_id();
				String username = rcForm.getUsername();
				String discount_id = rcForm.getDiscount_id();
					
				ShowsData showsData = new ShowsData();
				BooksData booksData = new BooksData();
				DiscountData discountData = new DiscountData();
				Movie_infoData movie_infoData = new Movie_infoData();
				CinemaData cinemaData = new CinemaData();
				MailData mailData = new MailData();
				
				discountData.setDiscount_id(discount_id);
				discountData = retrieveDiscount(discountData);
				int off_rate = discountData.getOff_rate();
				
				
				showsData.setShow_id(show_id);
				showsData = retrieveShows(showsData);
				String movie_id = showsData.getMovie_id();
				String cinema_id = showsData.getCinema_id();
				int screen = showsData.getScreen();
				Date show_date = showsData.getShow_date();
				Time show_time = showsData.getShow_time();
				int price = showsData.getPrice();
				int tprice = price * off_rate / 100;
				
				cinemaData.setCinema_id(cinema_id);
				cinemaData = retrieveCinema(cinemaData);
				String cinema_name = cinemaData.getCinema_name();
				
				movie_infoData.setMovie_id(movie_id);
				movie_infoData = retrieveMovie(movie_infoData);
				String movie_name = movie_infoData.getMovie_name();
					
				booksData.setShow_id(show_id);
				booksData.setUsername(username);
				booksData.setDiscount_id(discount_id);
				booksData.setSeatnumber(showsData.getSeats());
				booksData.setPrice(tprice);

				createTicket(booksData);
					
				//Set result
				String result = "Your Order:  MovieName¡¾"
	                 + movie_name + "¡¿   Cinema¡¾" 
	                 + cinema_name + "¡¿   Screen¡¾" 
	                 + screen + "¡¿   ShowDate¡¾"
	                 + show_date + "¡¿   ShowTime¡¾"
	                 + show_time + "¡¿   Seat#¡¾"
	                 + showsData.getSeats() +"¡¿   Price¡¾"
	                 + (showsData.getPrice() * off_rate / 100)+"¡¿";
				
				mailData.setAdminname("Matt");
				mailData.setUsername(username);
				mailData.setContact_date("2012-11-05");
				mailData.setContent(result);
				mailData.setSubject("Ticket Confirm");
				
				createMail(mailData);
				
				
				if(errors.isEmpty()){
					rcForm.setResult(result);
		            forward = mapping.findForward("BTDone");
				}
				else{
		            super.saveErrors(request, errors);
		            forward = mapping.findForward("ActionError");
				}							
				
				return (forward);
	}
}
