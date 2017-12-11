package dataAccess;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


import dataAccess.Constants;
import models.Login;
import models.UserToken;

public class LoginAcces extends RestRequest {
	
	
	public static String getSalt(String userLogin) throws IOException, URISyntaxException {
		String JSONAdr = getAllOrOne(new URI(Constants.USER_SOURCE +"/" + userLogin +"/salt"));
		String saltyString  = mapper.readValue(JSONAdr, String.class);
		return saltyString;
	}
	
	

}
