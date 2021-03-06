package com.example.miller.glideexample.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import com.example.miller.glideexample.R;

/**
 * Created by miller on 22.07.17.
 */

public class ActivitySplashScreen extends Activity {


	//how long until we go to the next activity
	protected int _splashTime = 10000;
	private Thread splashTread;

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		final ActivitySplashScreen sPlashScreen = this;

		// thread for displaying the SplashScreen
		splashTread = new Thread() {
			@Override
			public void run() {
				try {
					synchronized (this) {

						//wait 5 sec
						wait(_splashTime);
					}

				} catch (InterruptedException e) {
				} finally {
					finish();

					//start a new activity
					Intent i = new Intent();
					i.setClass(sPlashScreen, ActivityMain.class);
					startActivity(i);

					finish();
				}
			}
		};
		splashTread.start();
	}

	//Function that will handle the touch
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			synchronized (splashTread) {
				splashTread.notifyAll();
			}
		}
		return true;
	}

}
