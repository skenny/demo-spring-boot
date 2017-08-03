package com.example.demo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;

import io.ebean.Ebean;
import io.ebean.EbeanServer;

@Component
public class UserRepository {

	@Autowired private EbeanServer server;

	public User getById(long id) {
		return Ebean.find(User.class, id);
	}

	public User findByUsername(String username) {
		return server.find(User.class).where().eq("username", username).findOne();
	}

	public List<User> getAll() {
		return server.find(User.class).findList();
	}

}
