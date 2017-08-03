package com.example.demo.model;

import org.springframework.security.core.GrantedAuthority;

import io.ebean.annotation.DbEnumValue;

public enum UserRole implements GrantedAuthority {

	ADMIN,
	USER;

	@Override
	public String getAuthority() {
		return name();
	}

	@DbEnumValue
	public String getValue() {
		return name();
	}

}
