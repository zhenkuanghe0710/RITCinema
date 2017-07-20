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

import ritcinema.datas.AdminData;
import ritcinema.forms.RITCinemaForm;

public class AdminLoginAction extends Action{
	
	private ActionErrors errors = null;
	
	public AdminData retrieveAdmin(AdminData data) throws Exception{
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://localhost";
        String ejbObject = "ejb/RITCinema";
        
        AdminData adminData = new AdminData();
        try{
			
            Properties mailProperties = new Properties();
            mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
            mailProperties.put(Context.PROVIDER_URL, jndiServer);             
            Context context = new InitialContext( mailProperties );
           
            ritcinemaDAO mailProxy = (ritcinemaDAO) context.lookup( ejbObject );
           
            adminData = mailProxy.retrieveAdmin(data);
   	     }
         catch (Exception e){
        	throw e;
         }	
         return adminData;
    }
	
	public ActionForward execute (	ActionMapping mapping,
														 ActionForm form,
														 HttpServletRequest request, 
														 HttpServletResponse response ) throws Exception {

				RITCinemaForm rcForm = (RITCinemaForm) form;
				ActionForward forward = new ActionForward();
				errors = new ActionErrors();

				String adminname = rcForm.getAdminname();
				String password = rcForm.getPassword();
	
				AdminData adminData = new AdminData();
				adminData.setAdminname(adminname);
				adminData = retrieveAdmin(adminData);
				
				
				if(errors.isEmpty()){
					if(password.equals(adminData.getPassword()))
		            forward = mapping.findForward("ALDone");
		            else{
		            	String result = "User Name or Password is WRONG!";
		            	rcForm.setResult(result);
		            	forward = mapping.findForward("ALFail");
		            }
				}
				else{
		            super.saveErrors(request, errors);
		            forward = mapping.findForward("ActionError");
				}							
				
				return (forward);
	}
}
