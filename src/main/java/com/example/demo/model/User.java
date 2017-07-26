package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User extends AbstractModel implements Comparable<User> {

	private String firstName;
	private String lastName;

	public User() {}

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }

	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }

	public String getName() {
		return String.format("%s %s", firstName, lastName);
	}

	@Override
	public String toString() {
		return getName();
	}

	public int compareTo(User o) {
		return getName().compareTo(o.getName());
	}

}
