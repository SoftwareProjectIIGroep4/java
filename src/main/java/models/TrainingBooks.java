package models;

import java.io.IOException;
import java.net.URISyntaxException;

import dataAccess.AddressAccess;
import dataAccess.Cache;
import dataAccess.TrainingBookAcces;

public class TrainingBooks {
	private int trainingId;
	private int isbn;
	public TrainingBooks(int trainingId, int boekId) {
		super();
		this.trainingId = trainingId;
		this.isbn = boekId;
	}
	public TrainingBooks() {
		
	}
	public int getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int boekId) {
		this.isbn = boekId;
	}

	public void save() throws URISyntaxException, IOException {
		
			TrainingBookAcces.add(this);
			Cache.trainingBookCache.put(isbn, this);
		
	}
	public void delete() throws URISyntaxException, IOException {
		if (isbn != 0) {
			AddressAccess.remove(isbn);
			Cache.addressCache.invalidate(isbn);
		}
	}
}

