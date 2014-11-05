package dto;

import java.io.Serializable;

public class LoginInfo_DTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6563165875543413794L;
	private String username;
	private String password;

	public LoginInfo_DTO() {
	}

	/**
	 * @param username
	 * @param password
	 */
	public LoginInfo_DTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

}
