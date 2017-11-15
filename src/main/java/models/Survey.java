package models;
import java.util.ArrayList;


import models.SurveyQuestion;

public class Survey {
// DATAMEMBERS
	private int surverID;
	//private SurveyAnswer surveyAnswers;
	private ArrayList <SurveyQuestion> surveyQuestions;
//METHODS
	public Survey(int surverID, ArrayList<SurveyQuestion> surveyQuestions) {
		super();
		this.surverID = surverID;
		this.surveyQuestions = surveyQuestions;
	}
	public Survey(int surverID) {
		super();
		this.surverID = surverID;
	}
	public Survey(ArrayList<SurveyQuestion> surveyQuestions) {
		super();
		this.surveyQuestions = surveyQuestions;
	}
	public int getSurverID() {
		return surverID;
	}
	public void setSurverID(int surverID) {
		this.surverID = surverID;
	}
	public ArrayList<SurveyQuestion> getSurveyQuestions() {
		return surveyQuestions;
	}
	public void setSurveyQuestions(ArrayList<SurveyQuestion> surveyQuestions) {
		this.surveyQuestions = surveyQuestions;
	}
	public void addQuestion(SurveyQuestion question) {
		surveyQuestions.add(question);
	}
	
	
}