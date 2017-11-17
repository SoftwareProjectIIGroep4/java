package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import models.Survey;
import models.SurveyQuestion;

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
		putObject(survey, new URI(Constants.SURVEY_SOURCE + survey.getSurverID()));
	}
}
