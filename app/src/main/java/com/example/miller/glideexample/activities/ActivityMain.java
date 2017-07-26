package com.example.miller.glideexample.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miller.glideexample.R;
import com.example.miller.glideexample.adapters.AdapterSpacesPhoto;
import com.example.miller.glideexample.api.ApiClient;
import com.example.miller.glideexample.listeners.EndlessScrollListener;
import com.example.miller.glideexample.models.ModelSpacePhoto;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.miller.glideexample.R.id.recyclerView;

public class ActivityMain extends AppCompatActivity {


	private View mViewCalendar;
	private SlidingUpPanelLayout slidingUpPanelLayout;
	RecyclerView mRecyclerView;
	TextView Disconnected;
	public  String mPickDay = "2015-3-4";
	private ModelSpacePhoto mModelSpacePhoto;
	ProgressDialog pd;
	private SwipeRefreshLayout swipeContainer;
	private EndlessScrollListener endlessScrollListener;

	DatePicker mDatePicker;
	private static final String MAIN_FRAGMENT_TAG = "MainFragment";

	public List<ModelSpacePhoto> listOfSpace = new ArrayList<>();
	public ArrayList<ModelSpacePhoto.Photos> listOfPhotos = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
		swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
		swipeContainer.setColorSchemeResources(android.R.color.holo_orange_dark);
		swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				loadJSON();
				Toast.makeText(ActivityMain.this, "Photo List Refreshed.", Toast.LENGTH_SHORT).show();
			}
		});

		slidingUpPanelLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);

		mDatePicker = (DatePicker) findViewById(R.id.dialog_date_picker);
		Calendar calendar = Calendar.getInstance();
		mDatePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
				new DatePicker.OnDateChangedListener() {
					@Override
					public void onDateChanged(final DatePicker view, final int year, final int monthOfYear, final int dayOfMonth) {

						Date date = new GregorianCalendar(year, monthOfYear, dayOfMonth).getTime();
						SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd");
//						Date date = new Date();
						mPickDay = ss.format(date);
						setPickDate(mPickDay);
						loadJSON();
					}
				});


		slidingUpPanelLayout.setFadeOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
			}
		});
		slidingUpPanelLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
			@Override
			public void onPanelSlide(View panel, float slideOffset) {

			}

			@Override
			public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
				if (SlidingUpPanelLayout.PanelState.COLLAPSED.equals(newState)) {
					//need data fo
				}
			}
		});

//		endlessScrollListener = new EndlessScrollListener();
	}

	@Override
	public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
		super.onSaveInstanceState(outState, outPersistentState);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	private void initViews() {
		pd = new ProgressDialog(this);
		pd.setMessage("Fetching Photos...");
		pd.setCancelable(false);
		pd.show();

		mRecyclerView = (RecyclerView) findViewById(recyclerView);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
		mRecyclerView.smoothScrollToPosition(0);
		loadJSON();
	}


	private String setPickDate(String day){
		this.mPickDay = day;
		if (mPickDay==null){
			Toast.makeText(getApplicationContext(), "You pick BAAAD DAY ", Toast.LENGTH_LONG).show();
		}
		return mPickDay;
	}



	private void loadJSON() {
		Disconnected = (TextView) findViewById(R.id.disconnected);
		try {
			ApiClient.getPhotos(mPickDay, new Callback<ModelSpacePhoto>() {

				@Override
				public void onResponse(
						final Call<ModelSpacePhoto> call, final Response<ModelSpacePhoto> response
				) {
					Log.i("asd", "onResponse() called with: call = [" + call + "], response = [" + response.toString() + "]");

					listOfSpace.clear();
					listOfSpace.add(response.body());

					listOfPhotos.clear();
					for (final ModelSpacePhoto modelSpacePhoto : listOfSpace) {
						listOfPhotos.addAll(modelSpacePhoto.getPhotos());
					}
					Log.i("me", listOfPhotos.toString());

					mRecyclerView.setAdapter(new AdapterSpacesPhoto(ActivityMain.this, listOfPhotos));
					mRecyclerView.smoothScrollToPosition(0);

					//Toast.makeText(MainActivity.this, movieArrayList.toString(), Toast.LENGTH_SHORT).show();
					swipeContainer.setRefreshing(false);
					pd.hide();

				}

				@Override
				public void onFailure(final Call<ModelSpacePhoto> call, final Throwable t) {
					Log.d("asd", "onFailure() called with: call = [" + call + "], response = [" + t.toString() + "]");
					Log.d("Error", t.getMessage());
					Toast.makeText(ActivityMain.this, "Error Fetching Data!", Toast.LENGTH_SHORT).show();
					Disconnected.setVisibility(View.VISIBLE);
					pd.hide();
				}
			});

		} catch (Exception e) {
			Log.d("Error", e.getMessage());
			Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
		}
	}

}