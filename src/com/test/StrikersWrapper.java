package com.test;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class StrikersWrapper {
	@JsonProperty("strikers")
	private List<Strikers> strikers;

	public List<Strikers> getStrikers() {
		return strikers;
	}

	public void setStrikers(List<Strikers> strikers) {
		this.strikers = strikers;
	} 
	public void add(Strikers striker)
	{
		if(strikers == null)
		{
			strikers = new ArrayList<Strikers>();
		}
		strikers.add(striker);
	}
}
