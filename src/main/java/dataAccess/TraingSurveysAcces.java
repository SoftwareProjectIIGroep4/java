package dataAccess;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import models.Address;
import models.TrainigSurvey;
//TODO

public class TraingSurveysAcces extends RestRequest {
	public static TrainigSurvey get(TrainigSurvey traingSurveys) throws IOException, URISyntaxException {
		String JSONts = getAllOrOne(new URI(Constants.TRAINING_SURVEYS_SOURCE));
		TrainigSurvey NTraingSurvey = mapper.readValue(JSONts, TrainigSurvey.class);
		return NTraingSurvey;
	}
	

	public static HashMap<Integer, TrainigSurvey> getAll() throws IOException, URISyntaxException {
		String JSONts = getAllOrOne(new URI(Constants.TRAINING_SURVEYS_SOURCE));
		List<TrainigSurvey> traingSurveys = mapper.readValue(JSONts, new TypeReference<List<TrainigSurvey>>() {
		});

		HashMap<Integer, TrainigSurvey> traingSurveysMap = new HashMap<Integer, TrainigSurvey>();

		for (TrainigSurvey traingSurvey : traingSurveys) {
			traingSurveysMap.put(traingSurvey.getSurveyId(), traingSurvey);
		}
		return traingSurveysMap;
	}

	public static TrainigSurvey add(TrainigSurvey trainigSurvey) throws IOException, URISyntaxException {
		String JSONts = postObject(trainigSurvey, new URI(Constants.TRAINING_SURVEYS_SOURCE));
		return mapper.readValue(JSONts, TrainigSurvey.class);
	}

	public static void update(TrainigSurvey trainigSurvey) throws URISyntaxException, IOException {
		putObject(trainigSurvey, new URI(Constants.TRAINING_SURVEYS_SOURCE + trainigSurvey.getSurveyId()));
	}

	public static TrainigSurvey remove(Integer id) throws URISyntaxException, IOException {
		String JSONts = deleteObject(id, new URI(Constants.TRAINING_SURVEYS_SOURCE + id));
		return mapper.readValue(JSONts, TrainigSurvey.class);
	}
	public static TrainigSurvey getBySurveyId(Integer id) throws IOException, URISyntaxException {
		String JSONts = getAllOrOne(new URI(Constants.TRAINING_SURVEYS_SOURCE+"/"+id));
		TrainigSurvey NTraingSurvey = mapper.readValue(JSONts, TrainigSurvey.class);
		return NTraingSurvey;
	}
}
