package com.ivy.hm66.activity;

import com.ivy.hm66.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * 演示 发送广播 界面
 * 
 * @author Ivy
 */
public class SendBroadCastActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_sendbroadcast);
	}

	//有序
	public void click1(View v) {
		System.out.println("click...");
		Intent intent = new Intent();
		intent.setAction("b.a.b.c");
		sendOrderedBroadcast(intent, null, new MyBroadcastReceiver(), null, 0, "每人发100斤大米", null);
	}
	
	class MyBroadcastReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			String resultData = getResultData();
			if(resultData!=null){
				System.out.println("---"+resultData);
			}
		}
		
	}
	// 无序
	public void click2(View v) {
		System.out.println("click...");
		Intent intent = new Intent();
		intent.setAction("b.a.b.c");
		sendBroadcast(intent);
	}
}
