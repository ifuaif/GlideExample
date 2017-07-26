package com.example.miller.glideexample.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miller.glideexample.R;
import com.example.miller.glideexample.models.ModelSpacePhoto;

/**
 * Created by miller on 20.07.17.
 */

	public class FragmentMain extends Fragment {
	private static final String CURATOR_TAG = "curator";
	private ModelSpacePhoto mModelSpacePhoto;

	private RecyclerView mRecyclerView;

	public static FragmentMain newInstance() {
		final FragmentMain fragmentMain = new FragmentMain();
		return fragmentMain;
	}

	public FragmentMain() {
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.recyclerview_main, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

		if (savedInstanceState != null) {
			mModelSpacePhoto = savedInstanceState.getParcelable(CURATOR_TAG);
		}

		if (mRecyclerView != null && mModelSpacePhoto != null) {
		}
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		if (savedInstanceState != null) {
			mModelSpacePhoto = savedInstanceState.getParcelable(CURATOR_TAG);
		}

		if (mModelSpacePhoto == null) {

		}
	}

}