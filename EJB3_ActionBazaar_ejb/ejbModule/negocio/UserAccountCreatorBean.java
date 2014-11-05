package negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import dto.BillingInfo_DTO;
import dto.BiographicalInfo_DTO;
import dto.LoginInfo_DTO;
import ejbExcepciones.WorkFlowException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.sql.DataSource;

/**
 * Session Bean implementation class UserAccountCreatorBean
 */
@Stateful(mappedName = "UserAccountCreatorBean",name="UserAccountCreatorBean")
public class UserAccountCreatorBean implements UserAccountCreatorLocal {

	@Resource(name="java:jboss/datasources/ActionBazaarDB")
	private DataSource datasource;
	
	private Connection connection;
	private BiographicalInfo_DTO biographicalInfo;
	private BillingInfo_DTO billingInfo;
	private LoginInfo_DTO loginInfo;
	
	@PostConstruct
	@PostActivate
	public void openConnection(){
		try{
			connection = datasource.getConnection();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void addLoginInfo(LoginInfo_DTO loginInfo) {
		this.loginInfo = loginInfo;
	}
	
    /**
     * Default constructor. 
     */
    public UserAccountCreatorBean() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see UserAccountCreatorOper#addBiographicalInfo(BiographicalInfo_DTO)
     */
    public void addBiographicalInfo(BiographicalInfo_DTO biographicalInfo) throws WorkFlowException {
        
    	if ( this.loginInfo == null ){
    		throw new WorkFlowException("Login info must be set before biographical info");
    	}else{
    		this.biographicalInfo = biographicalInfo;
    	}
    }
    
	/**
     * @see UserAccountCreatorOper#addBillingInfo(BillingInfo_DTO)
     */
    public void addBillingInfo(BillingInfo_DTO billingInfo) throws WorkFlowException {
        
    	if ( this.biographicalInfo == null) {
    		throw new WorkFlowException("Biographical info must be set before Billing info");
    	} else  {
    		this.billingInfo = billingInfo;
    	}
    }
    
    @PrePassivate
    @PreDestroy
    public void cleanup(){
    	try{
    		connection.close();
    		connection = null;
    	} catch ( SQLException e ) {
    		e.printStackTrace();
    	}

    }
    
	/**
     * @see UserAccountCreatorOper#createAccount()
     */
    @Remove
    public void createAccount() {
    	try{
    		
    		Statement statement = connection.createStatement();
    		
    		String sql = "INSERT INTO Bidders ( username, password, firstname, " + 
    										  "lastname, accountnumber, creditCardType, expiryDate ) " +
    										  "VALUES (" + 
    										  "'" + this.loginInfo.getUsername() + "', '" + this.loginInfo.getPassword() + "', " +
    										  "'" + this.biographicalInfo.getFirstName() + "', '" + this.biographicalInfo.getLastName() + "', " +
    										  "'" + this.billingInfo.getAccountNumber() + "', '" + this.billingInfo.getCreditCardType() + "', '" + this.billingInfo.getExpiryDate() + "')" ;
    		statement.execute( sql );
    		statement.close();
    		
    	} catch ( SQLException e ){
    		e.printStackTrace();
    	}
    	
    }    
        
	/**
     * @see UserAccountCreatorOper#cancelAccount()
     */
    @Remove
    public void cancelAccountCreation() {
        
    	this.loginInfo = null;
    	this.biographicalInfo = null;
    	this.billingInfo = null;
    	
    }

}
