package dataAccess;
import models.Token;
import models.UserLoginCred;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;




public class TokenAcces extends RestRequest {
	public static Token getToken(UserLoginCred userLoginCred) throws IOException, URISyntaxException {
		String JSONtoken = postObject(userLoginCred,new URI(Constants.TOKEN_SOURCE+"login"));
		return mapper.readValue(JSONtoken,Token.class );
		
	}
	
}
