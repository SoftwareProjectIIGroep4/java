package models;

public class LogFileHelper {
//DATAMEMBERS
	private String user;
	private String actie;
	private String message;
//METHODS
	public LogFileHelper(String user,String actie){
		message="de user: "+user+" heeft volgende actie uitgevoerd"+actie;
	}
	//TODO wegschrijven naar de DB / naar een txt file
	public void writeToTxTFile() {
		
	}
}
