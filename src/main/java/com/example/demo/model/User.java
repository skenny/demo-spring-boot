package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.ebean.annotation.DbJson;

@Entity
@Table(name="users")
public class User extends AbstractModel implements Comparable<User> {

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private boolean enabled;

	@DbJson private List<UserRole> roles;

	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }

	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	public boolean isEnabled() { return enabled; }
	public void setEnabled(boolean enabled) { this.enabled = enabled; }

	public List<UserRole> getRoles() { return roles; }
	public void setRoles(List<UserRole> roles) { this.roles = roles; }

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

	public boolean hasRole(UserRole role) {
		return roles.contains(role);
	}

}
