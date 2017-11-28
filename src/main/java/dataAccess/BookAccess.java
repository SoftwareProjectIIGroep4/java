package dataAccess;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
//import java.net.URL;
import java.util.HashMap;
import java.util.List;

/*import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;*/


import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;


/*import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLConnection;*/


import models.Book;


public class BookAccess extends RestRequest {
		
		
		//Get all books
		public static HashMap<Long, Book> getAll() throws IOException, URISyntaxException {
	
				String JSONBooks = getAllOrOne(new URI(Constants.BOOK_SOURCE));
				List<Book> books = mapper.readValue(JSONBooks, new TypeReference<List<Book>>(){});

				HashMap<Long, Book> bookMap = new HashMap<Long, Book>();

				for (Book book : books) {
					bookMap.put(book.getIsbn(), book);
				}
				return bookMap;			
		}
		
		
		public static Book get(Long isbn) throws IOException, URISyntaxException {
			String JSONBooks = getAllOrOne(new URI(Constants.BOOK_SOURCE + isbn));
			Book book = mapper.readValue(JSONBooks, Book.class);
			return book;
		}
		
	    
	    public static Book add(Book book) throws IOException, URISyntaxException {
			String JSONBooks = postObject(book, new URI(Constants.BOOK_SOURCE));
			return mapper.readValue(JSONBooks, Book.class);
		}

		public static void update(Book book) throws URISyntaxException, IOException {
			putObject(book, new URI(Constants.BOOK_SOURCE + book.getIsbn()));
		}

		public static Book remove(Long id) throws URISyntaxException, IOException {
			String JSONBooks = deleteObject(id, new URI(Constants.BOOK_SOURCE + id));
			return mapper.readValue(JSONBooks, Book.class);
		}
		
		/*Get a book by title
		public static Book getBookByTitle(String title) {
			
			try {
				String JSONBooks = getBooks(null,title,new URL(rawSource+"q"));
				return mapper.readValue(JSONBooks, Book.class);
				
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			
		}*/
	    
		
		/*private static String getBooks(Long isbn,String title,URL source) throws Exception{
			CloseableHttpClient httpclient = HttpClients.createDefault();
			
			try {
				HttpGet httpget = null;
				if(isbn == null && title == null) {
					httpget=new HttpGet(source.toString());
				}
				else if (isbn != null) {
					httpget=new HttpGet(source.toString()+isbn);
				}
				else {
					httpget = new HttpGet(source.toString()+title);
				}
				System.out.println("Executing request "+ httpget.getRequestLine());
				
				//create a response handler
				ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
					
					public String handleResponse(final HttpResponse response) throws ClientProtocolException,IOException{
						
						int status = response.getStatusLine().getStatusCode();
						if(status>=200&&status<300) {
							HttpEntity entity=response.getEntity();
							return entity != null ? EntityUtils.toString(entity):null;
						}else {
							throw new ClientProtocolException("Unexpected response status: "+status);
						}
					}
					
				};
				String responseBody = httpclient.execute(httpget, responseHandler);
	            System.out.println("----------------------------------------");
	            System.out.println(responseBody);                   
	            return responseBody;
				
			} catch (IOException e) {
				System.out.println("Can't connect to the dataservice. It is either offline, or you need to run it locally.");
	        	return null;
			}
			
		finally {
			httpclient.close();
			}	
		}*/
}
