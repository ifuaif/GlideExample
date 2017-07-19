package com.example.miller.glideexample;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by miller on 18.07.17.
 */

public class ModelSpacePhoto implements Parcelable {


	@SerializedName("photos")
	private List<Photos> mPhotos;

	protected ModelSpacePhoto(Parcel in) {
	}

	public static final Creator<ModelSpacePhoto> CREATOR = new Creator<ModelSpacePhoto>() {
		@Override
		public ModelSpacePhoto createFromParcel(Parcel in) {
			return new ModelSpacePhoto(in);
		}

		@Override
		public ModelSpacePhoto[] newArray(int size) {
			return new ModelSpacePhoto[size];
		}
	};

	public List<Photos> getPhotos() {
		return mPhotos;
	}

	public void setPhotos(List<Photos> photos) {
		mPhotos = photos;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(final Parcel dest, final int flags) {
	}

	public static class Photos {
		/**
		 * id : 102685
		 * sol : 1004
		 * camera : {"id":20,"name":"FHAZ","rover_id":5,"full_name":"Front Hazard Avoidance Camera"}
		 * img_src : http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01004/opgs/edr/fcam/FLB_486615455EDR_F0481570FHAZ00323M_.JPG
		 * earth_date : 2015-06-03
		 * rover : {"id":5,"name":"Curiosity","landing_date":"2012-08-06","launch_date":"2011-11-26","status":"active","max_sol":1758,"max_date":"2017-07-17","total_photos":318435,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}
		 */

		@SerializedName("id")
		private int mId;
		@SerializedName("sol")
		private int mSol;
		@SerializedName("camera")
		private Camera mCamera;
		@SerializedName("img_src")
		private String mImgSrc;
		@SerializedName("earth_date")
		private String mEarthDate;
		@SerializedName("rover")
		private Rover mRover;

		public int getId() {
			return mId;
		}

		public void setId(int id) {
			mId = id;
		}

		public int getSol() {
			return mSol;
		}

		public void setSol(int sol) {
			mSol = sol;
		}

		public Camera getCamera() {
			return mCamera;
		}

		public void setCamera(Camera camera) {
			mCamera = camera;
		}

		public String getImgSrc() {
			return mImgSrc;
		}

		public void setImgSrc(String imgSrc) {
			mImgSrc = imgSrc;
		}

		public String getEarthDate() {
			return mEarthDate;
		}

		public void setEarthDate(String earthDate) {
			mEarthDate = earthDate;
		}

		public Rover getRover() {
			return mRover;
		}

		public void setRover(Rover rover) {
			mRover = rover;
		}

		public static class Camera {
			/**
			 * id : 20
			 * name : FHAZ
			 * rover_id : 5
			 * full_name : Front Hazard Avoidance Camera
			 */

			@SerializedName("id")
			private int mId;
			@SerializedName("name")
			private String mName;
			@SerializedName("rover_id")
			private int mRoverId;
			@SerializedName("full_name")
			private String mFullName;

			public int getId() {
				return mId;
			}

			public void setId(int id) {
				mId = id;
			}

			public String getName() {
				return mName;
			}

			public void setName(String name) {
				mName = name;
			}

			public int getRoverId() {
				return mRoverId;
			}

			public void setRoverId(int roverId) {
				mRoverId = roverId;
			}

			public String getFullName() {
				return mFullName;
			}

			public void setFullName(String fullName) {
				mFullName = fullName;
			}
		}

		public static class Rover {
			/**
			 * id : 5
			 * name : Curiosity
			 * landing_date : 2012-08-06
			 * launch_date : 2011-11-26
			 * status : active
			 * max_sol : 1758
			 * max_date : 2017-07-17
			 * total_photos : 318435
			 * cameras : [{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]
			 */

			@SerializedName("id")
			private int mId;
			@SerializedName("name")
			private String mName;
			@SerializedName("landing_date")
			private String mLandingDate;
			@SerializedName("launch_date")
			private String mLaunchDate;
			@SerializedName("status")
			private String mStatus;
			@SerializedName("max_sol")
			private int mMaxSol;
			@SerializedName("max_date")
			private String mMaxDate;
			@SerializedName("total_photos")
			private int mTotalPhotos;
			@SerializedName("cameras")
			private List<Camera> mCameras;

			public int getId() {
				return mId;
			}

			public void setId(int id) {
				mId = id;
			}

			public String getName() {
				return mName;
			}

			public void setName(String name) {
				mName = name;
			}

			public String getLandingDate() {
				return mLandingDate;
			}

			public void setLandingDate(String landingDate) {
				mLandingDate = landingDate;
			}

			public String getLaunchDate() {
				return mLaunchDate;
			}

			public void setLaunchDate(String launchDate) {
				mLaunchDate = launchDate;
			}

			public String getStatus() {
				return mStatus;
			}

			public void setStatus(String status) {
				mStatus = status;
			}

			public int getMaxSol() {
				return mMaxSol;
			}

			public void setMaxSol(int maxSol) {
				mMaxSol = maxSol;
			}

			public String getMaxDate() {
				return mMaxDate;
			}

			public void setMaxDate(String maxDate) {
				mMaxDate = maxDate;
			}

			public int getTotalPhotos() {
				return mTotalPhotos;
			}

			public void setTotalPhotos(int totalPhotos) {
				mTotalPhotos = totalPhotos;
			}

			public List<Camera> getCameras() {
				return mCameras;
			}

			public void setCameras(List<Camera> cameras) {
				mCameras = cameras;
			}
		}
	}
}