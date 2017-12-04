package models;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.management.openmbean.OpenDataException;

import dataAccess.AddressAccess;
import dataAccess.Cache;
import dataAccess.SurveyAnswerAcces;;
public class SurveyAnswer {
//DATAMEMBRS
	private int AnswerID,questionID,userID;
	private String answer;
	
	
//METHODS
	public SurveyAnswer(int answerID, int questionID, int userID, String answer) {
		super();
		AnswerID = answerID;
		this.questionID = questionID;
		this.userID = userID;
		this.answer = answer;
	}
	
	public SurveyAnswer( String answer) {
		//gebruiken voor antwoorden met textuele value
		super();
		this.answer = answer;
	}
	
	public void save() throws URISyntaxException, IOException {
		//  heeft al een ID, update het 
		if (AnswerID!= 0) {
			SurveyAnswerAcces.update(this);
			Cache.surveyAnswerCache.put(AnswerID, this);
		}
		//  heeft nog geen ID, maak het  aan
		else {
			AnswerID = (SurveyAnswerAcces.add(this).getAnswerID());
			Cache.surveyAnswerCache.put(AnswerID, this);
		}
	}
	public void delete() throws URISyntaxException, IOException {
		if (AnswerID != 0) {
			SurveyAnswerAcces.remove(AnswerID);
			Cache.surveyAnswerCache.invalidate(AnswerID);
		}
	}
	
	public int getAnswerID() {
		return AnswerID;
	}
	public void setAnswerID(int answerID) {
		AnswerID = answerID;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
			sb.append("antwoord: "+answer+" op vraag: "+questionID+" van user: "+userID+"/n");
		return sb.toString();
	}

	
	
	
	
}
