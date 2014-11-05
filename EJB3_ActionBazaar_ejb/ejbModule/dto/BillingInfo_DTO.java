package dto;

import java.io.Serializable;

public class BillingInfo_DTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4824100634598368301L;
	protected String accountNumber;
	protected String creditCardType;
	protected String expiryDate;
	
	public BillingInfo_DTO() {

	}

	/**
	 * @param accountNumber
	 * @param creditCardType
	 * @param expiryDate
	 */
	public BillingInfo_DTO(String accountNumber, String creditCardType,
			String expiryDate) {
		super();
		this.accountNumber = accountNumber;
		this.creditCardType = creditCardType;
		this.expiryDate = expiryDate;
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

	
	
}
