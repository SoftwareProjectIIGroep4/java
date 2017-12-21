package models;

import java.io.IOException;
import java.net.URISyntaxException;

import dataAccess.AddressAccess;
import dataAccess.Cache;
import dataAccess.TrainingBookAcces;

public class TrainingBooks {
	private int trainingId;
	private int boekId;
	public TrainingBooks(int trainingId, int boekId) {
		super();
		this.trainingId = trainingId;
		this.boekId = boekId;
	}
	public TrainingBooks() {
		
	}
	public int getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public int getBoekId() {
		return boekId;
	}
	public void setBoekId(int boekId) {
		this.boekId = boekId;
	}

	public void save() throws URISyntaxException, IOException {
		// Address heeft al een ID, update het address
		if (boekId != 0) {
			TrainingBookAcces.update(this);
			//Cache.put(boekId, this);
		}
		// Address heeft nog geen ID, maak het address aan
		else {
			boekId = TrainingBookAcces.add(this).getBoekId();
			Cache.trainingBookCache.put(boekId, this);
		}
	}
	public void delete() throws URISyntaxException, IOException {
		if (boekId != 0) {
			AddressAccess.remove(boekId);
			Cache.addressCache.invalidate(boekId);
		}
	}
}

