package ritcinema.actions;


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
import ritcinema.datas.Movie_infoData;
import ritcinema.forms.RITCinemaForm;

public class CheckMovieListAction extends Action{
	
	private ActionErrors errors = null;
	
	 public List<Movie_infoData> getMovieList(Movie_infoData data) throws Exception{
	    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
	        String jndiServer = "iiop://localhost";
	        String ejbObject = "ejb/RITCinema";
	        
	        List<Movie_infoData> resultList = null;
	        try{
				
	            Properties mailProperties = new Properties();
	            mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
	            mailProperties.put(Context.PROVIDER_URL, jndiServer);             
	            Context context = new InitialContext( mailProperties );
	           
	            ritcinemaDAO mailProxy = (ritcinemaDAO) context.lookup( ejbObject );
	           
	            resultList = mailProxy.getMovieList(data);
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
				String movie_name = rcForm.getMovie_name();
				String actor = rcForm.getActor();
				
				Movie_infoData movie_infoData = new Movie_infoData();
				
				movie_infoData.setActor(actor);
				movie_infoData.setMovie_id(movie_id);
				movie_infoData.setMovie_name(movie_name);
				
				List<Movie_infoData> movieList = getMovieList(movie_infoData);
			
				if(errors.isEmpty()){
					rcForm.setMovieList(movieList);
		            forward = mapping.findForward("CMDone");
				}
				else{
		            super.saveErrors(request, errors);
		            forward = mapping.findForward("ActionError");
				}							
				
				return (forward);
	}
}
