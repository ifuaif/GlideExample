package com.example.miller.glideexample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miller.glideexample.R;

/**
 * Created by miller on 25.07.17.
 */

public class ActivityDetail extends AppCompatActivity {

	TextView Title,Year ;
	ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		// mActionBarToolbar = (Toolbar) findViewById(R.id.movie_toolbar);
		//setSupportActionBar(mActionBarToolbar);
//		//allow return to home
//		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//		getSupportActionBar().setDisplayShowHomeEnabled(true);

		imageView = (ImageView) findViewById(R.id.iv_header_photo);

		//Year= (TextView) findViewById(R.id.year);
		// Title = (TextView) findViewById(R.id.);

//		//Get all Extras from previous activity
//		String title = getIntent().getExtras().getString("movie_title");
//		String coverUrl =getIntent().getExtras().getString("movie_cover");
//		//String year = getIntent().getExtras().getString("movie_year");
//		//String director= getIntent().getExtras().getString("movie_director");
//		String plot= getIntent().getExtras().getString("movie_plot");
//		String actors = getIntent().getExtras().getString("movie_actors");

//		Glide.with(this)
//				.load(coverUrl)
//				.placeholder(R.drawable.load)
//				.into(imageView);
//		//Title.setText(title);
//
//		//set toolbar title
//		getSupportActionBar().setTitle(title);
	}
}

