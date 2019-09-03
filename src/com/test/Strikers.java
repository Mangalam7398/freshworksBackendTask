package com.test;

import org.codehaus.jackson.annotate.JsonProperty;

public class Strikers {
	@JsonProperty("name")
	private String name; 
	@JsonProperty("club")
	private String club;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	
}
