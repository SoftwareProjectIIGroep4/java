package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import models.Employee;
import models.SurveyAnswer;
import models.SurveyQuestion;

public class SurveyAnswerAcces extends RestRequest {
	
	public static SurveyAnswer get(Integer surveyQuestionID) throws IOException, URISyntaxException {
		String JSONAdr = getAllOrOne(new URI(Constants.SURVEY_ANSWERS_SOURCE + surveyQuestionID));
		SurveyAnswer surveyQuestion= mapper.readValue(JSONAdr, SurveyAnswer.class);
		return surveyQuestion;
	}


public static HashMap<Integer, SurveyAnswer> getAllSurveyAnswers() throws IOException, URISyntaxException {
	String JSONAdr = getAllOrOne(new URI(Constants.SURVEY_ANSWERS_SOURCE));
	List<SurveyAnswer> surveyAnswers= mapper.readValue(JSONAdr, new TypeReference<List<SurveyAnswer>>() {
	});

	HashMap<Integer, SurveyAnswer> surveyAMap = new HashMap<Integer, SurveyAnswer>();

	for (SurveyAnswer surveyAnswer : surveyAnswers) {
		surveyAMap.put(surveyAnswer.getAnswerID(),surveyAnswer);
	}
	return surveyAMap;
}

public static SurveyAnswer add(SurveyAnswer surveyAnswer) throws IOException, URISyntaxException {
	String JSONSurveyAnswer = postObject(surveyAnswer, new URI(Constants.SURVEY_ANSWERS_SOURCE));
	return mapper.readValue(JSONSurveyAnswer, SurveyAnswer.class);
}
public static void update(SurveyAnswer surveyAnswer) throws URISyntaxException, IOException {
	putObject(surveyAnswer, new URI(Constants.SURVEY_ANSWERS_SOURCE + surveyAnswer.getAnswerID()));
}
public static SurveyQuestion remove(Integer id) throws URISyntaxException, IOException {
	String JSONSurveyQ = deleteObject(id, new URI(Constants.SURVEY_QUESTIONS_SOURCE + id));
	return mapper.readValue(JSONSurveyQ, SurveyQuestion.class);
}


public static HashMap<Integer, SurveyAnswer> getAnswersByQuestionID(Integer questionID) throws IOException, URISyntaxException {		
	String JSONEmps = getAllOrOne(new URI(Constants.SURVEY_QUESTIONS_SOURCE + questionID + "/question"));
	HashMap<Integer, SurveyAnswer> surverQs =  mapper.readValue(JSONEmps, new TypeReference<HashMap<Integer, SurveyAnswer>>() {
	});			
	return surverQs;
	}



}