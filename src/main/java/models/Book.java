package models;


import java.util.Objects;
import java.net.URISyntaxException;
import java.io.IOException;

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
		
			
}
	

