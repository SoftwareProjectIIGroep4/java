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
			      b.setUrl(volumeInfo.getInfoLink());
			      
			      	listBooks.add(b);
			   
			      }
			     
			    
			      
			     
			      
			      // Link  Google eBooks.
			      
			     
			    
			   
			    return listBooks;
			  }
}
