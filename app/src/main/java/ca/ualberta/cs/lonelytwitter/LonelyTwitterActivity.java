/**
 * LonelyTwitterActivity class
 *
 * Copyright 2017 Abid Rahman
 *
 * @author arahman1
 * @version 1.0
 * @created 2017-09-27
 */

package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * LonelyTwitterActivity is the main activity for the Lonely
 * Twitter app. It is responsible for storing and updating a list
 * of Tweets in a JSON file format. It also allows the user to type
 * a new tweet in a text field provided. The saved tweets are loaded
 * and displayed whenever the LonelyTwitterActivity is active.
 */
public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweets;
	private ArrayAdapter<Tweet> adapter;

    /**
     * onCreate links up the UI Controllers with the dataset used.
     * Also responsible for detecting save and clear button presses
     * and acts accordingly.
     * @param savedInstanceState
     */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				try {
					tweets.add(new NormalTweet(text));
				} catch (TweetTooLongException e) {
					e.printStackTrace();
				}

				adapter.notifyDataSetChanged();
				saveInFile();

			}
		});

		clearButton.setOnClickListener((new View.OnClickListener() {

			public void onClick(View v) {
				tweets.clear();
				adapter.notifyDataSetChanged();
				File dir = getFilesDir();
				File file = new File(dir, FILENAME);
				file.delete();
			}

		}));
	}

    /**
     * onStart is called whenever the Activity is started,
     * it fetches the saved Tweets from a file and sets
     * up the adapter for the list of tweets.
     */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		if (tweets == null) {
			throw new RuntimeException();
		}
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

    /**
     * Uses a Gson object to load tweets from the saved file
     * If no file is found, creates a new list of tweets.
     */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			// Following line based on https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html retrieved 2015-09-21
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
			tweets = gson.fromJson(in, listType);
		} catch (FileNotFoundException e) {
			tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

    /**
     * Saves the list of Tweets to a file using a Gson object.
     * If no file is found, throws runtimeException.
     */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,	Context.MODE_PRIVATE);
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			Gson gson = new Gson();
			gson.toJson(tweets, writer);
			writer.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}