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
import ritcinema.datas.PersonData;
import ritcinema.datas.PersonphoneData;
import ritcinema.datas.UsersData;
import ritcinema.forms.RITCinemaForm;

public class RegisterAction extends Action{
	
	private ActionErrors errors = null;
	
	public void createUser(UsersData data) throws Exception {
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://localhost";
        String ejbObject = "ejb/RITCinema";
        try{
			
            Properties mailProperties = new Properties();
            mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
            mailProperties.put(Context.PROVIDER_URL, jndiServer);             
            Context context = new InitialContext( mailProperties );
           
            ritcinemaDAO mailProxy = (ritcinemaDAO) context.lookup( ejbObject );
           
            mailProxy.createUser(data);
   	     }
         catch (Exception e){
        	throw e;
         }
    }
	
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
	
	public void createPersonphone(PersonphoneData data) throws Exception {
		String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://localhost";
        String ejbObject = "ejb/RITCinema";
        try{
			
            Properties mailProperties = new Properties();
            mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
            mailProperties.put(Context.PROVIDER_URL, jndiServer);             
            Context context = new InitialContext( mailProperties );
           
            ritcinemaDAO mailProxy = (ritcinemaDAO) context.lookup( ejbObject );
           
            mailProxy.createPersonphone(data);
   	     }
         catch (Exception e){
        	throw e;
         }
		
	}
	
	public void createPerson(PersonData data) throws Exception {
		String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://localhost";
        String ejbObject = "ejb/RITCinema";
        try{
			
            Properties mailProperties = new Properties();
            mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
            mailProperties.put(Context.PROVIDER_URL, jndiServer);             
            Context context = new InitialContext( mailProperties );
           
            ritcinemaDAO mailProxy = (ritcinemaDAO) context.lookup( ejbObject );
           
            mailProxy.createPerson(data);
   	     }
         catch (Exception e){
        	throw e;
         }
		
	}
	
	 public PersonData retrievePerson(PersonData data) throws Exception{
	    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
	        String jndiServer = "iiop://localhost";
	        String ejbObject = "ejb/RITCinema";
	        
	        PersonData personData = new PersonData();
	        try{
				
	            Properties mailProperties = new Properties();
	            mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
	            mailProperties.put(Context.PROVIDER_URL, jndiServer);             
	            Context context = new InitialContext( mailProperties );
	           
	            ritcinemaDAO mailProxy = (ritcinemaDAO) context.lookup( ejbObject );
	           
	            personData = mailProxy.retrievePerson(data);
	   	     }
	         catch (Exception e){
	        	throw e;
	         }	
	         return personData;
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
				int ssn = rcForm.getSsn();
				System.out.println(ssn);
				String person_name = rcForm.getPerson_name();
				String phone = rcForm.getPhone();
				String email = rcForm.getEmail();
				
				UsersData usersData = new UsersData();
				usersData.setSsn(ssn);
				
				PersonData personData = new PersonData();
				personData.setSsn(ssn);
				
				PersonphoneData personphoneData = new PersonphoneData();
				personphoneData.setSsn(ssn);
				
				
				
				if(errors.isEmpty()){
						
						personData.setEmail(email);
						personData.setSsn(ssn);
						personData.setPerson_name(person_name);
						createPerson(personData);
						
						personphoneData.setSsn(ssn);
						personphoneData.setPhone(phone);
						createPersonphone(personphoneData);
						
						usersData.setPassword(password);
						usersData.setSsn(ssn);
						usersData.setUsername(username);
						createUser(usersData);
						
						String result = "You are All Set, Enjoy!";
		            	rcForm.setResult(result);
						forward = mapping.findForward("RDone");
				}
				else{
		            super.saveErrors(request, errors);
		            forward = mapping.findForward("ActionError");
				}							
				
				return (forward);
	}
}
