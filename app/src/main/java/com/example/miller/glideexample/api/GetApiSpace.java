package com.example.miller.glideexample.api;

import com.example.miller.glideexample.models.ModelSpacePhoto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by miller on 19.07.17.
 */

public interface GetApiSpace {

	@GET(ApiClient.PHOTOS_ENDPOINT)
	Call<ModelSpacePhoto> getAllInformationAboutDateFoto(@Query(ApiClient.EARTH_DATE_PARAM) final String date);

}