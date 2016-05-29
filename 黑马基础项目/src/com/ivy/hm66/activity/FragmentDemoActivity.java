package com.ivy.hm66.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.ivy.hm66.R;
import com.ivy.hm66.fragment.Fragment01;
import com.ivy.hm66.fragment.Fragment02;
import com.ivy.hm66.fragment.Fragment03;

/**
 * —› æ XXX ΩÁ√Ê
 * 
 * @author Ivy
 */
public class FragmentDemoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_fragment);
	}

	@SuppressLint("NewApi") public void click(View v) {
//		FrameLayout mFrameLayout = (FrameLayout) findViewById(R.id.frame_id);
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		Fragment01 fragment01 = new Fragment01();
		
		ft.replace(R.id.frame_id, fragment01);
		ft.commit();
		
	}
	public void click1(View v) {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		Fragment02 fragment02 = new Fragment02();
		
		ft.replace(R.id.frame_id, fragment02);
		ft.commit();
	}
	public void click2(View v) {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		Fragment03 fragment03 = new Fragment03();
		
		ft.replace(R.id.frame_id, fragment03);
		ft.commit();
	}
}
