package ritcinema.actions;


import java.sql.Date;
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
import ritcinema.datas.BuyData;
import ritcinema.datas.FoodData;
import ritcinema.datas.MailData;
import ritcinema.forms.RITCinemaForm;

public class BuyFoodAction extends Action{
	
	private ActionErrors errors = null;
	
	public FoodData retrieveFood(FoodData data) throws Exception{
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://localhost";
        String ejbObject = "ejb/RITCinema";
        
        FoodData foodData = new FoodData();
        try{
			
            Properties mailProperties = new Properties();
            mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
            mailProperties.put(Context.PROVIDER_URL, jndiServer);             
            Context context = new InitialContext( mailProperties );
           
            ritcinemaDAO mailProxy = (ritcinemaDAO) context.lookup( ejbObject );
           
            foodData = mailProxy.retrieveFood(data);
   	     }
         catch (Exception e){
        	throw e;
         }	
         return foodData;
    }
	
	public void createOrder(BuyData data) throws Exception {
		String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
	    String jndiServer = "iiop://localhost";
	    String ejbObject = "ejb/RITCinema";
	    try{
			
	        Properties mailProperties = new Properties();
	        mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
	        mailProperties.put(Context.PROVIDER_URL, jndiServer);             
	        Context context = new InitialContext( mailProperties );
	       
	        ritcinemaDAO mailProxy = (ritcinemaDAO) context.lookup( ejbObject );
	       
	        mailProxy.createOrder(data);
	     }
	     catch (Exception e){
	    	throw e;
	     }				 
	}
	
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
				
				String food_id = rcForm.getFood_id();
				Date delivery_date = rcForm.getDelivery_date();
				String username = rcForm.getUsername();
				int quantity = rcForm.getQuantity();
				
					
				BuyData buyData = new BuyData();
				FoodData foodData = new FoodData();
				MailData mailData = new MailData();
				
				foodData.setFood_id(food_id);
				foodData = retrieveFood(foodData);
				float price = foodData.getPrice();
				float tprice = price * (float)quantity;
				String food_name = foodData.getFood_name();
				
				buyData.setFood_id(food_id);
				buyData.setDelivery_date(delivery_date);
				buyData.setQuantity(quantity);
				buyData.setTotal_price(tprice);
				buyData.setUsername(username);
	
				createOrder(buyData);
					
				//Set result
				String result = "Your Order:  FoodName¡¾"
	                 + food_name + "¡¿   Quantity¡¾" 
	                 + quantity + "¡¿   Delivery Date¡¾" 
	                 + delivery_date + "¡¿   Total price¡¾"
	                 + tprice +"¡¿";
			
				mailData.setAdminname("Matt");
				mailData.setUsername(username);
				mailData.setContact_date("2012-11-05");
				mailData.setContent(result);
				mailData.setSubject("Food Confirm");
				
				createMail(mailData);
				
				if(errors.isEmpty()){
					rcForm.setResult(result);
		            forward = mapping.findForward("BFDone");
				}
				else{
		            super.saveErrors(request, errors);
		            forward = mapping.findForward("ActionError");
				}							
				
				return (forward);
	}
}
