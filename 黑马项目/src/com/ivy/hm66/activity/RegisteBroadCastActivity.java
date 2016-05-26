package com.ivy.hm66.activity;

import com.ivy.hm66.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * 演示 XXX 界面
 * 
 * @author Ivy
 */
public class RegisteBroadCastActivity extends Activity {

	private MyBroadcastReceiver receiver;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_registerbroadcast);
	}

	public void click1(View v) {
		System.out.println("click...");
		
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_SCREEN_ON);
		filter.addAction(Intent.ACTION_SCREEN_OFF);
		receiver = new MyBroadcastReceiver();
		registerReceiver(receiver, filter);
	}
	
	class MyBroadcastReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if(Intent.ACTION_SCREEN_ON.equals(action)){
				Toast.makeText(context, "屏幕开启", 0).show();
			}else if(Intent.ACTION_SCREEN_OFF.equals(action)){
				Toast.makeText(context, "屏幕关闭", 0).show();
			}
		}
		
	}
	public void click2(View v) {
		System.out.println("click...");
		if(receiver!=null){
			unregisterReceiver(receiver);
		}
	}
}
