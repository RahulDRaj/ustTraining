package com.ust.flightreservation.entities;

import java.util.Set;

import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

public class Role extends AbstractEntity implements GrantedAuthority {
	private String name;
	@ManyToMany(mappedBy = "role")
	private Set<User> users;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}

}
