package ritcinema.actions;


import java.sql.Date;
import java.sql.Time;
import java.util.List;
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
import ritcinema.datas.FullShowsData;
import ritcinema.forms.RITCinemaForm;

public class BookCheckShowsListAction extends Action{
	
	private ActionErrors errors = null;
	
	public List<FullShowsData> getFullShowsList(FullShowsData data) throws Exception {

		String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
		String jndiServer = "iiop://localhost";
		String ejbObject = "ejb/RITCinema";

		List<FullShowsData> resultList = null;
		try{
			
		    Properties mailProperties = new Properties();
		    mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
		    mailProperties.put(Context.PROVIDER_URL, jndiServer);             
		    Context context = new InitialContext( mailProperties );
		   
		    ritcinemaDAO mailProxy = (ritcinemaDAO) context.lookup( ejbObject );
		   
		    resultList = mailProxy.getFullShowsList(data);
		    }
		 catch (Exception e){
			throw e;
		 }	
		 return resultList;
}
	
	public ActionForward execute (	ActionMapping mapping,
														 ActionForm form,
														 HttpServletRequest request, 
														 HttpServletResponse response ) throws Exception {

				RITCinemaForm rcForm = (RITCinemaForm) form;
				ActionForward forward = new ActionForward();
				errors = new ActionErrors();
				
				String movie_id = rcForm.getMovie_id();
				String cinema_id = rcForm.getCinema_id();
				Date show_date = rcForm.getShow_date();
				Time show_time = rcForm.getShow_time();
				
				FullShowsData fullshowsData = new FullShowsData();
				
				fullshowsData.setMovie_id(movie_id);
				fullshowsData.setCinema_id(cinema_id);
				fullshowsData.setShow_date(show_date);
				fullshowsData.setShow_time(show_time);
				
				List<FullShowsData> fullshowsList = getFullShowsList(fullshowsData);
			
				if(errors.isEmpty()){
					rcForm.setFullshowsList(fullshowsList);
		            forward = mapping.findForward("BCSIDone");
				}
				else{
		            super.saveErrors(request, errors);
		            forward = mapping.findForward("ActionError");
				}							
				
				return (forward);
	}
}
