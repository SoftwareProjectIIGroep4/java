package models;


import java.util.Objects;
import java.net.URISyntaxException;
import java.io.IOException;

//SOURCE: https://github.com/google/google-api-java-client-samples/blob/master/books-cmdline-sample/src/main/java/com/google/api/services/samples/books/cmdline/BooksSample.java

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.BooksRequestInitializer;
import com.google.api.services.books.Books.Volumes.List;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.NumberFormat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL; 


import dataAccess.BookAccess;
import dataAccess.Cache;

public class Book {

		private long isbn;
		private String title;
		private String author;
		private String publisher;
		private double price;
		
		
		public Book() {
			super();
		}
		
		public Book(Book book) {
			
			this(book.isbn,book.title,book.author,book.publisher,book.price);	
			
		}

		public Book(long isbn, String title, String author, String publisher, double price) {
			super();
			this.isbn = isbn;
			this.title = title;
			this.author = author;
			this.publisher = publisher;
			this.price = price;
		}


		public long getIsbn() {
			return isbn;
		}

		public void setIsbn(long isbn) {
			this.isbn = isbn;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getAuthor() {
			return author;
		}


		public void setAuthor(String author) {
			this.author = author;
		}


		public String getPublisher() {
			return publisher;
		}


		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}

		
		public double getPrice() {
			return price;
		}


		public void setPrice(double price) {
			this.price = price;
		}

		
		public String toString() {
			StringBuilder sbr=new StringBuilder();
			sbr.append("ISBN: "+isbn+'\n');
			sbr.append("Title: "+title+'\n');
			sbr.append("Author: "+author+'\n');
			sbr.append("Publisher: "+publisher+'\n');
			sbr.append("Price: "+price+'\n');
			return sbr.toString();	
		}
		
		
		public void save() throws URISyntaxException, IOException {
			if (isbn != 0) {
				BookAccess.update(this);
				Cache.bookCache.put(isbn, this);
			}
			else {
				isbn = (BookAccess.add(this).getIsbn());
				Cache.bookCache.put(isbn, this);
			}
		}
		
		
		public void delete() throws URISyntaxException, IOException {
			if (isbn != 0) {
				BookAccess.remove(isbn);
				Cache.bookCache.invalidate(isbn);
			}
		}
		
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Book other = (Book) obj;
			if (author == null) {
				if (other.author != null)
					return false;
			} else if (!author.equals(other.author))
				return false;
			if (isbn != other.isbn)
				return false;
			if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
				return false;
			if (publisher == null) {
				if (other.publisher != null)
					return false;
			} else if (!publisher.equals(other.publisher))
				return false;
			if (title == null) {
				if (other.title != null)
					return false;
			} else if (!title.equals(other.title))
				return false;
			return true;
		}
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((author == null) ? 0 : author.hashCode());
			result = prime * result + (int) (isbn ^ (isbn >>> 32));
			long temp;
			temp = Double.doubleToLongBits(price);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
			result = prime * result + ((title == null) ? 0 : title.hashCode());
			return result;
		}
		
	    //SOURCE: http://chillyfacts.com/java-send-http-getpost-request-and-read-json-response/
			   
		public static void Bookcall() throws Exception {
		     String url = "https://www.googleapis.com/books/v1/volumes?q=HarryPotter";
		     URL obj = new URL(url);
		     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		     // optional default is GET
		     con.setRequestMethod("GET");
		     //add request header
		     con.setRequestProperty("User-Agent", "Mozilla/5.0");
		     int responseCode = con.getResponseCode();
		     System.out.println("\nSending 'GET' request to URL : " + url);
		     System.out.println("Response Code : " + responseCode);
		     BufferedReader in = new BufferedReader(
		             new InputStreamReader(con.getInputStream()));
		     String inputLine;
		     StringBuffer response = new StringBuffer();
		     while ((inputLine = in.readLine()) != null) {
		     	response.append(inputLine);
		     }
		     in.close();
		     //print in String
		     System.out.println(response.toString());
		     //Read JSON response and print
		     System.out.println("result after Reading JSON Response");
		    /* System.out.println("statusCode- "+myResponse.getString("statusCode"));
		     System.out.println("statusMessage- "+myResponse.getString("statusMessage"));
		     System.out.println("ipAddress- "+myResponse.getString("ipAddress"));
		     System.out.println("countryCode- "+myResponse.getString("countryCode"));
		     System.out.println("countryName- "+myResponse.getString("countryName"));
		     System.out.println("regionName- "+myResponse.getString("regionName"));
		     System.out.println("cityName- "+myResponse.getString("cityName"));
		     System.out.println("zipCode- "+myResponse.getString("zipCode"));
		     System.out.println("latitude- "+myResponse.getString("latitude"));
		     System.out.println("longitude- "+myResponse.getString("longitude"));
		     System.out.println("timeZone- "+myResponse.getString("timeZone"));  */
		   }
			public static void main(String[] args) {
		     try {
		         Bookcall();
		        } catch (Exception e) {
		         e.printStackTrace();
		       }
		     }
			   
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		

		
		
			

	

