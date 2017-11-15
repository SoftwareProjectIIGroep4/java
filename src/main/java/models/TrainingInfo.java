package models;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

import dataAccess.Cache;
import dataAccess.TrainingInfoAccess;

public class TrainingInfo {
	private int trainingId;	
	private String name;
	private String infoGeneral;
	private int numberOfDays;
	private String infoExam;
	private String infoPayment;
	private float price;
	
	public TrainingInfo() {
		super();
	}

	public TrainingInfo(String name, String infoGeneral, int numberOfDays, String infoExam, String infoPayment,
			float price) {
		super();
		this.name = name;
		this.infoGeneral = infoGeneral;
		this.numberOfDays = numberOfDays;
		this.infoExam = infoExam;
		this.infoPayment = infoPayment;
		this.price = price;
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
	}

	public int getTrainingId() {
		return trainingId;
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
			Cache.teacherCache.invalidate(trainingId);
		}
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
