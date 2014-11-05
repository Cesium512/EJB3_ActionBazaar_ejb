package dto;

import java.io.Serializable;

public class BiographicalInfo_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3449039829818723319L;
	protected String firstName;
	protected String lastName;
	
	public BiographicalInfo_DTO() {

	}
	
	/**
	 * @param firstName
	 * @param lastName
	 */
	public BiographicalInfo_DTO(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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
	
}
