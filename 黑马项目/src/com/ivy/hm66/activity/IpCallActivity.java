package com.ivy.hm66.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ivy.hm66.R;

/**
 * 演示 XXX 界面
 * 
 * @author Ivy
 */
public class IpCallActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_aa);
		Button bt = (Button) findViewById(R.id.bt);
		bt.setText("实现详见IpCallBroadCast(点击关闭)");
	}

	public void click(View v) {
		System.out.println("click...");
	}
}
