package models;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import models.SurveyQuestion;

public class Survey {
	private int surveyID;
	private HashMap<Integer, SurveyQuestion> surveyQuestions;

	public Survey() {
		super();
	}
	
	public Survey(int surveyID) {
		super();
		this.surveyID = surveyID;
	}
	
	public Survey(int surveyID, HashMap<Integer, SurveyQuestion> surveyQuestions) {
		super();
		this.surveyID = surveyID;
		this.surveyQuestions = surveyQuestions;
	}
	
	public Survey(HashMap<Integer, SurveyQuestion> surveyQuestions) {
		super();
		this.surveyQuestions = surveyQuestions;
	}
	
	public int getSurveyID() {
		return surveyID;
	}
	
	public void setSurveyID(int surveyID) {
		this.surveyID = surveyID;
	}
	
	public HashMap<Integer, SurveyQuestion> getSurveyQuestions() {
		return surveyQuestions;
	}
	
	public void setSurveyQuestions(HashMap<Integer, SurveyQuestion> surveyQuestions) {
		this.surveyQuestions = surveyQuestions;
	}
	
	public void setSurveyQuestions(ArrayList<SurveyQuestion> surveyQuestions) {
		this.surveyQuestions = new HashMap<Integer, SurveyQuestion>();
		for (SurveyQuestion surveyQuestion : surveyQuestions) {
			this.surveyQuestions.put(surveyQuestion.getQuestionID(), surveyQuestion);
		}
	}
	
	public void addSurveyQuestion(SurveyQuestion question) {
		surveyQuestions.put(question.getQuestionID(), question);
	}
	
	public void deleteSurveyQuestion(int questionId) {
		surveyQuestions.remove(questionId);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + surveyID;
		result = prime * result + ((surveyQuestions == null) ? 0 : surveyQuestions.hashCode());
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
		Survey other = (Survey) obj;
		if (surveyID != other.surveyID)
			return false;
		if (surveyQuestions == null) {
			if (other.surveyQuestions != null)
				return false;
		} else if (!surveyQuestions.equals(other.surveyQuestions))
			return false;
		return true;
	}	
	
	
}