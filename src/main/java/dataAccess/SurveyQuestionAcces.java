package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import models.SurveyQuestion;

public class SurveyQuestionAcces extends RestRequest {
	
	public static SurveyQuestion get(Integer surveyQuestionID) throws IOException, URISyntaxException {
		String JSONSurveyQ = getAllOrOne(new URI(Constants.SURVEY_QUESTIONS_SOURCE + surveyQuestionID));
		SurveyQuestion surveyQuestion= mapper.readValue(JSONSurveyQ, SurveyQuestion.class);
		return surveyQuestion;
	}


public static HashMap<Integer, SurveyQuestion> getAllSurveyQuestions() throws IOException, URISyntaxException {

	String JSONSurveyQ = getAllOrOne(new URI(Constants.SURVEY_QUESTIONS_SOURCE));
	List<SurveyQuestion> surveyQuestions= mapper.readValue(JSONSurveyQ, new TypeReference<List<SurveyQuestion>>() {
	});

	HashMap<Integer, SurveyQuestion> surveyQMap = new HashMap<Integer, SurveyQuestion>();

	for (SurveyQuestion surveyQuestion : surveyQuestions) {
		surveyQMap.put(surveyQuestion.getQuestionID(), surveyQuestion);
	}
	return surveyQMap;
}


public static SurveyQuestion add(SurveyQuestion surveyQuestion) throws IOException, URISyntaxException {
	String JSONSurveyQ = postObject(surveyQuestion, new URI(Constants.SURVEY_QUESTIONS_SOURCE));
	return mapper.readValue(JSONSurveyQ, SurveyQuestion.class);
}
public static void update(SurveyQuestion surveyQuestion) throws URISyntaxException, IOException {
	putObject(surveyQuestion, new URI(Constants.SURVEY_QUESTIONS_SOURCE + surveyQuestion.getQuestionID()));
}
public static SurveyQuestion remove(Integer id) throws URISyntaxException, IOException {
	String JSONSurveyA = deleteObject(id, new URI(Constants.SURVEY_ANSWERS_SOURCE + id));
	return mapper.readValue(JSONSurveyA, SurveyQuestion.class);
}
public static HashMap<Integer, SurveyQuestion> getQuestionsBySurveyID(Integer questionID) throws IOException, URISyntaxException {	
	// get all questions by survey ID
	String JSONEmps = getAllOrOne(new URI(Constants.SURVEY_QUESTIONS_SOURCE + questionID + "/survey"));
	HashMap<Integer, SurveyQuestion> surveyQ =  mapper.readValue(JSONEmps, new TypeReference<HashMap<Integer, SurveyQuestion>>() {
		
	});		
	return surveyQ;
	}
public static HashMap<Integer, SurveyQuestion> getQuestionsByAnswerID(Integer answerID) throws IOException, URISyntaxException {	
	// get all questions by survey ID
	String JSONEmps = getAllOrOne(new URI(Constants.SURVEY_ANSWERS_SOURCE + answerID + "/answers"));
	HashMap<Integer, SurveyQuestion> surveyQ =  mapper.readValue(JSONEmps, new TypeReference<HashMap<Integer, SurveyQuestion>>() {
		
	});		
	return surveyQ;
	}



}