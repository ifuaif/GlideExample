package com.example.miller.glideexample.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.example.miller.glideexample.R;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by miller on 21.07.17.
 */

public class FragmentDatePicker  extends DialogFragment{

	public static final String EXTRA_DATE = "ErthDate";

	private Date mDate;
	private int mHour;

	public static FragmentDatePicker newInstance(Date date){
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_DATE, date);

		FragmentDatePicker fragment = new FragmentDatePicker();
		fragment.setArguments(args);
		return fragment;
	}

	private void sendResult(int resultCode){
		if (getTargetFragment() == null){
			return;
		}
		Intent i = new Intent();
		i.putExtra(EXTRA_DATE, mDate);

		getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		mDate = (Date) getArguments().getSerializable(EXTRA_DATE);

		// Create a calendar to extract day month year from Date
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(mDate);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		View v = getActivity().getLayoutInflater().inflate(R.layout.date_picker, null);

		DatePicker datePicker = (DatePicker)v.findViewById(R.id.dialog_date_picker);
		datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {

			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear,
									  int dayOfMonth) {
				// Translate year, month, day into a Date object using a calendar, maintaining the time
				mDate = new GregorianCalendar(year, monthOfYear, dayOfMonth).getTime();

				// Update argument to preserve selected value on rotation
				getArguments().putSerializable(EXTRA_DATE, mDate);
			}
		});

		return new AlertDialog.Builder(getActivity())
				.setView(v)
				.setTitle(R.string.date_picker_title)
				.setPositiveButton(
						android.R.string.ok,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {
								sendResult(Activity.RESULT_OK);
							}
						})
				.create();
	}
}

