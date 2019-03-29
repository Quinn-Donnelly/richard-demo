package com.example.models;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonAnyGetter;


@Entity
public class Developer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;

	@Transient
	private Map<String, String> properties;
	
	@JsonAnyGetter
	private Map<String, String> getProperties() {
		return properties;
	}
	
	public Developer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Developer(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Developer [id=" + id + ", name=" + name + "]";
	}
}
