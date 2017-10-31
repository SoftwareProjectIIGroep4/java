package models;

import java.util.Map;

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

}
