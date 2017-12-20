package models;
//https://gist.github.com/jtan189/3804290
import java.io.IOException;
import java.net.URISyntaxException;

import dataAccess.LoginAcces;
import javax.crypto.spec.PBEKeySpec;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.crypto.SecretKeyFactory;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import models.Token;
import models.UserLoginCred;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Login {
//DATAMEMBERS
		
	 private static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";
	 private static final int HASH_BYTES = 32;
	 private static final int PBKDF2_ITERATIONS = 1000;
	 private static final int ITERATION_INDEX = 0;
	 private static final int PBKDF2_INDEX = 2;
//METHODS
	public static Token authorizeAcces (String loginName,String loginPass) throws IOException, URISyntaxException {
		
		//get the salt
		String salt=null;
		try {
			 salt=LoginAcces.getSalt(loginName);

				if(salt=="404"||salt==null)
				{
					//username/pass does not exist or is wrong
					
					return null;
				}
				else {
					//username exist
					//has the salt and check with database
					
					String test =pepper(salt,loginPass);					
					UserLoginCred u = new UserLoginCred(loginName,test);					
					
					return dataAccess.TokenAcces.getToken(u);		
					
				}				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
	}
		return null;
	}
	
	static String pepper (String salt,String loginPass) {
		String hash=null;
		
		try {
			 hash = Base64.getEncoder().encodeToString(createHash(loginPass, salt));
			 
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hash;
		
	}
//code to hash (from external github)
	
private static byte[] pbkdf2(char[] password, byte[] salt, int iterations, int bytes)
	        throws NoSuchAlgorithmException, InvalidKeySpecException
	    {
	        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, bytes * 8);
	        SecretKeyFactory skf = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
	        return skf.generateSecret(spec).getEncoded();
	    }

 public static byte[] createHash(String password,String salt) throws NoSuchAlgorithmException, InvalidKeySpecException{
		 return createHash(password.toCharArray(), salt);
	 }
 
 public static byte[]  createHash(char[] password, String salt)
	        throws NoSuchAlgorithmException, InvalidKeySpecException
	    {
	 	
	      
	    	
	    	byte [] bSalt = Base64.getDecoder().decode(salt); 
	    	

	    	
	    	
	 

	        // Hash the password
	    	byte[] hash = pbkdf2(password, bSalt, PBKDF2_ITERATIONS, HASH_BYTES);
	    	return hash;
	        // format iterations:salt:hash
	       // return PBKDF2_ITERATIONS + ":" + toHex(bSalt) + ":" +  toHex(hash);
	    }
 
 
 private static String toHex(byte[] array)
 {
     BigInteger bi = new BigInteger(1, array);
     String hex = bi.toString(16);
     int paddingLength = (array.length * 2) - hex.length();
     if(paddingLength > 0) 
    	 
         return String.format("%0" + paddingLength + "d", 0) + hex;
     else
    	
         return hex;
     	
     
 }

 //code to compare pass 


 
 
 


}
	
	
	
	

