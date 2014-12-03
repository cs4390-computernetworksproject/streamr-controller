package com.example.streamr_controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import maps.MovieMap;

import com.example.streamr_controller.objects.MovieData;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class SearchActivity extends Activity {
	private ArrayAdapter<MovieData> mAdapter;
	private ArrayList<MovieData> mMovieList = new ArrayList<MovieData>();
	
	final String GET_MOVIES_URL = "http://192.168.1.127:8888/api/rest/movies_get_movies_by_name.php";
	
	// Views //////////
	ListView mListView;
	Button mSearchButton;
	EditText mEditText;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        
        // Set up the text field.
        mEditText = (EditText) findViewById(R.id.searchText);
        
        // Set up the search button.
        mSearchButton = (Button) findViewById(R.id.searchButton);
        mSearchButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				getMovies(mEditText.getText().toString());
			}
				
        });
        
        // MY GOD THIS IS DIRTY
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //mAdapter = new ArrayAdapter<MovieData>(SearchActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, mMovieList);
        mListView = (ListView) findViewById(R.id.list);
        
        // Assign adapter to mListView
        mListView.setAdapter(mAdapter); 
  
        // mListView Item Click Listener
        mListView.setOnItemClickListener(new OnItemClickListener() {
   
        	@Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {  
        		// Get the movie that was clicked.
            	MovieData clickedMovie = (MovieData) mListView.getItemAtPosition(position);
            	
            	// Create a new intent to start the player activity.
            	Intent intent = new Intent(SearchActivity.this, PlayerActivity.class);
            	intent.putExtra("movie", clickedMovie);
            	
            	// Start the activity
            	startActivity(intent);
            }
    	}); 
	}

    private void getMovies(String text) {    	
    	String jsonResult = performGET(GET_MOVIES_URL + "?name=" + text);
    	MovieMap movieMap = new MovieMap(jsonResult);
    	mMovieList = movieMap.getMovieData();
    	mListView.setAdapter(new ArrayAdapter<MovieData>(SearchActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, mMovieList));
	}
    
    /**
     * Perform a get request to the given URL.
     * 
     * @param resourceUrl The URL where the resource is located.
     * @return 
     */
    private String performGET(String resourceUrl) {
    	try {
            URL url = new URL(resourceUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            InputStream inStream = connection.getInputStream();
            if (connection.getResponseCode() == 204) {
                return "error";
            }
            BufferedReader input = new BufferedReader(new InputStreamReader(inStream));

            String line = "";
            String result = "";
            while ((line = input.readLine()) != null) {
                result += line;
            }

            return result;
        } catch (Exception ex) {
            System.err.println("MainActivity/" + ex);
            return ex.toString();
        }
    }
}
