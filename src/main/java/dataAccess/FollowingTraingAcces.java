package dataAccess;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import models.FollowingTraining;


public class FollowingTraingAcces extends RestRequest {
	
	public static FollowingTraining get(Integer id) throws IOException, URISyntaxException {
        String JSONFollowingt = getAllOrOne(new URI(Constants.FOLLOWING_TRAINING_SOURCE + id));
        FollowingTraining followingTraining = mapper.readValue(JSONFollowingt, FollowingTraining.class);
        return followingTraining;
    }
	
	public static HashMap<Integer, FollowingTraining> getAll() throws IOException, URISyntaxException {
		String JSONFollowingt = getAllOrOne(new URI(Constants.FOLLOWING_TRAINING_SOURCE));
		List<FollowingTraining> followingTrainings = mapper.readValue(JSONFollowingt, new TypeReference<List<FollowingTraining>>() {
		});

		HashMap<Integer, FollowingTraining> followingTrainingsMap = new HashMap<Integer, FollowingTraining>();

		for (FollowingTraining followingTraining : followingTrainings) {
			followingTrainingsMap.put(followingTraining.getTraingSessionId(), followingTraining);
		}
		return followingTrainingsMap;
	}

	public static FollowingTraining add(FollowingTraining followingTraining) throws IOException, URISyntaxException {
		String JSONFollowingt = postObject(followingTraining, new URI(Constants.FOLLOWING_TRAINING_SOURCE));
		return mapper.readValue(JSONFollowingt, FollowingTraining.class);
	}
	public static void update(FollowingTraining followingTraining) throws URISyntaxException, IOException {
		putObject(followingTraining, new URI(Constants.FOLLOWING_TRAINING_SOURCE + followingTraining.getTraingSessionId()));
	}
}
