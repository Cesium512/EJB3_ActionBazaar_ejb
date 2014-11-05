package negocio;

import dto.BillingInfo_DTO;
import dto.BiographicalInfo_DTO;
import dto.LoginInfo_DTO;
import ejbExcepciones.WorkFlowException;

public interface UserAccountCreatorOper {
	
	void addLoginInfo( LoginInfo_DTO loginInfo);

	void addBiographicalInfo( BiographicalInfo_DTO biographicalInfo ) throws WorkFlowException;
	
	void addBillingInfo( BillingInfo_DTO billingInfo ) throws WorkFlowException;
	
	void cancelAccountCreation();
	
	void createAccount();
	
}
