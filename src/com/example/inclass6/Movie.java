package com.example.inclass6;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Movie implements Serializable {
	String name;	//title
	String duration;	//runtime
	String description;	//synopsis
	public Movie(String name, String duration, String description) {
		super();
		this.name = name;
		this.duration = duration;
		this.description = description;
	}
	public Movie(JSONObject movieJSONObject) throws JSONException {
		// TODO Auto-generated constructor stub
		this.name = movieJSONObject.getString("title");
		this.duration = movieJSONObject.getString("runtime");
		this.description = movieJSONObject.getString("synopsis");
		Log.d("Created Movie", "Title: " + this.name + " Duration: " + this.duration + " description: " + this.description);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (this.name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
