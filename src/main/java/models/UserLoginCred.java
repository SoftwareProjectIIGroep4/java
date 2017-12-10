package models;

public class UserLoginCred {
	
	private String userName;
	private String userpass;
	public UserLoginCred(String userName, String userpass) {
		this.userName = userName;
		this.userpass = userpass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	
}
