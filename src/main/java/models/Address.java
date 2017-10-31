package dataAccess;

public class Address {
	private String administrativeArea;
	private String locality;
	private int PostalCode;
	private String streetAddress;
	private String Premise;
	private String Country;
	
	public Address(String administrativeArea, String locality, int postalCode, String streetAddress, String premise,
			String country) {
		super();
		this.administrativeArea = administrativeArea;
		this.locality = locality;
		PostalCode = postalCode;
		this.streetAddress = streetAddress;
		Premise = premise;
		Country = country;
	}

	public String getAdministrativeArea() {
		return administrativeArea;
	}

	public void setAdministrativeArea(String administrativeArea) {
		this.administrativeArea = administrativeArea;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public int getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(int postalCode) {
		PostalCode = postalCode;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPremise() {
		return Premise;
	}

	public void setPremise(String premise) {
		Premise = premise;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

}
