package maps;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import com.example.streamr_controller.objects.MovieData;
import com.google.gson.Gson;

public class MovieMap {
	private ArrayList<MovieData> mMovieList = new ArrayList<MovieData>();
	
	/**
     * Constructor. 
     * 
     * @param jsonResult Result from API call. Used directly to populate the ArrayList.
     */
    public MovieMap(String jsonResult) {
        
        try {
            JSONArray jsonArray = new JSONArray(jsonResult);
            if (jsonArray.length() > 0) {
                Gson gson = new Gson();
                for (int i = 0; i < jsonArray.length(); i++) {
                    MovieData movie = gson.fromJson(jsonArray.getString(i), MovieData.class);
                    if (movie.isNew(mMovieList)) {
                        mMovieList.add(movie);
                    }
                }
            }
        } catch (JSONException ex) {
            System.err.println("MovieMap/" + ex);
        }
    }
    
    /**
     * Returns the array list.
     * 
     * @return the array list.
     */
    public ArrayList<MovieData> getMovieData() {
        return mMovieList;
    }
    
    /**
     * Returns the size of the array list.
     * 
     * @return the size of the array list.
     */
    public int size() {
        return mMovieList.size();
    }
}
