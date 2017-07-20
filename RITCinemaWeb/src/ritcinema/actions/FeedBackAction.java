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
import ritcinema.datas.MailData;
import ritcinema.forms.RITCinemaForm;

public class FeedBackAction extends Action{
	
	private ActionErrors errors = null;
	
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
				
				String username = rcForm.getUsername();
				String content = rcForm.getContent();
	
				MailData mailData = new MailData();
			
				mailData.setAdminname("Matt");
				mailData.setUsername(username);
				mailData.setContact_date("2012-11-05");
				mailData.setContent(content);
				mailData.setSubject("Feedback");
				
				createMail(mailData);
				
				String result = "Your Feedback is Sent, Thank You!";
				
				if(errors.isEmpty()){
					rcForm.setResult(result);
		            forward = mapping.findForward("FBDone");
				}
				else{
		            super.saveErrors(request, errors);
		            forward = mapping.findForward("ActionError");
				}							
				
				return (forward);
	}
}
