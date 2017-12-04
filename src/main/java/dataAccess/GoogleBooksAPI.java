//https://github.com/google/google-api-java-client-samples/blob/master/books-cmdline-sample/src/main/java/com/google/api/services/samples/books/cmdline/BooksSample.java

/*
 * Copyright (c) 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package dataAccess;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.util.ArrayList;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.BooksRequestInitializer;
import com.google.api.services.books.Books.Volumes.List;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;

import dataAccess.ClientCredentials;
import models.Book;
public class GoogleBooksAPI {
	// HERE BEGINS API
	
			// HERE BEGINS API DATAMEMBRS
			private static final String APPLICATION_NAME = "";
			 
				
			private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();
			 
			private static final NumberFormat PERCENT_FORMATTER = NumberFormat.getPercentInstance();
			 // HERE BEGINS API METHODS 
			public static ArrayList<Book> queryGoogleBooks(JsonFactory jsonFactory, String query) throws Exception {
			    ClientCredentials.errorIfNotSpecified();
			    
			    // Set up Books client.
			    final Books books = new Books.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, null)
			        .setApplicationName(APPLICATION_NAME)
			       .setGoogleClientRequestInitializer(new BooksRequestInitializer(ClientCredentials.API_KEY))
			        .build();
			    // Set query string and filter only Google eBooks.
			    System.out.println("Query: [" + query + "]");
			    List volumesList = books.volumes().list(query);
			    volumesList.setFilter("ebooks");
			    // Execute the query.
			    Volumes volumes = volumesList.execute();
			    if (volumes.getTotalItems() == 0 || volumes.getItems() == null) {
			      System.out.println("No matches found.");
			      return null;
			    }
			    // Output results.
			    ArrayList<Book> listBooks = new ArrayList();
			    for (Volume volume : volumes.getItems()) {
			      Book b = new Book();
			      Volume.VolumeInfo volumeInfo = volume.getVolumeInfo();
			      Volume.SaleInfo saleInfo = volume.getSaleInfo();
			      System.out.println("==========");
			      // Title.
			      System.out.println("Title: " + volumeInfo.getTitle());
			      // Author(s).
			      java.util.List<String> authors = volumeInfo.getAuthors();
			      if (authors != null && !authors.isEmpty()) {
			        System.out.print("Author(s): ");
			        for (int i = 0; i < authors.size(); ++i) {
			          System.out.print(authors.get(i));
			          b.addAuthor(authors.get(i));
			          if (i < authors.size() - 1) {
			            System.out.print(", ");
			            b.addAuthor(", ");
			          }
			        }
			        System.out.println();
			      }
			      // Description (if any).
			      if (volumeInfo.getDescription() != null && volumeInfo.getDescription().length() > 0) {
			        System.out.println("Description: " + volumeInfo.getDescription());
			      }
			      // Ratings (if any).
			      if (volumeInfo.getRatingsCount() != null && volumeInfo.getRatingsCount() > 0) {
			        int fullRating = (int) Math.round(volumeInfo.getAverageRating().doubleValue());
			        System.out.print("User Rating: ");
			        for (int i = 0; i < fullRating; ++i) {
			          System.out.print("*");
			        }
			        System.out.println(" (" + volumeInfo.getRatingsCount() + " rating(s))");
			      }
			      // Price (if any).
			      if (saleInfo != null && "FOR_SALE".equals(saleInfo.getSaleability())) {
			        double save = saleInfo.getListPrice().getAmount() - saleInfo.getRetailPrice().getAmount();
			        if (save > 0.0) {
			          System.out.print("List: " + CURRENCY_FORMATTER.format(saleInfo.getListPrice().getAmount())
			              + "  ");
			        }
			        System.out.print("Google eBooks Price: "
			            + CURRENCY_FORMATTER.format(saleInfo.getRetailPrice().getAmount()));
			        b.setPrice(saleInfo.getRetailPrice().getAmount());
			        if (save > 0.0) {
			          System.out.print("  You Save: " + CURRENCY_FORMATTER.format(save) + " ("
			              + PERCENT_FORMATTER.format(save / saleInfo.getListPrice().getAmount()) + ")");
			        }
			        System.out.println();
			      }
			      // Access status.
			      String accessViewStatus = volume.getAccessInfo().getAccessViewStatus();
			      String message = "Additional information about this book is available from Google eBooks at:";
			      if ("FULL_PUBLIC_DOMAIN".equals(accessViewStatus)) {
			        message = "This public domain book is available for free from Google eBooks at:";
			      } else if ("SAMPLE".equals(accessViewStatus)) {
			        message = "A preview of this book is available from Google eBooks at:";
			      }
			      System.out.println(message);
			      // Link to Google eBooks.
			      System.out.println(volumeInfo.getInfoLink());
			      b.setLink(volumeInfo.getInfoLink());
			      listBooks.add(b);
			    }
			    System.out.println("==========");
			    System.out.println(
			        volumes.getTotalItems() + " total results at http://books.google.com/ebooks?q="
			        + URLEncoder.encode(query, "UTF-8"));
			    return listBooks;
			  }
}
