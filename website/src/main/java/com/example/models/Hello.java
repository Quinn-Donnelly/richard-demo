package com.example.models;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Hello {
	@JsonProperty("msg")
	private String name;

	private Map<String, String> props;
	
	@JsonAnyGetter
	public Map<String, String> getProps() {
		return props;
	}
	
	public Hello() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hello(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HelloDelegate [name=" + name + "]";
	}
}
