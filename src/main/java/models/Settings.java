package models;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import dataAccess.SettingsAccess;
import dataAccess.Cache;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Settings {
	private int companyId;
	private String companyName;

	public Settings() {
		super();
	}

	public Settings(Settings settings) {
		this(settings.companyId, settings.companyName);
	}

	public Settings(int companyId, String companyName) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
	}

	public void save() throws URISyntaxException, IOException {
			SettingsAccess.update(this);
			Cache.settingsCache.put(1, this);
	}

	public void delete() throws URISyntaxException, IOException {
			Cache.addressCache.invalidate(1);
		
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Company Name: " + companyName + "\n");
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Settings o = (Settings) obj;
		return companyName == o.companyName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyName);
	}

}
