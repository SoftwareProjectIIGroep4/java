package models;

public class Login {
//DATAMEMBERS
	private String loginName;
	private String loginPass;
//METHODS
	
	
	public String getLoginName() {
		return loginName;
	}
	public Login(String loginName, String loginPass) {
	super();
	this.loginName = loginName;
	this.loginPass = loginPass;
}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPass() {
		return loginPass;
	}
	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	public boolean loginuser (String username) {
		String usersalt=
		
		return true;
	}
	

}
