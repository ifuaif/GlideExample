//package com.example.miller.glideexample;
//
//import android.content.Context;
//import android.content.Intent;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
///**
// * Created by miller on 19.07.17.
// */
//
//public class AdapterSpace extends RecyclerView.Adapter<AdapterSpace.MyViewHolder>  {
//
//		@Override
//		public AdapterSpace.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//			Context context = parent.getContext();
//			LayoutInflater inflater = LayoutInflater.from(context);
//			View photoView = inflater.inflate(R.layout.item_photo, parent, false);
//			AdapterSpace.MyViewHolder viewHolder = new AdapterSpace().MyViewHolder(photoView);
//			return viewHolder;
//		}
//
//		@Override
//		public void onBindViewHolder(AdapterSpace.MyViewHolder holder, int position) {
//
//			ModelSpacePhoto spacePhoto = mSpacePhotos[position];
//			ImageView imageView = holder.mPhotoImageView;
//		}
//
//		@Override
//		public int getItemCount() {
//			return (mSpacePhotos.length);
//		}
//
//		public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//
//			public ImageView mPhotoImageView;
//
//			public MyViewHolder(View itemView) {
//
//				super(itemView);
//				mPhotoImageView = (ImageView) itemView.findViewById(R.id.iv_photo);
//				itemView.setOnClickListener(this);
//			}
//
//			@Override
//			public void onClick(View view) {
//
//				int position = getAdapterPosition();
//				if(position != RecyclerView.NO_POSITION) {
//					ModelSpacePhoto spacePhoto = mSpacePhotos[position];
//					Intent intent = new Intent(mContext, ModelSpacePhoto.class);
//					intent.putExtra(ModelSpacePhoto., spacePhoto);
//					startActivity(intent);
//				}
//			}
//		}
//
//		private ModelSpacePhoto[] mSpacePhotos;
//		private Context mContext;
//
//		public AdapterSpace(Context context, ModelSpacePhoto[] spacePhotos) {
//			mContext = context;
//			mSpacePhotos = spacePhotos;
//		}
//	}
//}
//}
