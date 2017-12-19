package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Token {
//DATAMEMBERS
	private int userID;
	private String token;
	
	private Token userToken;
//METHODS
	public Token(int userID, String token) {
		super();
		this.userID = userID;
		this.token = token;
	}
	public Token() {
		
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
