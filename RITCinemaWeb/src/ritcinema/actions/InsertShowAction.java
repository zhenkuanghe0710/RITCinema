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
import ritcinema.datas.ShowsData;
import ritcinema.forms.RITCinemaForm;

public class InsertShowAction extends Action{
	
	private ActionErrors errors = null;
	
	public void createShows(ShowsData data) throws Exception {
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://localhost";
        String ejbObject = "ejb/RITCinema";
        try{
			
            Properties mailProperties = new Properties();
            mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
            mailProperties.put(Context.PROVIDER_URL, jndiServer);             
            Context context = new InitialContext( mailProperties );
           
            ritcinemaDAO mailProxy = (ritcinemaDAO) context.lookup( ejbObject );
           
            mailProxy.createShows(data);
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
				String cinema_id = rcForm.getCinema_id();
				String movie_id = rcForm.getMovie_id();
				int screen = rcForm.getScreen();
				int seats = rcForm.getSeats();
				Date show_date = rcForm.getShow_date();
				Time show_time = rcForm.getShow_time();
				int price = (int)rcForm.getPrice();
				
				ShowsData showsData = new ShowsData();
				
				showsData.setCinema_id(cinema_id);
				showsData.setMovie_id(movie_id);
				showsData.setPrice(price);
				showsData.setScreen(screen);
				showsData.setSeats(seats);
				showsData.setShow_date(show_date);
				showsData.setShow_id(show_id);
				showsData.setShow_time(show_time);
				
				createShows(showsData);
				
				String result = "Show Inserted!";
			
				if(errors.isEmpty()){
					rcForm.setResult(result);
		            forward = mapping.findForward("ISDone");
				}
				else{
		            super.saveErrors(request, errors);
		            forward = mapping.findForward("ActionError");
				}							
				
				return (forward);
	}
}
