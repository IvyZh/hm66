package com.ivy.hm66.fragment;

import com.ivy.hm66.R;
import com.ivy.hm66.R.layout;
import com.ivy.hm66.log.L;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("NewApi")
public class Fragment01 extends Fragment {

	@Override
	public void onAttach(Activity activity) {
		L.v("----onAttach---");
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		L.v("----onCreate---");
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		L.v("----onCreateView---");
		return inflater.inflate(R.layout.activity_fragment01, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		L.v("----onActivityCreated---");
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		L.v("----onStart---");
		super.onStart();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		L.v("----onResume---");
		super.onResume();
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		L.v("----onPause---");
		super.onPause();
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		L.v("----onStop---");
		super.onStop();
	}

	// ----------------------------------------------------------
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		L.v("----onDestroyView---");
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		L.v("----onDestroy---");
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		L.v("----onDetach---");
		super.onDetach();
	}
}
