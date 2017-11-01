package models;

import java.util.Objects;

import dataAccess.AddressAccess;

public class Address {
	private int addressId;
	private String administrativeArea;
	private String locality;
	private int postalCode;
	private String streetAddress;
	private String premise;
	private String country;	
	
	public Address() {
		super();
	}
	
	public Address(Address address) {
		this(address.addressId, address.administrativeArea, address.locality, address.postalCode, address.streetAddress, address.premise, address.country);
	}

	public Address(int addressId, String administrativeArea, String locality, int postalCode, String streetAddress, String premise,
			String country) {
		super();
		this.addressId = addressId;
		this.administrativeArea = administrativeArea;
		this.locality = locality;
		this.postalCode = postalCode;
		this.streetAddress = streetAddress;
		this.premise = premise;
		this.country = country;
	}
	
	public Address(String administrativeArea, String locality, int postalCode, String streetAddress, String premise,
			String country) {
		super();
		this.administrativeArea = administrativeArea;
		this.locality = locality;
		this.postalCode = postalCode;
		this.streetAddress = streetAddress;
		this.premise = premise;
		this.country = country;
	}
	
	public void saveAddress() {
		try {
			this.setAddressId(AddressAccess.addAddress(this).getAddressId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public int getAddressId() {
		return addressId;
	}
	
	public void setAddressId(int addressId) {
		this.addressId = addressId;
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
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPremise() {
		return premise;
	}

	public void setPremise(String premise) {
		this.premise = premise;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Address ID: " + addressId + "\n");
		sb.append("Administrative area: " + administrativeArea + "\n");
		sb.append("Locality: " + locality + "\n");
		sb.append("Postal code: " + postalCode + "\n");
		sb.append("Street address: " + streetAddress + "\n");
		sb.append("Premise: " + premise + "\n");
		sb.append("Country: " + country + "\n");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			System.out.println("EQUAL 1");
			return true;
		}
		if (obj == null) {
			System.out.println("NOT EQUAL 2");
			return false;
		}
		if (getClass() != obj.getClass()) {
			System.out.println("NOT EQUAL 3");
			return false;
		}
		Address o = (Address) obj;
		return addressId == o.addressId && 
				postalCode == o.postalCode &&
				Objects.equals(administrativeArea, o.administrativeArea) &&
				Objects.equals(locality, o.locality) &&
				Objects.equals(streetAddress, o.streetAddress) &&
				Objects.equals(premise, o.premise) &&
				Objects.equals(country, o.country);
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressId, administrativeArea, locality, postalCode, streetAddress, premise, country);
	}

}
