package models;
import models.SurveyAnswer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import dataAccess.Cache;
import dataAccess.SurveyAnswerAcces;
import dataAccess.SurveyQuestionAcces;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SurveyQuestion {

public enum typeQuestion {NUMERICAL, TEXTUAL,FEELING }
//DATAMEMBERS
	private int questionID,surveyID;
	private String question;
	private ArrayList<SurveyAnswer> answers;
	private typeQuestion qType;
//METHODS
	public SurveyQuestion(int questionID, int surveyID, String question, ArrayList<SurveyAnswer> answers) {
		super();
		this.questionID = questionID;
		this.surveyID = surveyID;
		this.question = question;
		this.answers = answers;
	}
	public SurveyQuestion(int questionID, int surveyID, String question) {
		super();
		this.questionID = questionID;
		this.surveyID = surveyID;
		this.question = question;
	}
	public SurveyQuestion() {
	
	}
	
	public int getSurveyID() {
		return surveyID;
	}

	public void setSurveyID(int surveyID) {
		this.surveyID = surveyID;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public typeQuestion getqType() {
		return qType;
	}

	public void setqType(typeQuestion qType) {
		this.qType = qType;
	}

	public SurveyQuestion(String question) {
		super();
		this.question = question;
	}
	
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public String getQuestions() {
		return question;
	}
	public void setQuestions(String questions) {
		this.question = questions;
	}
	public ArrayList<SurveyAnswer> getAnswers() {
		return answers;
	}
	public void setAnswers(ArrayList<SurveyAnswer> answers) {
		this.answers = answers;
	}
	public void addAnswer (SurveyAnswer answer) {
		this.answers.add(answer);
	}
	public void save() throws URISyntaxException, IOException {
		//  heeft al een ID, update het 
		if (questionID!= 0) {
			SurveyQuestionAcces.update(this);
			Cache.surveyQuestionCache.put(questionID, this);
		}
		//  heeft nog geen ID, maak het  aan
		else {
			questionID = (SurveyQuestionAcces.add(this).getQuestionID());
			Cache.surveyQuestionCache.put(questionID, this);
			
		}
	}
	public void delete() throws URISyntaxException, IOException {
		if (questionID != 0) {
			SurveyQuestionAcces.remove(questionID);
			Cache.surveyQuestionCache.invalidate(questionID);
		}
	}
	@Override
	public String toString() {
		StringBuilder sb =new StringBuilder();
		sb.append("vraag: "+questionID+"\n");
		sb.append("van survey: "+surveyID+"\n");
		sb.append("antwoord(en)"+"\n");
		for (int i=0;i<answers.size();i++) {
			sb.append(answers.get(i).toString()+"\n");
		}
		return sb.toString();
	}
}
