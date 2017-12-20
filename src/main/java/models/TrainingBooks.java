package models;

public class TrainingBooks {
	private int trainingId;
	private int boekId;
	public TrainingBooks(int trainingId, int boekId) {
		super();
		this.trainingId = trainingId;
		this.boekId = boekId;
	}
	public int getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public int getBoekId() {
		return boekId;
	}
	public void setBoekId(int boekId) {
		this.boekId = boekId;
	}
	
}

