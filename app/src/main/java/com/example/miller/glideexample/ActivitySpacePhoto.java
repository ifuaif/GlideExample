package com.example.miller.glideexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by miller on 19.07.17.
 */

public class ActivitySpacePhoto extends AppCompatActivity{

	public static final String EXTRA_SPACE_PHOTO = "SpacePhotoActivity.SPACE_PHOTO";
	private ImageView mImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_photo_detail);
//
//		mImageView = (ImageView) findViewById(R.id.image);
//		ModelSpacePhoto spacePhoto = getIntent().getParcelableExtra(EXTRA_SPACE_PHOTO);
//
//		Glide.with(this)
//				.load(spacePhoto.getUrl())
//				.asBitmap()
//				.error(R.drawable.ic_cloud_off_red)
//				.diskCacheStrategy(DiskCacheStrategy.SOURCE)
//				.into(mImageView);
	}
}


