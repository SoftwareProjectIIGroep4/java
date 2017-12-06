package dataAccess;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


import dataAccess.Constants;
import models.Login;
import models.UserToken;

public class LoginAcces extends RestRequest {
	
	public static UserToken getUserToken(Login login) throws IOException, URISyntaxException {
		String JSONAdr = postObject(login, new URI(Constants.TOKEN_SOURCE));
		return mapper.readValue(JSONAdr, UserToken.class);
	}
	public static String getSalt(String userLogin) throws IOException, URISyntaxException {
		String JSONAdr = getAllOrOne(new URI(Constants.USER_SOURCE + userLogin));
		String saltyString  = mapper.readValue(JSONAdr, String.class);
		return saltyString;
	}
	

}
