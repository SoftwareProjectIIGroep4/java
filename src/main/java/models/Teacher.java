package models;

import java.io.IOException;
import java.net.URISyntaxException;

import dataAccess.Cache;
import dataAccess.TeacherAccess;

public class Teacher {
	private int teacherId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
			
	public Teacher() {
		super();
	}

	public Teacher(String firstName, String lastName, String email, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public Teacher(int teacherId, String firstName, String lastName, String email, String phoneNumber) {
		super();
		this.teacherId = teacherId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}	

	public void save() throws URISyntaxException, IOException {		
		if (teacherId != 0) {
			TeacherAccess.update(this);
			Cache.teacherCache.put(teacherId, this);
		}
		else {
			teacherId = (TeacherAccess.add(this).getTeacherId());
			Cache.teacherCache.put(teacherId, this);
		}
	}

	public void delete() throws URISyntaxException, IOException {
		if (teacherId != 0) {
			TeacherAccess.remove(teacherId);
			Cache.teacherCache.invalidate(teacherId);
		}
	}
	
	public static void delete(int id) throws URISyntaxException, IOException {
		if (id != 0) {
			TeacherAccess.remove(id);
			Cache.teacherCache.invalidate(id);
		}
	}
	
	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Teacher ID: " + teacherId + "\n");
		sb.append("First name: " + firstName + "\n");
		sb.append("Last name: " + lastName + "\n");
		sb.append("E-mail address: " + email + "\n");
		sb.append("Phone number: " + phoneNumber + "\n");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + teacherId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (teacherId != other.teacherId)
			return false;
		return true;
	}

}