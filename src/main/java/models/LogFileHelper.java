package models;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
//http://www.homeandlearn.co.uk/java/read_a_textfile_in_java.html

public class LogFileHelper {
//DATAMEMBERS
	private String user;
	private String actie;
	private String message;
	private String path;
	private boolean appendToFile;
	private Date date;
//METHODS
	public LogFileHelper(String user,String actie){
		date=new Date();
		this.message="de user: "+user+" heeft volgende actie uitgevoerd"+actie +"op " + date +" ";
		Save();
	}
	public LogFileHelper(String user,String actie,String path){
		date=new Date();
		this.message="de user: "+user+" heeft volgende actie uitgevoerd"+actie +"op " + date +" ";
		this.path=path;
		Save();
	}
	private boolean Save() {
		try {
			
			writeFile(path, true);
			System.out.println("file written to");
			writeToFile(message);
			return true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private void writeFile( String filePath , boolean appendValue ) {

		path = filePath;
		appendToFile = appendValue;

		}
	private void writeToFile( String textLine ) throws IOException {
		FileWriter write = new FileWriter( path , appendToFile);
		PrintWriter printLine = new PrintWriter(write);
		printLine.printf("%s"+"%n",textLine);
		// %s een string van onbekende lengte
		//%n een spatie
		printLine.close();
		

	}
}
