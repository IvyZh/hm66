package com.ivy.hm66.activity;

import com.ivy.hm66.R;
import com.ivy.hm66.interfaces.PublicBusiness;
import com.ivy.hm66.service.MyService;
import com.ivy.hm66.service.MyService.MyIBinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

/**
 * 演示 XXX 界面
 * 
 * @author Ivy
 */
public class ServiceActivity extends Activity {

	private Intent intent;
	private MyServiceConnection conn;
	private PublicBusiness myIBinder;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_service);
		intent = new Intent(this, MyService.class);
	}

	public void click1(View v) {
		System.out.println("click1...");
		startService(intent);
	}
	public void click2(View v) {
		System.out.println("click2...");
		stopService(intent);
	}
	public void click3(View v) {
		System.out.println("click3...");
		conn = new MyServiceConnection();
		bindService(intent, conn, BIND_AUTO_CREATE);
	}
	public void click4(View v) {
		System.out.println("click4...");
		if(conn!=null){
			unbindService(conn);
			conn = null;
		}
	}
	
	public void click5(View v) {
		System.out.println("click5...");
		myIBinder.pay(1222);
	}
	
	class MyServiceConnection implements ServiceConnection{

		

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			System.out.println("MyServiceConnection 服务连接了...");
			myIBinder = (MyIBinder) service;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			System.out.println("MyServiceConnection 服务断开了...");
		}
		
	}
}
