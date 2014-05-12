package com.example.inclass6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONException;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

public class JSONMovieParser extends AsyncTask<String, Void, ArrayList<Movie>>{
	
	
	MainActivity main;
	
	public JSONMovieParser(MainActivity mainActivity) {
		// TODO Auto-generated constructor stub
		this.main = mainActivity;
	}

		@Override
		protected ArrayList<Movie> doInBackground(String... params) {
			String urlString = params[0];
			try {
				URL url = new URL(urlString);			
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				con.connect();			
				int statusCode = con.getResponseCode();
				if (statusCode == HttpURLConnection.HTTP_OK) {				
					BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
					StringBuilder sb = new StringBuilder();
					String line = reader.readLine();
					while (line != null) {
						sb.append(line);
						line = reader.readLine();
					}
					// good
					ArrayList<Movie> movies = MoviesJSONParser.MoviesJSONParserUtil.parseMovies(sb.toString());
					return movies;
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null;
		}

		@Override
		protected void onPostExecute(ArrayList<Movie> result) {
			this.main.receiveMessages(result);
		//	}

		}	
	}

