package com.example.models;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String genre;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Developer> devs;

	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Game(Long id, String name, String genre, List<Developer> devs) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.devs = devs;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<Developer> getDevs() {
		return devs;
	}

	public void setDevs(List<Developer> devs) {
		this.devs = devs;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", genre=" + genre + ", devs=" + devs + "]";
	}
}
