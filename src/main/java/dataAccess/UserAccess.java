package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class UserAccess extends RestRequest {
	public static int get(Integer userid) throws IOException, URISyntaxException {
		String JSONAdr = getAllOrOne(new URI(Constants.USER_SOURCE + userid + "/trainingsessioncount"));
		int count = mapper.readValue(JSONAdr, Integer.class);
		return count;
	}
}
