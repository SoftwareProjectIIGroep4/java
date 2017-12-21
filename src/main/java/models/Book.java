
package models;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.BooksRequestInitializer;
import com.google.api.services.books.Books.Volumes.List;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;

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
import dataAccess.ClientCredentials;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

		private int isbn;
		private String title;
		private ArrayList<String>authors  = new ArrayList<>();
		private String publisher;
		 private String url;
		private double price;
		
		
		public Book() {
		}
		
		public Book(Book book) {
			
			this(book.isbn,book.title,book.authors,book.publisher,book.price);	
			
		}

		public Book(int isbn, String title, ArrayList<String> authors, String publisher, double price) {
			super();
			this.isbn = isbn;
			this.title = title;
			this.authors = authors;
			this.publisher = publisher;
			this.price = price;
		}
		public String getLink() {
			return this.url;
		}
		public void setLink(String link) {
			this.url=link;
		}
		public ArrayList<String> getAuthors(){
			return this.authors;
		}
		public void addAuthor(String author) {
			this.authors.add(author);
		}


		public int getisbn() {
			return isbn;
		}

		public void setisbn(int isbn) {
			this.isbn = isbn;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		/*public String getAuthor() {
			return author;
		}


		public void setAuthor(String author) {
			this.author = author;
		}*/


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
			sbr.append("bookID: "+isbn+'\n');
			sbr.append("Title: "+title+'\n');
			for (int i=0;i<authors.size();i++) {
			sbr.append("Author(s)"+'\n');
			sbr.append(authors.get(i)+'\n');
			}
			sbr.append("Publisher: "+publisher+'\n');
			sbr.append("Price: "+price+'\n');
			sbr.append("Link: "+url+"\n");
			return sbr.toString();	
		} 
		
		
		
		public void save() throws URISyntaxException, IOException {
			if (isbn != 0) {
				BookAccess.update(this);
				Cache.bookCache.put(isbn, this);
			}
			else {
				isbn = (BookAccess.add(this).getisbn());
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
			if (authors == null) {
				if (other.authors != null)
					return false;
			} else if (!authors.equals(other.authors))
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
			result = prime * result + ((authors == null) ? 0 : authors.hashCode());
			result = prime * result + (int) (isbn ^ (isbn >>> 32));
			long temp;
			temp = Double.doubleToLongBits(price);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
			result = prime * result + ((title == null) ? 0 : title.hashCode());
			return result;
		}
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		

		
		
			

	

