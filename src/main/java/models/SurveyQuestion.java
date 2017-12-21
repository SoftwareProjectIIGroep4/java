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
	private String content;
	private ArrayList<SurveyAnswer> answers= new ArrayList<SurveyAnswer>();
	private typeQuestion qType;
//METHODS
	public SurveyQuestion(int questionID, int surveyID, String question, ArrayList<SurveyAnswer> answers) {
		super();
		this.questionID = questionID;
		this.surveyID = surveyID;
		this.content = question;
		this.answers = answers;
	}
	public SurveyQuestion(int questionID, int surveyID, String question) {
		super();
		this.questionID = questionID;
		this.surveyID = surveyID;
		this.content = question;
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
		return content;
	}

	public void setQuestions(String question) {
		this.content = question;
	}

	public typeQuestion getqType() {
		return qType;
	}

	public void setqType(typeQuestion qType) {
		this.qType = qType;
	}

	public SurveyQuestion(String question) {
		super();
		this.content = question;
	}
	
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
			questionID = SurveyQuestionAcces.add(this).getQuestionID();
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answers == null) ? 0 : answers.hashCode());
		result = prime * result + ((qType == null) ? 0 : qType.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + questionID;
		result = prime * result + surveyID;
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
		SurveyQuestion other = (SurveyQuestion) obj;
		if (answers == null) {
			if (other.answers != null)
				return false;
		} else if (!answers.equals(other.answers))
			return false;
		if (qType != other.qType)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (questionID != other.questionID)
			return false;
		if (surveyID != other.surveyID)
			return false;
		return true;
	}
}
