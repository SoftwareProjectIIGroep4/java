package models;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import dataAccess.Cache;
import dataAccess.TrainingInfoAccess;
import dataAccess.TrainingSessionAccess;
 
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrainingInfo {
	private int trainingId;	
	private String name;
	private String infoGeneral;
	private int numberOfDays;
	private String infoExam;
	private String infoPayment;
	private float price;
	private int SurveyId;
	private HashMap<Integer, TrainingSession> sessions;
			
	public TrainingInfo() {
		//super();
		//sessions = new HashMap<Integer, TrainingSession>();
	}
	

	public TrainingInfo(String name, String infoGeneral, int numberOfDays, String infoExam, String infoPayment,
			float price,int SurveyId) {
		super();
		this.name = name;
		this.infoGeneral = infoGeneral;
		this.numberOfDays = numberOfDays;
		this.infoExam = infoExam;
		this.infoPayment = infoPayment;
		this.price = price;
		this.SurveyId=SurveyId;
		sessions = new HashMap<Integer, TrainingSession>();
	}

	public int getSurveyId() {
		return SurveyId;
	}


	public void setSurveyId(int surveyId) {
		SurveyId = surveyId;
	}


	public TrainingInfo(int trainingId, String name, String infoGeneral, int numberOfDays, String infoExam,
			String infoPayment, float price) {
		super();
		this.trainingId = trainingId;
		this.name = name;
		this.infoGeneral = infoGeneral;
		this.numberOfDays = numberOfDays;
		this.infoExam = infoExam;
		this.infoPayment = infoPayment;
		this.price = price;
		sessions = new HashMap<Integer, TrainingSession>();
	}
	
	public static HashMap<Integer, TrainingInfo> getByUserId(int userid) throws IOException, URISyntaxException {
		return TrainingInfoAccess.getUserTrainingInfos(userid);
	}
	
	public void save() throws URISyntaxException, IOException {		
		if (trainingId != 0) {
			TrainingInfoAccess.update(this);
			Cache.trainingInfoCache.put(trainingId, this);
		}
		else {
			trainingId = (TrainingInfoAccess.add(this).getTrainingId());
			Cache.trainingInfoCache.put(trainingId, this);
		}
	}

	public void delete() throws URISyntaxException, IOException {
		if (trainingId != 0) {
			TrainingInfoAccess.remove(trainingId);
			Cache.trainingInfoCache.invalidate(trainingId);
		}
	}
	
	public static void delete(int id) throws URISyntaxException, IOException {
		if (id != 0) {
			TrainingInfoAccess.remove(id);
			Cache.trainingInfoCache.invalidate(id);
		}
	}
	
	public void addSession(TrainingSession session) {
		if (session.getTrainingSessionId() == 0) {
			try {
				session.save();
				sessions.put(session.getTrainingSessionId(), session);
			} catch (URISyntaxException | IOException e) {				
				e.printStackTrace();
			}			
		}
	}

	public void loadSessions() {
		try {
			sessions = TrainingSessionAccess.getByTrainingInfo(trainingId);
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfoGeneral() {
		return infoGeneral;
	}

	public void setInfoGeneral(String infoGeneral) {
		this.infoGeneral = infoGeneral;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public String getInfoExam() {
		return infoExam;
	}

	public void setInfoExam(String infoExam) {
		this.infoExam = infoExam;
	}

	public String getInfoPayment() {
		return infoPayment;
	}

	public void setInfoPayment(String infoPayment) {
		this.infoPayment = infoPayment;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public HashMap<Integer, TrainingSession> getSessions() {
		return sessions;
	}

	public void setSessions(HashMap<Integer, TrainingSession> sessions) {
		this.sessions = sessions;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Training ID: " + trainingId + "\n");
		sb.append("Name: " + name + "\n");
		sb.append("General info: " + infoGeneral + "\n");
		sb.append("Number of days: " + numberOfDays + "\n");
		sb.append("Exam info: " + infoExam + "\n");
		sb.append("Payment info: " + infoPayment + "\n");
		sb.append("Price: " + price + "\n");
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
		TrainingInfo o = (TrainingInfo) obj;
		return trainingId == o.trainingId && numberOfDays == o.numberOfDays && price == o.price
				&& Objects.equals(name, o.name) && Objects.equals(infoGeneral, o.infoGeneral)
				&& Objects.equals(infoExam, o.infoExam) && Objects.equals(infoPayment, o.infoPayment);
	}

	@Override
	public int hashCode() {
		return Objects.hash(trainingId, name, infoGeneral, numberOfDays, infoExam, infoPayment, price);
	}
}
