package models;

public class TraingSurveys {
	private int surveyId;
	private int traingId;
public TraingSurveys(int surveyId, int traingId) {
		super();
		this.surveyId = surveyId;
		this.traingId = traingId;
	}
public TraingSurveys() {
	
}
public int getSurveyId() {
	return surveyId;
}
public void setSurveyId(int surveyId) {
	this.surveyId = surveyId;
}


}
