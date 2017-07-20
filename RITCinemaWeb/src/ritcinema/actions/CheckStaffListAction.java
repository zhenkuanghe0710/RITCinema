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
import ritcinema.datas.FullStaffData;
import ritcinema.forms.RITCinemaForm;

public class CheckStaffListAction extends Action{
	
	private ActionErrors errors = null;
	
	public List<FullStaffData> getFullStaffList(FullStaffData data)
	throws Exception {
		String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
		String jndiServer = "iiop://localhost";
		String ejbObject = "ejb/RITCinema";

		List<FullStaffData> resultList = null;
		try{
	
			Properties mailProperties = new Properties();
			mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
			mailProperties.put(Context.PROVIDER_URL, jndiServer);             
			Context context = new InitialContext( mailProperties );
    
			ritcinemaDAO mailProxy = (ritcinemaDAO) context.lookup( ejbObject );
   
			resultList = mailProxy.getFullStaffList(data);
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
				
				String department = rcForm.getDepartment();
				String position = rcForm.getPosition();
				
				FullStaffData fullStaffData = new FullStaffData();
				
				fullStaffData.setDepartment(department);
				fullStaffData.setPosition(position);
				
				List<FullStaffData> fullstaffList = getFullStaffList(fullStaffData);
			
				if(errors.isEmpty()){
					rcForm.setFullstaffList(fullstaffList);
		            forward = mapping.findForward("CSLDone");
				}
				else{
		            super.saveErrors(request, errors);
		            forward = mapping.findForward("ActionError");
				}							
				
				return (forward);
	}
}
