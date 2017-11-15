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
		String JSONAdr = getAllOrOne(new URI(Constants.SURVEY_QUESTIONS_SOURCE + surveyQuestionID));
		SurveyQuestion surveyQuestion= mapper.readValue(JSONAdr, SurveyQuestion.class);
		return surveyQuestion;
	}


public static HashMap<Integer, SurveyQuestion> getAll() throws IOException, URISyntaxException {
	String JSONAdr = getAllOrOne(new URI(Constants.SURVEY_QUESTIONS_SOURCE));
	List<SurveyQuestion> surveyQuestions= mapper.readValue(JSONAdr, new TypeReference<List<SurveyQuestion>>() {
	});

	HashMap<Integer, SurveyQuestion> surveyQMap = new HashMap<Integer, SurveyQuestion>();

	for (SurveyQuestion surveyQuestion : surveyQuestions) {
		surveyQMap.put(surveyQuestion.getQuestionID(), surveyQuestion);
	}
	return surveyQMap;
}

}