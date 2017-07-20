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

import ritcinema.datas.UsersData;
import ritcinema.forms.RITCinemaForm;

public class UserLoginAction extends Action{
	
	private ActionErrors errors = null;
	
	public UsersData retrieveUser(UsersData data) throws Exception{
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://localhost";
        String ejbObject = "ejb/RITCinema";
        
        UsersData usersData = new UsersData();
        try{
			
            Properties mailProperties = new Properties();
            mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
            mailProperties.put(Context.PROVIDER_URL, jndiServer);             
            Context context = new InitialContext( mailProperties );
           
            ritcinemaDAO mailProxy = (ritcinemaDAO) context.lookup( ejbObject );
           
            usersData = mailProxy.retrieveUser(data);
   	     }
         catch (Exception e){
        	throw e;
         }	
         return usersData;
    }
	
	public ActionForward execute (	ActionMapping mapping,
														 ActionForm form,
														 HttpServletRequest request, 
														 HttpServletResponse response ) throws Exception {

				RITCinemaForm rcForm = (RITCinemaForm) form;
				ActionForward forward = new ActionForward();
				errors = new ActionErrors();

				String username = rcForm.getUsername();
				String password = rcForm.getPassword();
	
				UsersData usersData = new UsersData();
				usersData.setUsername(username);
				usersData = retrieveUser(usersData);
				
				
				if(errors.isEmpty()){
					if(password.equals(usersData.getPassword()))
		            forward = mapping.findForward("ULDone");
		            else{
		            	String result = "User Name or Password is WRONG!";
		            	rcForm.setResult(result);
		            	forward = mapping.findForward("ULFail");
		            }
				}
				else{
		            super.saveErrors(request, errors);
		            forward = mapping.findForward("ActionError");
				}							
				
				return (forward);
	}
}
