package com.ivy.hm66.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.TimeFormatException;

public class PhoneRecorderService extends Service {

	private MediaRecorder mRecorder;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("--监听服务创建了--onCreate");

		TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		tm.listen(new MyPhoneStateListener(),
				PhoneStateListener.LISTEN_CALL_STATE);

		// mRecorder = new MediaRecorder();
		// mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		// mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		// File file = new File(getCacheDir(),"1.3gp");
		// mRecorder.setOutputFile(file.getAbsolutePath());
		// mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

	}

	private String number = "";
	class MyPhoneStateListener extends PhoneStateListener {
		

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			System.out.println(incomingNumber + "---" + state);
			
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE:
				System.out.println("电话空闲了");
				number = "";
				if(mRecorder != null){
//					mRecorder.stop();
					mRecorder.release();
					mRecorder=null;
	            }
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:
				System.out.println("电话接听了");
				prepareRecorder(number);
				if(mRecorder != null){
					mRecorder.start();
	            }
				break;
			case TelephonyManager.CALL_STATE_RINGING:
				System.out.println("电话铃响了");
				number = incomingNumber;
				break;

			}

		}

		private void prepareRecorder(String incomingNumber) {
			mRecorder = new MediaRecorder();
			 //设置声音来源
			mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
			//设置音频文件格式
			mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
			
			long time = System.currentTimeMillis();
			
			String localTime = new Date(time).toLocaleString();
			String fileName = incomingNumber+"_"+localTime+".3gp";
			File file = new File(getCacheDir(), fileName);
			
			mRecorder.setOutputFile(file.getAbsolutePath());
			//设置音频文件编码
			mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
			
			try {
				mRecorder.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("--服务销毁了--onDestroy");

		if (mRecorder != null) {
			mRecorder.release();
			mRecorder = null;
		}
		 
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("--服务开始了--onStartCommand");
		return super.onStartCommand(intent, flags, startId);

	}
}
