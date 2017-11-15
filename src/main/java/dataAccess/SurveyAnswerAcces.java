package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import models.SurveyAnswer;;

public class SurveyAnswerAcces extends RestRequest {
	
	public static SurveyAnswer get(Integer surveyQuestionID) throws IOException, URISyntaxException {
		String JSONAdr = getAllOrOne(new URI(Constants.SURVEY_ANSWERS_SOURCE + surveyQuestionID));
		SurveyAnswer surveyQuestion= mapper.readValue(JSONAdr, SurveyAnswer.class);
		return surveyQuestion;
	}


public static HashMap<Integer, SurveyAnswer> getAll() throws IOException, URISyntaxException {
	String JSONAdr = getAllOrOne(new URI(Constants.SURVEY_ANSWERS_SOURCE));
	List<SurveyAnswer> surveyAnswers= mapper.readValue(JSONAdr, new TypeReference<List<SurveyAnswer>>() {
	});

	HashMap<Integer, SurveyAnswer> surveyAMap = new HashMap<Integer, SurveyAnswer>();

	for (SurveyAnswer surveyAnswer : surveyAnswers) {
		surveyAMap.put(surveyAnswer.getAnswerID(),surveyAnswer);
	}
	return surveyAMap;
}

}
