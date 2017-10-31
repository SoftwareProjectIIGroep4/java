package dataAccess;

import java.util.Date;

public class TrainingSession {
	private Date date;
	private Date startHour;
	private Date endHour;
	private boolean canceled; // UK: cancelled, US: canceled
	private Address address;
	
	public TrainingSession(Date date, Date startHour, Date endHour, boolean canceled, Address address) {
		super();
		this.date = date;
		this.startHour = startHour;
		this.endHour = endHour;
		this.canceled = canceled;
		this.address = address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getStartHour() {
		return startHour;
	}

	public void setStartHour(Date startHour) {
		this.startHour = startHour;
	}

	public Date getEndHour() {
		return endHour;
	}

	public void setEndHour(Date endHour) {
		this.endHour = endHour;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
