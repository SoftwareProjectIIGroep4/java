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

		
		
			
}
	

