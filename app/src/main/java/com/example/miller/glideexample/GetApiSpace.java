package com.example.miller.glideexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by miller on 19.07.17.
 */

public interface GetApiSpace {

	@GET(ApiClient.PHOTOS_ENDPOINT)
	Call<List<ModelSpacePhoto>> getPhotos(@Query(ApiClient.EARTH_DATE_PARAM) final String date);

}