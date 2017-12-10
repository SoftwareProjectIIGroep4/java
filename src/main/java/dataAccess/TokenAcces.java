package dataAccess;
import models.Token;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;




public class TokenAcces extends RestRequest {
	public static Token getToken(String userName, String userPass) throws IOException, URISyntaxException {
		String JSONtoken = postObject(new Token(),new URI(Constants.TOKEN_SOURCE+"/login"));
		return mapper.readValue(JSONtoken,Token.class );
		
	}
	
}
