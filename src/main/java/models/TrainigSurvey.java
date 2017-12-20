package models;

public class TrainigSurvey {
	private int surveyId;
	private int traingId;
public TrainigSurvey(int surveyId, int traingId) {
		super();
		this.surveyId = surveyId;
		this.traingId = traingId;
	}
public TrainigSurvey() {
	
}
public int getSurveyId() {
	return surveyId;
}
public void setSurveyId(int surveyId) {
	this.surveyId = surveyId;
}


}
