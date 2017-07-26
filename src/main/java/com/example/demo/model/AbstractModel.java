package com.example.demo.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import io.ebean.Model;

@MappedSuperclass
public abstract class AbstractModel extends Model {

	@Id protected Long id;

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

}
