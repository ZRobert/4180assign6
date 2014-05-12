//Robert Payne
//in class 6
package com.example.inclass6;

import java.util.ArrayList;

import com.example.inclass6.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	ArrayList<Movie> movies;
	ListView listView;
	ArrayAdapter<Movie> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) findViewById(R.id.ListView1);
		new JSONMovieParser(this).execute("http://api.rottentomatoes.com/api/public/v1.0/lists/movies/in_theaters.json?page_limit=25&page=1&country=us&apikey=zp3sq5yqde9hnszzr9sd78mt");

		listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
                     long id) {
                 Log.d("demo1", (String) ((TextView) view).getText() );
                 Intent i = new Intent(getBaseContext(),DetailsActivity.class);
                 i.putExtra("Name",movies.get(position).getName());
                 i.putExtra("Duration", movies.get(position).getDuration());
                 i.putExtra("Description", movies.get(position).getDescription());
                 startActivity(i);
}
		});
	} 
	public void receiveMessages(ArrayList<Movie> movies) {
		
		this.movies = new ArrayList<Movie>(movies);
		adapter = new ArrayAdapter<Movie>(this, android.R.layout.simple_list_item_1, android.R.id.text1, movies);
		Log.d("Rc'd MSG", this.movies.toString());

		listView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
