package com.example.miller.glideexample;

import android.app.Application;

import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;

import java.io.IOException;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.platform.Platform;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by miller on 19.07.17.
 */
public class ApiClient extends Application {

	public static final String API_HTTP_TYPE = "https://";
	public static final String API_HOSTNAME = "api.nasa.gov";
	public static final String API_SUB_URL = "/mars-photos/api";
	public static final String API_VERSION = "/v1";
	public static final String BASE_URL = API_HTTP_TYPE + API_HOSTNAME + API_SUB_URL + API_VERSION;

//	https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date=2015-6-3&api_key=DEMO_KEY

	public final static String API_KEY = "PUkOzyLnqY6AjDDbx6EGj6AMVED1XmttEFBZoYrG";
	public final static String PHOTOS_ENDPOINT = "/rovers/curiosity/photos";

	public final static String EARTH_DATE_PARAM = "earth_date";
	public final static String API_KEY_PARAM = "api_key";

	private static Retrofit sRetrofit;

	@Override
	public void onCreate() {
		super.onCreate();

			final OkHttpClient okHttpClient = new OkHttpClient.Builder()
					.addInterceptor(
							new LoggingInterceptor.Builder()
									.loggable(BuildConfig.DEBUG)
									.setLevel(Level.BASIC)
									.log(Platform.INFO)
									.request("Request")
									.response("Response")
									.build()
					)
					.addInterceptor(new Interceptor() {
						@Override
						public Response intercept(final Chain chain) throws IOException {
							final Request originalRequest = chain.request();
							final HttpUrl originalHttpUrl = originalRequest.url();

							final HttpUrl url = originalHttpUrl.newBuilder()
									.addQueryParameter(API_KEY_PARAM, API_KEY)
									.build();

							final Request.Builder requestBuilder = originalRequest.newBuilder().url(url);
							final Request request = requestBuilder.build();

							return chain.proceed(request);
						}
					})
					.hostnameVerifier(new HostnameVerifier() {
						@Override
						public boolean verify(final String hostname, final SSLSession session) {
							return API_HOSTNAME.equalsIgnoreCase(hostname);
						}
					})
					.build();

			sRetrofit = new Retrofit.Builder()
					.baseUrl(BASE_URL)
					.addConverterFactory(GsonConverterFactory.create())
					.client(okHttpClient)
					.build();
	}


	public static void getPhotos(final String date, final Callback<List<ModelSpacePhoto>> callback) {
		sRetrofit.create(GetApiSpace.class).getPhotos(date).enqueue(callback);
	}


}
