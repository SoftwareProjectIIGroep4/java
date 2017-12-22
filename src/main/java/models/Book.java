
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

	private long isbn;

	private String url;


		public Book(long isbn, String url) {

		super();
		this.isbn = isbn;
		this.url = url;
	}


		
		
		
		

		public long getIsbn() {

			return isbn;
		}

		public void setIsbn(int isbn) {
			this.isbn = isbn;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public Book() {
		}
		
		public Book(Book book) {
			
			this(book.isbn,book.url);	
			
		}

		
		
		public String toString() {
			StringBuilder sbr=new StringBuilder();
			sbr.append("bookID: "+isbn+'\n');
			
			sbr.append("Link: "+url+"\n");
			return sbr.toString();	
		} 
		
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			long result = 1;
			result = prime * result + isbn;
			result = prime * result + ((url == null) ? 0 : url.hashCode());
			return (int) result;

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
			if (isbn != other.isbn)
				return false;
			if (url == null) {
				if (other.url != null)
					return false;
			} else if (!url.equals(other.url))
				return false;
			return true;
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
		
		
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		

		
		
			

	

