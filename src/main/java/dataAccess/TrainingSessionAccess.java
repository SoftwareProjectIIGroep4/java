package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import models.TrainingSession;

public class TrainingSessionAccess extends RestRequest {
	public static TrainingSession get(Integer trainingSessionId) throws IOException, URISyntaxException {
		String JSON = getAllOrOne(new URI(Constants.TRAINING_SESSION_SOURCE + trainingSessionId));
		TrainingSession trainingSession = mapper.readValue(JSON, TrainingSession.class);
		return trainingSession;
	}

	public static HashMap<Integer, TrainingSession> getAll() throws IOException, URISyntaxException {
		String JSON = getAllOrOne(new URI(Constants.TRAINING_SESSION_SOURCE));
		List<TrainingSession> trainingSessions = mapper.readValue(JSON, new TypeReference<List<TrainingSession>>() {
		});

		HashMap<Integer, TrainingSession> trainingSessionsMap = new HashMap<Integer, TrainingSession>();

		for (TrainingSession trainingSession : trainingSessions) {
			trainingSessionsMap.put(trainingSession.getTrainingSessionId(), trainingSession);
		}
		return trainingSessionsMap;
	}
	
	public static HashMap<Integer, TrainingSession> getByTrainingInfo(int trainingInfoId) throws IOException, URISyntaxException {
		String JSON = getAllOrOne(new URI(Constants.TRAINING_INFO_SOURCE + trainingInfoId + "/sessions"));
		List<TrainingSession> trainingSessions = mapper.readValue(JSON, new TypeReference<List<TrainingSession>>() {
		});

		HashMap<Integer, TrainingSession> trainingSessionsMap = new HashMap<Integer, TrainingSession>();

		for (TrainingSession trainingSession : trainingSessions) {
			trainingSessionsMap.put(trainingSession.getTrainingSessionId(), trainingSession);
		}
		return trainingSessionsMap;
	}

	public static TrainingSession add(TrainingSession trainingSession) throws IOException, URISyntaxException {
		String JSON = postObject(trainingSession, new URI(Constants.TRAINING_SESSION_SOURCE));
		return mapper.readValue(JSON, TrainingSession.class);
	}

	public static void update(TrainingSession trainingSession) throws URISyntaxException, IOException {
		putObject(trainingSession, new URI(Constants.TRAINING_SESSION_SOURCE + trainingSession.getTrainingSessionId()));
	}

	public static TrainingSession remove(Integer id) throws URISyntaxException, IOException {
		String JSON = deleteObject(id, new URI(Constants.TRAINING_SESSION_SOURCE + id));
		return mapper.readValue(JSON, TrainingSession.class);
	}
}
