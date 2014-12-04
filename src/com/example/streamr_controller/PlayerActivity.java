package com.example.streamr_controller;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.example.streamr_controller.objects.MovieData;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;


public class PlayerActivity extends Activity {
	// Renderer Info //////////
	final String mHost = "192.168.0.10";
	final int mPort = 8080;
	
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
	private boolean mFileOpened = false;
	
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
				if (!mFileOpened) {
					// Have the renderer open the file.
					commandOpenFile(mMovieData.getFile());
					mFileOpened = true;
				}
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
    }
    
    private void commandOpenFile(String resourceUrl) {
    	System.out.println("Open command");
    	try {
    		Socket socket = new Socket(mHost, mPort);
        	OutputStream outputStream = socket.getOutputStream();
        	DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        	dataOutputStream.writeUTF("open");
        	dataOutputStream.writeUTF(resourceUrl);
        	dataOutputStream.close();
        	socket.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    private void commandPlay() {
    	System.out.println("Play command");
    	try {
    		Socket socket = new Socket(mHost, mPort);
        	OutputStream outputStream = socket.getOutputStream();
        	DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        	dataOutputStream.writeUTF("play");
        	dataOutputStream.close();
        	socket.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    private void commandPause() {
    	System.out.println("Pause command");
    	try {
    		Socket socket = new Socket(mHost, mPort);
        	OutputStream outputStream = socket.getOutputStream();
        	DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        	dataOutputStream.writeUTF("pause");
        	dataOutputStream.close();
        	socket.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    private void commandRewind() {
    	System.out.println("Rewind command");
    	try {
    		Socket socket = new Socket(mHost, mPort);
        	OutputStream outputStream = socket.getOutputStream();
        	DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        	dataOutputStream.writeUTF("rewind");
        	dataOutputStream.close();
        	socket.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
		
    }
    
    private void commandFastforward() {
    	System.out.println("Fastforward command");
    	try {
    		Socket socket = new Socket(mHost, mPort);
        	OutputStream outputStream = socket.getOutputStream();
        	DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        	dataOutputStream.writeUTF("fastforward");
        	dataOutputStream.close();
        	socket.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
