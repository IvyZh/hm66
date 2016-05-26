package com.ivy.hm66.activity;

import com.ivy.alipay.service.AliPay;
import com.ivy.alipay.service.AliPay.Stub;
import com.ivy.hm66.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

/**
 * ��ʾ XXX ����
 * 
 * @author Ivy
 */
public class RemoteServiceActivity extends Activity {

	private MyConn conn;
	private AliPay aliPay;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_remoteservice);
	}

	public void click1(View v) {
		Intent intent = new Intent();
		intent.setAction("com.ivy.alipay.a.b.c");
		conn = new MyConn();
		bindService(intent, conn, BIND_AUTO_CREATE);
	}

	public void click2(View v) {
		if(conn!=null){
			unbindService(conn);
			conn = null;
		}
	}

	public void click(View v) {
		System.out.println("click...");
		if(aliPay!=null){
			try {
				aliPay.pay(1000);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	class MyConn implements ServiceConnection{

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			aliPay = Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
}
