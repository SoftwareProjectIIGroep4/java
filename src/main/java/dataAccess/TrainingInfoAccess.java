

package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
 
import models.TrainingInfo;

public class TrainingInfoAccess extends RestRequest {
	public static TrainingInfo get(Integer trainingId) throws IOException, URISyntaxException {
		String JSON = getAllOrOne(new URI(Constants.TRAINING_INFO_SOURCE + trainingId));
		TrainingInfo trainingInfo = mapper.readValue(JSON, TrainingInfo.class);
		return trainingInfo;
	}

	public static HashMap<Integer, TrainingInfo> getAll() throws IOException, URISyntaxException {
		String JSON = getAllOrOne(new URI(Constants.TRAINING_INFO_SOURCE));
		List<TrainingInfo> trainingInfos = mapper.readValue(JSON, new TypeReference<List<TrainingInfo>>() {
		});

		HashMap<Integer, TrainingInfo> trainingInfosMap = new HashMap<Integer, TrainingInfo>();

		for (TrainingInfo trainingInfo : trainingInfos) {
			trainingInfosMap.put(trainingInfo.getTrainingId(), trainingInfo);
		}
		return trainingInfosMap;
	}
	
	public static HashMap<Integer, TrainingInfo> getUserTrainingInfos(Integer userid) throws IOException, URISyntaxException {
		String JSON = getAllOrOne(new URI(Constants.USER_SOURCE + userid + "/traininginfos"));
		List<TrainingInfo> trainingInfos = mapper.readValue(JSON, new TypeReference<List<TrainingInfo>>() {
		});
		
		HashMap<Integer, TrainingInfo> trainingInfosMap = new HashMap<Integer, TrainingInfo>();
		
		for (TrainingInfo trainingInfo : trainingInfos) {
			trainingInfosMap.put(trainingInfo.getTrainingId(), trainingInfo);
		}
		return trainingInfosMap;
	}

	public static TrainingInfo add(TrainingInfo trainingInfo) throws IOException, URISyntaxException {
		String JSON = postObject(trainingInfo, new URI(Constants.TRAINING_INFO_SOURCE));
		return mapper.readValue(JSON, TrainingInfo.class);
	}

	public static void update(TrainingInfo trainingInfo) throws URISyntaxException, IOException {
		putObject(trainingInfo, new URI(Constants.TRAINING_INFO_SOURCE + trainingInfo.getTrainingId()));
	}

	public static TrainingInfo remove(Integer id) throws URISyntaxException, IOException {
		String JSON = deleteObject(id, new URI(Constants.TRAINING_INFO_SOURCE + id));
		return mapper.readValue(JSON, TrainingInfo.class);
	}
}
