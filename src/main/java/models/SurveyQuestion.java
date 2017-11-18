package models;
import models.SurveyAnswer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import dataAccess.Cache;
import dataAccess.SurveyAnswerAcces;
import dataAccess.SurveyQuestionAcces;

public class SurveyQuestion {
//DATAMEMBERS
	private int questionID;
	private String questions;
	private ArrayList<SurveyAnswer> answers;
//METHODS
	public SurveyQuestion(int questionID, String questions) {
		super();
		this.questionID = questionID;
		this.questions = questions;
	}
	public SurveyQuestion(String question) {
		super();
		this.questions = question;
	}
	public SurveyQuestion(int questionID,String questions,ArrayList<SurveyAnswer> answers) {
		super();
		this.questionID = questionID;
		this.questions = questions;
		this.answers=answers;
	}
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
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
	@Override
	public String toString() {
		StringBuilder sb =new StringBuilder();
		sb.append("vraag: "+questionID+"\n");
		sb.append("antwoord(en)"+"\n");
		for (int i=0;i<answers.size();i++) {
			sb.append(answers.get(i).toString()+"\n");
		}
		return sb.toString();
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
	//TODO pushen naar DB
}
