package com.example.miller.glideexample.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.miller.glideexample.R;
import com.example.miller.glideexample.activities.ActivityDetail;
import com.example.miller.glideexample.models.ModelSpacePhoto;

import java.util.ArrayList;

/**
 * Created by miller on 20.07.17.
 */

public class AdapterSpacesPhoto extends RecyclerView.Adapter<AdapterSpacesPhoto.ViewHolder> implements
		View.OnClickListener {

	private Context mContext;
	private LayoutInflater mLayoutInflater;

	private final ArrayList<ModelSpacePhoto.Photos> mPhotos = new ArrayList<>();

	public AdapterSpacesPhoto(final Context context, final ArrayList<ModelSpacePhoto.Photos> photos) {
		this.mContext = context;
		this.mLayoutInflater = LayoutInflater.from(context);

		setNewData(photos);
	}

	@Override
	public AdapterSpacesPhoto.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemViewType) {
		final View view = mLayoutInflater.inflate(R.layout.recyclerview_main, viewGroup, false);
		final ViewHolder viewHolder = new ViewHolder(view);

		viewHolder.itemView.setOnClickListener(this);

		return viewHolder;
	}

	@Override
	public void onBindViewHolder(AdapterSpacesPhoto.ViewHolder viewHolder, int i) {
		final ModelSpacePhoto.Photos photo = mPhotos.get(i);

		viewHolder.itemView.setTag(mPhotos);

		Glide.clear(viewHolder.imgPhoto);
		Glide.with(mContext)
				.load(photo.getImgSrc())
				.into(viewHolder.imgPhoto);

		viewHolder.txtDate.setText(photo.getEarthDate());

		final ModelSpacePhoto.Photos.Rover rover = photo.getRover();
		viewHolder.txtTitle.setText(rover.getStatus());
		viewHolder.txtName.setText(rover.getName());
	}

	@Override
	public int getItemCount() {
		return mPhotos.size();
	}

	@Override
	public void onClick(final View v) {
		Toast.makeText(mContext, "TODO", Toast.LENGTH_SHORT).show();
		//final ModelSpacePhoto.Photos photo = (ModelSpacePhoto.Photos) v.getTag();

	Intent intent = new Intent(mContext,ActivityDetail.class);
	v.getContext().startActivity(intent);

	}

	public void setNewData(final ArrayList<ModelSpacePhoto.Photos> photos) {
		mPhotos.clear();
		mPhotos.addAll(photos);
	}

	public class ViewHolder extends RecyclerView.ViewHolder {

		private TextView txtTitle, txtDate, txtName;
		private ImageView imgPhoto;

		public ViewHolder(View view) {
			super(view);
			txtTitle = (TextView) view.findViewById(R.id.tv_title);
			txtDate = (TextView) view.findViewById(R.id.tv_dateOfPhoto);
			txtName = (TextView) view.findViewById(R.id.tv_fullName);
			imgPhoto = (ImageView) view.findViewById(R.id.iv_spacePhoto);
		}
	}

}
