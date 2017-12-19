package models;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import dataAccess.Cache;
import dataAccess.TrainingSessionAccess;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrainingSession {	
	private int trainingSessionId;
	private int addressId;
	private int teacherId;
	private int trainingId;
	private Date date;
	private Time startHour;
	private Time endHour;
	private boolean cancelled;
	private int surveyId;
	
			
	
	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public TrainingSession() {
		super();		
	}

	public TrainingSession(int addressId, int teacherId, int trainingId, Date date, Time startHour, Time endHour,
			boolean cancelled,int surveyId) {
		super();
		this.addressId = addressId;
		this.teacherId = teacherId;
		this.trainingId = trainingId;
		this.date = date;
		this.startHour = startHour;
		this.endHour = endHour;
		this.cancelled = cancelled;
		this.surveyId=surveyId;
		
	}

	public TrainingSession(int trainingSessionId, int addressId, int teacherId, int trainingId, Date date,
			Time startHour, Time endHour, boolean cancelled) {
		super();
		this.trainingSessionId = trainingSessionId;
		this.addressId = addressId;
		this.teacherId = teacherId;
		this.trainingId = trainingId;
		this.date = date;
		this.startHour = startHour;
		this.endHour = endHour;
		this.cancelled = cancelled;
	}

	public void save() throws URISyntaxException, IOException {		
		if (trainingSessionId != 0) {
			TrainingSessionAccess.update(this);
			Cache.trainingSessionCache.put(trainingSessionId, this);
		}
		else {
			trainingSessionId = (TrainingSessionAccess.add(this).getTrainingSessionId());
			Cache.trainingSessionCache.put(trainingSessionId, this);
		}
	}

	public void delete() throws URISyntaxException, IOException {
		if (trainingSessionId != 0) {
			TrainingSessionAccess.remove(trainingSessionId);
			Cache.trainingSessionCache.invalidate(trainingSessionId);
		}
	}
	
	public static void delete(int id) throws URISyntaxException, IOException {
		if (id != 0) {
			TrainingSessionAccess.remove(id);
			Cache.trainingSessionCache.invalidate(id);
		}
	}
	
	
	public int getTrainingSessionId() {
		return trainingSessionId;
	}

	public void setTrainingSessionId(int trainingSessionId) {
		this.trainingSessionId = trainingSessionId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getStartHour() {
		return startHour;
	}

	public void setStartHour(Time startHour) {
		this.startHour = startHour;
	}

	public Time getEndHour() {
		return endHour;
	}

	public void setEndHour(Time endHour) {
		this.endHour = endHour;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCanceled(boolean cancelled) {
		this.cancelled = cancelled;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Training session ID: " + trainingSessionId + "\n");
		sb.append("Address ID: " + addressId + "\n");
		sb.append("Teacher ID: " + teacherId + "\n");
		sb.append("Training ID: " + trainingId + "\n");
		sb.append("Date: " + date + "\n");
		sb.append("Starts at: " + startHour + "\n");
		sb.append("Ends at: " + endHour + "\n");
		sb.append("Cancelled: " + cancelled + "\n");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addressId;
		result = prime * result + (cancelled ? 1231 : 1237);
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((endHour == null) ? 0 : endHour.hashCode());
		result = prime * result + ((startHour == null) ? 0 : startHour.hashCode());
		result = prime * result + teacherId;
		result = prime * result + trainingId;
		result = prime * result + trainingSessionId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainingSession other = (TrainingSession) obj;
		if (addressId != other.addressId)
			return false;
		if (cancelled != other.cancelled)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (endHour == null) {
			if (other.endHour != null)
				return false;
		} else if (!endHour.equals(other.endHour))
			return false;
		if (startHour == null) {
			if (other.startHour != null)
				return false;
		} else if (!startHour.equals(other.startHour))
			return false;
		if (teacherId != other.teacherId)
			return false;
		if (trainingId != other.trainingId)
			return false;
		if (trainingSessionId != other.trainingSessionId)
			return false;
		return true;
	}
	
		
}
