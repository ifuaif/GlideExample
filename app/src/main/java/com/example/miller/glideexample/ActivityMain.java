package com.example.miller.glideexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityMain extends AppCompatActivity {

	public List<ModelSpacePhoto> listOfSpace;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		ApiClient.getPhotos("2015-6-3", new Callback<List<ModelSpacePhoto>>() {
			@Override
			public void onResponse(
					final Call<List<ModelSpacePhoto>> call, final Response<List<ModelSpacePhoto>> response
			) {
				Log.d("asd", "onResponse() called with: call = [" + call + "], response = [" + response.toString() + "]");
			}

			@Override
			public void onFailure(final Call<List<ModelSpacePhoto>> call, final Throwable t) {
				Log.d("asd", "onFailure() called with: call = [" + call + "], response = [" + t.toString() + "]");

			}
		});

//				for (int i =0 ;i<list.size();i++) {
//					result = new Result();
//
//					List<Subcategory> listOfSubcategories = list.get(i).getSubcategories();
//					String categories = list.get(i).getCategory();
//
//					result.setCategory(categories);
//					result.setSubcategories(listOfSubcategories);
//					listResult.add(result);
//
//					bundle.putParcelableArrayList("listSub", listResult);
//					alaune.setArguments(bundle);


	}
}
