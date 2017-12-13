package models;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Savepoint;
import java.util.Date;
//http://www.homeandlearn.co.uk/java/read_a_textfile_in_java.html


public class LogFileHelper {
//DATAMEMBERS
	private  static String path;
	private static boolean appendToFile;
//METHODS
	
	public LogFileHelper(String path){
		this.path=path;
		appendToFile = true;
	}
	public LogFileHelper(String path, Boolean append){
		this.path=path;
		appendToFile = append;
	}
	public static void log (String user, String actie) {
		Date date= new Date();
		String message="de user: "+user+" heeft volgende actie uitgevoerd "+actie +" op " + date +" ";
		save(message);
	}
	
	private static  boolean save(String message) {
		try {
			System.out.println("file written to");
			writeToFile(message);
			return true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private static void writeToFile( String textLine ) throws IOException {
		FileWriter write = new FileWriter( path , appendToFile);
		PrintWriter printLine = new PrintWriter(write);
		printLine.printf("%s"+"%n",textLine);
		// %s een string van onbekende lengte
		//%n een spatie
		printLine.close();
		

	}
}
