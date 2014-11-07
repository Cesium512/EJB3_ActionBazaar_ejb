package web.beans;

import java.util.Hashtable;

import javax.faces.application.ViewExpiredException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import negocio.UserAccountCreatorBean;
import negocio.UserAccountCreatorLocal;
import dto.BillingInfo_DTO;
import dto.BiographicalInfo_DTO;
import dto.LoginInfo_DTO;
import ejbExcepciones.WorkFlowException;

@ManagedBean
@SessionScoped
public class CreateAccountBean {

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String accountNumber;
	private String creditCardType;
	private String expiryDate;
	
	private LoginInfo_DTO logininfo;
	private BiographicalInfo_DTO biographicalinfo;
	private BillingInfo_DTO billinginfo;
	private UserAccountCreatorLocal accountService;
	
	public CreateAccountBean() {
	}
	
	@PostConstruct
	private void initialize(){
		
		accountService = initializeService();
		
	}
	
	public void addLoginInfo(){
		
		logininfo = new LoginInfo_DTO(username, password);
		accountService.addLoginInfo( logininfo );
		
	}
	
	public void addBiographicalInfo(){
		
		biographicalinfo = new BiographicalInfo_DTO(firstName, lastName);
		try {
			accountService.addBiographicalInfo( biographicalinfo );
		} catch (WorkFlowException e) {
			e.printStackTrace();
		}
		
	}
	
	public void addBillingInfo(){
		
		billinginfo = new BillingInfo_DTO(accountNumber, creditCardType, expiryDate);
		try {
			accountService.addBillingInfo(billinginfo);
		} catch (WorkFlowException e) {
			e.printStackTrace();
		}
		
	}
	
	public void confirmAccount(){
		
		try{
			
			accountService.createAccount();
			
//			final UserAccountCreatorLocal createAccountService = initializeService();
//			
//			createAccountService.addLoginInfo( logininfo );
//			createAccountService.addBiographicalInfo( biographicalinfo );
//			createAccountService.addBillingInfo( billinginfo );
//			createAccountService.createAccount();
			clean();
			
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			
			
		} catch (  ViewExpiredException e) {
			e.printStackTrace();
		}
	}
	
	public void cancel(){
		
		accountService.cancelAccountCreation();
		clean();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
	}
	
	@SuppressWarnings("unchecked")
	private static UserAccountCreatorLocal initializeService() {
	
	    try {
	    	
	    	@SuppressWarnings("rawtypes")
			final Hashtable jndiProperties = new Hashtable();
	    	jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	    	final Context context = new InitialContext(jndiProperties);
	    	final String appName="EJB3_ActionBazaar_ear";
	    	final String moduleName="EJB3_ActionBazaar_ejb";
	    	final String distinctName = "";
	    	final String beanName = UserAccountCreatorBean.class.getSimpleName();
	    	final String viewClassName = UserAccountCreatorLocal.class.getName();
	    	
	    	return (UserAccountCreatorLocal) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName + "?stateful");
	    	
	    	
		} catch (NamingException e) {

			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	private void clean(){
		
		this.username ="";
		this.password ="";
		this.firstName="";
		this.lastName= "";
		this.accountNumber="";
		this.creditCardType="";
		this.expiryDate="";
		
	}
	
}
