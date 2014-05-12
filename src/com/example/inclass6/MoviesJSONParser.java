package com.example.inclass6;

import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class MoviesJSONParser {
	static public class MoviesJSONParserUtil{

		
			static ArrayList<Movie> parseMovies(String jsonString) throws JSONException{
				ArrayList<Movie> movies = new ArrayList<Movie>();	
				JSONObject moviesJSONObject = new JSONObject(jsonString);
				
				JSONArray moviesJSONArray = moviesJSONObject.getJSONArray("movies");
				Log.d("Parse This", moviesJSONArray.toString());
				for(int i=0; i<moviesJSONArray.length(); i++){
					JSONObject movieJSONObject = moviesJSONArray.getJSONObject(i);
					Movie movie = new Movie(movieJSONObject);	
					movies.add(movie);
				}
				return movies;
			}
		}
	}

