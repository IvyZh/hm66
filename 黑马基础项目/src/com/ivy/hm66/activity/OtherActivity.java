package com.ivy.hm66.activity;

import com.ivy.hm66.R;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * —› æ XXX ΩÁ√Ê
 * 
 * @author Ivy
 */
public class OtherActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_other);
		Uri data = getIntent().getData();
		if(data!=null)
			System.out.println(data.toString());
		String name = getIntent().getStringExtra("name");
		if(name!=null)
			System.out.println(name);
	}

	public void click(View v) {
		System.out.println("click...");
	}
}
