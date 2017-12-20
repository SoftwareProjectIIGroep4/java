package models;

public class UserCertificate {

	private Certificate certificate;
	private int userid;
	
	public UserCertificate(Certificate certificate, int userid) {
		this.certificate = certificate;
		this.userid = userid;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
	
	
}
