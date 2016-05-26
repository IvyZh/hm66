package com.ivy.hm66.activity;

import com.ivy.hm66.R;
import com.ivy.hm66.service.MyService;
import com.ivy.hm66.service.PhoneRecorderService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * 演示 电话录音机  界面
 * 
 * @author Ivy
 */
public class PhoneRecorderActivity extends Activity {

	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_service);
	}

	public void click1(View v) {
		intent = new Intent(this, PhoneRecorderService.class);
		startService(intent);
	}
	public void click2(View v) {
		stopService(intent);
	}
}
