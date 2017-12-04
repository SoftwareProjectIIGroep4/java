package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import models.Survey;
import models.SurveyAnswer;

public class SurveyAcces extends RestRequest {
	
	public static Survey get(Integer surveyID) throws IOException, URISyntaxException {
		String JSONSu = getAllOrOne(new URI(Constants.SURVEY_SOURCE + surveyID));
		Survey survey= mapper.readValue(JSONSu, Survey.class);
		return survey;
	}

	public static Survey remove(Integer id) throws URISyntaxException, IOException {
		String JSONSu = deleteObject(id, new URI(Constants.SURVEY_SOURCE + id));
		return mapper.readValue(JSONSu, Survey.class);
	}

	public static void update(Survey survey) throws URISyntaxException, IOException {
		putObject(survey, new URI(Constants.SURVEY_SOURCE + survey.getSurveyID()));
	}
	public static HashMap<Integer, Survey> getAllSurveys() throws IOException, URISyntaxException {

		String JSONSurvey = getAllOrOne(new URI(Constants.SURVEY_SOURCE));
		List<Survey> surveys= mapper.readValue(JSONSurvey, new TypeReference<List<Survey>>() {
		});

		HashMap<Integer, Survey> surveyMap = new HashMap<Integer, Survey>();

		for (Survey survey : surveys) {
			surveyMap.put(survey.getSurveyID(), survey);
		}
		return surveyMap;
	}
	public static HashMap<Integer, Survey> getSurveyByQuestionID(Integer questionID) throws IOException, URISyntaxException {		
		String JSONEmps = getAllOrOne(new URI(Constants.SURVEY_QUESTIONS_SOURCE + questionID + "/survey"));
		HashMap<Integer, Survey> surveys =  mapper.readValue(JSONEmps, new TypeReference<HashMap<Integer, SurveyAnswer>>() {
		});			
		return surveys;
		}
	public static Survey add(Survey survey) throws IOException, URISyntaxException {
		String JSONSurvey = postObject(survey, new URI(Constants.SURVEY_SOURCE));
		return mapper.readValue(JSONSurvey, Survey.class);
	}
}
