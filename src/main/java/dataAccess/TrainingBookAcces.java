package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import models.TrainingBooks;

public class TrainingBookAcces extends RestRequest {
	
	public static TrainingBooks get(Integer bookid) throws IOException, URISyntaxException {
		String JSONAdr = getAllOrOne(new URI(Constants.TRAINING_BOOKS_SOURCE + bookid));
		TrainingBooks trainingBooks = mapper.readValue(JSONAdr, TrainingBooks.class);
		return trainingBooks;
	}
	

	
	public static HashMap<Integer, TrainingBooks> getAll() throws IOException, URISyntaxException {
		String JSONAdr = getAllOrOne(new URI(Constants.TRAINING_BOOKS_SOURCE));
		List<TrainingBooks> trainingBooks = mapper.readValue(JSONAdr, new TypeReference<List<TrainingBooks>>() {
		});

		HashMap<Integer, TrainingBooks> traingingBooksMap = new HashMap<Integer, TrainingBooks>();

		for (TrainingBooks trainingBook : trainingBooks) {
			traingingBooksMap.put(trainingBook.getIsbn(), trainingBook);
		}
		return traingingBooksMap;
	}

	public static TrainingBooks add(TrainingBooks trainingBook) throws IOException, URISyntaxException {
		String JSONAdr = postObject(trainingBook, new URI(Constants.TRAINING_BOOKS_SOURCE));
		System.out.println(JSONAdr.toString());
		return mapper.readValue(JSONAdr, TrainingBooks.class);
	}

	public static void update(TrainingBooks trainingBook) throws URISyntaxException, IOException {
		putObject(trainingBook, new URI(Constants.TRAINING_BOOKS_SOURCE + trainingBook.getIsbn()));
	}

	public static TrainingBooks remove(Integer id) throws URISyntaxException, IOException {
		String JSONAdr = deleteObject(id, new URI(Constants.TRAINING_BOOKS_SOURCE + id));
		return mapper.readValue(JSONAdr, TrainingBooks.class);
	}
}
