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
import ritcinema.datas.BooksData;
import ritcinema.forms.RITCinemaForm;

public class CheckMyTicketListAction extends Action{
	
	private ActionErrors errors = null;
	
	public List<BooksData> getTicketList(BooksData data) throws Exception {
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://localhost";
        String ejbObject = "ejb/RITCinema";
        
        List<BooksData> resultList = null;
        try{
			
            Properties mailProperties = new Properties();
            mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
            mailProperties.put(Context.PROVIDER_URL, jndiServer);             
            Context context = new InitialContext( mailProperties );
           
            ritcinemaDAO mailProxy = (ritcinemaDAO) context.lookup( ejbObject );
           
            resultList = mailProxy.getTicketList(data);
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
				
				String username = rcForm.getUsername();
				
				BooksData booksData = new BooksData();
				
				booksData.setUsername(username);
				
				List<BooksData> ticketList = getTicketList(booksData);
			
				if(errors.isEmpty()){
					rcForm.setBooksList(ticketList);
		            forward = mapping.findForward("CMTDone");
				}
				else{
		            super.saveErrors(request, errors);
		            forward = mapping.findForward("ActionError");
				}							
				
				return (forward);
	}
}
