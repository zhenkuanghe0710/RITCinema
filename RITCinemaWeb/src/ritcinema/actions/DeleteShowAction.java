package ritcinema.actions;


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

public class DeleteShowAction extends Action{
	
	private ActionErrors errors = null;
	
	 public void deleteShows(ShowsData data) throws Exception {
	    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
	        String jndiServer = "iiop://localhost";
	        String ejbObject = "ejb/RITCinema";
	        try{
				
	            Properties mailProperties = new Properties();
	            mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
	            mailProperties.put(Context.PROVIDER_URL, jndiServer);             
	            Context context = new InitialContext( mailProperties );
	           
	            ritcinemaDAO mailProxy = (ritcinemaDAO) context.lookup( ejbObject );
	           
	            mailProxy.deleteShows(data);
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
				
				ShowsData showsData = new ShowsData();
				
				showsData.setShow_id(show_id);
				
				deleteShows(showsData);
				
				String result = "Show Delete!";
			
				if(errors.isEmpty()){
					rcForm.setResult(result);
		            forward = mapping.findForward("DSDone");
				}
				else{
		            super.saveErrors(request, errors);
		            forward = mapping.findForward("ActionError");
				}							
				
				return (forward);
	}
}
