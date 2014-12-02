package com.example.streamr_controller;

import com.example.streamr_controller.objects.MovieData;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;


public class PlayerActivity extends Activity {
	// Views //////////
	private TextView mNameTextView;
	private TextView mDirectorTextView;
	private TextView mStarTextView;
	private ImageButton mRewindImageButton;
	private ImageButton mPlayImageButton;
	private ImageButton mPauseImageButton;
	private ImageButton mFastforwardImageButton;
	
	// Data //////////
	private MovieData mMovieData;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        
        // Get a handle on all of the views.
        mNameTextView = (TextView) findViewById(R.id.nameTextView);
        mDirectorTextView = (TextView) findViewById(R.id.directorTextView);
        mStarTextView = (TextView) findViewById(R.id.starTextView);
        mRewindImageButton = (ImageButton) findViewById(R.id.rewindImageButton);
        mPlayImageButton = (ImageButton) findViewById(R.id.playImageButton);
        mPauseImageButton = (ImageButton) findViewById(R.id.pauseImageButton);
        mFastforwardImageButton = (ImageButton) findViewById(R.id.fastforwardImageButton);
        
        // Get the movie data from the intent.
        mMovieData = (MovieData) getIntent().getSerializableExtra("movie");
        
        // Set the TextViews to the correct data.
        mNameTextView.setText(mMovieData.getName());
        mDirectorTextView.setText(mMovieData.getDirector());
        mStarTextView.setText(mMovieData.getStar());
        
        // Add listeners for each of the buttons.
        mRewindImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				commandRewind();
			}
        });
        
        mPlayImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				commandPlay();
			}
        });
        
        mPauseImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				commandPause();
			}
        });
        
        mFastforwardImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				commandFastforward();
			}
        });
        
        // Have the renderer open the file.
        commandOpenFile(mMovieData.getFile());
    }
    
    private void commandOpenFile(String resourceUrl) {
    	
    }
    
    private void commandPlay() {
    	
    }
    
    private void commandPause() {
    	
    }
    
    private void commandRewind() {
    	
    }
    
    private void commandFastforward() {
    	
    }
}
