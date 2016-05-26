package com.ivy.hm66.activity;

import com.ivy.hm66.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * 演示 XXX 界面
 * 
 * @author Ivy
 */
public class StartActivityActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_startactivity);
	}

	// 显示开启Acv
	public void click1(View v) {
		System.out.println("click...");
		Intent intent = new Intent(this, CallDemoActivity.class);
		startActivity(intent);
	}

	// 隐式开启Acv
	public void click2(View v) {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_DIAL);
		startActivity(intent);
	}

	// 隐式开启Acv
	public void click3(View v) {
		Intent intent = new Intent();
		intent.setAction("a.b.c");
		intent.setData(Uri.parse("ivy://123"));
		startActivity(intent);
	}

	// 显示开启Acv
	public void click4(View v) {
		Intent intent = new Intent(this,OtherActivity.class);
		intent.putExtra("name", "zk");
		startActivity(intent);
	}
}
