package persistencia;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1698132289791505093L;
	private String firstname;
	private String lastname;
	private String userId;
	private byte[] picture;
	private Date birthDate;
	
	public User() {
		
	}

	/**
	 * @param firstname
	 * @param lastname
	 * @param userId
	 */
	public User(String firstname, String lastname, String userId) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}
